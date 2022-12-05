package javastudy;

public class Java22 {
    
    public static void main(String[] args) {
        // 반복문: 어떤 작업을 반복적으로 수행하는 것
        // 종류: for, while, do-while 문
        /* 
        * for ( 초기화 식; 조건식; 증강 식; ) {
        *     실행 문장;
        * }
        */
        
        int sum = 0;
        for (int a = 2; a <= 10; a += 2) {
            System.out.println(sum + "에 " + a + "를 더함");
            sum += a;
        }
        System.out.println(sum);
    }
}
