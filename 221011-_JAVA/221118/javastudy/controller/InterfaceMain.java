package controller;

import java.util.ArrayList;
import java.util.Scanner;
import dto.Student;

interface 점수 { // 인터페이스

    int 갯수 = 10; // 상수

    /* public abstract */ void 성적입력(); // 따로 접근 제한자를 두지 않아도 인터페이스에선 모두 이런 취급이다

    void 성적계산();

    void 성적출력();
}


class 점수처리 extends Student implements 점수 {

    ArrayList<Student> 학생목록 = new ArrayList<Student>();
    Scanner 스캐너 = new Scanner(System.in);

    int 번호 = 1110;

    @Override
    public void 성적입력() {
        System.out.println("학번: " + ++번호);
        System.out.print("이름: ");
        String name = 스캐너.next();
        System.out.print("주소: ");
        String address = 스캐너.next();
        System.out.print("전화번호: ");
        String tel = 스캐너.next();
        System.out.print("국어: ");
        int kor = 스캐너.nextInt();
        System.out.print("영어: ");
        int eng = 스캐너.nextInt();
        System.out.print("수학: ");
        int mat = 스캐너.nextInt();



        Student 학생 = new Student();
        학생.setNum(번호);
        학생.setName(name);
        학생.setAddress(address);
        학생.setTel(tel);
        학생.setKor(kor);
        학생.setEng(eng);
        학생.setMat(mat);
        학생목록.add(학생);
    }

    @Override
    public void 성적계산() {
        // 총점과 평균 계산
        for (Student 학생 : 학생목록) {
            int tot = 0;
            for (Student.Subjects 과목 : Student.Subjects.values()) {
                switch (과목) {
                    case KOR:
                        tot += 학생.getKor();
                        break;
                    case ENG:
                        tot += 학생.getEng();
                        break;
                    case MAT:
                        tot += 학생.getMat();
                        break;
                }
            }
            double avg = (double) tot / (double) Student.Subjects.values().length;
            학생.setTot(tot);
            학생.setAvg(avg);
        }
    }

    @Override
    public void 성적출력() {
        System.out.println("성적표");
        System.out.println("번호\t이름\t주소\t전화\t국어\t영어\t수학\t총점\t평균");
        for (Student 학생 : 학생목록) {
            System.out.println(학생.getNum() + "\t " + 학생.getName() + "\t " + 학생.getAddress() + "\t "
                    + 학생.getTel() + "\t " + 학생.getKor() + "\t " + 학생.getEng() + "\t " + 학생.getMat()
                    + "\t " + 학생.getTot() + "\t " + 학생.getAvg());
        }
    }

}


public class InterfaceMain {
    public static void main(String[] args) {
        점수처리 학생목록 = new 점수처리();
        Scanner 스캐너 = new Scanner(System.in);

        while (true) {
            System.out.println("메뉴");
            System.out.println("1. 자료입력");
            System.out.println("2. 성적출력");
            System.out.println("0(or etc.). 종료");
            System.out.print("작업 번호 선택 >> ");
            int 메뉴 = 스캐너.nextInt();
            if (메뉴 == 1) {
                while (true) {
                    학생목록.성적입력();
                    학생목록.성적계산();
                    System.out.print("더 입력하려면 1을 입력하세요: ");
                    int 추가입력여부 = 스캐너.nextInt();
                    if (추가입력여부 != 1) {
                        break;
                    }
                }
            } else if (메뉴 == 2) {
                학생목록.성적출력();
            } else {
                break;
            }
        }

        System.out.println("프로그램을 종료합니다.");
        스캐너.close();
    }
}
