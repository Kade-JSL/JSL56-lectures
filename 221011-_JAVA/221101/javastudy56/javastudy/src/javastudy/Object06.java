﻿package javastudy;

public class Object06 {
    static int getTotal(int... var) {
        int tot = 0;
        for (int i = 0; i < var.length; i++) {
            tot += var[i];
        }
        return tot;
    }
    static int getSum(String a, int b, int c) {
        return Integer.parseInt(a) + b + c;
    }
    static double getAve(int sum, int num) {
        return (double)sum / (double) num;
    }
    public static void main(String[] args) {
        int total = getTotal(10, 20);
        System.out.println("total: " + total);
        int sum = getSum("10", 20, 30);
        System.out.println("sum: " + sum);
        double average = getAve(sum, 3);
        System.out.println("average: " + average);
    }
}
