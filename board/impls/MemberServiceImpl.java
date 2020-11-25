package board.impls;

import board.domains.StudentDTO;
import board.domains.TeacherDTO;
import board.services.MemberService;

public class MemberServiceImpl implements MemberService {

    @Override
    public void registerStudent(StudentDTO student) {
        // TODO Auto-generated method stub

    }

    @Override
    public void registerTeacher(TeacherDTO teacher) {
        // TODO Auto-generated method stub

    }

    @Override
    public void modifyStudent(StudentDTO student) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeStudent(StudentDTO student) {
        // TODO Auto-generated method stub

    }

    @Override
    public StudentDTO login(StudentDTO student) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TeacherDTO access(TeacherDTO teacher) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StudentDTO[] fetchStudentList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StudentDTO fetchStudentDetail(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int sum(StudentDTO student) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float avg(int sum) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean existId(int userId) {
        // TODO Auto-generated method stub
        return false;
    }

}
