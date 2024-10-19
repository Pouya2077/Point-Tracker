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
    private Food f1;
    private Food f2;
    private Food f3;
    private Food f4;

    // MODIFIES: this
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
        f1 = new Food("Ice Capp", 10, 3.5, 5);
        f2 = new Food("Coffee", 8, 2.5, 4);
        f3 = new Food("Bagel", 5, 3, 2);
        f4 = new Food("Tim Bits", 12, 5.5, 6);

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

    // EFFECTS: takes the command and runs the appropriate
    // command for it
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
        } else if (currentCommand.equals("pur")) {
            cartPurchasables();
        } else if (currentCommand.equals("bp")) {
            buyWithPoints();
        } else if (currentCommand.equals("bm")) {
            buyWithMoney();
        } else if (currentCommand.equals("s")) {
            saveApplication();
        } else if (currentCommand.equals("l")) {
            loadApplication();
        } else {
            System.out.println("That input is invalid, try again...");
        }
    }

    // EFFECTS: loads a previous saved state of the application, 
    // this includes the previous restaurant and cart
    private void loadApplication() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadApplication'");
    }

    // EFFECTS: saves the current state of the application, 
    // this includes the current restaurant and cart 
    private void saveApplication() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveApplication'");
    }

    // MODIFIES: Restaurant
    // EFFECTS: purchases items in cart with the money the user
    // gives and adds points of restaurant to how many
    // points they accumulated from their purchases
    private void buyWithMoney() {
        System.out.println("How much money would you like to spend?");
        double userMoney = userInput.nextDouble();

        int pointsEarned = cart.purchaseWithMoney(userMoney);
        timmies.setUserPoints(pointsEarned);
        System.out.println("You earned " + pointsEarned + " points!");

    }

    // MODIFIES: Restaurant
    // EFFECTS: purchases items in cart with user's points and
    // sets how many points they have left at the restaurant
    private void buyWithPoints() {
        int pointsLeft = cart.purchaseWithPoints(timmies.getUserPoints());
        timmies.setUserPoints(pointsLeft);
        System.out.println("\nYou have " + pointsLeft + " points left.\n");
    }

    // EFFECTS: displays the items in the cart the user can purchase
    // with their current points
    private void cartPurchasables() {
        ArrayList<String> list = cart.canPurchaseList(timmies.getUserPoints());
        ArrayList<String> inCart = cart.getFoodNames();
        if (inCart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else if (timmies.getUserPoints() == 0) {
            System.out.println("You have 0 points.");
        } else if (list.isEmpty()) {
            System.out.println("You cannot purchase anything.");
        } else {
            System.out.println("\n You can purchase:");
            for (String s : list) {
                System.out.println("\n " + s);
            }

        }
    }

    // EFFECTS: displays total price items in the cart are worth
    private void cartTotalPrice() {
        double worth = cart.totalMoney();
        System.out.println("\n All items in your cart are worth " + "$" + worth + " \n");
    }

    // EFFECTS: displays total points items in the cart are costs
    private void cartTotalPoints() {
        int worth = cart.totalPoints();
        System.out.println("\nAll items in your cart are worth " + worth + " points.\n");
    }

    // EFFECTS: displays items currently in the cart
    private void viewCart() {
        ArrayList<Food> list = this.cart.getCart();
        if (cart.getCart().isEmpty()) {
            System.out.println("You have nothing in your cart.");
        } else {
            System.out.println("The items in your cart are:\n");
            for (Food f : list) {
                System.out.println(f.getName() + "\n");

            }

        }
    }

    // MODIFIES: Cart
    // EFFECTS: asks the user what item they want to remove
    // from the cart and then removes it
    private void removeItem() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("ice capp");
        list.add("tim bits");
        list.add("coffee");
        list.add("bagel");
        System.out.println("Which menu item would you like to remove?");
        nextLine();
        while (!list.contains(currentCommand)) {
            System.out.println("We do not carry that item, please try again.");
            nextLine();
        }

        if (cart.getCart().isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            removeAppropriate(currentCommand);

        }
    }

    // MODIFIES: Cart
    // EFFECTS: removes the item the user wants from the cart
    private void removeAppropriate(String item) {
        if (item.equals("ice capp")) {
            cart.removeFood(f1);
            System.out.println("\nRemoved " + item + ".\n");
        } else if (item.equals("coffee")) {
            cart.removeFood(f2);
            System.out.println("\nRemoved " + item + ".\n");
        } else if (item.equals("bagel")) {
            cart.removeFood(f3);
            System.out.println("\nRemoved " + item + ".\n");
        } else if (item.equals("tim bits")) {
            cart.removeFood(f4);
            System.out.println("\nRemoved " + item + ".\n");
        }
    }

    // MODIFIES: Cart
    // EFFECTS: asks for the item the user wants to add to their cart
    // and adds the item to their cart
    private void addItem() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("ice capp");
        list.add("tim bits");
        list.add("coffee");
        list.add("bagel");
        System.out.println("Which menu item would you like to add?");
        nextLine();
        while (!list.contains(currentCommand)) {
            System.out.println("We do not carry that item, please try again.");
            nextLine();
        }

        addAppropriate(currentCommand);
        System.out.println("\nAdded " + currentCommand + "!\n");
    }

    // MODIFIES: Cart
    // EFFECTS: adds the item the user wants to their cart
    private void addAppropriate(String item) {
        if (item.equals("ice capp")) {
            cart.addFood(f1);
        } else if (item.equals("coffee")) {
            cart.addFood(f2);
        } else if (item.equals("bagel")) {
            cart.addFood(f3);
        } else if (item.equals("tim bits")) {
            cart.addFood(f4);
        }
    }

    // EFFECTS: displays the points the user has
    private void displayCurrentPoints() {
        System.out.println("You have " + timmies.getUserPoints() + " points.");
    }

    // EFFECTS: displays all menu items at the restaurant
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

    // MODIFIES: Scanner
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
        System.out.println("pur = Items in my cart purchasable with my current points");
        System.out.println("a/r = Add an item to my cart/remove an item from my cart");
        System.out.println("tp/tm = Total points/total price items in my cart are worth");
        System.out.println("bp/bm = Buy items in my cart with points/money");
        System.out.println("s = Save currents state");
        System.out.println("Load previous state");
    }

    // EFFECTS: prints a simple line in the terminal
    private void line() {
        System.out.println("-----------------------------------");
    }

}
