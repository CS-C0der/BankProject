package lib;

import java.util.ArrayList;

public class Utility {

    private Utility() {

    };

    static public boolean checkIfNotUsed (String first, String second) {
        if (first == second) {
            return false;
        }
        return true;
    }

    static public boolean checkIfNotUsed (String first, ArrayList<Bank> bank_) {

        System.out.println(bank_);

        for (int i = 0; i < bank_.size(); i++) {

            String second = bank_.get(i).nameDerBank;

            if (first == second) {
                return false;
            }
        }
        return true;
    }
}
