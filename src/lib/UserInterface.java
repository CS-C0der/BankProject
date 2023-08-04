package lib;

import java.io.IOException;

public enum UserInterface {

    INSTANCE;

    private String userInputBank;
    private String userInputCustomer;
    private String userInputAccount;
    private int userInputDepositAmount;
    private String userInputDepositAccount;

    public String getUserInputBank() {
        return userInputBank;
    }

    public void setUserInputBank(String userInputBank) throws IOException, NullPointerException  {

       try {
            if (userInputBank.isBlank()) {
                throw new IOException("Eingabe ungültig.");
            }
            else this.userInputBank = userInputBank;
        }
        catch (NullPointerException e){
            throw new NullPointerException("Sie haben nichts eingegeben.");
        }
    }

    public String getUserInputCustomer() {
        return userInputCustomer;
    }

    public void setUserInputCustomer(String userInputCustomer) throws IOException, NullPointerException  {

        try {
            if (userInputCustomer.isBlank()) {
                throw new IOException("Eingabe ungültig.");
            }
            else this.userInputCustomer = userInputCustomer;
        }
        catch (NullPointerException e){
            throw new NullPointerException("Sie haben nichts eingegeben.");
        }

    }

    public String getUserInputAccount() {
        return userInputAccount;
    }

    public void setUserInputAccount(String userInputAccount)  throws IOException, NullPointerException  {

        try {
            if (userInputAccount.isBlank()) {
                throw new IOException("Eingabe ungültig.");
            }
            else this.userInputAccount = userInputAccount;
        }
        catch (NullPointerException e){
            throw new NullPointerException("Sie haben nichts eingegeben.");
        }
    }

    public int getUserInputDepositAmount() {
        return userInputDepositAmount;
    }

    public void setUserInputDepositAmount(String userInputDepositAmount) throws IOException, NumberFormatException, NullPointerException {

        try {
            if (userInputDepositAmount.isBlank()) {
                throw new IOException("Eingabe ungültig.");
            }
            else this.userInputDepositAmount = Integer.parseInt(userInputDepositAmount);
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Sie dürfen nur ganze Zahlen eingeben.");
        }
        catch (NullPointerException e){
            throw new NullPointerException("Sie haben nichts eingegeben.");
        }
        if (this.userInputDepositAmount <= 0) {
            throw new NumberFormatException("Sie dürfen nur positive Zahlen eingeben.");
        }
    }

    public String getUserInputDepositAccount() {
        return userInputDepositAccount;
    }

    public void setUserInputDepositAccount(String userInputDepositAccount) {
        this.userInputDepositAccount = userInputDepositAccount;
    }


}
