package exercises;

// 인터페이스
interface Ningen {
    public void ningenSound();
    public void run();
    // 본체가 비어 있는 관련 메서드를 정의하기 위함
}

// implements 키워드(예약문)로 이 인터페이스를 구현(implement)한다. 또는 이렇게 정의된 추상 클래스를 상속받는다.
class Kade implements Ningen {
    public void ningenSound() {
        System.out.println("Kade said: Tanoshii!");
    }
    public void run() {
        System.out.println("Sutatata...!");
    }
}

// 인터페이스를 구현할 때는 반드시 정의된 모든 메서드의 본체를 작성해야 한다.
class BlueCat implements Ningen {
    public void ningenSound() {
        System.out.println("BlueCat said: Watashi wa ningen desu. Neko wa namae dake.");
    }
    public void run() {
        System.out.println("Totototo...!");
    }
}

public class Face01 {
    public static void main(String[] args) {
        Kade k = new Kade();
        BlueCat b = new BlueCat();
        k.ningenSound();
        b.ningenSound();
        k.run();
        b.run();
        // 역시나 같은 인터페이스를 적용해도 
    }
}
