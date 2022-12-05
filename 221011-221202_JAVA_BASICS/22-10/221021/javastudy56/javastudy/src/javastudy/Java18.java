package javastudy;

import java.util.Scanner;

public class Java18 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score; // 점수
        String grade; // 학점
        System.out.print("점수 입력: ");
        score = sc.nextInt();

        switch (score/5) { // 정수 아니면 문자만 넣을 수 있다.
            case 20: // 다음 줄의 case 9(19)와 이어진다.
            case 19: grade = "A+"; break; // 더 잇고 싶지 않으면 break;를 써야 한다.
            case 18: grade = "A"; break;
            case 17: grade = "B+"; break;
            case 16: grade = "B"; break;
            case 15: grade = "C+"; break;
            case 14: grade = "C"; break;
            case 13: grade = "D+"; break;
            case 12: grade = "D"; break;
            default: grade = "재평가";
        }
        System.out.printf("%d점은 %s 학점이다\n", score, grade);

        sc.close();
    }

}
