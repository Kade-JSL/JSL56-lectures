package javastudy;

// 헤헤 다 숨겨놨지롱
public class Object03 {
    static void compare() {
        Ob03 m = new Ob03();
        m.inputAndPrintBiggerInt();
    }
    public static void main(String[] args) {
        Ob03 m = new Ob03();
        int[] score = m.getParams();
        int sum = m.add(score); // score는 add() 메서드를 호출하면서 매개변수에 저장되는 값
        System.out.println("result: " + sum);
        compare();
    }
}
