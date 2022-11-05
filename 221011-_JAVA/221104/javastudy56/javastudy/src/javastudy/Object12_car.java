package javastudy;

public class Object12_car { // 차를 한 대 뽑아보자.
    /* 전역 변수, 또는 멤버 변수 */
    String color; // 색도 칠하고...
    int speed; // 속도도 설정해 보자.

    public Object12_car() {// this를 붙이면 전역 변수로써의 color를 말하게 된다.
    } // 지역 변수는 지역 안에서만 쓸 수 있고 밖에서는 쓸 수 없다. 이름이 같더라도 말이다.
    public Object12_car(String color) {
        this.color = color; // this라고 하는 건 자기 클래스에 있는 변수나 메소드를 지칭하는 것
    }
    public Object12_car(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }

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
