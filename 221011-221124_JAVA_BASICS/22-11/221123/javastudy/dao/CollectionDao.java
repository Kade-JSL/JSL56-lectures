package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import dto.Student;

public class CollectionDao {

    private static CollectionDao collectionDao = new CollectionDao();
    private CollectionDao() {
        subStrings.put(Student.Subjects.KOR, "국어");
        subStrings.put(Student.Subjects.ENG, "영어");
        subStrings.put(Student.Subjects.MAT, "수학");
    }
    public static CollectionDao getInstance() { return collectionDao; }

    private static ArrayList<Student> studentArray = new ArrayList<Student>();
    public static ArrayList<Student> getStudentArray() { return studentArray; }

    private Scanner s = new Scanner(System.in);
    private Student.Subjects[] ja = Student.Subjects.values();
    private HashMap<Student.Subjects, String> subStrings = new HashMap<Student.Subjects, String>();

    public void insert() {
        System.out.println("성적 입력을 시작합니다. 총 학생 수: " + studentArray.size());
        Student st = new Student();
        System.out.print("학번 입력: ");
        st.setNum(s.nextInt());
        System.out.print("이름 입력: ");
        st.setName(s.next());
        System.out.print("주소 입력: ");
        st.setAddress(s.next());
        System.out.print("전화번호 입력: ");
        st.setTel(s.next());
        
        for (Student.Subjects j : ja) {
            System.out.print(subStrings.get(j) + " 점수 입력: ");
            st.setSub(j, s.nextInt());
        }
        st.setTot(intTot(st));
        st.setAvg((double) st.getTot() / (double) ja.length);

        studentArray.add(st);
    }

    public void print(Student st) {
        System.out.printf("%d\t%s\t%s\t%s\t%d\t%d\t%d\t%d\t%.2f\n", st.getNum(), st.getName(), st.getAddress(), st.getTel(), st.getSub(Student.Subjects.KOR), st.getSub(Student.Subjects.ENG), st.getSub(Student.Subjects.MAT), st.getTot(), st.getAvg());
    }

    public void delete(int num) {
        studentArray.remove(numToIndex(num));
        System.out.println(num + "번 학생을 삭제하였습니다.");
    }

    public Student select(int num) {
        return studentArray.get(numToIndex(num));
    }

    public void update(int num) {
        Student st = studentArray.get(numToIndex(num));
        System.out.println(st.getNum() + "번 학생의 점수를 수정합니다.");

        for (Student.Subjects j : ja) {
            System.out.print(subStrings.get(j) + " 점수 입력: ");
            st.setSub(j, s.nextInt());
        }
        st.setTot(intTot(st));
        st.setAvg((double) st.getTot() / (double) ja.length);

        System.out.println("수정이 성공적으로 완료되었습니다.");
    }

    private int numToIndex(int num) {
        for (int i = 0; i < studentArray.size(); i++) {
            if (studentArray.get(i).getNum() == num) {
                return i;
            }
        }
        System.out.println("학생을 찾을 수 없습니다.");
        return studentArray.size() - 1;
    }

    private int intTot(Student st) {
        int tot = 0;
        for (Student.Subjects j : ja) {
            tot += st.getSub(j);
        }
        return tot;
    }
}