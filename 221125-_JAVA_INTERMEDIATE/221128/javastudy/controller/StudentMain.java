package controller;

import java.util.HashMap;
import java.util.Scanner;
import dao.StudentJdbcDao;
import dto.Student;

public class StudentMain {
    public static void main(String[] args) {

        StudentJdbcDao studentDBConn = StudentJdbcDao.getDao();

        Scanner sc = new Scanner(System.in);

        Student.Subjects[] subs = Student.Subjects.values();
        HashMap<Student.Subjects, String> subm = new HashMap<>();
        subm.put(subs[0], "국어"); subm.put(subs[1], "영어"); subm.put(subs[2], "수학");

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

                    for (Student.Subjects j : subs) {
                        System.out.print(subm.get(j) + "점수: ");
                        stu.setSub(j, sc.nextInt());
                    }

                    int tot = 0; for (Student.Subjects j : subs) { tot += stu.getSub(j); }
                    stu.setTot(tot);
                    double avg = (double) tot / (double) subs.length;
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
