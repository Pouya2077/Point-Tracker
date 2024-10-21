package persistence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Restaurant;
import ui.RestaurantApp;
import model.ApplicationState;
import model.Cart;

// tests for JsonSaver class
public class TestJsonSaver {

    @Test
    void testWriteToInvalidLocation() {
        try {
            JsonSaver saver = new JsonSaver("./data/invali:\0dName.json");
            saver.open();
            fail("Should not reach here - exception should have been thrown!");
        } catch (FileNotFoundException e) {
            // Expected exception to be thrown here
        }

    }

    @Test
    void testWriteZeroPointsEmptyCart() {
        Restaurant restaurant = new Restaurant();
        Cart cart = new Cart();
        ApplicationState state = new ApplicationState(restaurant, cart);
        JsonSaver saver = new JsonSaver("./data/testWriteZeroPointsEmptyCart.json");

        try {
            saver.open();
            saver.write(state);
            saver.close();

            JsonLoader loader = new JsonLoader("./data/testWriteZeroPointsEmptyCart.json");
            ApplicationState readState = loader.read();
            Restaurant readRestaurant = readState.getRestaurant();
            Cart readCart = readState.getCart();

            assertEquals(RestaurantApp.FOOD1, readRestaurant.getMenuItems().get(0));
            assertEquals(RestaurantApp.FOOD2, readRestaurant.getMenuItems().get(1));
            assertEquals(RestaurantApp.FOOD3, readRestaurant.getMenuItems().get(2));
            assertEquals(RestaurantApp.FOOD4, readRestaurant.getMenuItems().get(3));
            assertEquals(4, readRestaurant.getMenuItems().size());

            assertEquals(0, readRestaurant.getUserPoints());
            assertEquals("Tim Horton's", readRestaurant.getName());
            assertEquals(0, readCart.getCart().size());

        } catch (IOException e) {
            fail("Should not have caught exception here - excecution should be fine!");
        }
    }

    @Test
    void testWriteGeneralApplicationState() {
        Restaurant restaurant = new Restaurant();
        Cart cart = new Cart();
        JsonSaver saver = new JsonSaver("./data/testWriteGeneralApplicationState.json");
        restaurant.addPoints(15);
        cart.addFood(RestaurantApp.FOOD1);
        cart.addFood(RestaurantApp.FOOD3);
        ApplicationState state = new ApplicationState(restaurant, cart);

        try {
            saver.open();
            saver.write(state);
            saver.close();

            JsonLoader loader = new JsonLoader("./data/testWriteGeneralApplicationState.json");
            ApplicationState readState = loader.read();
            Restaurant readRestaurant = readState.getRestaurant();
            Cart readCart = readState.getCart();

            assertEquals(15, readRestaurant.getUserPoints());
            assertEquals("Tim Horton's", readRestaurant.getName());

            assertEquals(2, readCart.getCart().size());

        } catch (IOException e) {
            fail("Should not have caught exception here - excecution should be fine!");
        }

    }

}
