package exercises;

public class Abs02 {
    public static void main(String[] args) {
        Abs01_sub kadeObj = new Abs01_sub(); // 추상 클래스가 아닌 그것을 상속받은 하위 클래스 객체를 생성

        System.out.println("Name: " + kadeObj.fname);
        System.out.println("Age: " + kadeObj.age);
        System.out.println("Graduation Year: " + kadeObj.graduationYear);
        kadeObj.coding(); // 부모인 추상 클래스의 
    }
}
