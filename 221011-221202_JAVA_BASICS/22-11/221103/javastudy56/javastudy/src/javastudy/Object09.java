package javastudy;

public class Object09 {
    public static void main(String[] args) {
        // int[] arr = new int[3]; // 3칸짜리 int 타입의 배열, int 타입만 들어간다
        // arr[0] = 20; arr[1] = 30; arr[2] = 40;
        int[] arr = new int[] {10, 20, 30};
        // 중괄호만 쓰는 건 C++ 레거시 코드. 사실은 int 객체를 생성해 줘야 자바에 맞다.
        /* 근데 arr[3]은 왜 컴파일 에러가 나지 않는가?
         * 자바 문법적으로 오류는 없지만 실행시킬 때 오류가 생기는 것이다.
         */
        int[] point = new int[] {10, 20, 30, 40};
        int total = getTotal(arr, point, "홍길동"); // 자바에선 메서드에 뭐든지 넣을 수 있다. 진짜 뭐든지. 기본변수든 클래스든.
        System.out.println(total);
    }

    private static int getTotal(int[] a, int[] b, String n) {
        int t = 0;
        for (int i = 0; i < a.length; i++) { // for(초기값; 조건식; 증감식) {}
            t += a[i];
        }
        for (int i = 0; i < b.length; i++) {
            t += b[i];
        }
        return t;
    }
}
