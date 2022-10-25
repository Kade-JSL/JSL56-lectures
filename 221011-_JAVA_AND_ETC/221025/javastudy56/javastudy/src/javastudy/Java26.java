package javastudy;

public class Java26 {
    public static void main(String[] args) {
        /*
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
        */
        /*
        for (int j = 1; j <= 9; j++) {
            for (int i = 2; i <= 9; i++) {
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
        */
        /*
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        */
        for (int i = 2; i <= 4; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print("[" + i + ", " + j + "]");
            }
            System.out.println();
        }
    }
}
