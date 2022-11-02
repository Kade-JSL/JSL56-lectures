package javastudy;

public class Object07 {
    static int getTotal(int a, String b, int c) {
        return a + Integer.parseInt(b) + c;
    }
    static double getAve(int a, String b) {
        return (double)a / (double)Integer.parseInt(b);
    }
    static String getResult(double avg) {
        if (avg > 90) return "수";
        else if (avg > 80) return "우";
        else if (avg > 70) return "미";
        else if (avg > 60) return "양";
        else return "가";
    }
    public static void main(String[] args) {
        int total = getTotal(55, "60", 85);
        System.out.println("총점: " + total);
        double average = getAve(total, "3");
        System.out.println("평균: " + average);
        String result = getResult(average);
        System.out.println("결과: " + result);
    }
}
