package javastudy;

public class Object04 {
    public static int getHeight() { // 리턴 타입은 메소드의 사용 목적에 맞게
        return 176;
    }
    public static String getName() { // (), {} 잊지 말 것
        return "케이드";
    }
    public static void main(String[] args) {
        System.out.println("제 이름은 " + getName() + "이며 키는 " + getHeight() + "cm입니다.");
    }
}
