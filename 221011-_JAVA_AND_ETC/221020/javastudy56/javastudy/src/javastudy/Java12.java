package javastudy;

import java.util.Scanner;

public class Java12 {
    
    public static void main(String[] args) {
        // 상품 가격을 입력: 50000
        // 적용할 할인율을 입력(%): 20
        // 출력예:
        // 상품 가격: [50000 입력]
        // 할인율(%): [20 입력]
        // 세일 가격: [출력값]
        /* 실제로 IT 기업에서 코딩테스트를 할 경우,
        원하는 출력값을 제시한 다음 이 출력값을
        특정 방법을 사용하여 구현하라는 식의 문제가
        출제됩니다. */
        Scanner dis = new Scanner(System.in);
        System.out.print("상품 가격: ");
        double price = dis.nextDouble();
        System.out.print("할인율(%): ");
        double sale = dis.nextDouble();
        price *= (1 - sale / 100.);
        System.out.println("세일 가격: " + price);
    }

}
