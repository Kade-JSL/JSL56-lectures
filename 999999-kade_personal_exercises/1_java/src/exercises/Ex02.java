package exercises;

public class Ex02 {
    // WIP. 완성된 코드 아님.
    public static void main(String[] args) {
    int dsize = 6;
        for (int i = 1; i <= 2 * dsize - 1; i++) {
            for (int j = 1; j <= dsize - i || j <= i - dsize; j++) {
                System.out.print("*");
            }
            for (int k = 1; (k <= 2 * i - 1 && i <= dsize) || (k <= 2 * (2 * dsize - i) - 1 && i >= dsize + 1); k++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
