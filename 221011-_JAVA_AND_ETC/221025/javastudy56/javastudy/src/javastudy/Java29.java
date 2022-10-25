package javastudy;

public class Java29 {
    public static void main(String[] args) {
        // while문을 이용해 1에서 100까지의 짝수 합계를 구하는 프로그램을 만들어 보자!
        
        /*
        int i = 0, sum = 0;
        while (i <= 100) {
            sum += i;
            i += 2;
        }
        System.out.println(sum);
        */
        /*
        int i = 1, sum = 0;
        while (true) {
            if (i % 2 == 0) {
                sum += i;
            }
            if (i <= 100) { break; }
            i++;
        }
        System.out.println(sum);
        */

        // 이번엔 for문으로 바꿔 보자!
        /*
        int sum = 0;
        for (int i = 2; i <= 100; i += 2) {
            sum += i;
        }
        System.out.println(sum);
        */

        // 그럼 do...while 문으로!

        int i = 0, sum = 0;
        do {
            sum += i;
            i += 2;
        } while (i <= 100);
        System.out.println(sum);
    }
}
