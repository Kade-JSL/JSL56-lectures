package exercises;

// 추상 클래스 Human
abstract class Human {
    public abstract void humanSound(); // 추상 메서드(하위 클래스에서 정의)
    public void sleep() {
        System.out.println("Suya... Suya...");
    }
}

// Human을 상속받은 자식 클래스들
class ChulSu extends Human {
    public void humanSound() { // 철수 클래스의 humanSound()
        System.out.println("Chulsu goes like: Ohayou!");
    }
}

class YeongHee extends Human {
    public void humanSound() { // 영희 클래스의 humanSound()
        System.out.println("Yeonghee goes like: Konnichiwa!");
    }
}

public class Abs03 {
    public static void main(String[] args) {
        ChulSu su = new ChulSu();
        YeongHee hee = new YeongHee();
        su.humanSound();
        hee.humanSound(); // 똑같은 메서드지만 하위 클래스가 다르면 메서드도 다르게 정의됨
        su.sleep();
        hee.sleep(); // 같은 상위 클래스인 Human에서 공유하는 메서드
    }
}

// 요렇게 하는 이유는?

// 보안을 위해서. 객체의 특정 특성은 숨기면서 보여주고 싶은 특성만 보여줄 수 있게 된다.
