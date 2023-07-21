package lib;

import java.io.IOException;

public enum UserInput {

    INSTANCE;

    private String userInputName;
    private String userInputIBAN;

    public String getUserInputName() {
        return userInputName;
    }

    public void setUserInputName(String userInputName) throws IOException, NullPointerException  {
        this.userInputName = userInputName;
        try {
            if (this.userInputName.isBlank() == true) {
                throw new IOException("Eingabe ungültig.");
            }
        }
        catch (NullPointerException e){
            throw new NullPointerException("Sie haben nichts eingegeben.");
        }

    }

    public String getUserInputIBAN() {
        return userInputIBAN;
    }

    public void setUserInputIBAN(String userInputIBAN) throws IllegalArgumentException {
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

    }
}
