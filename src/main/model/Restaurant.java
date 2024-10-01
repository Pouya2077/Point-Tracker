package model;

import java.util.ArrayList;

// Represents a fast food restaurant with a name
// list of menu items, the points the user has
// at the restaurant, and a cart with their menu items
public class Restaurant {

    // EFFECTS: initializes the restaurant with a name
    //          zero user points, list of menu items, 
    //          and an empty cart
    public Restaurant() {
        // stub
    }

    public String getName() {
        return ""; //stub
    }

    public ArrayList<Food> getMenuItems() {
        return new ArrayList<Food>(); // stub
    }

    public int getUserPoints() {
        return 0; //stub
    }

    public Cart getCart() {
        return new Cart();
    }

    public void setUserPoints() {
        // stub
    }


}
