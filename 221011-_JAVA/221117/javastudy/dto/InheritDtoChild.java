package dto;

public class InheritDtoChild extends InheritDto {

    public InheritDtoChild() {
        super();
        System.out.println("그리고 그걸 상속받은 자식 클래스 객체 만듦");
    }

    void setC(int c) { super.c = c; }

    void setD(int d) { super.d = d; }

    public void mul() {
        System.out.println("곱셈: " + (a * b));
        // 상속을 받았어도 private 변수는 접근할 수 없다
    }
    public void div() {
        System.out.println("나눗셈: " + (a / b));
    }
}
