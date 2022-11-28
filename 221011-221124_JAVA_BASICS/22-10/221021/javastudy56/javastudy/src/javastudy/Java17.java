package javastudy;

import java.util.Scanner;

public class Java17 {
    
    private static void intprint(int input) {
        System.out.print("물건 " + input + " 구매액: ");
    }

    public static void main(String[] args) {
        int sum = 0, point = 0;
        Scanner sc = new Scanner(System.in);

        for (int goodscount = 1; goodscount <= 3; goodscount++) {
            intprint(goodscount);
            sum += sc.nextInt();
        }

        if (sum >= 30000) {
            point = 3000;
        } else if (sum >= 20000) {
            point = 2000;
        } else if (sum >= 10000) {
            point = 1000;
        }

        System.out.println("합계: " + sum + "원");
        System.out.println("포인트: " + point + "점");
        
        sc.close();
    }

}
