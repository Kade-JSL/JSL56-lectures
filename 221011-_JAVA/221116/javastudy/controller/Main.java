package controller;

import java.util.Scanner;
// import dto.Student; // javastudy.Student도 존재함
import dao.StudentDao;

public class Main {

    // private 멤버들은 클래스 밖에선 접근할 수 없음
    // 참고로 아무 것도 안 붙이면 패키지 밖에선 접근할 수 없다. import를 한대도 말이다.
    public static void main(String[] args) {

        StudentDao dao = new StudentDao();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("메뉴");
            System.out.println("1. 자료입력");
            System.out.println("2. 성적출력");
            System.out.println("0(or etc.). 종료");
            System.out.print("작업 번호 선택 >> ");
            int menu = s.nextInt();
            if (menu == 1) {
                while (true) {
                    dao.addStudent();
                    System.out.print("더 입력하려면 1을 입력하세요: ");
                    int stopInput = s.nextInt();
                    if (stopInput != 1) {
                        break;
                    }
                }
            } else if (menu == 2) {
                dao.printStudentList();
            } else {
                break;
            }
        }

        System.out.println("프로그램을 종료합니다.");
        s.close();
    }
}
