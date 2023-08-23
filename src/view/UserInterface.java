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

    public boolean run(Database database) throws Exception {

        navigation = showOptionDialog(null, "Was möchten Sie tun?", "Willkommen bei der " + BankInstitution.INSTANCE.getNameOfBank(), 0, JOptionPane.QUESTION_MESSAGE,
                null, options, "Neue Bank");

        switch (navigation) {
            case 0:

                try {
                    setUserInputBank(showInputDialog("Welchen Namen soll Ihre Bank in Zukunft tragen?"));
                    database.renameBank(getUserInputBank());
                } catch (IOException | NullPointerException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case 1:

                try {
                    setUserInputCustomer(showInputDialog("Bitte geben Sie den Namen des neuen Kunden ein."));
                    database.addCustomer(getUserInputCustomer());
                } catch (IOException | NullPointerException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case 2:

                try {
                    setUserInputAccount(showInputDialog("Für welchen Kunden möchten Sie einen Account anlegen?"));
                    database.addAccount(getUserInputAccount());
                } catch (IOException | IllegalAccessError | NullPointerException e) {
                    System.err.println(e.getMessage());
                }
                break;

            case 3:

                try {
                    setUserInputDepositAccount(showInputDialog("Welcher Kunde möchte einzahlen?"));
                    setUserInputDepositAmount(showInputDialog("Wie viel Geld möchten Sie einzahlen?"));
                    database.deposit(getUserInputDepositAccount(), getUserInputDepositAmount());
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

    public void setUserInputDepositAccount(String userInputDepositAccount)  throws IOException, NullPointerException {
        try {
            if (userInputAccount.isBlank()) {
                throw new IOException("Eingabe ungültig.");
            }
            else this.userInputDepositAccount = userInputDepositAccount;
        }
        catch (NullPointerException e){
            throw new NullPointerException("Zugriff nicht möglich. Haben Sie alles Nötige angelegt?");
        }

    }


}
