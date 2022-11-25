package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // HashMap<Integer, String> map = new HashMap<Integer, String>();

        // map.put(0, "아기");
        // map.put(1, "사랑");
        // map.put(2, "사과");

        // while (true) {
        // System.out.print("검색하고자 하는 단어 입력 >> ");
        // int key = sc.nextInt();
        // if (key == 9) {
        // System.out.println("'9' 입력됨. 프로그램 종료.");
        // break;
        // }
        // if (map.get(key) != null) {
        // System.out.println(key + "의 값은 " + map.get(key) + "입니다.");
        // } else {
        // System.out.println(map.get(key) + "의 값을 찾을 수 없습니다.");
        // }
        // }

        HashMap<String, Integer> score = new HashMap<String, Integer>();
        score.put("홍자바", 100);
        score.put("김자바", 70);
        score.put("박자바", 50);

        System.out.println("HashMap의 요소 크기: " + score.size());
        // Set<String> keyset = score.keySet(); // HashMap의 모든 키를 담는 Set

        System.out.println(score);

        Set keys = score.entrySet(); // 키와 값을 모두 출력
        System.out.println(keys);
        Iterator it = keys.iterator(); // 컬렉션을 반복하는 데 사용하는 객체
        System.out.println(it);

        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            System.out.println(me.getKey() + " " + me.getValue());
        }

        sc.close();
    }
}
