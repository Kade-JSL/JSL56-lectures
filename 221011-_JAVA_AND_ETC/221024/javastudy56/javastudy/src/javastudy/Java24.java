package javastudy;

import java.util.Scanner;

public class Java24 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inc = 0, sum = 0, cnt = 0; double avg = 0.0;
        // avgは実際出力だけで使われるので、宣言する必要まではないんですが、コードの可読性のため宣言しました。
        while (inc != -1) { // incが-1じゃない限り、ループは抜けません。
            System.out.print("次の整数：");
            inc = sc.nextInt(); // 抜けるにはここに-1を入力します。
            if (inc == -1) {
                break; // ループ文を抜けます。
            }
            cnt++;
            sum += inc;
        }
        avg = (double)sum / (double)cnt;
        System.out.println("平均 = " + avg);
        sc.close();
    }
}
