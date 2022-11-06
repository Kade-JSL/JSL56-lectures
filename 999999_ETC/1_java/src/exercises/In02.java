package exercises;

class TwoClassOuter {
    int x = 10;

    class TwoClassInner { // 내부 클래스의 장점: 메서드로 외부 클래스의 필드나 특성에 접근할 수 있음
        public int myInnerMethod() {
            return x;
        }
    }
}

public class In02 {
    public static void main(String[] args) {
        TwoClassOuter myOuter = new TwoClassOuter();
        TwoClassOuter.TwoClassInner myInner = myOuter.new TwoClassInner();
        System.out.println(myInner.myInnerMethod()); 
    }
}
