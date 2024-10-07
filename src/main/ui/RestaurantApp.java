package ui;

import java.util.Scanner;

// Represents the ui used for the application, 
// can take in user input and respond to it
public class RestaurantApp {
    private boolean canRun = true;
    private String currentCommand = null;
    private Scanner userInput;

    // EFFECTS: runs the Restaurant app
    public RestaurantApp() {
        runApp();
    }

    // EFFECTS: responsible for taking user input
    //          and running the display of the application
    private void runApp() {

        while (canRun) {
            welcomeScreen();
            nextLine();

            if (currentCommand.equals("Quit")) { 
                canRun = false;
            } else {
                processCommand(currentCommand);
            }

        }

        System.out.println("Thank You For Using Our App!");

    }

    private void processCommand(String currentCommand) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS; finds the next command that user 
    //          specifies
    private String nextLine() {
        currentCommand = userInput.next();
        currentCommand.toLowerCase();
        return currentCommand;

    }

    // EFFECTS: displays an opening message and
    //          shows commands user can input
    private void welcomeScreen() {
        // stub
    }

}
