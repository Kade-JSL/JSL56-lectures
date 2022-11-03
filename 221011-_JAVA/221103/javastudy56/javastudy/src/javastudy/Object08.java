package javastudy;

import java.util.Scanner;

public class Object08 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("성명? ");
        String name = sc.next();
        System.out.print("성별?(남:1, 여:2, 정하지 못할 경우 다른 숫자를 입력하세요) ");
        int gender = sc.nextInt();
        System.out.print("국어점수? ");
        int kor = sc.nextInt(); // 문자열을 입력하면 예외가 떠버림.
        System.out.print("영어점수? ");
        int eng = sc.nextInt();
        System.out.print("수학점수? ");
        int mat = sc.nextInt();
        String total = getTotal(kor, eng, mat);
        double ave = getAve(total, 3);
        String result = getResult(ave, gender);
        System.out.println("\n\t성적표");
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부");
        System.out.println(name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + total + "\t" + ave + "\t" + result);
        sc.close();
    }

    private static String getResult(double a, int g) {
        String r = "불합격";
        switch(g) {
            case 1: if (a >= 80) r = "합격"; break;
            case 2: if (a >= 70) r = "합격"; break;
            default:
                if (a >= 80) r = "합격";
        }
        // if문을 사용할 경우
        /* 
        if (g == 1 && a >= 80) {
            r = "합격";
        } else if (g == 2 && a >= 70) {
            r = "합격";
        } else if (g != 1 && g != 2 && a >= 80) {
            r = "합격";
        } 
        */
        return r;
    }

    private static double getAve(String t, int i) {
        return (double)Integer.parseInt(t) / (double)i; // 캐스팅
    }

    private static String getTotal(int... i) {
        int t = 0;
        for (int f = 0; f < i.length; f++) {
            t += i[f];
        }
        return Integer.toString(t);
    }

}
