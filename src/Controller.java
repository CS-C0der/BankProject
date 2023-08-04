import lib.*;

import java.io.IOException;

public class Controller {

    public static void main(String[] args) throws Exception {

        Database database = new Database();
        UserInterface.INSTANCE.run(database);

    }
}