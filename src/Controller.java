import lib.*;

import java.io.IOException;
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
            UserInput.INSTANCE.setUserInputName(javax.swing.JOptionPane.showInputDialog("Bitte geben Sie den  Namen für ihren neuen Account ein."));
        }
        catch (IOException | NullPointerException e ) {
            System.err.println(e.getMessage());
        }

        try {
            UserInput.INSTANCE.setUserInputIBAN(javax.swing.JOptionPane.showInputDialog("Bitte geben Sie die IBAN für ihren neuen Account ein."));
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        BankCustomer newCustomer = new BankCustomer(UserInput.INSTANCE.getUserInputName());
        newCustomer.createNewAccount(UserInput.INSTANCE.getUserInputIBAN());

        sparkasse.treeMapOfAllCurrentAccount.put(newCustomer.getCurrentAccount().getIBANOfCurrentAccount(), newCustomer.getNameOfBankCustomer());

        System.out.println(sparkasse.treeMapOfAllCurrentAccount.get(newCustomer.getCurrentAccount().getIBANOfCurrentAccount())); //Output: name of new Account

        BiConsumer<String, String> outputOfAllCurrentAccounts = (key, value) -> System.out.println(key + " - " + value);
        sparkasse.treeMapOfAllCurrentAccount.forEach(outputOfAllCurrentAccounts);

    }
}