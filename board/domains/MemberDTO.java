package board.domains;

// 게시판 관리등에서 
// 로그인하는 회원을 담당할 Member 클래스
public class MemberDTO {
    //필드
    private int userId; //회원 번호
    private String userName; //로그인 id
    private String password; //로그인 비밀번호
    private String nickName; //게시판에서 보여지는 닉네임
    
    //getters/setters
    public int getId() {
        return userId;
    }
    public void setId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    //java.lang.Object 메소드 오버라이드
    public boolean equals(Object o) {
        if(o instanceof MemberDTO) {
            MemberDTO m = (MemberDTO)o;
            if(userName.equals(m.userName) && password.equals(m.password)) {
                return true;
            }
        }
        
        return false;
    }
    
    public String toString() {
        return "userId: "+userId+
                ", userName: "+userName+
                ", password: "+password+
                ", nickName: "+nickName;
    }
    
    // 생성자
    public MemberDTO() {
        userName = new String();
        password = new String();
        nickName = new String();
    }
    
    public MemberDTO(int userId, String userName, String password, String nickName) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
    }
}























