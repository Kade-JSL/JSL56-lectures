package exercises;

public class Ex01 {

    public static void main(String[] args) {
        int dsize = Integer.parseInt(args[0]);
        for (int i = 1; i <= 2 * dsize - 1; i++) {
            // 공백 부분
            for (int j = 1; j <= dsize - i || j <= i - dsize; j++) {
                System.out.print(" ");
            }
            // 별표 부분
            for (int k = 1; (k <= 2 * i - 1 && i <= dsize) || (k <= 2 * (2 * dsize - i) - 1 && i >= dsize + 1); k++) {
                System.out.print("*");
            }
            // 위아래로 범위를 억지로 쪼갠 격이라 뭔가 만족스럽지 않지만 검색해서 나온 답안도 대체로 위아래를 쪼개고 있었기에 이 정도로 만족하기로 헀다
            System.out.println();
        }
    }

}