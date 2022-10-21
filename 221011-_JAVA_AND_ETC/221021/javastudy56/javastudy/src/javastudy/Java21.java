package javastudy;

import java.util.Scanner;

public class Java21 {
    
    public static void main(String[] args) {
        // 임의의 정수 만들기
        // Math.random(): 0.0과 1.0 사이의 임의의 double 값을 반환
        // 0.0 <= Math.random() < 1.0
        // 1에서부터 6까지의 무작위 정수 만들기:
        // 6 * 0.0 <= 6 * Math.random() < 6 * 1.0
        // 6 * 0.0 + 1 <= 6 * Math.random() + 1 < 6 * 1.0 + 1
        // 1 <= 6*M.r() < 7
        // System.out.println((int)(20 * Math.random()) + 1);
        // 형변환(캐스팅), double형을 int형으로 형변환하는 것
        Scanner sc = new Scanner(System.in);
        int w = 0, l = 0, d = 0, g = 0;
        while (true) {
            System.out.print("가위(1), 바위(2), 보(3) 중의 하나를 선택하세요: ");
            int me = sc.nextInt();
            if (me == 99) {
                break;
            } else if (me != 1 && me != 2 && me != 3) {
                System.out.println("다시 입력하세요...");
                continue;
            }
            int com = (int)(3 * Math.random()) + 1;
            String result = "";
            switch (me - com) {
                case 1:
                case -2:
                    result = "\nYou Win!";
                    w++;
                    break;
                case 0:
                    result = "\nDraw!";
                    d++;
                    break;
                default:
                    result = "\nYou Lose...";
                    l++;
            }
            g++;
            System.out.print("\nGame #" + g + ": " + result);
            System.out.println(" (W: " + w + " L: " + l + " D: " + d + ")\n\n(게임을 종료하고 싶다면 99를 입력하세요.)\n");
        }
        System.out.println("게임 종료.");
        sc.close();
    }
        
}
