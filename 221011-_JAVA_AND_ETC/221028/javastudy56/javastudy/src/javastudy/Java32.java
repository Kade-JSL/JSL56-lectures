package javastudy;

// import java.util.Scanner;

public class Java32 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        
        // 2차원 배열

        // 배열 초기화하기:

        // 1번 방법
        // int[][] arr = new int[3][3]; // 3행 3열인 2차원 배열

        // 2번 방법
        /*
        int[][] arr = new int[][] {
            {80, 80, 80},
            {100, 100, 100},
            {50, 50, 50}
        };
        */

        // 3번 방법
        int[][] arr = {
            {80, 80, 80},
            {100, 100, 100},
            {50, 50, 50}
        };

        /*
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                String sub;
                if (j == 0) {
                    sub = "국어";
                } else if (j == 1) {
                    sub = "영어";
                } else {
                    sub = "수학";
                }
                System.out.print((i + 1) + "번의 " + sub + " 점수 입력: ");
                arr[i][j] = sc.nextInt();
            }
        }
        */

        /* 뱀발:
         * arr[][]에서 행의 길이는 arr.length, i번 열의 길이는 arr[i].length로 표현합니다.
         * 이는 사실 2차원 배열은 1차원 배열로 이루어진 1차원 배열이기 때문입니다.
         * 즉 arr[][] = {arr[1], arr[2], ... , arr[i], ...};이라는 뜻입니다.
         * 여기까지 이해하셨다면 아래의 코드에서 제가 length 메소드를 어떻게 사용하였는지 이해가 되실 겁니다.
         */

        // 선언
        int tk = 0, te = 0, tm = 0;
        int[] rank = {1, 1, 1}, tot = new int[arr.length];
        double[] avg = new double[arr.length];

        // 처리
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                tot[i] += arr[i][j];
            } // 총점
            avg[i] = (double)tot[i] / (double)arr.length; // 평균
            tk += arr[i][0]; te += arr[i][1]; tm += arr[i][2]; // 과목총점
        }
        for (int i = 0; i < rank.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                if (tot[i] < tot[j]) {
                    rank[i]++;
                }
            }
        }

        // 출력
        System.out.println("번호\t국어\t영어\t수학\t총점\t평균\t순위");
        for (int i = 0; i < arr.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println(tot[i] + "\t" + avg[i] + "\t" + rank[i]);
        }

        System.out.println("총점" + "\t" + tk  + "\t" + te + "\t" + tm);
    }
}
