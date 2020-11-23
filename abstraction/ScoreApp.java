package abstraction;

import java.util.Scanner;
public class ScoreApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ScoreController controller = new ScoreController();
		ScoreDTO grade = null;
		
		while(true) {
			System.out.print("1. 성적등록 2. 성적수정 3. 성적삭제 4. 등수발표 0. 종료 \n>> ");
			switch (scanner.next()) {
			case "1": 
				grade = new ScoreDTO();
				System.out.print("이름: ");
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
				grade = new ScoreDTO();
				System.out.print("이름: ");
				grade.setName(scanner.next());
				System.out.print("국어: ");
				grade.setKor(scanner.nextInt());
				System.out.print("영어: ");
				grade.setEng(scanner.nextInt());
				System.out.print("수학: ");
				grade.setMath(scanner.nextInt());
				controller.putGrade(grade);
				break;
			case "3":
				grade = new ScoreDTO();
				System.out.print("이름: ");
				grade.setName(scanner.next());
				controller.deleteGrade(grade);
				break;
			case "4": 
				ScoreDTO[] grades = controller.getGradeSort();
				for(int i = 0; i < controller.getCount(); i++) {
					System.out.println(grades[i].toString());
				}
				break;
			case "0": 
				System.out.println("시스템 종료");
				return;
			}
		}
	}
}
class ScoreDTO {
    private String name;
    private int kor, eng, math, sum;
    private float avg;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getKor() {
        return kor;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public int getEng() {
        return eng;
    }
    public void setEng(int eng) {
        this.eng = eng;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
    public float getAvg() {
        return avg;
    }
    public void setAvg(float avg) {
        this.avg = avg;
    }
    @Override
    public String toString() {
        return "ScoreDTO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", avg="
                + avg + "]";
    }
}
interface ScoreService {
    public void addGrade(ScoreDTO grade);
    public void updateGrade(ScoreDTO grade);
    public void deleteGrade(ScoreDTO grade);
    public int sum(ScoreDTO grade);
    public float avg(int sum);
    public ScoreDTO[] gradeSort();
    public int count();
}
class ScoreServiceImpl implements ScoreService{
    private ScoreDTO[] grades;
    private int count;
    
    public ScoreServiceImpl() {
        grades = new ScoreDTO[3];
        count = 0;
    }
    @Override
    public void addGrade(ScoreDTO grade) {
        int sum = sum(grade);
        float avg = avg(sum);
        grade.setSum(sum);
        grade.setAvg(avg);
        grades[count] = grade;
        count++;
    }
    @Override
    public void updateGrade(ScoreDTO grade) {
        for(int i = 0; i < count; i++) {
            if(grade.getName().equals(grades[i].getName())){
                grades[i].setKor(grade.getKor());
                grades[i].setEng(grade.getEng());
                grades[i].setMath(grade.getMath());
                break;
            }
        }
    }
    @Override
    public void deleteGrade(ScoreDTO grade) {
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
    public int sum(ScoreDTO grade) {
        return grade.getKor() + grade.getEng() + grade.getMath();
    }
    @Override
    public float avg(int sum) {
        return (float)sum / 3;
    } 
    @Override
    public ScoreDTO[] gradeSort() {
        int size = grades.length;
        for(int i = 0; i < size - 1; i++) {
            for(int j = i+1; j < size; j++) {
                if(grades[i].getSum() < grades[j].getSum()) {
                    ScoreDTO temp = grades[i];
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
class ScoreController {
    private ScoreService gradeService;

    public ScoreController() {
        gradeService = new ScoreServiceImpl();
    }     
    public void postGrade(ScoreDTO grade) {
        gradeService.addGrade(grade);
    }
    public void putGrade(ScoreDTO grade) {
        gradeService.updateGrade(grade);
    }    
    public void deleteGrade(ScoreDTO grade) {
        gradeService.deleteGrade(grade);
    }    
    public int getSum(ScoreDTO grade) {
        return gradeService.sum(grade);
    }
    public float getAvg(int sum) {
        return gradeService.avg(sum);
    }
    public ScoreDTO[] getGradeSort() {
        return gradeService.gradeSort();
    }
    public int getCount() {
        return gradeService.count();
    }
}
