package exercises;

public class Ex02 {
    // 모래시계 띄우는 코드
    public static void main(String[] args) {
    int dsize = 4;
        for (int i = 1; i <= 2 * dsize - 1; i++) {
            // 공백 부분
            for (int k = 1; (k <= i - 1 && i <= dsize - 1) || (k <= 2 * dsize - i - 1 && i >= dsize); k++) {
                // i가 예컨대 4 이하(dsize = 5)면 공백 갯수가 늘어나고, 5 이상이면 별 갯수가 줄어든다.
                System.out.print(" ");
            }
            // 별표 부분
            for (int j = 1; (j <= 2 * (dsize - i) + 1) || (j <= 2 * (i - dsize) + 1); j++) {
                // 위의 k가 들어간 for문과 같지만 i의 조건이 없다. OR을 쓴대도 둘 중에 큰 편을 j가 고르기 때문이다.
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
