package model;

// Every customer can create one current account that is referenced to by its IBAN and contains a balance.
public class CurrentAccount {

    private String iBANOfCurrentAccount;
    private int balance;

    // Creates the account by passing the IBAN which is assigned to the new account
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
