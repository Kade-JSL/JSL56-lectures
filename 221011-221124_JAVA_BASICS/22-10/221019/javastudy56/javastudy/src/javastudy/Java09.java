package javastudy;

import java.util.Scanner;

public class Java09 {

    public static void main(String[] args) {
        /* 키보드로부터 10과 20을 입력받아
        더하기, 빼기, 곱하기, 나누기, 나머지
        의 값을 구하여 출력하시오 */
        Scanner cal = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int num1 = cal.nextInt();
        System.out.print("Enter the second integer: ");
        int num2 = cal.nextInt();
        int add = num1 + num2;
        int sub = num1 - num2;
        long mul = (long)num1 * (long)num2;
        double div = (double)num1 / (double)num2;
        int rem = num1 % num2;
        System.out.println("\nThe result of the calculations: \nAddition = " + add + "\nSubtraction = " + sub + "\nMultiplication = " + mul + "\nDivision = " + div + "\nRemainder = " + rem);
    }

}
