package model;

import java.util.ArrayList;

// Represents a cart class with a list
// of food items put in the cart by the user 
public class Cart {
    private ArrayList<Food> cart;

    // MODIFIES: this
    // EFFECTS: initializes a Cart with an
    // empty list of food items
    public Cart() {
        this.cart = new ArrayList<Food>();
    }

    // EFFECTS: returns the ArrayList of Food that
    // is in the cart
    public ArrayList<Food> getCart() {
        return this.cart;
    }

    // MODIFIES: this
    // EFFECTS: adds the food given by the
    // user to the back of the cart
    public void addFood(Food food) {
        cart.add(food);
    }

    // MODIFIES: this
    // EFFECTS: removes the food specified by
    // the user from the cart
    public void removeFood(Food food) {
        cart.remove(food);
    }

    // EFFECTS: prints a list of the names of
    // each food item in the cart
    public ArrayList<String> getFoodNames() {
        ArrayList<String> acc = new ArrayList<String>();
        for (Food f : cart) {
            acc.add(f.getName());
        }
        return acc;
    }

    // EFFECTS: returns the total points everything
    // in your cart is worth
    public int totalPoints() {
        int acc = 0;
        for (Food f : cart) {
            acc += f.getPointsWorth();
        }
        return acc;
    }

    // EFFECTS: returns the total price everything
    // in your cart is worth
    public double totalMoney() {
        double acc = 0;
        for (Food f : cart) {
            acc += f.getCostInMoney();
        }
        return acc;
    }

    // EFFECTS: prints a list of the names of
    // each food item user can purchase
    // with their current points
    public ArrayList<String> canPurchaseList(int userPoints) {
        ArrayList<String> canPurchase = new ArrayList<String>();
        for (Food f : cart) {
            if (f.getCostInPoints() <= userPoints
                    && !canPurchase.contains(f.getName())) {
                canPurchase.add(f.getName());
            }
        }
        return canPurchase;
    }

    // MODIFIES: this
    // EFFECTS: purchases items in your cart with the
    // points the user has starting from the first, 
    // removes what has been purchased and returns
    // the points the user has left
    public int purchaseWithPoints(int userPoints) {
        while(userPoints > 0 && !cart.isEmpty()) {
            Food first = cart.get(0);
            if (first.getCostInPoints() > userPoints) {
                break;
            } else {
                int subBy = first.getCostInPoints();
                userPoints -= subBy;
                cart.remove(0);

            }
        }
        return userPoints;

    }

    // MODIFIES: this
    // EFFECTS: purchases items in your cart with the
    // money the user specifies starting from the first, 
    // removes what has has been purchased and returns
    // the amount of points the user has earned
    public int purchaseWithMoney(double userMoney) {
        return 0; // stub
    }
}
