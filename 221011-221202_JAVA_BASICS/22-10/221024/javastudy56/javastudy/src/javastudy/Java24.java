package javastudy;

import java.util.Scanner;

public class Java24 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inc = 0, sum = 0, cnt = 0; double avg = 0.0;
        // 그냥 출력에서 avg 식을 넣어서 써도 됩니다만, 이 편이 가독성이 더 좋겠죠.
        while (inc != -1) { // inc가 -1이 아닌 이상 계속 반복
            System.out.print("次の整数：");
            inc = sc.nextInt(); // 반복을 멈추려면 여기에 -1을 입력
            if (inc == -1) {
                break; // 반복문을 즉시 나감
            }
            cnt++;
            sum += inc;
        }
        avg = (double)sum / (double)cnt;
        System.out.println("平均 = " + avg);
        sc.close();
    }
}
