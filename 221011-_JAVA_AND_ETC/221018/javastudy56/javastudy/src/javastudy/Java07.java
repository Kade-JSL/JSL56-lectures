package javastudy;

import java.util.Scanner;
// Eclipse IDE에서의 import 단축키: Ctrl+Shift+'O'

public class Java07 {
    
    public static void main(String[] args) {
        // 선언: 변수
        int bno; String name; int base, bonus, pay;
        // 선언: 객체 생성
        Scanner sc = new Scanner(System.in);
        // 처리: 키보드 입력
        System.out.print("사원번호: ");
        bno = sc.nextInt();
        System.out.print("이름: ");
        name = sc.next();
        System.out.print("기본급: ");
        base = sc.nextInt();
        System.out.print("상여금: ");
        bonus = sc.nextInt();
        // 처리: 내부 변수 계산
        pay = base + bonus;
        // 출력: 조건에 맞게 출력
        System.out.println("\t\t급여명세서");
        System.out.println("-------------------------------------------");
        System.out.println("번호\t이름\t기본급\t상여금\t금액");
        System.out.println("-------------------------------------------");
        System.out.println(bno + "\t" + name + "\t" + base + "\t" + bonus + "\t" + pay);
    }

}
