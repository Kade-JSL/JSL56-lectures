package javastudy;

public class Java33 {
    public static void main(String[] args) {
        // 가변 배열

        /*
        int[][] score = new int[3][];
        score[0] = new int[3];
        score[1] = new int[2];
        score[5] = new int[5];
        */

        // 配列：同じ型の変数を保存して置く記憶空間
        int [][] score = {
            {10, 20, 30},
            {10, 20},
            {10, 20, 30, 40, 50}
        };

        for(int i = 0; i < score.length; i++) {
            int sum = 0;
            for(int j = 0; j < score[i].length; j++) {
                sum += score[i][j];
            }
            System.out.println(i + "번 행의 합: " + sum);
        }

    }
}
