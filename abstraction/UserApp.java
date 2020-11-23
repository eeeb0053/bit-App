package abstraction;

import java.util.Scanner;

public class UserApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserController controller = new UserController();
        UserDTO user = null;
        
        while(true) {
            System.out.print("Menu: 1.ȸ������ 2.�α��� 3.��й�ȣ ���� 4.ȸ��Ż�� 5.���̵� �ߺ�üũ "
                    + "\n6.���������� 7.ȸ����� 8.���̵�˻� 9.�̸��˻� 10.��ü ȸ���� 0.���� \n>> ");
            switch (scanner.next()) {
            case "1":
                user = new UserDTO();
                System.out.print("[ȸ������]\n�̸� >> ");
                user.setName(scanner.next());
                System.out.print("���̵� >> ");
                user.setUserid(scanner.next());
                System.out.print("��й�ȣ >> ");
                user.setPassword(scanner.next());
                controller.postJoin(user);
                break;
            case "2":
                user = new UserDTO();
                System.out.print("[�α���]\n���̵� >> ");
                user.setUserid(scanner.next());
                System.out.print("��й�ȣ >> ");
                user.setPassword(scanner.next());
                UserDTO loginUser = controller.postLogin(user);
                if(loginUser == null) {
                    System.out.println("�α��� ����");
                }else {
                    System.out.println(loginUser.toString());                   
                }
                break;
            case "3":
                user = new UserDTO();
                System.out.print("[��й�ȣ ����]\n���̵� >> ");
                user.setUserid(scanner.next());
                System.out.print("������ ��й�ȣ >> ");
                user.setPassword(scanner.next());
                controller.putPassword(user);
                break;
            case "4":
                user = new UserDTO();
                System.out.print("[ȸ��Ż��]\n���̵� >> ");
                user.setUserid(scanner.next());
                System.out.print("��й�ȣ >> ");
                user.setPassword(scanner.next());
                controller.deleteUser(user);
                break;
            case "5":
                System.out.print("[���̵� �ߺ�üũ]\n���̵� >> ");
                boolean exist = controller.getExistId(scanner.next());
                if(exist) {
                    System.out.println("��� ������ ���̵��Դϴ�.");
                }else {
                    System.out.println("�̹� �����ϴ� ���̵��Դϴ�.");
                }
                break;
            case "6":
                user = new UserDTO();
                System.out.print("[����������]\n���̵� >> ");
                user.setUserid(scanner.next());
                System.out.print("��й�ȣ >> ");
                user.setPassword(scanner.next());
                UserDTO mypage = controller.getUser(user);
                if(mypage == null) {
                    System.out.println("�������� �ʽ��ϴ�.");
                }else {
                    System.out.printf("�̸�: %s ���̵�: %s ��й�ȣ: %s\n", 
                            mypage.getName(), mypage.getUserid(), mypage.getPassword());
                }
                break;
            case "7":
                System.out.println("[ȸ�����]");
                UserDTO[] list = controller.getUserList();
                for(int i = 0; i < controller.getCount(); i++) {
                    System.out.println(list[i].toString());
                }
                break;
            case "8":
                System.out.print("[���̵� �˻�]\n���̵� >> ");
                UserDTO idSearch = controller.getById(scanner.next());
                if(idSearch == null) {
                    System.out.println("�������� �ʴ� ���̵��Դϴ�.");
                }else {
                    System.out.println(idSearch.getUserid());
                }
                break;
            case "9":
                System.out.print("[�̸� �˻�]\n�̸� >> ");
                String name = scanner.next();
                UserDTO[] nameSearch = controller.getByName(name);
                if(nameSearch == null) {
                    System.out.println("�������� �ʴ� �̸��Դϴ�.");
                }else {
                    for(int i = 0; i < controller.getCountSameName(name); i++) {
                        System.out.println(nameSearch[i].getName());
                    }
                }
                break;
            case "10":
                System.out.printf("��ü ȸ������ %d���Դϴ�.\n",controller.getCount());
                break;
            case "0":
                System.out.println("�ý��� ����");
                return;
            }   
        }
    }
}
class UserDTO {
    private String userid, name, password;
    
    public String getUserid() {return userid;}
    public void setUserid(String userid) {this.userid = userid;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String toString() {
        return "��������� [���̵�=" + userid + ", �̸�=" + name + ", ��й�ȣ=" + password + "]";
    }
}
interface UserService {
    public void join(UserDTO user);
    public UserDTO login(UserDTO user);
    public void updatePassword(UserDTO user);
    public void deleteUser(UserDTO user);
    public boolean existId(String id);
    public UserDTO mypage(UserDTO user);
    public int countSameName(String name);
    public UserDTO[] userList();
    public UserDTO searchId(String id);
    public UserDTO[] searchName(String name);
    public int userCount();
}
class UserServiceImpl implements UserService{
    private UserDTO[] users;
    private int count;
    
