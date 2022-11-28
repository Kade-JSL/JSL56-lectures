package javastudy;

class Overloading {
    int num;
    String name;
    int score;
    double avg;

    public Overloading() { // 기본 생성자
        this(1111,"길길동"); // 매개변수가 다른 (여기서는 2개짜리) 생성자 호출
    } 
    public Overloading(int num, String name) { // 기본 생성자에 더하여 매개변수를 받을 수 있도록 똑같은 생성자를 하나 더 만듬
        this.num = num;
        this.name = name;
    }
    public Overloading(int num, String name, int score, double avg) {
        this.num = num;
        this.name = name;
        this.score = score;
        this.avg = avg;
    }
    
    public void printPassOrFailStatus() {
        if (avg >= 80) {
            System.out.println("합격입니다!");
        }
    }
    public void printPassOrFailStatus(double avg) {
        if (avg >= 80) {
            System.out.println("합격입니다!");
        } else {
            System.out.println("재응시 대상입니다.");
        }
    }
}

public class OverloadingMain {
    public static void main(String[] args) {
        Overloading ol1 = new Overloading();
        // Overloading ol2 = new Overloading(11, "홍길동");
        // Overloading ol3 = new Overloading(22, "이순신", 300, 100.0);

        ol1.printPassOrFailStatus(60);
    }
}
