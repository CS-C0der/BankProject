package lib;

import java.io.IOException;

public enum UserInterface {

    INSTANCE;

    private String userInputBank;
    private String userInputCustomer;
    private String userInputAccount;
    private String userInputIBAN;

    public String getUserInputBank() {
        return userInputBank;
    }

    public void setUserInputBank(String userInputBank) throws IOException, NullPointerException  {

       try {
            if (userInputBank.isBlank()) {
                throw new IOException("Eingabe ungültig.");
            }
            else this.userInputBank = userInputBank;
        }
        catch (NullPointerException e){
            throw new NullPointerException("Sie haben nichts eingegeben.");
        }
    }

    public String getUserInputCustomer() {
        return userInputCustomer;
    }

    public void setUserInputCustomer(String userInputCustomer) throws IOException, NullPointerException  {

        try {
            if (userInputCustomer.isBlank()) {
                throw new IOException("Eingabe ungültig.");
            }
            else this.userInputCustomer = userInputCustomer;
        }
        catch (NullPointerException e){
            throw new NullPointerException("Sie haben nichts eingegeben.");
        }

    }

    public String getUserInputAccount() {
        return userInputAccount;
    }

    public void setUserInputAccount(String userInputAccount)  throws IOException, NullPointerException  {

        try {
            if (userInputAccount.isBlank()) {
                throw new IOException("Eingabe ungültig.");
            }
            else this.userInputAccount = userInputAccount;
        }
        catch (NullPointerException e){
            throw new NullPointerException("Sie haben nichts eingegeben.");
        }
    }

    public String getUserInputIBAN() {
        return userInputIBAN;
    }

    public void setUserInputIBAN(String userInputIBAN) throws IllegalArgumentException, NullPointerException {
        this.userInputIBAN = userInputIBAN;
        String fehlertext =
                "Allgemeine Regeln:\n" +
                "Ihre IBAN muss mit DE starten.\n" +
                "Ihre IBAN muss 22 Stellen aufweisen.\n" +
                "Bitte geben Sie ab Stelle 3 nur Zahlen ein.\n";

        if  (!userInputIBAN.substring(0,2).equals("DE")) {
            throw new IllegalArgumentException("Aktueller Fehler: Ihre IBAN startet nicht mit 'DE'.\n" + fehlertext);
        }

        if (!(userInputIBAN.length() == 22)) {
            throw new IllegalArgumentException("Aktueller Fehler: Ihre IBAN weist nicht 22 Stellen auf.\n" + fehlertext);
        }

        try {
            Integer.parseInt(userInputIBAN.substring(2));
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("Aktueller Fehler: Ab Stelle 3 dürfen nur Zahlen folgen.\n" + fehlertext);
        }
        catch (NullPointerException e){
            throw new NullPointerException("Sie haben nichts eingegeben.");
        }

    }
}
