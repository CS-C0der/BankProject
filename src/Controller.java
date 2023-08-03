import lib.*;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.function.BiConsumer;

public class Controller {

    public static void main(String[] args) throws IOException {

        ArrayList <BankInstitution> listOfAllBankInstitution = new ArrayList<>();

        String incomingString = "Volksbank";

        BankInstitution sparkasse = new BankInstitution("Sparkasse");
        listOfAllBankInstitution.add(sparkasse);

        if (Utility.checkIfNotUsed(incomingString, listOfAllBankInstitution)) {
            BankInstitution volksbank = new BankInstitution(incomingString);
            listOfAllBankInstitution.add(volksbank);
        }

        try {
            UserInput.INSTANCE.setUserInputName(javax.swing.JOptionPane.showInputDialog("Bitte geben Sie den Namen des neuen Kunden ein."));
        }
        catch (IOException | NullPointerException e ) {
            System.err.println(e.getMessage());
        }

        BankCustomer newCustomer = new BankCustomer(UserInput.INSTANCE.getUserInputName());
        System.out.println("Neuer Kunde " + newCustomer.getNameOfBankCustomer() + " erfolgreich eingetragen.");

        try {
            UserInput.INSTANCE.setUserInputIBAN(javax.swing.JOptionPane.showInputDialog("Bitte geben Sie die IBAN für ihren neuen Account ein."));
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        newCustomer.createNewAccount(UserInput.INSTANCE.getUserInputIBAN());
        sparkasse.treeMapOfAllCurrentAccount.put(UserInput.INSTANCE.getUserInputIBAN(), newCustomer.getNameOfBankCustomer());
        System.out.println("Neuer Account für IBAN " + newCustomer.getCurrentAccount().getIBANOfCurrentAccount() + " erfolgreich angelegt.");

        System.out.println("Liste aller bestehenden Accounts mit zugehörigen Kunden: ");
        BiConsumer<String, String> outputOfAllCurrentAccounts = (key, value) -> System.out.println(key + " - " + value);
        sparkasse.treeMapOfAllCurrentAccount.forEach(outputOfAllCurrentAccounts);

    }
}