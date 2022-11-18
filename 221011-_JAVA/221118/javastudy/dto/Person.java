package dto;

public class Person {
    
    /* 필드 */
    protected String name;
    protected int age;

    /* 생성자 */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("<개인>");
        System.out.printf("이름: %s\n", name);
        System.out.printf("나이: %d\n", age);
    }
}
