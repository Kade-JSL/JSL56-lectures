package javastudy;

import java.util.Scanner;

public class Java27 {
    public static void main(String[] args) {
        // continue문: 반복문의 한 루프를 끝내고 다음 루프를 바로 시작
        // 5개의 정수를 입력받고 그 중 양수들만 합하여 출력하시오
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + "번째 정수 입력: ");
            int n = sc.nextInt();
            if (n < 0) {
                continue; // 양수가 아니면 다음 반복문을 실행하라
            } else {
                sum += n;
            }
        }
        System.out.println("양수의 합: " + sum);
        sc.close();
    }
}
