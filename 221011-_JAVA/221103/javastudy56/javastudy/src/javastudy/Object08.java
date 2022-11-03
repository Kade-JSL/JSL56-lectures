package javastudy;

import java.util.Scanner;

public class Object08 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("성명? ");
        String name = sc.next();
        System.out.print("국어점수? ");
        int kor = sc.nextInt();
        System.out.print("영어점수? ");
        int eng = sc.nextInt();
        System.out.print("수학점수? ");
        int mat = sc.nextInt();
        String total = getTotal(kor, eng, mat);
        System.out.println("\t성적표");
        System.out.println("이름\t국어\t영어\t수학\t총점");
        System.out.println(name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + total);
        sc.close();
    }

    private static String getTotal(int... s) {
        int m = 0;
        for (int i = 0; i < s.length; i++) {
            m += s[i];
        }
        return Integer.toString(m);
    }
}
