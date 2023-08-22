package util;

import model.BankInstitution;

import java.util.LinkedList;

public class Utility {

    private Utility() {};

    static private int min = 0;
    static private int max = 9;
    static private int randomInt;

    static private String generateRandomIBAN () {

        String randomIBAN = "DE";
        for (int i = 0; i < 20; i++) {
           randomInt = (int)Math.floor(Math.random() * (max - min + 1) + min);
           randomIBAN = randomIBAN.concat(String.valueOf(randomInt));
        }
        return randomIBAN;
    }

    static public String getRandomIBAN() {
        return generateRandomIBAN();
    }

    static public boolean checkIfNotUsed (String first, LinkedList<BankInstitution> bank_Institution_) {

        for (int i = 0; i < bank_Institution_.size(); i++) {

            String second = bank_Institution_.get(i).getNameOfBank();

            if (first == second) {
                return false;
            }
        }
        return true;
    }
}
