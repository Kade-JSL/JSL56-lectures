package javastudy;

// import java.util.InputMismatchException;
// import java.util.Scanner;

public class Object05 {
    
    public static void main(String[] args) {
        // 프로그램 오류 처리
        // 어떤 원인에 의해서 오동작을 하거나 비정상적으로 종료되는 경우가 있다
        // 이러한 결과를 초래하는 원인을 프로그램 에러 또는 오류라고 한다

        // 발생하는 시점에 따라 컴파일 에러와 런타임 에러로 나눌 수 있다.
        // 컴파일 에러: 컴파일시에 발생하는 에러
        // 런타임 에러: 실행시에 발생하는 에러
        // 논리적 에러: 실행은 되지만, 의도와 다르게 동작하는 것

        // 에러: 수습이 될 수 없는 심각한 오류(메모리 부족, 스택오버플로우)
        // 예외(Exception): 수습이 될 수 없는 미약한 오류

        // 예외의 종류
        // ArithmeticException: 연산 또는 산수, 정수를 0으로 나눌 때
        // NullPointerException: null 레퍼런스를 참조할 떄 발생. 「슈타인즈 게이트」에도 등장한 적 있는 넷슬랭인 ぬるぽ가 여기서 유래.
        // ArrayIndexOutOfBoundsException: 말 그대로 배열의 인덱스가 범위를 벗어났을 때 발생.
        // NumberFormatException: 숫자와 일치하는 타입의 숫자로 변환시 발생
        // IOException: 입출력 동작 실패 또는 인터럽트 발생
        // IllegalArgumentException: 잘못된 인자 전달 시 발생

        /*
        try {
            int[] a = new int [5];
            a[4] = 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("너 배열 범위를 벗어난 느낌인데?");
        } finally {
            System.out.println("여튼 finally는 무조건 실행함.");
        }
        */

        /*
        Scanner sc = new Scanner(System.in);
        int[] a = new int[3];
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.print(i + 1 + "번째 정수를 입력해 주세요: ");
            try {
                a[i] = sc.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("정수가 아닙니다. 다시 입력하세요.");
                sc.next(); // 입력 스트림에 있는 정수가 아닌 토큰을 버리는 역할
                i--; continue;
            }
            s += a[i];
        }
        System.out.println(a.length + "개 정수의 합: " + s);
        sc.close();
         */

        String[] s = new String[] {"23", "66", "3.14", "999"};
        int i;
        for (i = 0; i < s.length; i++) {
            try {
                System.out.println(Integer.parseInt(s[i]));
            } catch (NumberFormatException e) {
                System.out.println(s[i] + "는 정수로 변환할 수 없습니다.");
                continue;
            }
        }
    }
}
