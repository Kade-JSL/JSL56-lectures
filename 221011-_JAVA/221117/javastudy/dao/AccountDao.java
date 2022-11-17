package dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import dto.AccountDto;

// 메서드가 들어가는 클래스
public class AccountDao {

    private static AccountDao ad = new AccountDao();

    private AccountDao() {}

    public static AccountDao getAccountDao() {
        return ad;
    } 

    Scanner s = new Scanner(System.in);

    private static ArrayList<AccountDto> accArr = new ArrayList<AccountDto>();

    public void createAccount() {
        System.out.print("예금주명 입력: ");
        String ownerName = s.next();
        System.out.print("초기 입금액: ");
        int balance = s.nextInt();
        accArr.add(new AccountDto(ownerName, balance));
    }

    public void accountList() {
        System.out.println("계좌 목록");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("계좌번호\t\t예금주\t잔액");
        for (int i = 0; i < accArr.size(); i++) {
            System.out.println(accArr.get(i).getAccNumber() + "\t\t"
                + accArr.get(i).getOwnerName() + "\t" + accArr.get(i).getBalance());
        }
    }

    public void deposit() {
        System.out.print("계좌번호를 입력하세요: ");
        int accNumber = s.nextInt();
        AccountDto a;
        try {
            a = findAccount(accNumber); 
            System.out.println("계좌번호 " + a.getAccNumber() + " 잔액: " + a.getBalance());
        } catch (NullPointerException e) {
            return;
        }
        System.out.print("입금할 금액을 입력하세요: ");
        int d = s.nextInt();
        a.setBalance(a.getBalance() + d);
        System.out.println(d + "원이 정상적으로 입금 완료되었습니다.");
        System.out.println("계좌번호 " + a.getAccNumber() + " 잔액: " + a.getBalance());
    }

    public void withdraw() {
        System.out.print("계좌번호를 입력하세요: ");
        int accNumber = s.nextInt();
        AccountDto a;
        try {
            a = findAccount(accNumber); 
        } catch (NullPointerException e) {
            System.out.println("찾으시는 계좌가 없습니다. 다시 입력해 주세요.");
            return;
        }
        System.out.println("계좌번호 " + a.getAccNumber() + " 잔액: " + a.getBalance());
        System.out.print("출금할 금액을 입력하세요: ");
        int w = s.nextInt();
        if (a.getBalance() - w < 0) {
            System.out.println("출금 잔액이 부족합니다.");
            a.setBalance(a.getBalance());
        } else {
            a.setBalance(a.getBalance() - w);
            System.out.println(w + "원이 정상적으로 출금 완료되었습니다.");
            System.out.println("계좌번호 " + a.getAccNumber() + " 잔액: " + a.getBalance());
        }
    }
    
    public AccountDto findAccount(int accNumber) {
        AccountDto a = null;
        for (int i = 0; i < accArr.size(); i++) {
            if (accNumber == accArr.get(i).getAccNumber()) {
                a = accArr.get(i);
            }
        }
        if (a == null) {
            System.out.println("해당 계좌를 찾을 수 없습니다.");
            return null;
        }
        return a;
    }

    public void printTotalDepositAmount() {
        int tda = 0;
        for (int i = 0; i < accArr.size(); i++) {
            tda += accArr.get(i).getBalance();
        }
        DecimalFormat f = new DecimalFormat("￦ #,###");
        System.out.println("총 계좌 수: " + accArr.size() + "개\n총 예금액: " + f.format(tda));
    }
}
