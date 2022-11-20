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

public class GeneralActions implements AccountActions {
    private static GeneralActions ga = new GeneralActions();

    private GeneralActions() {
    }

    public static GeneralActions getInstance() {
        return ga;
    } // 역시나 싱글톤 객체

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
            System.out.printf("계좌가 성공적으로 생성되었습니다.\n계좌번호: %d\n비밀번호(한 번만 알려드리니 적어 두세요): %d\n", a.getAccountNum(),
                    a.getPassword());
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
        System.out.printf("%d원의 입금이 성공적으로 완료되었습니다.\n입금 후 잔액: %d원\n", amount, a.getBalance());
    }

    public void withdraw(BankAccount a) {
        System.out.printf("%s 회원님의 %s번 계좌에서 출금합니다.\n", a.getOwnerName(), a.getAccountNum());
        passwordMatch(a);
        int amount = balanceCheck(a);
        a.setBalance(a.getBalance() - amount);
        System.out.printf("%d원의 출금이 정상적으로 완료되었습니다.\n출금 후 잔액: %d원\n", amount, a.getBalance());
    }

    public void transfer(BankAccount a) {
        if (AccountList.getLength() == 1) {
            System.out.println("근데 이 은행엔 당신 혼자뿐인데요. 누구한테 보낸다는 거죠?");
            return;
        }
        System.out.printf("%s 회원님의 %s번 계좌에서 이체합니다.\n", a.getOwnerName(), a.getAccountNum());
        passwordMatch(a);
        System.out.print("이제할 계좌의 번호를 입력해 주세요 >> ");
        int num = s.nextInt();
        BankAccount b = numToAccount(num);
        int amount = balanceCheck(a);
        System.out.printf("%s님의 계좌 %d로 %d원을 이체합니다. 계속하시겠습니까?\n계속하려면 1을 눌러주세요.(아닐 경우 처음부터 반복) >> ", b.getOwnerName(),
                b.getAccountNum(), amount);
        int yesorno = s.nextInt();
        if (yesorno == 1) {
            a.setBalance(a.getBalance() - amount);
            b.setBalance(b.getBalance() + amount);
            System.out.printf("이체가 완료되었습니다.\n계좌 잔액: %d\n", a.getBalance());
        } else {
            System.out.println("처음부터 다시 반복합니다.");
            return;
        }
    }

    public void deleteAccount(BankAccount a) {
        System.out.printf("%s 회원님의 %s번 계좌를 제거합니다.\n", a.getOwnerName(), a.getAccountNum());
        passwordMatch(a);
        System.out.print("남은 잔고를 이전할 계좌번호를 입력해 주세요 >> ");
        int num = s.nextInt();
        BankAccount b = numToAccount(num);
        System.out.printf("%s님의 계좌 %d로 잔고 전액 %d원을 이전합니다. 계속하시겠습니까?\n계속하려면 1을 눌러주세요.(아닐 경우 처음부터 반복) >> ",
                b.getOwnerName(), b.getAccountNum(), a.getBalance());
        int yesorno = s.nextInt();
        if (yesorno == 1) {
            System.out.println("계좌 제거가 완료되었습니다. 이용해 주셔서 감사합니다.");
        } else {
            System.out.println("처음부터 다시 반복합니다.");
            return;
        }
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

    public void passwordMatch(BankAccount a) {
        while (true) {
            System.out.print("계좌 비밀번호를 입력해 주세요(4자리) >> ");
            int guess = s.nextInt();
            if (a.getPassword() == guess) {
                return;
            }
            System.out.println("비밀번호가 틀렸습니다.");
        }
    }

    int balanceCheck(BankAccount a) {
        while (true) {
            System.out.printf("잔액: %d원\n출금할 금액을 입력해 주세요. >> ", a.getBalance());
            int amount = s.nextInt();
            if (a.getBalance() < amount) {
                System.out.println("계좌 잔고가 부족합니다.");
            } else {
                return amount;
            }
        }
    }
}
