package util;

import model.BankInstitution;

import java.util.LinkedList;

/**
 * Contains static functions for general use
 */
public class Utility {

    /**
     * The private constructor prohibits any objects of this class from being built
     */
    private Utility() {};

    static private int min = 0;
    static private int max = 9;
    static private int randomInt;

    /**
     * Generates a random number with 20 digits and adds each digit incrementally to the "DE" in front, so a German IBAN is created
     *
     * @return - passes the generated IBAN as String
     */
    static private String generateRandomIBAN () {

        String randomIBAN = "DE";
        for (int i = 0; i < 20; i++) {
           randomInt = (int)Math.floor(Math.random() * (max - min + 1) + min);
           randomIBAN = randomIBAN.concat(String.valueOf(randomInt));
        }
        return randomIBAN;
    }

    /**
     * Passes the privately generated IBAN to the outside. This serves data encapsulation
     *
     * @return - passes the IBAN String
     */
    static public String getRandomIBAN() {
        return generateRandomIBAN();
    }

}
