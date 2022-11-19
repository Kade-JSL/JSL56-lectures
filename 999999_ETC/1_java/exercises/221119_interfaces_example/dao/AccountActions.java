package dao;

import java.util.Scanner;

import dto.*;

/* 공통적 계좌 활동 */
interface AccountActions {
    void createAccount();

    void readAccount(BankAccount a);

    void deposit(BankAccount a);

    void withdraw(BankAccount a);

    void transfer(BankAccount a);

    void deleteAccount(BankAccount a);
}

class GeneralActions implements AccountActions {
    private static GeneralActions ga = new GeneralActions();
    private GeneralActions() {}
    public static GeneralActions getInstance() { return ga; } // 역시나 싱글톤 객체

    Scanner s = new Scanner(System.in);

    public void createAccount() {
        System.out.println("계좌를 개설합니다.");
        if (!BankAccount.isOtherTypeExists) {
            System.out.println("현재는 일반 계좌 타입밖에 생성할 수 없습니다.");
            System.out.print("성함을 입력하세요 >> ");
            String name = s.next();
            System.out.print("초기 잔액을 입금해 주세요 >> ");
            int amount = s.nextInt();
            BankAccount a = new GeneralAccount(name, amount);
            AccountList.addList(a);
            System.out.printf("계좌가 성공적으로 생성되었습니다.\n비밀번호(한 번만 알려드리니 적어 두세요): %d\n", a.getPassword());
        }
    }

    public void readAccount(BankAccount a) {
        if (AccountList.getLength() == 0) {
            System.out.println("아직은 계좌가 없습니다.");
        } else if (a.accountType == 0) {
            System.out.printf("일반\t%d\t\t%s\t%d\n", a.getAccountNum(), a.getOwnerName(), a.getBalance());
        }
    }

    public void deposit(BankAccount a) {
        System.out.printf("%s 회원님의 %s번 계좌에 입금합니다.\n", a.getOwnerName(), a.getAccountNum());
        System.out.print("입금할 금액을 입력해 주세요 >> ");
        int amount = s.nextInt();
        a.setBalance(a.getBalance() + amount);
        System.out.print("%d원의 입금이 성공적으로 완료되었습니다.\n");
    }
}