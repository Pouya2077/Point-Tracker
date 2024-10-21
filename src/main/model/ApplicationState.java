package model;

import org.json.JSONObject;

// Represents the current state of the application
// by holding the restaurant and cart
public class ApplicationState {
    private Restaurant restaurant;
    private Cart cart;

    public ApplicationState(Restaurant restaurant, Cart cart) {
        this.restaurant = restaurant;
        this.cart = cart;

    }

    public Restaurant getRestaurant() {
        return this.restaurant;

    }

    public Cart getCart() {
        return this.cart;

    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    // EFFECTS: creates a JSONObject that holds the restaurant
    // and cart of the application
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        JSONObject restJson = this.restaurant.toJson();
        json.put("restaurant", restJson);

        JSONObject cartJson = this.cart.toJson();
        json.put("cart", cartJson);

        return json;
    }

}
