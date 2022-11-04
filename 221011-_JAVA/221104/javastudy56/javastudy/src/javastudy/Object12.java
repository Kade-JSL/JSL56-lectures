package javastudy;

public class Object12 {
    public static void main(String[] args) {
        /* 클래스의 기능을 사용하고 싶다면? 그 클래스의 객체를 만들어야 한다.
         * Scanner 객체를 부르는 이유: next()랑 nextInt()를 쓰고 싶어서!
         * 역시 Object12_sub 객체를 부르는 이유도 그 안에 있는 getTotal(...)을 쓰고 싶어서이다.
         */
        Object12_car myCar = new Object12_car();
        System.out.println("myCar color: " + myCar.getColor());
        // myCar.setColor("yellow");
        // myCar.setColor("Red");

        Object12_car yourCar = new Object12_car("yellow");
        System.out.println("yourCar color: " + yourCar.getColor());
        System.out.println("yourCar speed: " + yourCar.getSpeed());

        Object12_car ourCar = new Object12_car("white", 150);
        System.out.println("ourCar color: " + ourCar.getColor());
        System.out.println("ourCar speed: " + ourCar.getSpeed());
    }    
}
