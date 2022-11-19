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

    void deleteAccount(BankAccount a); // CRUD를 의식하면서 메서드 이름 작명

    BankAccount numToAccount(int num);
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
        System.out.printf("%d원의 입금이 성공적으로 완료되었습니다.\n입금 후 잔액: %d원");
    }

    public void withdraw(BankAccount a) {
        System.out.printf("%s 회원님의 %s번 계좌에서 출금합니다.\n", a.getOwnerName(), a.getAccountNum());
        while(true) {
            System.out.print("계좌 비밀번호를 입력해 주세요(4자리) >> ");
            int guess = s.nextInt();
            if (passwordMatch(a, guess)) break;
            System.out.println("비밀번호가 틀렸습니다.");
        }
        System.out.printf("잔액: %d원\n출금할 금액을 입력해 주세요. >> ", a.getBalance());
        int amount = s.nextInt();
        a.setBalance(a.getBalance() - amount);
        System.out.printf("%d원의 출금이 정상적으로 완료되었습니다.\n출금 후 잔액: %d원\n", amount, a.getBalance());
    }

    public void transfer(BankAccount a) {
        System.out.printf("%s 회원님의 %s번 계좌에서 이체합니다.\n", a.getOwnerName(), a.getAccountNum());
    }

    public void deleteAccount(BankAccount a) {

    }

    public BankAccount numToAccount(int num) {
        BankAccount b = null;
        if (AccountList.getLength() != 0) {
            for (int i = 0; i < AccountList.getLength(); i++) {
                if (AccountList.getList()[i].getAccountNum() == num) {
                    b = AccountList.getList()[i];
                    break;
                }
            }
        }
        return b;
    }

    public boolean passwordMatch(BankAccount a, int password) {
        if (password < 10000) {
            return a.getPassword() == password;
        } else {
            System.out.println("알맞은 비밀번호를 입력해 주세요.");
            return false;
        }
    }
}