package dto;

/* 계좌 리스트 */
public class AccountList {
    private static AccountList accountList = new AccountList();
    private static int listLength;
    private AccountList() { listLength = 0; } // 싱글톤 객체

    private BankAccount[] accList = new BankAccount[1000];


    public static BankAccount[] getList() { return accountList.accList; }
    public static int getLength() { return listLength; }

    public static void addList(BankAccount a) {
        getList()[listLength] = a;
        listLength++;
    }
}
