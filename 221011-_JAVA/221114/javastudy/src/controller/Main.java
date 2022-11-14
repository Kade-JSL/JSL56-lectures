package controller;

import dto.Student; // javastudy.Student도 존재함

public class Main {

    public static void main(String[] args) {

        Student stu = new Student(); // private 멤버들은 클래스 밖에선 접근할 수 없음
        // 참고로 아무 것도 안 붙이면 패키지 밖에선 접근할 수 없다. import를 한대도 말이다.
    }
}
