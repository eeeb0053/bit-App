package board.controllers;

import board.domains.StudentDTO;
import board.domains.TeacherDTO;
import board.impls.MemberServiceImpl;
import board.services.MemberService;

public class MemberController {
    private MemberService memberService;
    public MemberController() {
        memberService = new MemberServiceImpl();
    }
    public void postStudent(StudentDTO student) {
        memberService.registerStudent(student);
    }
    public void postTeacher(TeacherDTO teacher) {
        memberService.registerTeacher(teacher);
    }
    public void updateStudent(StudentDTO student) {
        memberService.modifyStudent(student);
    }
    public void deleteStudent(StudentDTO student) {
        memberService.removeStudent(student);
    }
    public StudentDTO postLogin(StudentDTO student) {
        return memberService.login(student);
    }
    public TeacherDTO postAccess(TeacherDTO teacher) {
        return memberService.access(teacher);
    }
    public StudentDTO[] getStudentList() {
        return memberService.fetchStudentList();
    }
    public StudentDTO getStudentDetail(int userId) {
        return memberService.fetchStudentDetail(userId);
    }
    public int getSum(StudentDTO student) {
        return memberService.sum(student);
    }
    public float getAvg(int sum) {
        return memberService.avg(sum);
    }
    public boolean getExistId(int userId) {
        return memberService.existId(userId);
    }
}

















