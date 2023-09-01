package view;

import data.Database;
import model.BankInstitution;

import javax.swing.*;
import java.io.IOException;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showOptionDialog;

/**
 * Handles all interactions with the user and what he gets to see.
 * It is an enum to prohibit object referencing conflicts and to make clear there is only one user interface
 */
public enum UserInterface {

    INSTANCE;

    private String userInputBank;
    private String userInputCustomer;
    private String userInputAccount;
    private int userInputDepositAmount;
    private String userInputDepositAccount;
    private int navigation;
    private String[] options = {"Bank umbenennen", "Neuer Kunde", "Neues Konto", "Geld einzahlen", "Bestand anzeigen", "Beenden"};
    // dialogReturn gets reassigned and directly processed each time an Input Dialog for any operation is called
    private String dialogReturn;
    private String errMessageNullPointer = "Das hat leider nicht geklappt. Haben Sie alles Nötige angelegt?";
    private String errMessageBlank = "Bitte stellen Sie sicher, dass Ihre Eingabe etwas enthält.";

    /**
     * Runs the UserInterface with a central Option Dialog from which various actions can be performed
     *
     * @param database - the local java database is initialised in the main method and passed here, so that all data operations can be performed from here
     * @return - passes the boolean indicating whether the application is still running (so this method gets recalled from the main method) or terminated
     * @throws Exception - in this method, all exceptions (thrown in other functions that were called from here) are caught and error messages printed
     */
    public boolean run(Database database) throws Exception {

        //Provides a choice of buttons saved under "options" and displays a welcome message with the name of the bank (which can be changed by the user)
        navigation = showOptionDialog(null, "Was möchten Sie tun?", "Willkommen bei der " + BankInstitution.INSTANCE.getNameOfBank(), 0, JOptionPane.QUESTION_MESSAGE,
                null, options, "Neuer Kunde");

        //The return value of the option dialog, saved as "navigation", determines what to do next
        switch (navigation) {
            case 0 -> {
                try {
                    dialogReturn = showInputDialog("Welchen Namen soll Ihre Bank in Zukunft tragen?");
                    if (dialogReturn != null) { //only executes if OK-button was clicked; "x" or "Cancel" lead to a null
                        setUserInputBank(dialogReturn);
                        BankInstitution.INSTANCE.setNameOfBank(getUserInputBank());
                    }
                } catch (IOException | NullPointerException e) {
                    System.err.println(e.getMessage());
                }
            }
            case 1 -> {
                try {
                    dialogReturn = showInputDialog("Bitte geben Sie den Namen des neuen Kunden ein.");
                    if (dialogReturn != null) {
                        setUserInputCustomer(dialogReturn);
                        database.addCustomer(getUserInputCustomer());
                    }
                } catch (IOException | IllegalAccessError | NullPointerException e) {
                    System.err.println(e.getMessage());
                }
            }
            case 2 -> {
                try {
                    dialogReturn = showInputDialog("Für welchen Kunden möchten Sie ein Konto anlegen?");
                    if (dialogReturn != null) {
                        setUserInputAccount(dialogReturn);
                        database.addAccount(getUserInputAccount());
                    }
                } catch (IOException | IllegalAccessError | NullPointerException e) {
                    System.err.println(e.getMessage());
                }
            }
            case 3 -> {
                try {
                    dialogReturn = showInputDialog(("Welcher Kunde möchte einzahlen?"));
                    if (dialogReturn != null) {
                        setUserInputDepositAccount(dialogReturn);

                        //only call second dialog if first one is responded to with "OK"
                        dialogReturn = showInputDialog(("Welcher Betrag soll eingezahlt werden?"));
                        if (dialogReturn != null) {
                            setUserInputDepositAmount(dialogReturn);
                            database.deposit(getUserInputDepositAccount(), getUserInputDepositAmount());
                        }
                    }
                } catch (IOException | IllegalArgumentException | IllegalAccessError | NullPointerException e) {
                    System.err.println(e.getMessage());
                }
            }
            case 4 -> {
                try {
                    database.showAll();
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                }
            }
            // the default case handles clicking the exit button as well as the "x" on top right
            default -> {
                System.out.println("Vielen Dank für Ihren Besuch. Beehren Sie uns bald wieder.");
                // terminates application by returning "false" to the loop in main method
                return false;
            }
        }

        return true;
    }

