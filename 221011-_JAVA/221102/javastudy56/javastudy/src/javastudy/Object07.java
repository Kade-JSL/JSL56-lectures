package javastudy;

public class Object07 {
    static int getTotal(int a, String b, int c){
        return a + Integer.parseInt(b) + c;
    }
    public static void main(String[] args) {
        int x = new Integer("");
        int total = getTotal(55, "60", 85);
        System.out.println("총점: " + total + "...." + x);
    }
}
