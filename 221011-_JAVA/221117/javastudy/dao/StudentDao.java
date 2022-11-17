package dao;

import java.util.ArrayList;
import java.util.Scanner;
import dto.StudentDto;

public class StudentDao {

    ArrayList<StudentDto> stuArr = new ArrayList<StudentDto>();

    Scanner s = new Scanner(System.in);

    int num = 1110;

    public void addStudent() {
        System.out.println("학번: " + ++num);
        System.out.print("이름: ");
        String name = s.next();
        System.out.print("주소: ");
        String address = s.next();
        System.out.print("전화번호: ");
        String tel = s.next();
        System.out.print("국어: ");
        int kor = s.nextInt();
        System.out.print("영어: ");
        int eng = s.nextInt();
        System.out.print("수학: ");
        int mat = s.nextInt();

        int tot = 0;
        for (StudentDto.Subjects s : StudentDto.Subjects.values()) {
            switch (s) {
                case KOR:
                    tot += kor;
                    break;
                case ENG:
                    tot += eng;
                    break;
                case MAT:
                    tot += mat;
                    break;
            }
        }
        double avg = (double) tot / (double) StudentDto.Subjects.values().length;

        StudentDto s = new StudentDto();
        s.setNum(num);
        s.setName(name);
        s.setAddress(address);
        s.setTel(tel);
        s.setKor(kor);
        s.setEng(eng);
        s.setMat(mat);
        s.setTot(tot);
        s.setAvg(avg);
        stuArr.add(s);
    }

    public void printStudentList() {
        System.out.println("성적표");
        System.out.println("번호\t이름\t주소\t전화\t국어\t영어\t수학\t총점\t평균");
        for (int i = 0; i < stuArr.size(); i++) {
            System.out.println(stuArr.get(i).getNum() + "\t " + stuArr.get(i).getName() + "\t "
                    + stuArr.get(i).getAddress() + "\t " + stuArr.get(i).getTel() + "\t "
                    + stuArr.get(i).getKor() + "\t " + stuArr.get(i).getEng() + "\t "
                    + stuArr.get(i).getMat() + "\t " + stuArr.get(i).getTot() + "\t "
                    + stuArr.get(i).getAvg());
        }
    }
}
