package javastudy;

import java.util.Scanner;

public class Java19 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("정수 x: ");
        int x = sc.nextInt();
        System.out.print("정수 y: ");
        int y = sc.nextInt();

        System.out.print("[ +, -, *, /, % ] 중 하나를 선택: ");
        String op = sc.next();

        switch (op) {
            case "+":
                System.out.printf("%d + %d = %d", x, y, x + y);
                break;
            case "-":
                System.out.printf("%d - %d = %d", x, y, x - y);
                break;
            case "*":
                System.out.printf("%d * %d = %d", x, y, x * y);
                break;
            case "/":
                System.out.printf("%d / %d = %d", x, y, x / y);
                break;
            case "%":
                System.out.printf("%d %% %d = %d", x, y, x % y);
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }
        sc.close();
    }
}
