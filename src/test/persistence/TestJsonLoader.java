package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import model.Restaurant;

// tests for JsonLoader class
public class TestJsonLoader {

    @Test
    void testNoSuchFileExisting() {
        JsonLoader loader = new JsonLoader("./data/noFile.json");

        try {
            loader.read();
            fail("Should not reach here - no such file exists!");
        } catch (IOException e) {
            // Expected to catch this exception
        }

    }

    @Test
    void testReadRestaurantZeroPoints() {
        JsonLoader loader = new JsonLoader(
                "./data/testReadRestaurantZeroPoints.json");

        try {
            Restaurant restaurant = loader.read();
            assertEquals("Tim Horton's", restaurant.getName());
            assertEquals(0, restaurant.getUserPoints());
        } catch (IOException e) {
            fail("Should not reach here - the file does exist and should be read!");
        }

    }

    @Test
    void testReadRestaurantTenPoints() {
        JsonLoader loader = new JsonLoader(
                "./data/testReadRestaurantTenPoints.json");

        try {
            Restaurant restaurant = loader.read();
            assertEquals(10, restaurant.getUserPoints());
            assertEquals("Tim Horton's", restaurant.getName());
        } catch (IOException e) {
            fail("Should not reach here - the file does exist and should be read!");
        }

    }

}
