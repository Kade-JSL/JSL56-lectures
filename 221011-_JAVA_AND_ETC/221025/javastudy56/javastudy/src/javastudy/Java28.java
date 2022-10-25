package javastudy;

import java.util.Scanner;

public class Java28 {
    public static void main(String[] args) {
        // 메뉴 만들기
        String menu = null;
        int num = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[1] 자료입력");
            System.out.println("[2] 검색");
            System.out.println("[3] 수정");
            System.out.println("[4] 삭제");
            System.out.println("[0] 종료");
            System.out.print("작업 메뉴를 선택하세요: ");

            menu = sc.next();
            num = Integer.parseInt(menu); // 문자열을 숫자로 변환
            if (num == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (num < 1 || num > 4) {
                System.out.println("메뉴를 잘못 선택했습니다. 다시 선택해 주세요.");
                continue;
            }
            // System.out.println("메뉴로 돌아갑니다.");
        }

        sc.close();
    }
}
