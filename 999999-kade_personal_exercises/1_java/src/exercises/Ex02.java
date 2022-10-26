package exercises;

public class Ex02 {
    // 모래시계 띄우는 코드
    public static void main(String[] args) {
    int dsize = 4;
        for (int i = 1; i <= 2 * dsize - 1; i++) {
            for (int k = 1; (k <= i - 1 && i <= dsize - 1) || (k <= 2 * dsize - i - 1 && i >= dsize); k++) {
                System.out.print(" ");
            }
            for (int j = 1; (j <= 2 * (dsize - i) + 1) || (j <= 2 * (i - dsize) + 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
