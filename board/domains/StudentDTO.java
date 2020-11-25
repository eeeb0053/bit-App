package board.domains;

public class StudentDTO extends MemberDTO{
    private String nickName; 
    public StudentDTO() {}
    public StudentDTO(
        int userId,
        String userName,
        String password,
        String nickname) {
        super.userId = userId;
        super.userName = userName;
        super.password = password;

    }

    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}