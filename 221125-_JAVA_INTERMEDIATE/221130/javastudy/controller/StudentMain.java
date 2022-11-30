package controller;

import java.util.List;
import java.util.Scanner;
import dao.StudentDao;
import dto.Student;

public class StudentMain {

    static void prompt(String s) {
        String crudString = s.substring(0, 2);
        if (crudString.equals("학생")) {
            if (s.substring(2).equals("못찾음")) {
                System.out.println("해당 학생을 찾을 수 없습니다. 다시 시도해 주세요.");
                return;
            } else if (s.substring(2).equals("첫줄")) {
                System.out.println("학번\t이름\t주소\t\t번호\t국어\t영어\t수학\t총점\t평균\t결과");
                return;
            }
        }
        if (s.substring(2).equals("입력")) {
            System.out.print(crudString + "하고자 하는 학번을 입력하세요 >> ");
        } else if (s.substring(2).equals("완료")) {
            System.out.print("정상적으로 " + crudString + "(이)가 완료되었습니다.\n");
        } else if (s.substring(2).equals("안완료")) {
            System.out.print("정상적으로 " + crudString + "(이)가 완료되지 않았습니다. 다시 시도해 주세요.\n");
        } else if (s.substring(2).equals("정말")) {
            System.out.print("정말로 " + crudString + "하시겠습니까?[Y/n(default)] >> ");
        }
    }

    public static void main(String[] args) {

        StudentDao stuDao = StudentDao.getDao();

        Scanner sc = new Scanner(System.in);

        boolean run = true;

        Student stu = null;
        int inputNum = 0;
        String ynselect = null;

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
                    prompt("학생첫줄");
                    for (Student s : stuList) {
                        stuDao.read(s);
                    }
                    break;
                case 3:
                    prompt("수정입력");
                    inputNum = sc.nextInt();
                    stu = stuDao.selectNum(inputNum);
                    if (stu == null) {
                        prompt("학생못찾음");
                        break;
                    }
                    System.out.println("수정 대상 학생");
                    prompt("학생첫줄");
                    stuDao.read(stu);
                    prompt("수정정말");
                    ynselect = sc.next();
                    if (!ynselect.toLowerCase().equals("y")) break;
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
                        prompt("수정완료");
                        System.out.println("수정 결과: ");
                        stuDao.read(stu);
                    } else {
                        prompt("수정안완료");
                    }
                    break;
                case 4:
                    prompt("삭제입력");
                    inputNum = sc.nextInt();
                    stu = stuDao.selectNum(inputNum);
                    if (stu == null) { prompt("학생못찾음"); break; }
                    prompt("학생첫줄");
                    stuDao.read(stu);
                    prompt("삭제정말");
                    ynselect = sc.next();
                    if (!ynselect.toLowerCase().equals("y")) { System.out.println("삭제가 취소되었습니다."); break; }
                    int result = stuDao.delete(inputNum);
                    if (result > 0) prompt("삭제완료");
                    else prompt("삭제안완료");
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
