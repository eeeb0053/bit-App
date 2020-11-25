package board.services;

import board.domains.StudentDTO;
import board.domains.TeacherDTO;

/*
+"01.학생등록 02.아이디중복체크 03.학생로그인 04.학생정보수정 05.학생정보삭제\n"
+"11. 강사등록 12.강사접속 13. 학생목록보기 14.학생상세정보 15.성적합계 16.성적평균\n"
+"21.새글작성 22.글목록 23.글상세 24.글수정 25.글삭제"
+"26.댓글쓰기 27.댓글보기 \n"
+"0.종료\n";
*/
public interface MemberService {
    public void registerStudent(StudentDTO student);
    public void registerTeacher(TeacherDTO teacher);
    public void modifyStudent(StudentDTO student);
    public void removeStudent(StudentDTO student);
    public StudentDTO login(StudentDTO student);
    public TeacherDTO access(TeacherDTO teacher);
    public StudentDTO[] fetchStudentList();
    public StudentDTO fetchStudentDetail(String userId);
    public int sum(StudentDTO student);
    public float avg(int sum);
    public boolean existId(String userId);
}
