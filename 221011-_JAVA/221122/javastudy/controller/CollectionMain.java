package controller;

import java.util.ArrayList;
import dto.Student;

public class CollectionMain {
    public static void main(String[] args) {
        // ArrayList<Integer> arrayList = new ArrayList<Integer>(); 
        // arrayList.add(10);
        // arrayList.add(20);
        // arrayList.add(30);
        // System.out.println(arrayList.size());
        // int sum = 0;
        // for (int i = 0; i < arrayList.size(); i++) {
        //     System.out.print(arrayList.get(i) + " ");
        //     sum += arrayList.get(i);
        // }
        // System.out.println("\nsum = " + sum);

        ArrayList<Student> stuList = new ArrayList<Student>();
        Student student1 = new Student();
        student1.setNum(1111);
        student1.setName("케이드");
        student1.setAddress("대전광역시");
        student1.setKor(100);
        student1.setEng(100);
        student1.setMat(100);

        stuList.add(student1);

        Student student2 = new Student();
        student2.setNum(2222);
        student2.setName("파랑이");
        student2.setAddress("서울특별시");
        student2.setKor(90);
        student2.setEng(90);
        student2.setMat(90);

        stuList.add(student2);

        stuList.add(new Student(3333, "페시아", "서울특별시", 80, 100, 80));

        // 출력 한 번 시켜봐.
        for (Student s : stuList) {
            int tot = 0;
            Student.Subjects[] jv = Student.Subjects.values();
            System.out.print(s.getNum() + " ");
            System.out.print(s.getName() + " ");
            System.out.print(s.getAddress() + " ");
            for (Student.Subjects j : jv) {
                System.out.print(s.getSub(j));
                tot += s.getSub(j);
                System.out.print(" ");
            }
            s.setTot(tot);
            s.setAvg((double) tot / (double) jv.length);
            System.out.print(s.getTot() + " ");
            System.out.print(s.getAvg() + " ");
            System.out.println();
        }
    }
}
