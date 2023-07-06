package lib;

import java.util.LinkedList;
import java.util.List;

public class BankInstitution {

    private String nameOfBank;

    public LinkedList<CurrentAccount> listOfAllCurrentAccount;


    public BankInstitution(){};

    public BankInstitution(String nameOfBank_) {
        this.nameOfBank = nameOfBank_;
    }


    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

}
