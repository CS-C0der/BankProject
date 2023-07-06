package lib;

import java.util.LinkedList;

public class BankCustomer {

    private String nameOfBankCustomer;
    private int idOfBankCustomer;
    private CurrentAccount currentAccount;

    public BankCustomer(String nameOfBankCustomer_) {

    }

    public void createNewAccount(LinkedList list_) {
        //CurrentAccount.setIdOfCurrentAccount(list_.size());
        //resolve static/non-static issue here
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
