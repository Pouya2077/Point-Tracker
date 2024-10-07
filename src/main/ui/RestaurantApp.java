package ui;

import java.util.Scanner;

// Represents the ui used for the application, 
// can take in user input and respond to it
public class RestaurantApp {
    private boolean canRun;
    private String currentCommand;
    private Scanner userInput;

    // EFFECTS: runs the Restaurant app
    //          and initializes fields
    public RestaurantApp() {
        canRun = true;
        currentCommand = null;
        userInput = new Scanner(System.in);
        userInput.useDelimiter("\r?\n|\r");
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
        if (currentCommand.equals("m")) {
            displayMenu();
        } else if (currentCommand.equals("p")) {
            displayCurrentPoints();
        } else if (currentCommand.equals("a")) {
            addItem();
        } else if (currentCommand.equals("r")) {
            removeItem();
        } else if (currentCommand.equals("v")) {
            viewCart();
        } else if (currentCommand.equals("tp")) {
            cartTotalPoints();
        } else if (currentCommand.equals("tm")) {
            cartTotalPrice();
        } else if (currentCommand.equals("cp")) {
            cartPurchasables();
        } else if (currentCommand.equals("bp")) {
            buyWithPoints();
        } else if (currentCommand.equals("bm")) {
            buyWithMoney();
        } else {
            System.out.println("That input is invalid, try again...");
        }
    }

    private void buyWithMoney() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buyWithMoney'");
    }

    private void buyWithPoints() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buyWithPoints'");
    }

    private void cartPurchasables() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cartPurchasables'");
    }

    private void cartTotalPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cartTotalPrice'");
    }

    private void cartTotalPoints() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cartTotalPoints'");
    }

    private void viewCart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewCart'");
    }

    private void removeItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItem'");
    }

    private void addItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }

    private void displayCurrentPoints() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayCurrentPoints'");
    }

    private void displayMenu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayMenu'");
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

    // EFFECTS: prints a simple line in the terminal
    private void line() {
        System.out.println("-----------------------------------");
    }

}
