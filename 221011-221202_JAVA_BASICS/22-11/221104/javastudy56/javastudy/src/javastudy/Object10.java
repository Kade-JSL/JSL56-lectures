package javastudy;

import java.util.Scanner;

public class Object10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        for(int i = 0; i < nums.length; i++) {
            System.out.print(i + 1 + "번째 점수를 입력하세요: ");
            nums[i] = sc.nextInt();
        }
        int tot = getTotal(nums);
        System.out.println("총점: " + tot);
        double ave = getAve(tot, nums.length);
        System.out.println("평균: " + ave);
        sc.close();
    }

    private static double getAve(int t, int l) {
        return (double)t / (double)l;
    }

    private static int getTotal(int... a) {
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s += a[i];
        }
        return s;
    }
}
