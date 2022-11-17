package controller;

class Computer {
    int cores;

    public void powerOn() {
        System.out.println("컴퓨터가 켜졌습니다.");
    }
}

class SmartPhone extends Computer {
    int smallCores;

    public void makeACall() {
        System.out.println("스마트폰으로 전화를 걸었습니다.");
    }

}

class Laptop extends Computer {
    double batteryAmount;

    public void pickUp() {
        System.out.println("노트북을 집어들었습니다.");
    }
}
 
public class Polymorphism01 {
    public static void main(String[] args) {
        Computer c = new Computer();
        Computer s = new SmartPhone();

        c.cores = 8;
        // s.batteryAmount = 0.95; // 컴파일 에러
        s.cores = 8;
        s.powerOn(); // 상속받은 메서드

        Computer c2; // 타입만 이렇지 아무런 내용도 없는 공허한 포인터
        SmartPhone s2 = new SmartPhone();
        c2 = s2; // c2 = (Computer)s2;가 좀 더 보기 쉬울 것이다.
        // 업캐스팅: 자손 클래스의 객체를 조상 클래스의 타입으로 대입. TV로 치면 리모콘이 바뀌었다고 생각해 보자.
        // 이렇게 되면 Computer~SmartPhone까지 멤버의 스코프가 넓어졌던 s2 객체가 형변환이 되면서 Computer로 스코프가 줄어들게 된다.
        c2.powerOn();
        // c2.smallCores = 4; // 컴파일 에러. 스코프가 좁아져서 그렇다.

        Computer c3 = new Computer();
        SmartPhone s3; // 타입만 이렇지 아무런 내용도 없는 공허한 포인터(2)
        s3 = (SmartPhone)c3; // 다운캐스팅을 할 때는 반드시 객체 형을 써 줘야 한다. 왜냐면 무슨 하위 클래스를 가리키는지 모르니까.
        // 이렇게 되면 Computer뿐인 c3의 스코프가 ~SmartPhone까지 스코프가 넓어지게 된다.
        s3.powerOn();
        s3.smallCores = 4; // 에러가 안 난다. 스코프가 넓어져서.
    }
}
