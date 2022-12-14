package dto;

/* 일반 계좌 */
public class LiteAccount extends BankAccount {

    public LiteAccount() {
        super();
        super.setAccountNum(10000 + (int) (Math.random() * 10000));
        int p = (int) (Math.random() * 100);
        if (p < 10) {
            p *= 10;
        } else if (p == 100) {
            p /= 10;
        }
        super.setPassword(p);
        super.accountType = 0;
    }

    public LiteAccount(String name, int initialDeposit) {
        super(name, initialDeposit);
        super.setAccountNum(10000 + (int) (Math.random() * 10000));
        int p = (int) (Math.random() * 100 + 1);
        if (p < 10) {
            p *= 10;
        } else if (p == 100) {
            p /= 10;
        }
        super.setPassword(p);
        super.accountType = 0;
    }

}