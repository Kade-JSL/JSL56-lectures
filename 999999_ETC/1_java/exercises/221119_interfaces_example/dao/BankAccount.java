package dao;

public abstract class BankAccount { // 일반적인 은행 계좌가 공통으로 가지는 속성
    int accountType;
    private long accountNum;
    private String ownerName;
    private long balance;

    public BankAccount() {
        this.accountNum = 10000000000l + (long) (Math.random() * 10000000000l);
    }
    public BankAccount(String name, long initialDeposit) {
        this();
        this.ownerName = name;
        this.balance = initialDeposit;
    }
    public long getAccountNum() { return accountNum; }
    public void setAccountNum(long accountNum) { this.accountNum = accountNum; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public long getBalance() { return balance; }
    public void setBalance(long balance) { this.balance = balance; }
}

class AccountList { // 싱글톤 객체
    private static AccountList accountList = new AccountList();
    private static int listLength;

    private AccountList() { listLength = 0; }

    private BankAccount[] accList = new BankAccount[1000];


    public static BankAccount[] getList() { return accountList.accList; }
    public static int getLength() { return listLength; }

    public static void addList(BankAccount a) {
        getList()[listLength] = a;
        listLength++;
    }
}

class GeneralAccount extends BankAccount {
    public GeneralAccount() {
        super();
        super.accountType = 0;
    }

    public GeneralAccount(String name, long initialDeposit) {
        super(name, initialDeposit);
    }

}

class BankDao {
    public static void main(String[] args) {
        AccountList.addList(new GeneralAccount("홍길동", 100000));
        AccountList.addList(new GeneralAccount("이순신", 200000));
        AccountList.addList(new GeneralAccount("강감찬", 300000));
        BankAccount[] accList = AccountList.getList();
        for(int i = 0; i < AccountList.getLength(); i++) {
            System.out.println(accList[i].getAccountNum() + " " + accList[i].getOwnerName() + " " + accList[i].getBalance());
        }
    }
}