package controller;

class Point /* extends Object */ {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        Point p = (Point)obj; // ダウンキャスト
        if (this.x == p.x && this.y == p.y) return true;
        return false;
    }

    @Override
    public String toString() {
        return "x = " + x + " y = " + y;
    }

}

class ObjectProperty /* extends Object */ {
    public static void print(Object obj) { // 다형성으로 어떤 타입의 객체든 받을 수 있다
        System.out.println(obj.getClass().getName());
        System.out.println(obj.hashCode());
        System.out.println(obj.toString());
        System.out.println(obj);
    }
}

public class PackageMain /* extends Object */ {
    public static void main(String[] args) {
        /* Object 클래스의 기본 메서드, 다형성 활용 */
        // Point p = new Point(10, 20);
        // System.out.println(p.toString());
        // ObjectProperty.print(p);

        // Point a = new Point(20, 30);
        // Point b = new Point(20, 30);

        // String a = "10";
        // String b = "10";

        /* toString() 오버라이드 */
        // System.out.println(a == b); // 값이 같은지를 비교하는 것이 아니라 주소가 같은지를 비교함
        // System.out.println(a.equals(b));

        /* Wrapper 클래스 */
        // Integer i = new Integer(10);
        // System.out.println(i.intValue()); // i = 10
        // int i2 = Integer.parseInt("200");
        // System.out.println(i2);
        // System.out.println(i.toString());

        Integer ten = 10; // 자동 박싱 == new Integer(10)
        int teni = ten; // 자동 언박싱 == ten.intValue(10)
    } // main
} // class
