import lib.Bank;
import lib.Utility;
import lib.branchOfBank;
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


        branchOfBank filialeAmPlatz = new branchOfBank("Platzfiliale", Sparkasse);

        System.out.println("Namen unserer Filialen: ");
        System.out.println(filialeAmPlatz.getNameOfBranch());
        System.out.println(filialeAmPlatz.getNameOfBank());


    }
}