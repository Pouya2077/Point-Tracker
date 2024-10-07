package ui;

import java.util.Scanner;

// Represents the ui used for the application, 
// can take in user input and respond to it
public class RestaurantApp {
    private boolean canRun;
    private String currentCommand;
    private Scanner userInput;

    // EFFECTS: runs the Restaurant app
    public RestaurantApp() {
        runApp();
    }

    // EFFECTS: responsible for taking user input
    //          and running the display of the application
    private void runApp() {
        canRun = true;
        currentCommand = null;
        userInput = new Scanner(System.in);
        userInput.useDelimiter("\r?\n|\r");

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
    // EFFECTS: gets the next command that user 
    //          specifies
    private void nextLine() {
        currentCommand = userInput.next();
        currentCommand = currentCommand.toLowerCase();

    }

    // EFFECTS: displays an opening message and
    //          shows commands user can input
    private void welcomeScreen() {
        System.out.println("Welcome to Tim Horton's!");
        line();
        System.out.println("Please choose one of the following...");
        line();
        System.out.println("m = Menu");
        System.out.println("p = Points I currently have");
        System.out.println("a = Add an item to my cart");
        System.out.println("r = Remove an item from my cart");
        System.out.println("v = View items in my cart");
        System.out.println("tp = Total points my cart is worth");
        System.out.println("tm = Total price items in my cart are worth");
        System.out.println("cp = Items in my cart purchasable with my current points");
        System.out.println("bp = Buy items in my cart with my current points");
        System.out.println("bm = Buy items in my cart with money");
    }

    private void line() {
        System.out.println("-----------------------------------");
    }

}
