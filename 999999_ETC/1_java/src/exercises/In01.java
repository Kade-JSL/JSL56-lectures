package exercises;


class OneClassOuter {
    int x = 10;
    
    // private class OneClassInner {
    static class OneClassInner {
    // class OneClassInner { // 내부 클래스
        int y = 5;
    }
    
}

public class In01 {
    public static void main(String[] args) {
        // OneClassOuter myOuter = new OneClassOuter(); // 평범하게 객체 생성
        // OneClassOuter.OneClassInner myInner = myOuter.new OneClassInner(); // 내부 클래스의 객체를 생성하려면 반드시 외부.내부 = 외부객체.new 형태로 선언해 줘야 한다.
        // 내부 클래스가 private이나 protected일 경우 외부 클래스 블럭 안에서만 접근할 수 있고 객체로는 접근할 수 없다.
        // 내부 클래스가 static일 경우 외부 클래스 객체를 생성하지 않고도 내부 클래스에 접근할 수 있게 된다.
        OneClassOuter.OneClassInner myInner = new OneClassOuter.OneClassInner();
        // System.out.println(myInner.y + myOuter.x);
        System.out.println(myInner.y);
    }
}
