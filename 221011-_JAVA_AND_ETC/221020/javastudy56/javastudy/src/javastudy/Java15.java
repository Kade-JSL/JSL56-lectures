package javastudy;

import java.util.Scanner;

public class Java15 {
    
    public static void main(String[] args) {
        // if / else 문
        /* if(조건식1) {
         * } else if(조건식2) {
         * } else if(조건식3) {
         * } else {
         * }
         */

        Scanner sc = new Scanner(System.in);
        
        System.out.print("점수를 입력하세요: ");
        int score = sc.nextInt();
        String grade = "";
        
        if (score >= 85) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 75) {
            grade = "C";
        } else {
            grade = "재시험";
        }

        System.out.println("학점 등급은: " + grade + "입니다.");

        sc.close();
    }

}
