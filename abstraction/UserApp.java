package abstraction;

import java.util.Scanner;

public class UserApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserController controller = new UserController();
        UserDTO user = null;
        
        while(true) {
            System.out.print("Menu: 1.회원가입 2.로그인 3.비밀번호 수정 4.회원탈퇴 5.아이디 중복체크 "
                    + "\n6.마이페이지 7.회원목록 8.아이디검색 9.이름검색 10.전체 회원수 0.종료 \n>> ");
            switch (scanner.next()) {
            case "1":
                user = new UserDTO();
                System.out.print("[회원가입]\n이름 >> ");
                user.setName(scanner.next());
                System.out.print("아이디 >> ");
                user.setUserid(scanner.next());
                System.out.print("비밀번호 >> ");
                user.setPassword(scanner.next());
                controller.postJoin(user);
                break;
            case "2":
                user = new UserDTO();
                System.out.print("[로그인]\n아이디 >> ");
                user.setUserid(scanner.next());
                System.out.print("비밀번호 >> ");
                user.setPassword(scanner.next());
                UserDTO loginUser = controller.postLogin(user);
                if(loginUser == null) {
                    System.out.println("로그인 실패");
                }else {
                    System.out.println(loginUser.toString());                   
                }
                break;
            case "3":
                user = new UserDTO();
                System.out.print("[비밀번호 변경]\n아이디 >> ");
                user.setUserid(scanner.next());
                System.out.print("변경할 비밀번호 >> ");
                user.setPassword(scanner.next());
                controller.putPassword(user);
                break;
            case "4":
                user = new UserDTO();
                System.out.print("[회원탈퇴]\n아이디 >> ");
                user.setUserid(scanner.next());
                System.out.print("비밀번호 >> ");
                user.setPassword(scanner.next());
                controller.deleteUser(user);
                break;
            case "5":
                System.out.print("[아이디 중복체크]\n아이디 >> ");
                boolean exist = controller.getExistId(scanner.next());
                if(exist) {
                    System.out.println("사용 가능한 아이디입니다.");
                }else {
                    System.out.println("이미 존재하는 아이디입니다.");
                }
                break;
            case "6":
                user = new UserDTO();
                System.out.print("[마이페이지]\n아이디 >> ");
                user.setUserid(scanner.next());
                System.out.print("비밀번호 >> ");
                user.setPassword(scanner.next());
                UserDTO mypage = controller.getUser(user);
                if(mypage == null) {
                    System.out.println("존재하지 않습니다.");
                }else {
                    System.out.printf("이름: %s 아이디: %s 비밀번호: %s\n", 
                            mypage.getName(), mypage.getUserid(), mypage.getPassword());
                }
                break;
            case "7":
                System.out.println("[회원목록]");
                UserDTO[] list = controller.getUserList();
                for(int i = 0; i < controller.getCount(); i++) {
                    System.out.println(list[i].toString());
                }
                break;
            case "8":
                System.out.print("[아이디 검색]\n아이디 >> ");
                UserDTO idSearch = controller.getById(scanner.next());
                if(idSearch == null) {
                    System.out.println("존재하지 않는 아이디입니다.");
                }else {
                    System.out.println(idSearch.getUserid());
                }
                break;
            case "9":
                System.out.print("[이름 검색]\n이름 >> ");
                String name = scanner.next();
                UserDTO[] nameSearch = controller.getByName(name);
                if(nameSearch == null) {
                    System.out.println("존재하지 않는 이름입니다.");
                }else {
                    for(int i = 0; i < controller.getCountSameName(name); i++) {
                        System.out.println(nameSearch[i].getName());
                    }
                }
                break;
            case "10":
                System.out.printf("전체 회원수는 %d명입니다.\n",controller.getCount());
                break;
            case "0":
                System.out.println("시스템 종료");
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
        return "사용자정보 [아이디=" + userid + ", 이름=" + name + ", 비밀번호=" + password + "]";
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
