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

    // MODIFIES: Cart, Restaurant
    // EFFECTS: purchases items in cart with the money the user
    // gives and sets points of restaurant to how many
    // points they accumulated from their purchases
    private void buyWithMoney() {
        // stub
    }

    // MODIFIES: Cart, Restaurant
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
        for (String s : list) {
            System.out.println("\n You can purchase:");
            System.out.println("\n " + s + "\n");
        }
    }

    // EFFECTS: displays total price items in the cart are worth
    private void cartTotalPrice() {
        double worth = cart.totalMoney();
        System.out.println("\n All items in your cart are worth " + worth + " $\n");
    }

    // EFFECTS: displays total points items in the cart are worth
    private void cartTotalPoints() {
        int worth = cart.totalPoints();
        System.out.println("\nAll items in your cart are worth " + worth + " points.\n");
    }

    // EFFECTS: displays items in the cart currently
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

    private void removeItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItem'");
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
            cart.addFood(new Food("Ice Capp", 10, 3.5, 5));
        } else if (item.equals("coffee")) {
            cart.addFood(new Food("Coffee", 8, 2.5, 4));
        } else if (item.equals("bagel")) {
            cart.addFood(new Food("Bagel", 5, 3, 2));
        } else if (item.equals("tim bits")) {
            cart.addFood(new Food("Tim Bits", 12, 5.5, 6));
        }
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
