package dto;

// 부모 클래스와 자식 클래스의 생성자 간의 호출 및 실행 관계
class A {
    int a, b;
    public A() {
        System.out.println("A class");
    }
    public A(int a, int b) {
        System.out.println("A class with args " + a + " and " + b);
    }
    // 매개변수가 있는 생성자를 만들면 컴파일러는 기본 생성자를 넣지 않는다
}

class B extends A {
    int c, d;
    public B() { // 상위의 기본 생성자가 없으면 에러가 나옴
        System.out.println("B class");
    }
    public B(int c, int d) {
        super(c, d);
        System.out.println("B class with args " + c + " and " + d);
    }
}

class C extends B {
    int e, f;
    public C() {
        super(10, 20);
        System.out.println("C class");
    }
    public C(int e, int f) {
         // 상위 클래스의 적당한 생성자를 호출할 때 사용. 반드시 생성자의 첫 줄에 코딩해야 함.
        System.out.println("C class with args " + e + " and " + f);
    }
}

public class ConstructorExtends {

    public static void main(String[] args) {
        C c = new C();
        C c2 = new C(10, 20);
        // 상속 관계에서는 C가 호출되면
        // 상속받은 B 클래스를 찾아가서 B의 생성자를 찾고,
        // B 클래스에선 A의 생성자를 찾아간다.
        // 그리고 상속한 순서대로 A(), B(), C()의 순서대로 실행이 되는 것이다.
    }
}
