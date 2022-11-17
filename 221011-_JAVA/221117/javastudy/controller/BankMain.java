package controller;

import java.util.Scanner;
import dao.AccountDao;

public class BankMain {

    public static void main(String[] args) {
        
        boolean run = true;

        Scanner s = new Scanner(System.in);
        AccountDao ad = AccountDao.getAccountDao();

        while (run) {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 입금하기 | 4. 출금하기 | 5. 전체 예금액 | 0. 종료하기");
            System.out.print("작업 선택 > ");
            int sel = s.nextInt();

            if (sel == 1) {
                /* 계좌 생성 */
                ad.createAccount();

            } else if (sel == 2) {
                /* 계좌 목록 */
                ad.accountList();

            } else if (sel == 3) {
                /* 입금하기 */
                ad.deposit();

            } else if (sel == 4) {
                /* 출금하기 */
                ad.withdraw();

            } else if (sel == 5) {
                /* 총 예금액 출력 */
                ad.printTotalDepositAmount();

            } else if (sel == 0) {
                System.out.println("계좌 관리 프로그램을 종료합니다.");
                s.close();
                run = false;
            } else {
                System.out.println("알맞은 메뉴 번호를 입력하세요.");
            }
        }
    }

}
