package javastudy;

import java.util.Scanner;

public class Java10 {
    
    public static void main(String[] args) {
        /* 두 개의 값을 입력받아 변수 a, 변수 b에 저장하고 a에 저장된 값이 b보다 큰지 출력하시오 */
        /*
        Scanner ineq = new Scanner(System.in);
        System.out.print("Enter integer a: ");
        int a = ineq.nextInt();
        System.out.print("Enter integer b: ");
        int b = ineq.nextInt();
        System.out.print("Enter integer c: ");
        int c = ineq.nextInt();
        System.out.print("Enter integer d: ");
        int d = ineq.nextInt();

        boolean result = (a > b) || (c > d);

        System.out.println("a>b OR c>d?: " + result);
        */
        int bal = 0; // 통장 생성
        System.out.println("통장 잔고: " + bal + "원"); // 잔고 출력
        int depwit = 100; // 첫 입금액은 100원이다
        System.out.println(depwit + "원을 입금함"); // 입금액 출력
        bal = bal + depwit; // 입금한 만큼 잔고에 반영
        System.out.println("통장 잔고: " + bal + "원"); // 아까와 똑같은 식
        depwit = -10; // 10원을 출금(마이너스), 아까와 똑같은 식!
        System.out.println(depwit*(-1) + "원을 출금함"); // 아까와...이하생략
        bal = bal + depwit;
        System.out.println("통장 잔고: " + bal + "원");
        depwit = 50;
        System.out.println(depwit + "원을 입금함");
        bal = bal + depwit;
        System.out.println("통장 잔고: " + bal + "원");
        depwit = 100;
        System.out.println(depwit + "원을 입금함");
        bal = bal + depwit;
        System.out.println("통장 잔고: " + bal + "원");
    }
}
