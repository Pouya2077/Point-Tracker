package persistence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

import model.Restaurant;
import model.Food;

// tests for JsonSaver class
public class TestJsonSaver {

    @Test 
    void testWriteToInvalidLocation() {
        try {
            JsonSaver saver = new JsonSaver("./data/invalidName.json");
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

        } catch(IOException e) {
            fail("Should not have caught exception here - excecution should be fine!");
        }
    }

    @Test 
    void testWriteGeneralRestaurant() {
        Restaurant restaurant = new Restaurant();
        JsonSaver saver = new JsonSaver("./data/testWriteGeneralRestaurant.json");
        restaurant.setUserPoints(15);

        try {
            Food f1 = new Food("Ice Capp", 10, 3.5, 5);
            Food f2 = new Food("Coffee", 8, 2.5, 4);
            Food f3 = new Food("Bagel", 5, 3, 2);
            Food f4 = new Food("Tim Bits", 12, 5.5, 6);

            saver.open();
            saver.write(restaurant);
            saver.close();

            JsonLoader loader = new JsonLoader("./data/testWriteGeneralRestaurant.json");
            Restaurant readRestaurant = loader.read();

            assertEquals(15, readRestaurant.getUserPoints());
            assertEquals("Tim Horton's", readRestaurant.getName());

           ArrayList<Food> menu = readRestaurant.getMenuItems();

           assertEquals(f1, menu.get(0));
           assertEquals(f2, menu.get(1));
           assertEquals(f3, menu.get(2));
           assertEquals(f4, menu.get(3));
           assertEquals(4, menu.size());

        } catch (IOException e) {
            fail("Should not have caught exception here - excecution should be fine!");
        }
        

    }

}
