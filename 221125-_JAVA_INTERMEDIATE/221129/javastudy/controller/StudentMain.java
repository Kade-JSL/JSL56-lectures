package controller;

import java.util.List;
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
                case 2:
                    List<Student> stuList = studentDBConn.selectAll();
                    
                    System.out.println("학생 목록\n학번\t이름\t주소\t\t번호\t국어\t영어\t수학\t총점\t평균\t결과");
                    for (Student s : stuList) {
                        System.out.printf("%d\t%s\t%s\t%s\t%d\t%d\t%d\t%d\t%5.2f\t%s\n", s.getNum(), s.getName(),
                                s.getAddress(), s.getTel(), s.getKor(), s.getEng(), s.getMat(), s.getTot(),
                                s.getAvg(), s.getResult());
                    }
                    break;
                case 4:
                    System.out.print("삭제하고자 하는 학번을 입력하세요 >> ");
                    int deleteNum = sc.nextInt();
                    Student s = studentDBConn.selectNum(deleteNum);
                    System.out.printf("%d\t%s\t%s\t%s\t%d\t%d\t%d\t%d\t%5.2f\t%s\n", s.getNum(), s.getName(),
                                s.getAddress(), s.getTel(), s.getKor(), s.getEng(), s.getMat(), s.getTot(),
                                s.getAvg(), s.getResult());
                    System.out.print("정말로 이 학생을 삭제하시겠습니까(Y/n(default))? >> ");
                    if (sc.next().equals("Y")) {
                        int result = studentDBConn.delete(deleteNum);
                        if (result > 0) System.out.println("삭제가 완료되었습니다.");
                        else System.out.println("정상적으로 삭제가 완료되지 않았습니다. 다시 시도해 주세요."); break;
                    } else {
                        System.out.println("삭제가 취소되었습니다.");
                    }
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
