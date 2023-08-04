package lib;

import java.io.IOException;
import java.util.function.BiConsumer;

public enum UserInterface {

    INSTANCE;

    private String userInputBank;
    private String userInputCustomer;
    private String userInputAccount;
    private int userInputDepositAmount;
    private String userInputDepositAccount;

    public void run(Database database) throws Exception {


        try {
            setUserInputBank(javax.swing.JOptionPane.showInputDialog("Bitte geben Sie den Namen der neuen Bankinstitution ein."));
            database.addBank(getUserInputBank());
        }
        catch (IOException | NullPointerException e ) {
            System.err.println(e.getMessage());
        }

        try {
            setUserInputCustomer(javax.swing.JOptionPane.showInputDialog("Bitte geben Sie den Namen des neuen Kunden ein."));
            database.addCustomer(getUserInputCustomer());
        }
        catch (IOException | NullPointerException e ) {
            System.err.println(e.getMessage());
        }

        try {
            setUserInputAccount(javax.swing.JOptionPane.showInputDialog("Für welchen Kunden wollen Sie einen Account anlegen?"));
            database.addAccount(getUserInputAccount());
        }
        catch (IOException | IllegalAccessError | NullPointerException e) {
            System.err.println(e.getMessage());
        }

        try {
            setUserInputDepositAccount(javax.swing.JOptionPane.showInputDialog("Welcher Kunde möchte einzahlen?"));
            setUserInputDepositAmount(javax.swing.JOptionPane.showInputDialog("Wie viel Geld wollen Sie aufs Konto einzahlen?"));
            database.deposit(getUserInputDepositAccount(), getUserInputDepositAmount());
        }
        catch (IllegalArgumentException | IllegalAccessError | NullPointerException e) {
            System.err.println(e.getMessage());
        }

        try {
            database.showAll();
        }
        catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }

    }

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
            throw new NullPointerException("Zugriff nicht möglich. Haben Sie alles Nötige angelegt?");
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
            throw new NullPointerException("Zugriff nicht möglich. Haben Sie alles Nötige angelegt?");
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
            throw new NullPointerException("Zugriff nicht möglich. Haben Sie alles Nötige angelegt?");
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
            throw new NullPointerException("Zugriff nicht möglich. Haben Sie alles Nötige angelegt?");
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
