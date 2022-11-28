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
        Student.Subjects[] jv = Student.Subjects.values();

        Student student1 = new Student();
        student1.setNum(1111);
        student1.setName("케이드");
        student1.setAddress("대전광역시");
        for (Student.Subjects j : jv) {
            student1.setSub(j, 100);
        }

        stuList.add(student1);

        Student student2 = new Student();
        student2.setNum(2222);
        student2.setName("파랑이");
        student2.setAddress("서울특별시");
        for (Student.Subjects j : jv) {
            student2.setSub(j, 90);
        }

        stuList.add(student2);

        stuList.add(new Student(3333, "페시아", "서울특별시", 80, 100, 80));

        // 출력 한 번 시켜봐.
        for (Student s : stuList) {
            int tot = 0;
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
