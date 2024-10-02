package model;

import java.util.ArrayList;

// Represents a cart class with a list
// of food items put in the cart by 
// the user and has operations to run
// on cart items
public class Cart {

    // MODIFIES: this
    // EFFECTS:  initializes a Cart with an 
    //           empty list of food items
    public Cart() {
        // stub
    }

    // EFFECTS: returns the ArrayList of Food that 
    //          is in the cart
    public ArrayList<Food> getCart() {
        return new ArrayList<Food>(); // stub
    }

    // MODIFIES: this
    // EFFECTS:  adds the food given by the 
    //           user to the back of the cart
    public void addFood(Food food) {
        // stub
    }

    // MODIFIES: this 
    // EFFECTS:  removes the food specified by 
    //           the user from the cart
    public void removeFood(Food food) {
        // stub
    }

    // EFFECTS: prints a list of the names of 
    //          each food item in the cart
    public ArrayList<String> foodNames() {
        return new ArrayList<String>(); // stub
    }

    // EFFECTS: returns the total points everything
    //          in your cart is worth
    public int totalPoints() {
        return 0; // stub
    }

    // EFFECTS: returns the total price everything
    //          in your cart is worth
    public double totalMoney() {
        return 0; //stub
    }

    // EFFECTS: prints a list of the names of 
    //          each food item user can purchase
    //          with their current points
    public ArrayList<String> canPurchaseList(int userPoints) {
        return new ArrayList<String>(); // stub
    }

    // EFFECTS:  purchases items in your cart with the 
    //           points the user specifies, returns the 
    //           points the user has left
    public int purchaseWithPoints(int userPoints){ 
        return 0; // stub
    }

    // EFFECTS: purchases items in your cart with the 
    //          money the user specifies, returns the 
    //          amount of points the user earned
    public int purchaseWithMoney(double userMoney){
        return 0; // stub
    }
}
