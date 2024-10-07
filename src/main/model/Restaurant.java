package model;

import java.util.ArrayList;

// Represents a fast food restaurant with a name,
// list of menu items, the points the user has
// at the restaurant
public class Restaurant {
    private String name;
    private ArrayList<Food> menu;
    private int userPoints;
    

    // MODIFIES: this
    // EFFECTS:  initializes the restaurant with a name
    //           zero user points, list of menu items, 
    //           and an empty cart
    public Restaurant() {
        this.name = "Tim Horton's";
        this.menu = new ArrayList<Food>();
        this.menu.add(new Food("Ice Capp", 10, 3.5, 5));
        this.menu.add(new Food("Coffee", 8, 2.5, 4));
        this.menu.add(new Food("Bagel", 5, 3, 2));
        this.menu.add(new Food("Tim Bits", 12, 5.5, 6));
        this.userPoints = 0;

    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Food> getMenuItems() {
        return this.menu; 
    }

    public int getUserPoints() {
        return this.userPoints; 
    }

    public void setUserPoints(int points) {
        this.userPoints += points;
    }


}
