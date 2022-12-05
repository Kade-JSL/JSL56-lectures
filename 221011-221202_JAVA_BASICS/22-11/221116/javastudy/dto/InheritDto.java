package dto;

public class InheritDto {
    
    // private
    int a; // private 변수는 상속이 되어도 접근할 수 없다.
    int b; // default 접근 제한
    int c, d;

    public InheritDto() {
        System.out.println("부모 클래스 만듦");
    }

    public void setA(int a) { this.a = a; }

    public void setB(int b) { this.b = b; }

    public void add() {
        System.out.println("덧셈: " + (a + b));
    }

    public void sub() {
        System.out.println("뺄셈: " + (a - b));
    }
}
