package javastudy;

public class Object06/* extends Object */{ // 모든 클래스는 Object 클래스를 상속받음. 
    public static void main(String[] args) {
        // 그러니 메서드2 -> 메서드1 안쪽의 호출문 -> 메인 안쪽의 호출문 -> 메인 정의문으로 예외처리가 던져졌다.
        // 이러면 최상위 클래스인 Object에 예외가 넘겨짐.

        // printStackTrace()
        // 예외 발생 시 호출 스택에 있었던 메서드의 정보와 예외 메시지를 출력
        // getMessage()
        // 발생한 예외 클래스의 인스턴스에 저장된 메시지를 얻을 수 있음

        try {
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);    
        } catch (Exception e) { // Exception: 모든 예외를 포함함
            e.printStackTrace();
            System.out.println("예외 메시지: " + e.getMessage());
        }

        try {
            method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // throws

    static void method1() throws Exception {
        System.out.println("메서드 1 호출");
        method2(); // 원래는 빨간 줄. 왜냐면 예외를 받았는데 처리하는 문장이 없기 때문이다.
    }

    static void method2() throws Exception { // Exception: 예외처리 클래스들의 최상위 클래스
        System.out.println("메서드 2 호출"); // 이 부분에서 예외가 발생했다 치자
        // 여기서 이제 호출한 곳으로 예외를 던지는(throw) 방법이 존재하며, 이게 throws문이다.
    }

    // 예외가 발생된 메서드에서 예외 처리를 하지 않고 자신을 호출한 메서드에게 예외를 넘겨주는 것이지,
    // 예외가 처리된 것은 아니고 정말 전달만 한 것이기 때문에
    // 결국은 어느 한 곳에서 try ~ catch 문으로 이걸 처리해 줘야 한다.
}
