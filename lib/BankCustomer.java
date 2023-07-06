package lib;

public class BankCustomer {

    private String nameOfBankCustomer;
    private int idOfBankCustomer;
    private CurrentAccount currentAccount;

    public BankCustomer(String nameOfBankCustomer_) {

    }

    public void createNewAccount() {


    }

    public String getNameOfBankCustomer() {
        return nameOfBankCustomer;
    }

    public void setNameOfBankCustomer(String nameOfBankCustomer) {
        this.nameOfBankCustomer = nameOfBankCustomer;
    }

    public int getIdOfBankCustomer() {
        return idOfBankCustomer;
    }

    public void setIdOfBankCustomer(int idOfBankCustomer) {
        this.idOfBankCustomer = idOfBankCustomer;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }
}
