package javastudy;

public class Object12 {
    public static void main(String[] args) {
        int kor = 10, eng = 20, mat = 30;
        Object12_sub s = new Object12_sub();
        /* 클래스의 기능을 사용하고 싶다면? 그 클래스의 객체를 만들어야 한다.
         * Scanner 객체를 부르는 이유: next()랑 nextInt()를 쓰고 싶어서!
         * 역시 Object12_sub 객체를 부르는 이유도 그 안에 있는 getTotal(...)을 쓰고 싶어서이다.
         */
        int total = s.getTotal(kor, eng, mat);
        double ave = s.getAverage(total, 3);

    }    
}
