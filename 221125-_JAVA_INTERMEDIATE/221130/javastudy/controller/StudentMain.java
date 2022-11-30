package controller;

import java.util.List;
import java.util.Scanner;
import dao.StudentDao;
import dto.Student;

public class StudentMain {

    static void prompt() {
        System.out.println("해당 학생을 찾을 수 없습니다. 다시 시도해 주세요.");
    }

    static void prompt(char crud, int pindex) {
        String crudString = "";
        switch (crud) {
            case 'r': System.out.println("학번\t이름\t주소\t\t번호\t국어\t영어\t수학\t총점\t평균\t결과"); return;
            case 'u': crudString = "수정"; break;
            case 'd': crudString = "삭제"; break;
            default: return;
        }
        switch (pindex) {
            case 0:
                System.out.print(crudString + "하고자 하는 학번을 입력하세요 >> ");
                break;
            case 1:
                System.out.print("정상적으로 " + crudString + "(이)가 완료되었습니다.\n");
                break;
            case 2:
                System.out.print("정상적으로 " + crudString + "(이)가 완료되지 않았습니다. 다시 시도해 주세요.\n");
                break;
            default: return;
        }
    }

    public static void main(String[] args) {

        StudentDao stuDao = StudentDao.getDao();

        Scanner sc = new Scanner(System.in);

        boolean run = true;

        Student stu = null;
        int inputNum = 0;

        while (run) {
            System.out.print("[1] 입력 / [2] 출력 / [3] 수정 / [4] 삭제 / [0] 종료\n메뉴 선택 >> ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    stu = new Student();
                    stu.setNum(stuDao.numAdd() + 1);
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

                    stuDao.insert(stu);

                    break;
                case 2:
                    List<Student> stuList = stuDao.selectAll();
                    
                    System.out.println("학생 목록");
                    prompt('r', 0);
                    for (Student s : stuList) {
                        stuDao.read(s);
                    }
                    break;
                case 3:
                    prompt('u', 0);
                    inputNum = sc.nextInt();
                    stu = stuDao.selectNum(inputNum);
                    if (stu == null) {
                        prompt();
                        break;
                    }
                    System.out.println("수정 대상 학생");
                    prompt('r', 0);
                    stuDao.read(stu);
                    System.out.print("수정할 국어점수: ");
                    int ukor = sc.nextInt();
                    System.out.print("수정할 영어점수: ");
                    int ueng = sc.nextInt();
                    System.out.print("수정할 수학점수: ");
                    int umat = sc.nextInt();
                    int utot = ukor + ueng + umat;
                    double uavg = (double) utot / 3.;

                    stu.setKor(ukor);
                    stu.setEng(ueng);
                    stu.setMat(umat);
                    stu.setTot(utot);
                    stu.setAvg(uavg);
                    if (uavg >= 80) stu.setResult("합격");
                    else stu.setResult("불합격");
                    int updateResult = stuDao.update(stu);
                    if (updateResult > 0) {
                        prompt('u', 1);
                        System.out.println(" 수정 결과: ");
                        stuDao.read(stu);
                    } else {
                        prompt('u', 2);
                    }
                    break;
                case 4:
                    prompt('d', 0);
                    inputNum = sc.nextInt();
                    stu = stuDao.selectNum(inputNum);
                    if (stu == null) {
                        prompt();
                        break;
                    }
                    stuDao.read(stu);
                    System.out.print("정말로 이 학생을 삭제하시겠습니까(Y/n(default))? >> ");
                    if (sc.next().equals("Y")) {
                        int result = stuDao.delete(inputNum);
                        if (result > 0) prompt('d', 1);
                        else prompt('d', 2); break;
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
