import lib.Bank;
import lib.Utility;
import lib.FilialeDerBank;
import java.util.ArrayList;

public class Controller {

    public static void main(String[] args) {

        ArrayList <Bank> Datenbank = new ArrayList<>();

        String eingehenderString = "Volksbank";

        Bank Sparkasse = new Bank("Sparkasse");
        Datenbank.add(Sparkasse);

        if (Utility.checkIfNotUsed(eingehenderString, Datenbank)) {
            Bank Volksbank = new Bank(eingehenderString);
            Datenbank.add(Volksbank);
        }

        System.out.println("Namen unserer Banken: ");
        System.out.println(Datenbank.get(0).nameDerBank);
        System.out.println(Datenbank.get(1).nameDerBank);


        FilialeDerBank filialeAmPlatz = new FilialeDerBank("Platzfiliale", Sparkasse);

        System.out.println("Namen unserer Filialen: ");
        System.out.println(filialeAmPlatz.getNameDerFiliale());
        System.out.println(filialeAmPlatz.getNameDerBank());


    }
}