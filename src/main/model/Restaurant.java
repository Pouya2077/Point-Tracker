package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import ui.RestaurantApp;

// Represents a fast food restaurant with a name,
// list of menu items, the points the user has
// at the restaurant
public class Restaurant {
    private String name;
    private ArrayList<Food> menu;
    private int userPoints;

    // MODIFIES: this
    // EFFECTS: initializes the restaurant with a name
    // zero user points, list of menu items,
    // and an empty cart
    public Restaurant() {
        this.name = "Tim Horton's";
        this.menu = new ArrayList<Food>();
        this.menu.add(RestaurantApp.FOOD1);
        this.menu.add(RestaurantApp.FOOD2);
        this.menu.add(RestaurantApp.FOOD3);
        this.menu.add(RestaurantApp.FOOD4);
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

    public void addPoints(int points) {
        this.userPoints += points;
    }

    public void setPoints(int points) {
        this.userPoints = points;
    }

    // EFFECTS: returns the restaurant as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("userPoints", this.userPoints);

        JSONArray jsonArray = new JSONArray();

        for (Food f : menu) {
            JSONObject foodJson = new JSONObject();

            foodJson.put("name", f.getName());
            foodJson.put("pointsToBuy", f.getCostInPoints());
            foodJson.put("money", f.getCostInMoney());
            foodJson.put("pointsWorth", f.getPointsWorth());

            jsonArray.put(foodJson);

        }

        json.put("menu", jsonArray);

        return json;

    }

}
