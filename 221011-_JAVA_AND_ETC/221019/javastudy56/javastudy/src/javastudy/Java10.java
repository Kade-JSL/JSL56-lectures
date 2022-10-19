package javastudy;

import java.util.Scanner;

public class Java10 {
    
    public static void main(String[] args) {
        /* 두 개의 값을 입력받아 변수 a, 변수 b에 저장하고 a에 저장된 값이 b보다 큰지 출력하시오 */
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
    }
}
