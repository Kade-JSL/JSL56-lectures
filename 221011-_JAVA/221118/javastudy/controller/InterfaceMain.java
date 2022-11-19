package controller;

import java.util.ArrayList;
import java.util.Scanner;
import dto.Student;

interface ScoreInterfaces { // 인터페이스

    int 갯수 = 10; // 상수

    /* public abstract */ void scoreInput(); // 따로 접근 제한자를 두지 않아도 인터페이스에선 모두 이런 취급이다

    void scoreCalc();

    void printScore();
}


class ScoreCalc extends Student implements ScoreInterfaces {

    ArrayList<Student> studentList = new ArrayList<Student>();
    Scanner scanner = new Scanner(System.in);

    int bno = 1110;

    @Override
    public void scoreInput() {
        System.out.println("학번: " + ++bno);
        System.out.print("이름: ");
        String name = scanner.next();
        System.out.print("주소: ");
        String address = scanner.next();
        System.out.print("전화번호: ");
        String tel = scanner.next();
        System.out.print("국어: ");
        int kor = scanner.nextInt();
        System.out.print("영어: ");
        int eng = scanner.nextInt();
        System.out.print("수학: ");
        int mat = scanner.nextInt();

        Student student = new Student();
        student.setNum(bno);
        student.setName(name);
        student.setAddress(address);
        student.setTel(tel);
        student.setKor(kor);
        student.setEng(eng);
        student.setMat(mat);
        studentList.add(student);
    }

    @Override
    public void scoreCalc() {
        // 총점과 평균 계산
        for (Student s : studentList) {
            int tot = 0;
            for (Student.Subjects subj : Student.Subjects.values()) {
                switch (subj) {
                    case KOR:
                        tot += s.getKor();
                        break;
                    case ENG:
                        tot += s.getEng();
                        break;
                    case MAT:
                        tot += s.getMat();
                        break;
                }
            }
            double avg = (double)tot / (double)Student.Subjects.values().length;
            s.setTot(tot);
            s.setAvg(avg);
        }
    }

    @Override
    public void printScore() {
        System.out.println("성적표");
        System.out.println("번호\t이름\t주소\t전화\t국어\t영어\t수학\t총점\t평균");

        for (Student s : studentList) {
            System.out.println(s.getNum() + "\t " + s.getName() + "\t " + s.getAddress() + "\t "
                    + s.getTel() + "\t " + s.getKor() + "\t " + s.getEng() + "\t " + s.getMat()
                    + "\t " + s.getTot() + "\t " + s.getAvg());
        }
    }

}


public class InterfaceMain {
    public static void main(String[] args) {
        ScoreCalc scoreCalc = new ScoreCalc();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("메뉴");
            System.out.println("1. 자료입력");
            System.out.println("2. 성적출력");
            System.out.println("0(or etc.). 종료");
            System.out.print("작업 번호 선택 >> ");
            int menu = sc.nextInt();
            if (menu == 1) {
                while (true) {
                    scoreCalc.scoreInput();
                    scoreCalc.scoreCalc();
                    System.out.print("더 입력하려면 1을 입력하세요: ");
                    int addInput = sc.nextInt();
                    if (addInput != 1) {
                        break;
                    }
                }
            } else if (menu == 2) {
                scoreCalc.printScore();
            } else {
                break;
            }
        }

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
