package lib;

import java.util.LinkedList;
import java.util.TreeMap;

public class BankInstitution {

    private String nameOfBank;

    public TreeMap<String, String> treeMapOfAllCurrentAccount = new TreeMap<String, String>();

    public LinkedList<BranchOfBank> listOfAllBranchOfBank;

    public LinkedList<ATMOfBank> listOfAllATMOfBank;

    public LinkedList<BankCustomer> listOfAllBankCustomer;

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
