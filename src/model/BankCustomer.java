package model;

public class BankCustomer {

    private String nameOfBankCustomer;

    /**
     * Every customer can have one account which must be created by the user first
     */
    private CurrentAccount currentAccount;

    /**
     * Creates a new BankCustomer, which is only possible when passing a name
     *
     * @param nameOfBankCustomer_ - Name of the customer
     */
    public BankCustomer(String nameOfBankCustomer_) {
    	this.nameOfBankCustomer = nameOfBankCustomer_;
    }

    public String getNameOfBankCustomer() {
        return nameOfBankCustomer;
    }

    public void setNameOfBankCustomer(String nameOfBankCustomer_) {
        this.nameOfBankCustomer = nameOfBankCustomer_;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }
}
