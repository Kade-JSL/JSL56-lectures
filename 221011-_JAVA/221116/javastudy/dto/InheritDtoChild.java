package dto;

public class InheritDtoChild extends InheritDto {

    public void mul() {
        System.out.println("곱셈: " + (a * b));
        // 상속을 받았어도 private 변수는 접근할 수 없다
    }
    public void div() {
        System.out.println("나눗셈: " + (a / b));
    }
}
