package controller;

import java.util.Scanner;
import dao.StudentDaoE;
import dto.StudentDto;

public class StudentMainE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean run = true;
        
        while (run) {
            System.out.print("menu\n[1] create new / [0] exit\n>> ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    StudentDto stu = new StudentDto();
                    stu.setNum(StudentDaoE.getMaxNum() + 1);
                    System.out.printf("num = %d\nname address tel kor eng mat\n>> ", stu.getNum());
                    stu.setName(sc.next());
                    stu.setAddress(sc.next());
                    stu.setTel(sc.next());
                    stu.setKor(sc.nextInt());
                    
            }
        }
        sc.close();
    }
}
