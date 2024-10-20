package persistence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

import model.Restaurant;
import ui.RestaurantApp;
import model.Food;

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
    void testWriteZeroPoints() {
        Restaurant restaurant = new Restaurant();
        JsonSaver saver = new JsonSaver("./data/testWriteZeroPoints.json");

        try {
            saver.open();
            saver.write(restaurant);
            saver.close();

            JsonLoader loader = new JsonLoader("./data/testWriteZeroPoints.json");
            Restaurant readRestaurant = loader.read();

            assertEquals(0, readRestaurant.getUserPoints());
            assertEquals("Tim Horton's", readRestaurant.getName());

        } catch (IOException e) {
            fail("Should not have caught exception here - excecution should be fine!");
        }
    }

    @Test
    void testWriteGeneralRestaurant() {
        Restaurant restaurant = new Restaurant();
        JsonSaver saver = new JsonSaver("./data/testWriteGeneralRestaurant.json");
        restaurant.setUserPoints(15);

        try {
            saver.open();
            saver.write(restaurant);
            saver.close();

            JsonLoader loader = new JsonLoader("./data/testWriteGeneralRestaurant.json");
            Restaurant readRestaurant = loader.read();

            assertEquals(15, readRestaurant.getUserPoints());
            assertEquals("Tim Horton's", readRestaurant.getName());

            ArrayList<Food> menu = readRestaurant.getMenuItems();

            assertEquals(RestaurantApp.FOOD1, menu.get(0));
            assertEquals(RestaurantApp.FOOD2, menu.get(1));
            assertEquals(RestaurantApp.FOOD3, menu.get(2));
            assertEquals(RestaurantApp.FOOD4, menu.get(3));
            assertEquals(4, menu.size());

        } catch (IOException e) {
            fail("Should not have caught exception here - excecution should be fine!");
        }

    }

}
