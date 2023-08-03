package lib;

import java.util.ArrayList;

public class Utility {

    private Utility() {};

    static public boolean checkIfNotUsed (String first, ArrayList<BankInstitution> bank_Institution_) {

        for (int i = 0; i < bank_Institution_.size(); i++) {

            String second = bank_Institution_.get(i).getNameOfBank();

            if (first == second) {
                return false;
            }
        }
        return true;
    }
}
