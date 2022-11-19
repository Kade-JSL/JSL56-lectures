package dto;

/* 일반 계좌 */
public class GeneralAccount extends BankAccount {

    public GeneralAccount() {
        super();
        super.accountType = 0;
    }

    public GeneralAccount(String name, int initialDeposit) {
        super(name, initialDeposit);
        super.accountType = 0;
    }

}