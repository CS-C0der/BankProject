package view;

import data.Database;
import model.BankInstitution;

import javax.swing.*;
import java.io.IOException;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showOptionDialog;

public enum UserInterface {

    INSTANCE;

    private String userInputBank;
    private String userInputCustomer;
    private String userInputAccount;
    private int userInputDepositAmount;
    private String userInputDepositAccount;
    private int navigation;
    private String[] options = {"Bank umbenennen", "Neuer Kunde", "Neuer Account", "Geld einzahlen", "Bestand anzeigen", "Beenden"};
    private String dialogReturn;
    private String errMessageNullpointer = "Das hat leider nicht geklappt. Haben Sie alles Nötige angelegt?";
    private String errMessageBlank = "Bitte stellen Sie sicher, dass Ihre Eingabe etwas enthält.";

    /**
     * Runs the UserInterface with a central Option Dialog from which various actions can be performed
     *
     * @param database - the local java database is initialised in the main method and passed here, so that all data operations can be performed from here
     * @return - passes the boolean indicating whether the application is still running (so this method gets recalled from the main method) or terminated
     * @throws Exception - in this method, all exceptions (thrown in other functions that were called from here) are caught and error messages printed
     */
    public boolean run(Database database) throws Exception {

        /**
         * Provides a choice of buttons saved under "options" and displays a welcome message with the name of the bank (which can be changed by the user)
         */
        navigation = showOptionDialog(null, "Was möchten Sie tun?", "Willkommen bei der " + BankInstitution.INSTANCE.getNameOfBank(), 0, 3,
                null, options, "Neue Bank");

        /**
         * The return value of the option dialog, saved as "navigation", determines what to do next
         */
        switch (navigation) {
            case 0:

                try {
                    dialogReturn = showInputDialog("Welchen Namen soll Ihre Bank in Zukunft tragen?");
                    if (dialogReturn!=null) {
                        setUserInputBank(dialogReturn);
                        BankInstitution.INSTANCE.setNameOfBank(getUserInputBank());
                    }
                } catch (IOException | NullPointerException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case 1:

                try {
                    dialogReturn = showInputDialog("Bitte geben Sie den Namen des neuen Kunden ein.");
                    if (dialogReturn!=null) {
                        setUserInputCustomer(dialogReturn);
                        database.addCustomer(getUserInputCustomer());
                    }
                } catch (IOException | NullPointerException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case 2:

                try {
                    dialogReturn = showInputDialog("Für welchen Kunden möchten Sie einen Account anlegen?");
                    if (dialogReturn!=null) {
                        setUserInputAccount(dialogReturn);
                        database.addAccount(getUserInputAccount());
                    }
                } catch (IOException | IllegalAccessError | NullPointerException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case 3:

                try {
                    dialogReturn = showInputDialog(("Welcher Kunde möchte einzahlen?"));
                    if (dialogReturn!=null) {
                        setUserInputDepositAccount(dialogReturn);
                        dialogReturn = showInputDialog(("Welcher Betrag soll eingezahlt werden?"));
                        if (dialogReturn!=null) {
                            setUserInputDepositAmount(dialogReturn);
                            database.deposit(getUserInputDepositAccount(), getUserInputDepositAmount());
                        }
                    }
                } catch (IOException | IllegalArgumentException | IllegalAccessError | NullPointerException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case 4:

                try {
                    database.showAll();
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case 5:
                System.out.println("Vielen Dank für Ihren Besuch. Beehren Sie uns bald wieder.");
                return false;
        }

        return true;
    }

    public String getUserInputBank() {
        return userInputBank;
    }

    public void setUserInputBank(String userInputBank) throws IOException, NullPointerException  {

       try {
            if (userInputBank.isBlank()) {
                throw new IOException(errMessageBlank);
            }
            else this.userInputBank = userInputBank;
        }
        catch (NullPointerException e){
            throw new NullPointerException(errMessageNullpointer);
        }
    }

    public String getUserInputCustomer() {
        return userInputCustomer;
    }

    public void setUserInputCustomer(String userInputCustomer) throws IOException, NullPointerException  {

        try {
            if (userInputCustomer.isBlank()) {
                throw new IOException(errMessageBlank);
            }
            else this.userInputCustomer = userInputCustomer;
        }
        catch (NullPointerException e){
            throw new NullPointerException(errMessageNullpointer);
        }

    }

    public String getUserInputAccount() {
        return userInputAccount;
    }

    public void setUserInputAccount(String userInputAccount)  throws IOException, NullPointerException  {

        try {
            if (userInputAccount.isBlank()) {
                throw new IOException(errMessageBlank);
            }
            else this.userInputAccount = userInputAccount;
        }
        catch (NullPointerException e){
            throw new NullPointerException(errMessageNullpointer);
        }
    }

    public int getUserInputDepositAmount() {
        return userInputDepositAmount;
    }

    public void setUserInputDepositAmount(String userInputDepositAmount) throws IOException, NumberFormatException, NullPointerException {

        try {
            if (userInputDepositAmount.isBlank()) {
                throw new IOException(errMessageBlank);
            }
            else this.userInputDepositAmount = Integer.parseInt(userInputDepositAmount);
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Sie dürfen nur ganze Zahlen eingeben.");
        }
        catch (NullPointerException e){
            throw new NullPointerException(errMessageNullpointer);
        }
        if (this.userInputDepositAmount <= 0) {
            throw new NumberFormatException("Sie dürfen nur positive Zahlen eingeben.");
        }
    }

    public String getUserInputDepositAccount() {
        return userInputDepositAccount;
    }

    public void setUserInputDepositAccount(String userInputDepositAccount)  throws IOException, NullPointerException {
        try {
            if (userInputAccount.isBlank()) {
                throw new IOException(errMessageBlank);
            }
            else this.userInputDepositAccount = userInputDepositAccount;
        }
        catch (NullPointerException e){
            throw new NullPointerException(errMessageNullpointer);
        }

    }


}
