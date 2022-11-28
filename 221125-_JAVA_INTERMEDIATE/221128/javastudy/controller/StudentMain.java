package controller;

import java.util.Scanner;
import dao.StudentJdbcDao;
import dto.Student;

public class StudentMain {
    public static void main(String[] args) {

        StudentJdbcDao studentDBConn = StudentJdbcDao.getDao();

        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.print("[1] 입력 / [2] 출력 / [3] 수정 / [4] 삭제 / [0] 종료\n메뉴 선택 >> ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    Student stu = new Student();
                    stu.setNum(studentDBConn.numAdd() + 1);
                    System.out.print("학번: " + stu.getNum() + "\n");
                    System.out.print("이름: ");
                    stu.setName(sc.next());
                    System.out.print("주소: ");
                    stu.setAddress(sc.next());
                    System.out.print("전화번호: ");
                    stu.setTel(sc.next());
                    System.out.print("국어점수: ");
                    stu.setKor(sc.nextInt());
                    System.out.print("영어점수: ");
                    stu.setEng(sc.nextInt());
                    System.out.print("수학점수: ");
                    stu.setMat(sc.nextInt());

                    int tot = stu.getKor() + stu.getEng() + stu.getMat();
                    stu.setTot(tot);
                    double avg = (double) tot / 3.;
                    stu.setAvg(avg);

                    if (avg >= 80.0) stu.setResult("합격");
                    else stu.setResult("불합격");

                    studentDBConn.insert(stu);

                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                    break;
                default:
                    System.out.println("메뉴를 다시 입력해 주세요.");
                    continue;
            }
        }

        sc.close();
    }
}
