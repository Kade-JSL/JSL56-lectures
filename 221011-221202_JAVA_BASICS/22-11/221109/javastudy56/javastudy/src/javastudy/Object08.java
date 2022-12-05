package javastudy;

import java.util.Scanner;

public class Object08 {
    public static void main(String[] args) {
        Object07 obj1 = new Object07(); // 클래스 객체 생성, 반드시 new라는 예약어를 사용

        obj1.bno = 1111;
        obj1.name = "홍길동";
        obj1.kor = 100;
        obj1.eng = 100;
        obj1.mat = 100;

        System.out.println(obj1.bno + " " + obj1.name + " " + obj1.kor + " " + obj1.eng + " " + obj1.mat + " " + obj1.getScore() + " " + obj1.getAve());

        Object07 obj2 = new Object07(2222, "이순신", 90, 90 ,90);

        System.out.println(obj2.bno + " " + obj2.name + " " + obj2.kor + " " + obj2.eng + " " + obj2.mat + " " + obj2.getScore() + " " + obj2.getAve());

        Scanner sc = new Scanner(System.in);
        System.out.print("번호: ");
        int bno = sc.nextInt();
        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("국어: ");
        int kor = sc.nextInt();
        System.out.print("영어: ");
        int eng = sc.nextInt();
        System.out.print("수학: ");
        int mat = sc.nextInt();
        

        Object07 obj3 = new Object07(bno, name, kor, eng, mat);

        System.out.println(obj3.bno + " " + obj3.name + " " + obj3.kor + " " + obj3.eng + " " + obj3.mat + " " + obj3.getScore() + " " + obj3.getAve());
        sc.close();
    }
}
