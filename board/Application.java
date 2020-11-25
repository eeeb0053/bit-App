package board;

import java.util.Scanner;

import board.domains.ArticleDTO;

/*
<< RFP >>
"게시판 관리 프로그램"
String message = "1. 새글 작성 2. 글 목록 보기 3. 처음 화면으로";
1. 새글 쓰기 2. 목록 보기 3. 종료
제목 / 작성자 / 내용
사용해주셔서 감사합니다.
아직 입력된 글이 없습니다.
상세보기할 글 번호를 선택해주세요.

SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
            System.out.println();
            System.out.println("---------------------------");
            System.out.println("제목: "+b.getTitle());
            System.out.println("작성자: "+userViewer.selectNicknameById(b.getWriterId()));    
            System.out.println("작성일: "+sdf.format(b.getWrittenDate().getTime()));
            System.out.println("수정일: "+sdf.format(b.getUpdatedDate().getTime()));

                message = "1. 수정 2. 삭제 3. 댓글달기 4. 목록으로";
                message = "1. 댓글달기 2. 뒤로가기";
정말로 삭제하겠습니까?

"비트 성적관리 프로그램"
"1. 입력 2. 출력 3. 종료\n";
번호, 이름, 국어, 영어, 수학
                System.out.println("사용해주셔서 감사합니다.");
            System.out.println("아직 추가된 학생이 없습니다.");
            String message = "상세보기할 학생의 번호를 입력해주세요 (0은 뒤로가기)\n";
        String message = "1. 수정 2. 삭제 3. 목록";
        System.out.print("정말로 삭제하시겠습니까? y/n ");

        System.out.printf("번호: %d번 이름: %s\n", s.getId(), s.getName());
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", 
                s.getKorean(), s.getEnglish(), s.getMath());
        System.out.printf("총점: %03d점 평균: %.2f점\n", 
                s.calculateSum(), s.calculateAverage());    
"1. 로그인 2. 회원가입 3. 종료";
"님 환영합니다"
"username (종료를 원하시면 x를 입력하세요): ");
("중복된 username입니다. 다시 입력해주세요");
*/
public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArticleController controller = new ArticleController
        String title = "비트 성적관리 프로그램\n";
        String navi = "[학생 UI]\n"
        +"01.학생등록 02.아이디중복체크 03.학생로그인 04.학생정보수정 05.학생정보삭제\n"
        +"[강사 UI]\n"
        +"11. 강사등록 12.강사접속 13. 학생목록보기 14.학생상세정보 15.성적합계 16.성적평균\n"
        +"[게시판 UT]\n"
        +"21.새글작성 22.글목록 23.글상세 24.글수정 25.글삭제"
        +"26.댓글쓰기 27.댓글보기 \n"
        +"0.종료\n";
        while(true){
            System.out.println(title+navi);
            switch (scanner.next()) {
                case "01": 
                    break;
                case "02":
                    break;
                case "03":
                    break;
                case "04": 
                    break;
                case "05": 
                    break;
                case "11": 
                    break;
                case "12": 
                    break;
                case "13": 
                    break;
                case "14": 
                    break;
                case "15": 
                    break;
                case "16": 
                    break;
                case "21": 
                    break;
                case "22": 
                    break;
                case "23": 
                    break;
                case "24": 
                    break;
                case "25": 
                    break;
                case "26": 
                    break;
                case "27": 
                    break;
                case "0":
                    System.out.println("시스템 종료");
                    return;
            }
        }
    }
}
