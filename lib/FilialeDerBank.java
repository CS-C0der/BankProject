package lib;

public class FilialeDerBank extends Bank {

    private String nameDerFiliale;
    private String IBAN;
    private String BIC;

    public FilialeDerBank(String nameDerFiliale_){
        this.nameDerFiliale = nameDerFiliale_;
    }


    public String getNameDerFiliale() {
        return nameDerFiliale;
    }

    public void setNameDerFiliale(String nameDerFiliale) {
        this.nameDerFiliale = nameDerFiliale;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

}
