package lib;

public class Bank {

    private String nameOfBank;

    public Bank(){};

    public Bank(String nameOfBank_) {
        this.nameOfBank = nameOfBank_;
    }


    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

}
