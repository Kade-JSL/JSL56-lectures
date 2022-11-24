package dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import dto.Student;

public class ScoreDaoImpl implements ScoreDao {

    private static ScoreDaoImpl scoreDao = new ScoreDaoImpl();

    private ScoreDaoImpl() {
    }

    public static ScoreDaoImpl getInstance() {
        return scoreDao;
    }

    private static HashMap<String, Student> stuMap = new HashMap<String, Student>();

    private Scanner s = new Scanner(System.in);
    private Student.Subjects[] jv = Student.Subjects.values();

    public void run() {
        while (true) {
            switch (selectMenu()) {
                case 1:
                    scoreAdd();
                    break;
                case 2:
                    scoreSelect();
                    break;
                case 3:
                    scoreUpdate();
                    break;
                case 4:
                    scoreDelete();
                    break;
                case 0:
                    System.out.println("exiting the program.");
                    return;
                default:
                    System.out.println("enter the right number...\n");
                    break;
            }
        }
    }

    public int selectMenu() {
        System.out.print("[1] add / [2] select / [3] update / [4] delete / [0] exit\n>> ");
        return s.nextInt();
    }

    public void scoreAdd() {
        System.out.printf("%d번째 학생 등록을 시작합니다.\n", stuMap.size() + 1);
        Student student = new Student();
        System.out.print("학번, 이름, 주소, 전화, 국어, 영어, 수학 순으로 입력\n>> ");
        student.setNum(s.nextInt());
        student.setName(s.next());
        student.setAddress(s.next());
        student.setTel(s.next());
        for (Student.Subjects j : jv) {
            student.setSub(j, s.nextInt());
        }

        student.setTot(intTot(student));
        student.setAvg((double) student.getTot() / (double) jv.length);

        stuMap.put(student.getName(), student);
        System.out.println(student.getName() + " 학생의 정보 입력이 완료되었습니다.");
    }

    // public void scoreDelete() {
    // System.out.print("삭제하고자 하는 학생 이름을 입력하세요 >> ");
    // String remove = s.next();
    // if (stuMap.containsKey(remove)) {
    // stuMap.remove(remove);
    // System.out.println(remove + " 학생의 기록 제거가 성공적으로 완료되었습니다.");
    // } else {
    // System.out.println(remove + " 학생은 목록에 없습니다.");
    // }
    // }

    public void scoreDelete() {
        System.out.print("삭제하고자 하는 학생 이름을 입력하세요 >> ");
        String name = s.next();

        Set<String> set = stuMap.keySet();
        Iterator<String> it = set.iterator();

        while (it.hasNext()) {
            String n = it.next();
            if (name.equals(n)) {
                stuMap.remove(n);
                System.out.println(name + " 학생의 기록 제거가 성공적으로 완료되었습니다.");
                return;
            }
        }
        System.out.println(name + " 학생은 목록에 없습니다.");
    }

    public void scoreSelect() {
        System.out.println("전체 목록(총 인원수: " + stuMap.size() + "명)");
        System.out.println("학번\t이름\t주소\t번호\t국어\t영어\t수학\t총점\t평균");

        Iterator<String> it = stuMap.keySet().iterator();

        while (it.hasNext()) {
            String name = it.next();
            System.out.printf("%d\t%s\t%s\t%s\t%d\t%d\t%d\t%d\t%.2f\n", stuMap.get(name).getNum(),
                    stuMap.get(name).getName(), stuMap.get(name).getAddress(), stuMap.get(name).getTel(),
                    stuMap.get(name).getSub(Student.Subjects.KOR), stuMap.get(name).getSub(Student.Subjects.ENG),
                    stuMap.get(name).getSub(Student.Subjects.MAT), stuMap.get(name).getTot(),
                    stuMap.get(name).getAvg());
        }
    }

    public void scoreUpdate() {
        System.out.print("수정할 학생의 이름을 입력하세요 >> ");
        String name = s.next();
        if (!stuMap.containsKey(name)) {
            System.out.println(name + " 학생이 목록에 없습니다.");
            return;
        }
        System.out.print(name + "학생의 점수 입력(국어, 영어, 수학 순) >> ");
        Student stu = stuMap.get(name);
        for (Student.Subjects j : jv) {
            stu.setSub(j, s.nextInt());
        }
        stu.setTot(intTot(stu));
        stu.setAvg((double) stu.getTot() / (double) jv.length);
        System.out.println(name + " 학생의 성적 수정이 정상적으로 완료되었습니다.");
    }

    private int intTot(Student st) {
        int tot = 0;
        for (Student.Subjects j : jv) {
            tot += st.getSub(j);
        }
        return tot;
    }
}
