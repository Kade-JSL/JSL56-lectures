package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dto.*;

/* 공통적 계좌 활동 */
interface AccountActions {
    int createAccount(BankAccount account);

    BankAccount readAccount(int accountNum);

    // void deposit(BankAccount a);

    // void withdraw(BankAccount a);

    // void transfer(BankAccount a);

    // void deleteAccount(BankAccount a); // CRUD를 의식하면서 메서드 이름 작명

    // BankAccount numToAccount(int num);
}

public class LiteAccountDao implements AccountActions {

    /* 싱글톤 패턴 */
    private static AccountActions instance = new LiteAccountDao();
    private LiteAccountDao() {}
    public static LiteAccountDao getInstance() { return (LiteAccountDao) instance; } 

    /* DB 연결, DTO 객체 생성, 리턴 변수 생성 */
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    BankAccount bacc = null;
    int result = 0;
    String query = null;

    /* 입력 스트림 */
    Scanner s = new Scanner(System.in);

    /* 계좌 개설 */
    public int createAccount(BankAccount account) {

        if (!BankAccount.isOtherTypeExists) {
            conn = DBConnection.getInstance().getConnection();

            query = "INSERT INTO LITEACCOUNT " +
                "(ACCOUNTNUM, OWNERNAME, PASSWORD, BALANCE) " +
                "VALUES (?, ?, ?, ?)";

            try {
                pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, account.getAccountNum());
                pstmt.setString(2, account.getOwnerName());
                pstmt.setInt(3, account.getPassword());
                pstmt.setInt(4, account.getBalance());

                result = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close(conn, pstmt);
            }

        }
        return result;
    }

    public BankAccount readAccount(int accountNum) {
        conn = DBConnection.getInstance().getConnection();
        if(!BankAccount.isOtherTypeExists()) bacc = new LiteAccount();
        
        query = "SELECT * FROM LITEACCOUNT WHERE ACCOUNTNUM = " + accountNum;

        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                bacc.setAccountType(0);
                bacc.setAccountNum(rs.getInt("ACCOUNTNUM"));
                bacc.setOwnerName(rs.getString("OWNERNAME"));
                bacc.setPassword(rs.getInt("PASSWORD"));
                bacc.setBalance(rs.getInt("BALANCE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }

        return bacc;
    }

    public int updateAccount(BankAccount account) {
        conn = DBConnection.getInstance().getConnection();
        if(!BankAccount.isOtherTypeExists()) bacc = new LiteAccount();

        query = "UPDATE LITEACCOUNT SET BALANCE = ? WHERE ACCOUNTNUM = ?, PASSWORD = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, account.getBalance());
            pstmt.setInt(2, account.getAccountNum());
            pstmt.setInt(3, account.getPassword());
            rs = pstmt.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }

        return result;
    }
    // public void deposit(BankAccount a) {
    //     System.out.printf("%s 회원님의 %s번 계좌에 입금합니다.\n", a.getOwnerName(), a.getAccountNum());
    //     System.out.print("입금할 금액을 입력해 주세요 >> ");
    //     int amount = s.nextInt();
    //     a.setBalance(a.getBalance() + amount);
    //     System.out.printf("%d원의 입금이 성공적으로 완료되었습니다.\n입금 후 잔액: %d원\n", amount, a.getBalance());
    // }

    // public void withdraw(BankAccount a) {
    //     System.out.printf("%s 회원님의 %s번 계좌에서 출금합니다.\n", a.getOwnerName(), a.getAccountNum());
    //     passwordMatch(a);
    //     int amount = balanceCheck(a);
    //     a.setBalance(a.getBalance() - amount);
    //     System.out.printf("%d원의 출금이 정상적으로 완료되었습니다.\n출금 후 잔액: %d원\n", amount, a.getBalance());
    // }

    // public void transfer(BankAccount a) {
    //     if (accList.size() == 1) {
    //         System.out.println("근데 이 은행엔 당신 혼자뿐인데요. 누구한테 보낸다는 거죠?");
    //         return;
    //     }
    //     System.out.printf("%s 회원님의 %s번 계좌에서 이체합니다.\n", a.getOwnerName(), a.getAccountNum());
    //     passwordMatch(a);
    //     System.out.print("이제할 계좌의 번호를 입력해 주세요 >> ");
    //     int num = s.nextInt();
    //     BankAccount b = numToAccount(num);
    //     int amount = balanceCheck(a);
    //     System.out.printf("%s님의 계좌 %d로 %d원을 이체합니다. 계속하시겠습니까?\n계속하려면 1을 눌러주세요.(아닐 경우 처음부터 반복) >> ", b.getOwnerName(),
    //             b.getAccountNum(), amount);
    //     int yesorno = s.nextInt();
    //     if (yesorno == 1) {
    //         a.setBalance(a.getBalance() - amount);
    //         b.setBalance(b.getBalance() + amount);
    //         System.out.printf("이체가 완료되었습니다.\n계좌 잔액: %d\n", a.getBalance());
    //     } else {
    //         System.out.println("처음부터 다시 반복합니다.");
    //         return;
    //     }
    // }

    // public void deleteAccount(BankAccount a) {
    //     System.out.printf("%s 회원님의 %s번 계좌를 제거합니다.\n", a.getOwnerName(), a.getAccountNum());
    //     passwordMatch(a);
    //     System.out.print("남은 잔고를 이전할 계좌번호를 입력해 주세요 >> ");
    //     int num = s.nextInt();
    //     BankAccount b = numToAccount(num);
    //     System.out.printf("%s님의 계좌 %d로 잔고 전액 %d원을 이전합니다. 계속하시겠습니까?\n계속하려면 1을 눌러주세요.(아닐 경우 처음부터 반복) >> ",
    //             b.getOwnerName(), b.getAccountNum(), a.getBalance());
    //     int yesorno = s.nextInt();
    //     if (yesorno == 1) {
    //         b.setBalance(b.getBalance() + a.getBalance());
    //         accList.remove(a);
    //         System.out.println("계좌 제거가 완료되었습니다. 이용해 주셔서 감사합니다.");
    //     } else {
    //         System.out.println("처음부터 다시 반복합니다.");
    //         return;
    //     }
    // }

    // public BankAccount numToAccount(int num) {
    //     BankAccount b = null;
    //     if (accList.size() != 0) {
    //         for (BankAccount a : accList) {
    //             if (a.getAccountNum() == num) {
    //                 b = a;
    //                 break;
    //             }
    //         }
    //     }
    //     return b;
    // }

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

    // public static void sortItAndPrintIt() {
    //     ArrayList<BankAccount> b = new ArrayList<BankAccount>();
    //     // BankAccount[] b = new BankAccount[accList.size()];
    //     for (BankAccount a : accList) {
    //         b.add(a);
    //     }
    //     for (int i = 0; i < b.size(); i++) {
    //         for (int j = i; j < b.size(); j++) {
    //             if (b.get(i).getAccountNum() > b.get(j).getAccountNum()) {
    //                 BankAccount temp = b.get(i);
    //                 b.set(i, b.get(j));
    //                 b.set(j, temp);
    //             }
    //         }
    //     }
    //     System.out.println("계좌 목록\n타입\t계좌번호\t예금주\t잔액\n---------------------------------------------------");

    //     for (BankAccount ba : b) {
    //         System.out.printf("일반\t%d\t%s\t%d\n", ba.getAccountNum(), ba.getOwnerName(), ba.getBalance());
    //     }
    // }
}
