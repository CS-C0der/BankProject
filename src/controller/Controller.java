package controller;

import data.Database;
import view.UserInterface;

public class Controller {

    // Initialises Database and runs UserInterface's "run" method until program is exited by passing the return value "false"
    public static void main(String[] args) throws Exception {

        boolean running = true;
        Database database = new Database();
        do {
            running = UserInterface.INSTANCE.run(database);
        }
        while (running);

    }
}