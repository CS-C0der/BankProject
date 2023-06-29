package lib;

public class Utility {

    private Utility() {

    };

    static boolean checkIfNotUsed (String first, String second) {
        if (first == second) {
            return false;
        }
        return true;
    }
}
