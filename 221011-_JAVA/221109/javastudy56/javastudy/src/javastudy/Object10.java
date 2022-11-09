package javastudy;

import java.util.Scanner;

public class Object10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력하세요: ");
        String id = sc.next();
        System.out.print("비밀번호를 입력하세요: ");
        String pw = sc.next();
        Object09 u = new Object09(id, pw);
        u.printResult();
        sc.close();
    }
}