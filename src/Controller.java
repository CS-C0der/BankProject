import lib.Bank;

import java.util.ArrayList;

public class Controller {


    public static void main(String[] args) {

        ArrayList <Bank> Datenbank = new ArrayList<>();


        Bank Sparkasse = new Bank("Sparkasse");
        Datenbank.add(Sparkasse);

        Bank Volksbank = new Bank("Volksbank");
        Datenbank.add(Volksbank);

        System.out.println(Sparkasse.nameDerBank);
        System.out.println(Datenbank.get(0).nameDerBank);
        System.out.println(Datenbank.get(1).nameDerBank);
    }
}