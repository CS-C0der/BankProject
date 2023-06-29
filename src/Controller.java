import lib.Bank;
import lib.Utility;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Controller {

    public static void main(String[] args) {

        ArrayList <Bank> Datenbank = new ArrayList<>();

        String eingehenderString = "Testbank";

        Bank Sparkasse = new Bank("Sparkasse");
        Datenbank.add(Sparkasse);

        if (Utility.checkIfNotUsed(eingehenderString, Datenbank)) {
            Bank Volksbank = new Bank(eingehenderString);
            Datenbank.add(Volksbank);
        }


        System.out.println(Datenbank.get(0).nameDerBank);
        System.out.println(Datenbank.get(1).nameDerBank);


    }
}