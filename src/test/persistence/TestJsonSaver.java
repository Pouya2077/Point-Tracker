package persistence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Restaurant;

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
            fail("Should not have caught exception here!");
        }
    }

    @Test 
    void testWriteGeneralRestaurant() {
        // TODO - finish this test
    }

}
