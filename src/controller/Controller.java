package controller;

import data.Database;
import view.UserInterface;

public class Controller {

    /**
     * Launches the application.
     * Initialises Database first.
     * Runs UserInterface's "run" method until program is exited by passing the return value "false"
     *
     * @param args - Application startup arguments
     * @throws Exception - passes exception handlings thrown in the run method
     */
    public static void main(String[] args) throws Exception {

        boolean running = true;
        Database database = new Database();
        do {
            running = UserInterface.INSTANCE.run(database);
        }
        while (running);
    }
}