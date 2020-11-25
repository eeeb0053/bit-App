package board.controllers;

import board.domains.StudentDTO;
import board.domains.TeacherDTO;

public class MemberController {
    public void postStudent(StudentDTO student);
    public void postTeacher(TeacherDTO teacher);
    public void updateStudent(StudentDTO student);
    public void deleteStudent(StudentDTO student);
    public StudentDTO postLogin(StudentDTO student);
    public TeacherDTO access(TeacherDTO teacher);
    public StudentDTO[] getStudentList();
    public StudentDTO getStudentDetail(String userId);
    public int sum(StudentDTO student);
    public float avg(int sum);
    public boolean existId(String userId);
}

















