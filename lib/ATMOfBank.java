package lib;

public class ATMOfBank extends Bank {

    private int nrOfATM;

    public ATMOfBank(int nrOfATM_){
        this.nrOfATM = nrOfATM_;
    }

    public int getNrOfATM() {
        return nrOfATM;
    }

    public void setNrOfATM(int nrOfATM) {
        this.nrOfATM = nrOfATM;
    }

}
