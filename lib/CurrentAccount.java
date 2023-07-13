package lib;

public class CurrentAccount {

    private String iBANOfCurrentAccount;

    public CurrentAccount(String iBANOfCurrentAccount_) {
    	this.iBANOfCurrentAccount = iBANOfCurrentAccount_;
    	
    }

    public String getIBANOfCurrentAccount() {
        return iBANOfCurrentAccount;
    }

    public void setIBANOfCurrentAccount(String iBANOfCurrentAccount_) {
        this.iBANOfCurrentAccount = iBANOfCurrentAccount_;
    }

}
