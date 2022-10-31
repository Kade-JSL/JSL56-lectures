package javastudy;

import java.util.Scanner;

public class Java11 {
    
    public static void main(String[] args) {
        /*
        int sum = 1;
        System.out.println("sum의 값= " + sum);
        sum = sum + 1;
        System.out.println("sum의 값= " + sum);
        sum = sum + 1;
        System.out.println("sum의 값= " + sum);
        sum = sum + 1;
        System.out.println("sum의 값= " + sum);
        sum = sum + 1;
        System.out.println("sum의 값= " + sum);
        */

        /*
        Scanner tri = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int a = tri.nextInt();
        System.out.print("Enter the second integer: ");
        a = a + tri.nextInt();
        System.out.print("Enter the third integer: ");
        a = a + tri.nextInt();

        System.out.println("Sum of three integers: " + a);
        */

        int a = 5;
        a++; a--; // ++은 a += 1로도 쓸 수 있다. 
        System.out.println(a);

        int b = 5;
        System.out.println(++b);
    }

}
