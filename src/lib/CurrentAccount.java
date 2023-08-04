package lib;

public class CurrentAccount {

    private String iBANOfCurrentAccount;
    private int balance;

    public CurrentAccount(String iBANOfCurrentAccount_) {
    	this.iBANOfCurrentAccount = iBANOfCurrentAccount_;
    }

    public String getIBANOfCurrentAccount() {
        return iBANOfCurrentAccount;
    }

    public void setIBANOfCurrentAccount(String iBANOfCurrentAccount_) {
        this.iBANOfCurrentAccount = iBANOfCurrentAccount_;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
