package dto;

// import dao.AccountList;

/* 계좌 공통 속성 */
public abstract class BankAccount {
    public int accountType;
    public static boolean isOtherTypeExists = false;
    private int accountNum;
    private String ownerName;
    private int password;
    private int balance;

    public BankAccount() {
        this.accountNum = 1000000000 + (int) (Math.random() * 1000000000);
        int p = (int) (Math.random() * 10000);
        if (p < 1000) {
            p *= 10;
        } else if (p == 10000) {
            p /= 10;
        }
        this.password = p;
    }

    public BankAccount(String name, int initialDeposit) {
        this();
        this.ownerName = name;
        this.balance = initialDeposit;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public static boolean isOtherTypeExists() {
        return isOtherTypeExists;
    }

    public static void setOtherTypeExists(boolean isOtherTypeExists) {
        BankAccount.isOtherTypeExists = isOtherTypeExists;
    }
}

/* 테스트 코드 */
// class BankDao {
// public static void main(String[] args) {
// AccountList.addList(new LiteAccount("홍길동", 100000));
// AccountList.addList(new LiteAccount("이순신", 200000));
// AccountList.addList(new LiteAccount("강감찬", 300000));
// BankAccount[] accList = AccountList.getList();
// for(int i = 0; i < AccountList.getLength(); i++) {
// System.out.println(accList[i].getAccountNum() + " " +
// accList[i].getOwnerName() + " " + accList[i].getBalance());
// }
// }
// }