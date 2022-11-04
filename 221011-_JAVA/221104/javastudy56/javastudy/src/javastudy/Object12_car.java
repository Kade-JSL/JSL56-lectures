package javastudy;

import java.util.Scanner;

public class Object12_car { // 차를 한 대 뽑아보자.
    String color; // 색도 칠하고...
    int speed; // 속도도 설정해 보자.
    Scanner sc = new Scanner(System.in);

    void setColor(String c) {
        color = c;
    }
    void setSpeed(int s) {
        speed = s;
    }
    String getColor() {
        return color;
    }
    int getSpeed() {
        return speed;
    }
}
