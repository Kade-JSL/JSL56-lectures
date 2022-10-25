package javastudy;

import java.util.Scanner;

public class Java25 {
    public static void main(String[] args) {
        // do-while 문:
        // do {
        // 실행문;
        // } while(조건식);
        // 조건식이 끝에 있기 때문에 무조건 한 번은 실행문이 실행됨
        // 조건식이 true이면 반복, false이면 다음 줄 == 반복 종료
        Scanner sc = new Scanner(System.in);
        int ans = (int)(100 * Math.random() + 1);
        int att = 0;
        int cnt = 0;
        do {
            System.out.print("숫자를 하나 던져 보아라?(1-100): ");
            att = sc.nextInt(); cnt++;
            if (att < ans) {
                System.out.println("Up");
            } else if (att > ans) {
                System.out.println("Down");
            } else if (att == ans) {
                break;
            }
        } while (true);
        System.out.println("정답! 숫자는 " + ans + "(이)었습니다.\n추측한 횟수: " + cnt);
        sc.close();
    }
}
