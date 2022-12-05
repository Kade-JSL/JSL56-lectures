package javastudy;

import java.util.Scanner;

public class Object04 {
    static void sum(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        System.out.println("1에서 " + n + "까지의 합: " + s);
    }

    static int odd(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
                c++;
            }
        }
        System.out.println();
        return c;
    }

    static int evenOdd(int n) {
        int s = 0, e, o = 0;
        for (int i = 1; i <= n; i++) {
            s += i;
            if (i % 2 == 1) o += i;
        }
        System.out.println("홀수의 합: " + o);
        e = s - o;
        System.out.println("짝수의 합: " + e);
        return s;
    }

    public static void main(String[] args) {
        // 1-n까지 합을 구하여 출력하는 sum() 메서드
        // 1-n까지 홀수를 출력하고 홀수의 개수를 리턴하는 odd() 메서드
        // 1-n까지 홀수의 합과 짝수의 합을 구하여 출력하고 전체합을 리턴하는 evenOdd() 메서드

        Scanner s = new Scanner(System.in);
        System.out.print("자연수 하나를 입력하세요: ");
        int n = s.nextInt();
        sum(n);
        System.out.println("1부터 " + n + "까지 홀수의 총 갯수: " + odd(n));
        System.out.println("전체 합: " + evenOdd(n));
        s.close();
    }
}