    public String getUserInputBank() {
        return userInputBank;
    }

    /**
     * stores user input for renaming the bank in local variable
     * @param userInputBank - new name for bank entered by the user
     * @throws IOException - reports to user when his input is empty or only blanks
     * @throws NullPointerException - reports to user when NullPointer is evoked
     */
    public void setUserInputBank(String userInputBank) throws IOException, NullPointerException  {

       try {
            if (userInputBank.isBlank()) {
                throw new IOException(errMessageBlank);
            }
            else this.userInputBank = userInputBank;
        }
        catch (NullPointerException e){
            throw new NullPointerException(errMessageNullPointer);
        }
    }

    public String getUserInputCustomer() {
        return userInputCustomer;
    }

    /**
     * stores user input for new customer in local variable
     * @param userInputCustomer - new name for customer entered by the user
     * @throws IOException - reports to user when his input is empty or only blanks
     * @throws NullPointerException - reports to user when NullPointer is evoked
     */
    public void setUserInputCustomer(String userInputCustomer) throws IOException, NullPointerException  {

        try {
            if (userInputCustomer.isBlank()) {
                throw new IOException(errMessageBlank);
            }
            else this.userInputCustomer = userInputCustomer;
        }
        catch (NullPointerException e){
            throw new NullPointerException(errMessageNullPointer);
        }

    }

    public String getUserInputAccount() {
        return userInputAccount;
    }

    /**
     * stores user input for new account (customer reference) in local variable
     * @param userInputAccount - passes the name of the customer for which the account should be created
     * @throws IOException - reports to user when his input is empty or only blanks
     * @throws NullPointerException - reports to user when NullPointer is evoked
     */
    public void setUserInputAccount(String userInputAccount)  throws IOException, NullPointerException  {

        try {
            if (userInputAccount.isBlank()) {
                throw new IOException(errMessageBlank);
            }
            else this.userInputAccount = userInputAccount;
        }
        catch (NullPointerException e){
            throw new NullPointerException(errMessageNullPointer);
        }
    }

    public int getUserInputDepositAmount() {
        return userInputDepositAmount;
    }

    /**
     * stores user input for deposit amount (customer reference) in local variable
     * @param userInputDepositAmount - passes the amount of money to be deposited
     * @throws IOException - reports to user when his input is empty or only blanks
     * @throws NumberFormatException - reports to user when his input is not an integer or not positive
     * @throws NullPointerException - reports to user when NullPointer is evoked
     */
    public void setUserInputDepositAmount(String userInputDepositAmount) throws IOException, NumberFormatException, NullPointerException {

        try {
            if (userInputDepositAmount.isBlank()) {
                throw new IOException(errMessageBlank);
            }
            // The parseInt function causes the NumberFormatExceptions that are handled further down if anything is wrong
            else this.userInputDepositAmount = Integer.parseInt(userInputDepositAmount);
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Sie dürfen nur ganze Zahlen eingeben.");
        }
        catch (NullPointerException e){
            throw new NullPointerException(errMessageNullPointer);
        }
        if (this.userInputDepositAmount <= 0) {
            throw new NumberFormatException("Sie dürfen nur positive Zahlen eingeben.");
        }
    }

    public String getUserInputDepositAccount() {
        return userInputDepositAccount;
    }

    /**
     * stores user input for which customer's account the money should be deposited, in a local variable
     * @param userInputDepositAccount - passes the name of the customer into whose account the money will be deposited
     * @throws IOException - reports to user when his input is empty or only blanks
     * @throws NullPointerException - reports to user when NullPointer is evoked
     */
    public void setUserInputDepositAccount(String userInputDepositAccount)  throws IOException, NullPointerException {
        try {
            if (userInputAccount.isBlank()) {
                throw new IOException(errMessageBlank);
            }
            else this.userInputDepositAccount = userInputDepositAccount;
        }
        catch (NullPointerException e){
            throw new NullPointerException(errMessageNullPointer);
        }

    }


}
