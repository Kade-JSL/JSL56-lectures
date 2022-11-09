package javastudy;

import java.util.Scanner;

class Member {
    String birth, id, writer, email, tel;
    Scanner s = new Scanner(System.in);

    public Member() {
        /*
        System.out.print("아이디: ");
        id = s.next();
        System.out.print("이메일: ");
        email = s.next();
        System.out.print("이름: ");
        writer = s.next();
        System.out.print("생년월일: ");
        birth = s.next();
        System.out.print("전화번호: ");
        tel = s.next();
        */
    }
    public Member(String id, String email, String writer, String birth, String tel) {
        this.id = id;
        this.email = email;
        this.writer = writer;
        this.birth = birth;
        this.tel = tel;
    }

    public void headerPrint() {
        System.out.println("회원관리");
        System.out.println("---------------------------------------------------------------");
        System.out.println("번호\t이름\t아이디\t이메일\t전화번호\t생년월일");
        System.out.println("---------------------------------------------------------------");
    }
    public void memberPrint() {
        System.out.println("1" + "\t" + writer + "\t" + id + "\t" + email + "\t" + tel + "\t" + birth);
    }
}

public class MemberMain {
    public static void main(String[] args) {
        String birth, id, writer, email, tel;
        Scanner s = new Scanner(System.in);
        System.out.print("아이디: ");
        id = s.next();
        System.out.print("이메일: ");
        email = s.next();
        System.out.print("이름: ");
        writer = s.next();
        System.out.print("생년월일: ");
        birth = s.next();
        System.out.print("전화번호: ");
        tel = s.next();
        Member m = new Member(id, email, writer, birth, tel);
        m.headerPrint();
        m.memberPrint();
        s.close();
    }
}
