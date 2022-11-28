package javastudy;

import java.util.Scanner;

public class Java06 {
 
    // 요기는 수업 과정에 맞게 코딩한 부분입니다.

    public static void main(String[] args) {
        // 1. 변수 선언
        int bno, kor, eng, mat, tot;
        double avg;
        String name;
        
        // 2. 객체 생성
        Scanner sc = new Scanner(System.in);
        
        // 3. 데이터 입력
        System.out.print("번호?: ");
        bno = sc.nextInt();
        System.out.print("이름?: ");
        name = sc.next();
        System.out.print("국어점수?: ");
        kor = sc.nextInt();
        System.out.print("영어점수?: ");
        eng = sc.nextInt();
        System.out.print("수학점수?: ");
        mat = sc.nextInt();
        
        // 4. 데이터 처리
        tot = kor + eng + mat;
        avg = tot / 3.;
        
        // 5. 출력
        System.out.println("\t\t성적표");
        System.out.println("-----------------------------------------------------------");
        System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println("-----------------------------------------------------------");
        System.out.println(bno + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + avg);
        
	}
    
    /* 이하는 제가 편하게 코딩한 부분입니다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("번호?: ");
        int bno = sc.nextInt();
        System.out.print("이름?: ");
        String name = sc.next();
        System.out.print("국어점수?: ");
        int kor = sc.nextInt();
        System.out.print("영어점수?: ");
        int eng = sc.nextInt();
        System.out.print("수학점수?: ");
        int mat = sc.nextInt();
        int tot = kor + eng + mat;
        double avg = tot / 3.;

        System.out.println("\t\t성적표");
        System.out.println("-----------------------------------------------------------");
        System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println("-----------------------------------------------------------");
        System.out.println(bno + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + avg);
    }
    */

}
