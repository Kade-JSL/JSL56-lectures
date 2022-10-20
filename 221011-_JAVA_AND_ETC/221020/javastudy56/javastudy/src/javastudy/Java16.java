package javastudy;

import java.util.Scanner;

public class Java16 {

    public static void main(String[] args) {
        // 학번 bno, 이름 name, 점수 score를 입력받아
        // 점수가 90점 이상이면 A+ 학점,
        // 점수가 85점 이상 90점 미만이면 A 학점,
        // 점수가 80점 이상 85점 미만이면 B+ 학점,
        // 점수가 75점 이상 80점 미만이면 B 학점,
        // 점수가 70점 이상 75점 미만이면 C+ 학점,
        // 점수가 65점 이상 70점 미만이면 C 학점,
        // 65점 미만의 점수는 재시험을 출력하기
        // 입력예:
        // 학번: 1111 \n 이름: 홍길동 \n 점수: 76
        // 출력예:
        // 학점: C학점
        Scanner sc = new Scanner(System.in);
        System.out.print("학번: ");
        int bno = sc.nextInt();
        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("점수: ");
        int score = sc.nextInt();

        String grade = "";
        if (score >= 90) {
            grade = "A+";
        } else if (score >= 85) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B+";
        } else if (score >= 75) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C+";
        } else if (score >= 65) {
            grade = "C";
        } else {
            grade = "재시험";
        }

        System.out.println("\t성적표");
        System.out.println("-----------------------------");
        System.out.println("번호\t이름\t점수\t학점");
        System.out.println(bno + "\t" + name + "\t" + score + "\t" + grade);
    }

}