    public UserServiceImpl() {
        users = new UserDTO[3];
        count = 0;
    }
    public void join(UserDTO user) {
        users[count] = user;
        count++;
    }
    public UserDTO login(UserDTO user) {
        UserDTO result = null;
        for(int i = 0; i < count; i++) {
            if(user.getUserid().equals(users[i].getUserid()) &&
                    user.getPassword().equals(users[i].getPassword())) {
                result = users[i];
                break;
            }
        }
        return result;
    }
    public void updatePassword(UserDTO user) {
        for(int i = 0; i < count; i++) {
            if(user.getUserid().equals(users[i].getUserid())) {
                users[i].setPassword(user.getPassword());
                break;
            }
        }
    }
    public void deleteUser(UserDTO user) {
        for(int i = 0; i < count; i++) {
            if(user.getUserid().equals(users[i].getUserid()) &&
                    user.getPassword().equals(users[i].getPassword())) {
                users[i] = users[count-1];
                users[count-1] = null;
                count--;
                break;
            }
        }
    }
    public boolean existId(String id) {
        for(int i = 0; i < count; i++) {
            if(id.equals(users[i].getUserid())) {
                return false;
            }
        }
        return true;
    }
    public UserDTO mypage(UserDTO user) {
        UserDTO result = new UserDTO();
        for(int i = 0; i < count; i++) {
            if(user.getUserid().equals(users[i].getUserid()) &&
                    user.getPassword().equals(users[i].getPassword())) {
                result = users[i];
                break;
            }
        }
        return result;
    }
    public UserDTO[] userList() {
        return users;
    }
    public UserDTO searchId(String id) {
        UserDTO user = new UserDTO();
        for(int i = 0; i < count; i++) {
            if(id.equals(users[i].getUserid())) {
                user = users[i];
                break;
            }
        }
        return user;
    }
    public int countSameName(String name) {
        int num = 0;
        for(int i = 0; i < count; i++) {
            if(name.equals(users[i].getName())) {
                num++;
            }
        }
        return num;
    }
    public UserDTO[] searchName(String name) {
        int num= countSameName(name);
        UserDTO[] usersWithSameName = null;
        if(num != 0) {
            usersWithSameName = new UserDTO[num];
        }
        int j = 0;
        for(int i = 0; i < count; i++) {
            if(name.equals(users[i].getName())) {
                usersWithSameName[j] = users[i];
                j++;
                if(j == num) {break;}
            }
        } 
        return usersWithSameName;
    }
    public int userCount() {
        return count;
    }
}
class UserController {
    private UserService userService;

    public UserController() {
        userService = new UserServiceImpl();
    }
    public void postJoin(UserDTO user) {
        userService.join(user);
    }
    public UserDTO postLogin(UserDTO user) {
        return userService.login(user);
    }
    public void putPassword(UserDTO user) {
        userService.updatePassword(user);
    }
    public void deleteUser(UserDTO user) {
        userService.deleteUser(user);
    }
    public boolean getExistId(String id) {
        return userService.existId(id);
    }
    public UserDTO getUser(UserDTO user) {
        return userService.mypage(user);
    }
    public UserDTO[] getUserList() {
        return userService.userList();
    }
    public UserDTO getById(String id) {
        return userService.searchId(id);    
    }
    public int getCountSameName(String name) {
        return userService.countSameName(name);
    }
    public UserDTO[] getByName(String name) {
        return userService.searchName(name);
    }
    public int getCount() {
        return userService.userCount();
    }
}
interface UserDAO {
    public void insertUser(UserDTO user);
    public UserDTO login(UserDTO user);
    public void updatePassword(UserDTO user);
    public void deleteUser(UserDTO user);
    public boolean selectCheckId(String id);
    public UserDTO selectUser(UserDTO user);
    public UserDTO[] selectUserList();
    public UserDTO selectById(String id);
    public UserDTO[] selectByName(String name);
    public int selectCount();
}
class UserDAOImpl implements UserDAO{
    public void insertUser(UserDTO user) {
    }
    public UserDTO login(UserDTO user) {
        return null;
    }
    public void updatePassword(UserDTO user) {
    }
    public void deleteUser(UserDTO user) {
    }
    public boolean selectCheckId(String id) {
        return false;
    }
    public UserDTO selectUser(UserDTO user) {
        return null;
    }
    public UserDTO[] selectUserList() {
        return null;
    }
    public UserDTO selectById(String id) {
        return null;
    }
    public UserDTO[] selectByName(String name) {
        return null;
    }
    public int selectCount() {
        return 0;
    }
}
