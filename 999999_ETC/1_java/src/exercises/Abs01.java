package exercises;

// 추상 클래스 실습
abstract class Abs01 {
    public String fname = "Kade";
    public int age = 28;
    public abstract void coding(); // 추상 메서드, Abstract01의 멤버
}


// Abstract01 클래스에서 상속받은 Abs01_sub

class Abs01_sub extends Abs01 {
    public int graduationYear = 2022;
    public void coding() {
        System.out.println("Spendind all, spending, spending all my time");
        System.out.println("So coding like, coding, coding like forever");
    }
}