package exercises;

import java.util.Scanner;

public class 한글 {
    public static void main(String[] args) {
        int 정수형변수 = 0;
        Scanner 스캐너 = new Scanner(System.in);
        정수형변수 = 스캐너.nextInt();
        String 출력 = Integer.toString(정수형변수);
        System.out.println(출력);
        스캐너.close();
    }
}
