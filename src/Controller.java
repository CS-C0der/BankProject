import lib.ATMOfBank;
import lib.BankInstitution;
import lib.Utility;
import lib.BranchOfBank;
import java.util.ArrayList;

public class Controller {

    public static void main(String[] args) {

        ArrayList <BankInstitution> Database = new ArrayList<>();

        String incomingString = "Volksbank";

        BankInstitution Sparkasse = new BankInstitution("Sparkasse");
        Database.add(Sparkasse);

        if (Utility.checkIfNotUsed(incomingString, Database)) {
            BankInstitution volksbank = new BankInstitution(incomingString);
            Database.add(volksbank);
        }

        System.out.println("Namen unserer Banken: ");
        System.out.println(Database.get(0).getNameOfBank());
        System.out.println(Database.get(1).getNameOfBank());


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