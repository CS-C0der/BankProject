package lib;

public class BankCustomer {

    private String nameOfBankCustomer;
    private CurrentAccount currentAccount;

    public BankCustomer(String nameOfBankCustomer_) {
    	this.nameOfBankCustomer = nameOfBankCustomer_;
    }

    public void createNewAccount(String iBAN_) {
        this.currentAccount = new CurrentAccount(iBAN_);
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
