import lib.*;

import java.io.IOException;

public class Controller {

    public static void main(String[] args) throws Exception {

        Database database = new Database();

        try {
            UserInterface.INSTANCE.setUserInputBank(javax.swing.JOptionPane.showInputDialog("Bitte geben Sie den Namen der neuen Bankinstitution ein."));
            database.addBank(UserInterface.INSTANCE.getUserInputBank());
        }
        catch (IOException | NullPointerException e ) {
            System.err.println(e.getMessage());

        }


        try {
            UserInterface.INSTANCE.setUserInputCustomer(javax.swing.JOptionPane.showInputDialog("Bitte geben Sie den Namen des neuen Kunden ein."));
            database.addCustomer(UserInterface.INSTANCE.getUserInputCustomer());
        }
        catch (IOException | NullPointerException e ) {
            System.err.println(e.getMessage());
        }

        try {
            UserInterface.INSTANCE.setUserInputAccount(javax.swing.JOptionPane.showInputDialog("Für welchen Kunden wollen Sie einen Account anlegen?"));
            database.addAccount(UserInterface.INSTANCE.getUserInputAccount());
        }
        catch (IOException | NullPointerException e) {
            System.err.println(e.getMessage());
        }

        try {
            UserInterface.INSTANCE.setUserInputDepositAccount(javax.swing.JOptionPane.showInputDialog("Welcher Kunde möchte einzahlen?"));
            UserInterface.INSTANCE.setUserInputDepositAmount(javax.swing.JOptionPane.showInputDialog("Wie viel Geld wollen Sie aufs Konto einzahlen?"));
            database.deposit(UserInterface.INSTANCE.getUserInputDepositAccount(), UserInterface.INSTANCE.getUserInputDepositAmount());
        }
        catch (IllegalArgumentException | NullPointerException e) {
            System.err.println(e.getMessage());
        }


 

/*
        System.out.println("Liste aller bestehenden Accounts mit zugehörigen Kunden: ");
        BiConsumer<String, String> outputOfAllCurrentAccounts = (key, value) -> System.out.println(key + " - " + value);
        database.treeMapOfAllCurrentAccount.forEach(outputOfAllCurrentAccounts);
*/
    }
}