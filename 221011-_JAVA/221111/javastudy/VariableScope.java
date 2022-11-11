package javastudy;

class MyClass {
    int num;
    // 인스턴스 변수
    final static double PI = 3.1415926535;
    // static 변수
    // final: 수정하거나 오버라이드할 수 없음

    static void printAboutCats() {
        System.out.println("고양이는 야옹야옹 울어요");
    }
}

public class VariableScope {
    public static void main(String[] args) {
        MyClass myObj = new MyClass();
        myObj.num = 1; // 인스턴스 변수는 객체를 생성하고 나서

        System.out.println(Math.PI); // static 변수는 그냥 소속된 클래스만 언급
        MyClass.printAboutCats(); // static 메서드도 마찬가지
    }
}
