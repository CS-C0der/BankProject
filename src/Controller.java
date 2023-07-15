import lib.*;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class Controller {

    public static void main(String[] args) {

        ArrayList <BankInstitution> Database = new ArrayList<>();

        String incomingString = "Volksbank";

        BankInstitution sparkasse = new BankInstitution("Sparkasse");
        Database.add(sparkasse);

        if (Utility.checkIfNotUsed(incomingString, Database)) {
            BankInstitution volksbank = new BankInstitution(incomingString);
            Database.add(volksbank);
        }

        System.out.println("Namen unserer Banken: ");
        System.out.println(Database.get(0).getNameOfBank());
        System.out.println(Database.get(1).getNameOfBank());


        BranchOfBank filialeAmPlatz = new BranchOfBank("Platzfiliale", sparkasse);

        System.out.println("Name unserer Filiale: ");
        System.out.println(filialeAmPlatz.getNameOfBranch());
        System.out.println(filialeAmPlatz.getNameOfBank());

        ATMOfBank atmAmPlatz = new ATMOfBank(1, sparkasse);

        System.out.println("Nummer unseres Bankautomaten: ");
        System.out.println(atmAmPlatz.getNrOfATM());
        System.out.println(atmAmPlatz.getNameOfBank());
        
        String eingabeName = javax.swing.JOptionPane.showInputDialog("Bitte geben Sie den Namen für ihren neuen Account ein.");
        
        String eingabeIBAN = javax.swing.JOptionPane.showInputDialog("Bitte geben Sie die IBAN für ihren neuen Account ein.");
        
        BankCustomer newCustomer = new BankCustomer(eingabeName);
        newCustomer.createNewAccount(eingabeIBAN);
        
        sparkasse.treeMapOfAllCurrentAccount.put(newCustomer.getCurrentAccount().getIBANOfCurrentAccount(), newCustomer.getNameOfBankCustomer());
        
        System.out.println(sparkasse.treeMapOfAllCurrentAccount.get(newCustomer.getCurrentAccount().getIBANOfCurrentAccount()));
                
        BiConsumer<String, String> outputOfAllCurrentAccounts = (key, value) -> System.out.println(key + " - " + value);
        sparkasse.treeMapOfAllCurrentAccount.forEach(outputOfAllCurrentAccounts);
        
        

    }
}