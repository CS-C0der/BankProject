package lib;

public class ATMOfBank extends Bank {

    private int nrOfATM;

    public ATMOfBank(int nrOfATM_, Bank bank_){
        this.nrOfATM = nrOfATM_;
        this.nameOfBank = bank_.nameOfBank;
    }

    public int getNrOfATM() {
        return nrOfATM;
    }

    public void setNrOfATM(int nrOfATM) {
        this.nrOfATM = nrOfATM;
    }

}
