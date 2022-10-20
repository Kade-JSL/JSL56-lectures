package javastudy;

import java.util.Scanner;

public class Java13 {
    
    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        
        /*
        System.out.print("점수 입력: ");
        int score = con.nextInt();

        if(score >= 80) {// 단순 if문: 분기가 true 아니만 false 두 개밖에 존재하지 않음 
            System.out.println("합격입니다!"); // 조건이 참이면 안에 있는 명령어를 실행하도록 제어된다.
        } else {
            System.out.println("불합격입니다.");
        }    
        */

        /*
        System.out.print("정수 하나를 입력하시오: ");
        int count = con.nextInt();

        if(count < 0) {
            System.out.println(count + "(은)는 음수입니다.");
        } else {
            System.out.println(count + "(은)는 양수입니다.");
        }
        */

        // 연습 문제
        // 정수를 한 개 입력받아 홀수인지 짝수인지를 출력하시오.
        System.out.print("정수 하나를 입력하시오: ");
        int num = con.nextInt();

        if(num % 2 == 0) {
            System.out.println(num + "(은)는 짝수입니다.");
        } else {
            System.out.println(num + "(은)는 홀수입니다.");
        }


        con.close(); // 객체를 생성했으면 닫아 주면 좋다.

    } // main
} // class
