package dto;

public class Account {
    
    // 계좌번호, 예금주, 잔액
    private int accNumber;
    private String ownerName;
    private int balance; // 21억까지밖에 못 넣는 은행;;

    public Account() {}
    public Account(String ownerName, int balance) {
        setAccNumber((int)(1000000000 + Math.random() * 100000000 + 1));
        setOwnerName(ownerName);
        setBalance(balance);
    }

    public int getAccNumber() {
        return accNumber;
    }
    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
