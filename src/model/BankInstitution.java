package model;


public enum BankInstitution {

    INSTANCE;

    private String nameOfBank = "Bank Ihres Vertrauens";

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

}
