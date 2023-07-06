package lib;

public class ATMOfBank {

    private String nameOfBank;
    private int nrOfATM;

    public ATMOfBank(int nrOfATM_, Bank bank_){
        this.nrOfATM = nrOfATM_;
        this.nameOfBank = bank_.nameOfBank;
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public int getNrOfATM() {
        return nrOfATM;
    }

    public void setNrOfATM(int nrOfATM) {
        this.nrOfATM = nrOfATM;
    }

}