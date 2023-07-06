package lib;

public class BranchOfBank {

    private String nameOfBank;
    private String nameOfBranch;
    private String IBAN;
    private String BIC;

    public BranchOfBank(String nameOfBranch_, Bank bank_){
        this.nameOfBranch = nameOfBranch_;
        this.nameOfBank = bank_.nameOfBank;
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public String getNameOfBranch() {
        return nameOfBranch;
    }

    public void setNameOfBranch(String nameOfBranch) {
        this.nameOfBranch = nameOfBranch;
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
