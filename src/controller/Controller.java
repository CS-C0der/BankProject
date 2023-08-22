package controller;

import data.Database;
import view.UserInterface;

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