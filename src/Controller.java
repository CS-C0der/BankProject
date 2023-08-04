import lib.*;

import java.io.IOException;

public class Controller {

    public static void main(String[] args) throws Exception {

        boolean running = true;
        Database database = new Database();
        do {
            running = UserInterface.INSTANCE.run(database);
        }
        while (running);

    }
}