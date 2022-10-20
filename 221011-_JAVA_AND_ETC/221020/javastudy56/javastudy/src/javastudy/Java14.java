package javastudy;

import java.util.Scanner;

public class Java14 {
    
    public static void main(String[] args) {
        // 번호 1111, 이름 홍길동, 점수가 90점

        // 출력예:
        // 합격여부
        // 번호 이름 점수 합격여부
        // 1111 홍길동 90 합격

        // 80점 이상이면 합격, 아니면 재시험
        Scanner sc = new Scanner(System.in);

        System.out.print("번호: ");
        int bno = sc.nextInt();
        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("점수: ");
        int score = sc.nextInt();
        
        String msg = "";
        if (score >= 80) {
            msg = "합격";
        } else {
            msg = "재시험";
        }

        System.out.println("\t합격여부");
        System.out.println("번호\t이름\t점수\t합격여부");
        System.out.println(bno + "\t" + name + "\t" + score + "\t" + msg);
        
        sc.close();
    }
}
