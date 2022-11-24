package controller;

import java.util.HashMap;
import java.util.Scanner;

class Student { // 패키지가 다르면 import라도 하지 않는 이상 뭐 이름이 같아도 상관 없다
    int id;
    String name;
    String tel;

    public Student() {
    }

    public Student(int id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }
}

public class MapMainTwo {

    public static void main(String[] args) {

        HashMap<Integer, Student> map = new HashMap<>();

        map.put(1, new Student(111, "aaa", "030"));
        map.put(2, new Student(222, "bbb", "020"));
        map.put(3, new Student(333, "ccc", "010"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("검색키 입력 >> ");
            int keys = sc.nextInt();
            if (keys == 0)
                break;

            Student stu = map.get(keys);

            if (!map.containsKey(keys)) {
                System.out.println("입력한 키에 해당하는 요소가 없습니다.");
            } else {
                System.out.printf("%s %s %s\n", stu.id, stu.name, stu.tel);
            }
        }

        sc.close();
    }
}
