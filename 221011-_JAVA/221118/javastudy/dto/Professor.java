package dto;

public class Professor extends Person {

    private String major;

    public Professor(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override // 아래 메서드를 오버라이딩한다는 어노테이션
    public void printInfo() {
        System.out.println("<교수>");
        System.out.printf("이름: %s\n", name); // protected 변수라 하위 클래스에서 사용 가능
        System.out.printf("나이: %d\n", age);
        System.out.printf("전공: %s\n",major);
}
}
