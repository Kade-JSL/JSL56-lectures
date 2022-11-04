package javastudy;

public class Object12_sub { // 클래스들은 메서드와 필드의 집합
    public Object12_sub(){ // 리턴 타입도 없고, 클래스 이름이랑 같다.
        // 클래스의 생성자(contructor) 메서드

    }
    int getTotal(int... a) { // Object12_sub.getTotal(...)라는 게 이제 합계를 더하는 기능이 있다는 거다.
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s += a[i];
        }
        return s;
    }
    double getAverage(int t, int c) {
        return (double)t / (double)c;
    }
}
