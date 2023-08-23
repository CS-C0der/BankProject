package model;

// Our Bank is an enum because it constitutes one overarching organisation.
public enum BankInstitution {

    INSTANCE;

    // For personalisation and the fun of the user
    // the bank's name (which is initialised here) can be changed in our program.
    private String nameOfBank = "Bank Ihres Vertrauens";

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

}
