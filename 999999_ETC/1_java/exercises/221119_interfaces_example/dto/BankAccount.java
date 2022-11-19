package dto;

// import dao.AccountList;

/* 계좌 공통 속성 */
public abstract class BankAccount {
    public int accountType;
    public static boolean isOtherTypeExists = false;
    private long accountNum;
    private String ownerName;
    private int password;
    private long balance;

    public BankAccount() {
        this.accountNum = 10000000000l + (long) (Math.random() * 10000000000l);
        this.password = (int) (Math.random() * 10000);
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
    public int getPassword() { return password; }
    public void setPassword(int password) { this.password = password; }
    public long getBalance() { return balance; }
    public void setBalance(long balance) { this.balance = balance; }
}

/* 테스트 코드 */
// class BankDao {
//     public static void main(String[] args) {
//         AccountList.addList(new GeneralAccount("홍길동", 100000));
//         AccountList.addList(new GeneralAccount("이순신", 200000));
//         AccountList.addList(new GeneralAccount("강감찬", 300000));
//         BankAccount[] accList = AccountList.getList();
//         for(int i = 0; i < AccountList.getLength(); i++) {
//             System.out.println(accList[i].getAccountNum() + " " + accList[i].getOwnerName() + " " + accList[i].getBalance());
//         }
//     }
// }