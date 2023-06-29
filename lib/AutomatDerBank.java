package lib;

public class AutomatDerBank extends Bank {

    private int nrDesAutomaten;

    public AutomatDerBank(int nrDesAutomaten_){
        this.nrDesAutomaten = nrDesAutomaten_;
    }

    public int getNrDesAutomaten() {
        return nrDesAutomaten;
    }

    public void setNrDesAutomaten(int nrDesAutomaten) {
        this.nrDesAutomaten = nrDesAutomaten;
    }

}
