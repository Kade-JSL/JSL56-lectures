package javastudy;

public class Object11 {
    public static void main(String[] args) {
        int[] arr = setPoint(10, 20, 30);
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        System.out.println("Total: " + total);
    }

    static int[] setPoint(int a, int b, int c) {
        int[] r = new int[] {a, b, c};
        return r;
    }
}
