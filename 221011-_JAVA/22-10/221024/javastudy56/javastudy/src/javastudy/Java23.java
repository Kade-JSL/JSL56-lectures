package javastudy;

// import java.util.Scanner;

public class Java23 {
    
    public static void main(String[] args) {
        /*
        int jt = 0, et = 0, mt = 0; // 番号ごとに点数を保存する必要がないなら、総点の変数だけ宣言してもいいではないかと。
        Scanner sc = new Scanner(System.in);
        for (int bno = 1; bno <= 3; bno++) {
            System.out.print(bno + "番の国語点数は?: ");
            jt += sc.nextInt();
            System.out.print(bno + "番の英語点数は?: ");
            et += sc.nextInt();
            System.out.print(bno + "番の数学点数は?: ");
            mt += sc.nextInt();
        }
        System.out.printf("国語総合: %d点, 英語総合: %d点, 数学総合: %d点", jt, et, mt);
        sc.close();
        */

        /*
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("1から10までの合: " + sum);
        */

        
        int sum = 0;
        for(int i = 1; i <= 10; i++) {
            sum += i;
            if (i == 10) {
                System.out.print(i + "=");
            } else {
                System.out.print(i + "+");
            }
        }
        System.out.print(sum);
        
    }
}
