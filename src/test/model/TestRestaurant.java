package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

// tests for the Restaurant class
public class TestRestaurant {
    private Restaurant testRestaurant;

    @BeforeEach
    void runBefore() {
        testRestaurant = new Restaurant();

    }

    @Test
    void testConstructor() {
        ArrayList<Food> menu = testRestaurant.getMenuItems();
        assertEquals("Tim Horton's", testRestaurant.getName());
        assertEquals(0, testRestaurant.getUserPoints());
        assertEquals(4, menu.size());

        testRestaurant.addPoints(20);
        assertEquals(20, testRestaurant.getUserPoints());

    }

}
