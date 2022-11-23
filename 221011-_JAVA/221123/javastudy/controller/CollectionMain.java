package controller;

import dao.CollectionDao;
import dto.Student;
import java.util.Scanner;

public class CollectionMain {

    public static void main(String[] args) {
        
        CollectionDao c = CollectionDao.getInstance();
        Scanner s = new Scanner(System.in);

        boolean exitb = true;
        do {

            System.out.print("[1] insert / [2] print / [3] delete / [4] select / [5] update / [etc] exit\n----------------------------------------------------------------------------\n> ");

            int menu = s.nextInt();

            if (CollectionDao.getStudentArray().size() == 0 && menu != 1) continue;

            switch(menu) {
                case 1 : {
                    int exit = 1;
                    while (true) {
                        c.insert();
                        System.out.print("입력을 종료하시겠습니까? 계속 입력하시려면 정수 " + exit + "(을)를 눌러 주세요 >> ");
                        int input = s.nextInt();
                        if (input != exit) break;
                    }
                    break;
                } case 2 : {
                    studentHeader();
                    for (Student student : CollectionDao.getStudentArray()) {
                        c.print(student);
                    }
                    break;
                } case 3 : {
                    System.out.print("제거할 학생의 번호를 입력해 주세요. 없는 학생일 경우 맨 마지막으로 입력한 학생을 제거합니다.\n>> ");
                    c.delete(s.nextInt());
                    break;
                } case 4 : {
                    System.out.print("검색할 학생의 번호를 입력해 주세요. 없는 학생일 경우 맨 마지막으로 입력한 학생을 출력합니다.\n>> ");
                    Student sel = c.select(s.nextInt());
                    System.out.println("검색 결과:\n학번\t이름\t주소\t번호\t국어\t영어\t수학\t총점\t평균");
                    c.print(sel);
                    break;
                } case 5 : {
                    System.out.print("수정할 학생의 번호를 입력해 주세요. 없는 학생일 경우 맨 마지막으로 입력한 학생을 수정합니다.\n>> ");
                    c.update(s.nextInt());
                    break;
                } default: exitb = false; break;
            }
        } while (exitb);
        System.out.println("exiting the program.");
        s.close();
    }

    static void studentHeader() {
        System.out.println("\t학생목록\n학번\t이름\t주소\t번호\t국어\t영어\t수학\t총점\t평균");
    }
}
