package abstraction;

import java.util.Scanner;
public class GradeApp{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeController controller = new GradeController();
        GradeDTO grade = null;
        
        while(true) {
            System.out.print("Menu: 1. 성적입력 2. 성적수정 3. 성적삭제 4. 등수발표 0. 종료 \n>> ");
            switch (scanner.next()) {
            case "1":
                grade = new GradeDTO();
                System.out.print("[성적입력]\n이름: ");
                grade.setName(scanner.next());
                System.out.print("국어: ");
                grade.setKor(scanner.nextInt());
                System.out.print("영어: ");
                grade.setEng(scanner.nextInt());
                System.out.print("수학: ");
                grade.setMath(scanner.nextInt());
                controller.postGrade(grade);
                break;
            case "2":
                grade = new GradeDTO();
                System.out.print("[성적수정]\n이름: ");
                grade.setName(scanner.next());
                System.out.print("국어: ");
                grade.setKor(scanner.nextInt());
                System.out.print("영어: ");
                grade.setEng(scanner.nextInt());
                System.out.print("수학: ");
                grade.setMath(scanner.nextInt());
                controller.putGrade(grade);
                System.out.println(grade.toString());
                break;
            case "3":
                grade = new GradeDTO();
                System.out.print("[성적삭제]\n이름: ");
                grade.setName(scanner.next());
                controller.deleteGrade(grade);
                break;
            case "4":
                System.out.println("[등수발표]");
                GradeDTO[] grades = controller.getGradeSort();
                for(int i = 0 ; i < controller.getCount(); i++) {
                    System.out.printf("%d등 %s (총점: %d점 평균: %.2f점)\n", i+1, 
                            grades[i].getName(), grades[i].getSum(), grades[i].getAvg());
                }
                break;
            case "0":
                System.out.println("시스템 종료");
                return;
            }
        }     
    }
}
class GradeDTO {
    private String name;
    private int kor, eng, math, sum;
    private float avg;
    
    public int getSum() {return sum;}
    public void setSum(int sum) {this.sum = sum;}
    public float getAvg() {return avg;}
    public void setAvg(float avg) {this.avg = avg;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getKor() {return kor;}
    public void setKor(int kor) {this.kor = kor;}
    public int getEng() {return eng;}
    public void setEng(int eng) {this.eng = eng;}
    public int getMath() {return math;}
    public void setMath(int math) {this.math = math;}
    @Override
    public String toString() {
        return "GradeDTO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", avg="
                + avg + "]";
    }
}
interface GradeService {
    public void addGrade(GradeDTO grade);
    public void updateGrade(GradeDTO grade);
    public void deleteGrade(GradeDTO grade);
    public int sum(GradeDTO grade);
    public float avg(int sum);
    public GradeDTO[] gradeSort();
    public int count();
}
class GradeServiceImpl implements GradeService{
    private GradeDTO[] grades;
    private int count;
    public GradeServiceImpl() {
        grades = new GradeDTO[3];
        count = 0;
    }
    @Override
    public void addGrade(GradeDTO grade) {
        int sum = sum(grade);
        float avg = avg(sum);
        grade.setSum(sum);
        grade.setAvg(avg);
        grades[count] = grade;
        count++;
    }
    @Override
    public void updateGrade(GradeDTO grade) {
        for(int i = 0; i < count; i++) {
            if(grade.getName().equals(grades[i].getName())) {
                grades[i].setKor(grade.getKor());
                grades[i].setEng(grade.getEng());
                grades[i].setMath(grade.getMath());
                grades[i].setSum(sum(grade));
                grades[i].setAvg(grades[i].getSum());
                break;
            }
        }
    }
    @Override
    public void deleteGrade(GradeDTO grade) {
        for(int i = 0; i < count; i++) {
            if(grade.getName().equals(grades[i].getName())) {
                grades[i] = grades[count-1];
                grades[count-1] = null;
                count--;
                break;
            }
        }
    }
    @Override
    public int sum(GradeDTO grade) {
        return grade.getKor() + grade.getEng() + grade.getMath();
    }
    @Override
    public float avg(int sum) {
        return (float)sum / 3; 
    }
    @Override
    public GradeDTO[] gradeSort() {
        int size = grades.length;
        for(int i = 0; i < size - 1; i++) {
            for(int j = i+1; j < size; j++) {
                if(grades[i].getSum() < grades[j].getSum()) {
                    GradeDTO temp = grades[i];
                    grades[i] = grades[j];
                    grades[j] = temp;
                }
            }
        }
        return grades;
    }
    @Override
    public int count() {
        return count;
    }
}
class GradeController {
    private GradeService service;
    public GradeController() {
        service = new GradeServiceImpl();
    }
    public void postGrade(GradeDTO grade) {
        service.addGrade(grade);
    }
    public void putGrade(GradeDTO grade) {
        service.updateGrade(grade);
    }
    public void deleteGrade(GradeDTO grade) {
        service.deleteGrade(grade);
    }
    public int getSum(GradeDTO grade) {
        return service.sum(grade);
    }
    public float getAvg(int sum) {
        return service.avg(sum);
    }
    public GradeDTO[] getGradeSort() {
        return service.gradeSort();
    }
    public int getCount() {
        return service.count();
    }
}
