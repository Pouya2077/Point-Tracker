package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import model.Restaurant;
import model.ApplicationState;
import model.Cart;

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
    void testReadRestaurantZeroPointsEmptyCart() {
        JsonLoader loader = new JsonLoader(
                "./data/testReadRestaurantZeroPointsEmptyCart.json");

        try {
            ApplicationState readState = loader.read();
            Restaurant readRestaurant = readState.getRestaurant();
            Cart readCart = readState.getCart();
            assertEquals("Tim Horton's", readRestaurant.getName());
            assertEquals(0, readRestaurant.getUserPoints());
            assertEquals(0, readCart.getCart().size());

        } catch (IOException e) {
            fail("Should not reach here - the file does exist and should be read!");
        }

    }

    @Test
    void testReadGeneralApplicationState() {
        JsonLoader loader = new JsonLoader(
                "./data/testReadGeneralApplicationState.json");

        try {
            ApplicationState readState = loader.read();
            Restaurant readRestaurant = readState.getRestaurant();
            Cart readCart = readState.getCart();

            assertEquals(10, readRestaurant.getUserPoints());
            assertEquals("Tim Horton's", readRestaurant.getName());
            assertEquals(3, readCart.getCart().size());

        } catch (IOException e) {
            fail("Should not reach here - the file does exist and should be read!");
        }

    }

}
