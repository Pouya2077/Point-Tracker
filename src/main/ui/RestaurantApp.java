package ui;

import java.util.Scanner;
import java.util.ArrayList;

import model.Restaurant;
import model.Food;
import model.Cart;

// Represents the ui used for the application, 
// can take in user input and respond to it, 
// will hold the user cart and the restaurant 
// they are using
public class RestaurantApp {
    private boolean canRun;
    private String currentCommand;
    private Scanner userInput;
    private Restaurant timmies;
    private Cart cart;
    private ArrayList<Food> menu;

    // EFFECTS: runs the Restaurant app
    // and initializes fields
    public RestaurantApp() {
        canRun = true;
        currentCommand = null;
        userInput = new Scanner(System.in);
        userInput.useDelimiter("\r?\n|\r");
        timmies = new Restaurant();
        cart = new Cart();
        menu = timmies.getMenuItems();
        runApp();
    }

    // EFFECTS: responsible for taking user input
    // and running the display of the application
    private void runApp() {
        while (canRun) {
            welcomeScreen();
            nextLine();

            if (currentCommand.equals("q")) {
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

    // EFFECTS: displays items in the cart currently
    private void viewCart() {
        ArrayList<Food> list = this.cart.getCart();
        if (cart.getCart().isEmpty()) {
            System.out.println("You have nothing in your cart.");
        } else {
            System.out.println("The items in your cart are:\n");
            for (Food f: list) {
                System.out.println(f.getName() + "\n");
    
            }

        }
    }

    private void removeItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItem'");
    }

    private void addItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }

    // EFFECTS: displays the points the user has
    private void displayCurrentPoints() {
        System.out.println("You have " + timmies.getUserPoints() + " points.");
    }

    // EFFECTS: displays all menu items in the terminal
    private void displayMenu() {
        line();
        System.out.println("We offer the following menu items...");
        line();
        for (Food f : menu) {
            System.out.println(f.getName() + " for "
                    + f.getCostInMoney() + " dollars or "
                    + f.getCostInPoints() + " points \n");
        }
    }

    // MODIFIES: this
    // EFFECTS: gets the next command that user
    // specifies
    private void nextLine() {
        currentCommand = userInput.next();
        currentCommand = currentCommand.toLowerCase();

    }

    // EFFECTS: displays an opening message and
    // shows commands user can input
    private void welcomeScreen() {
        line();
        System.out.println("Welcome to Tim Horton's!");
        line();
        System.out.println("Please choose one of the following...");
        line();
        System.out.println("m = Menu");
        System.out.println("q = Quit");
        System.out.println("p = Points I currently have");
        System.out.println("v = View items in my cart");
        System.out.println("cp = Items in my cart purchasable with my current points");
        System.out.println("a/r = Add an item to my cart/remove an item from my cart");
        System.out.println("tp/tm = Total points/total price items in my cart are worth");
        System.out.println("bp/bm = Buy items in my cart with points/money");
    }

    // EFFECTS: prints a simple line in the terminal
    private void line() {
        System.out.println("-----------------------------------");
    }

}
