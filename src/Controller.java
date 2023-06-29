import lib.ATMOfBank;
import lib.Bank;
import lib.Utility;
import lib.BranchOfBank;
import java.util.ArrayList;

public class Controller {

    public static void main(String[] args) {

        ArrayList <Bank> Database = new ArrayList<>();

        String incomingString = "Volksbank";

        Bank Sparkasse = new Bank("Sparkasse");
        Database.add(Sparkasse);

        if (Utility.checkIfNotUsed(incomingString, Database)) {
            Bank Volksbank = new Bank(incomingString);
            Database.add(Volksbank);
        }

        System.out.println("Namen unserer Banken: ");
        System.out.println(Database.get(0).nameOfBank);
        System.out.println(Database.get(1).nameOfBank);


        BranchOfBank filialeAmPlatz = new BranchOfBank("Platzfiliale", Sparkasse);

        System.out.println("Name unserer Filiale: ");
        System.out.println(filialeAmPlatz.getNameOfBranch());
        System.out.println(filialeAmPlatz.getNameOfBank());

        ATMOfBank atmAmPlatz = new ATMOfBank(1, Sparkasse);

        System.out.println("Nummer unseres Bankautomaten: ");
        System.out.println(atmAmPlatz.getNrOfATM());
        System.out.println(atmAmPlatz.getNameOfBank());

    }
}