package javastudy;

public class PackageAccess {
    public static void main(String[] args) {
        int diceroll = (int)(Math.random() * 6) + 1; // int 형변환은 소수점 아래를 그냥 버린다
        System.out.println(diceroll);
    }
}
