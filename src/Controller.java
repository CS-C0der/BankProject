import lib.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class Controller {

    public static void main(String[] args) throws Exception {

        Database database = new Database();

        try {
            UserInput.INSTANCE.setUserInputBank(javax.swing.JOptionPane.showInputDialog("Bitte geben Sie den Namen der neuen Bankinstitution ein."));
            database.addBank(UserInput.INSTANCE.getUserInputBank());
        }
        catch (IOException | NullPointerException e ) {
            System.err.println(e.getMessage());
        }


        try {
            UserInput.INSTANCE.setUserInputCustomer(javax.swing.JOptionPane.showInputDialog("Bitte geben Sie den Namen des neuen Kunden ein."));
            database.addCustomer(UserInput.INSTANCE.getUserInputCustomer());
        }
        catch (IOException | NullPointerException e ) {
            System.err.println(e.getMessage());
        }

        try {
            UserInput.INSTANCE.setUserInputAccount(javax.swing.JOptionPane.showInputDialog("Für welchen Kunden wollen Sie einen Account anlegen?"));
            database.addAccount(UserInput.INSTANCE.getUserInputAccount());
        }
        catch (IllegalArgumentException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
/*
        try {
            UserInput.INSTANCE.setUserInputIBAN(javax.swing.JOptionPane.showInputDialog("Für welchen Kunden wollen Sie einen Account anlegen?"));
            database.addAccount(UserInput.INSTANCE.getUserInputIBAN());
        }
        catch (IllegalArgumentException | NullPointerException e) {
            System.err.println(e.getMessage());
        }

 */

/*
        System.out.println("Liste aller bestehenden Accounts mit zugehörigen Kunden: ");
        BiConsumer<String, String> outputOfAllCurrentAccounts = (key, value) -> System.out.println(key + " - " + value);
        database.treeMapOfAllCurrentAccount.forEach(outputOfAllCurrentAccounts);
*/
    }
}