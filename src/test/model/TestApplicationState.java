package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Restaurant;
import model.Cart;
import model.ApplicationState;

// test for ApplicationState class
public class TestApplicationState {
    private ApplicationState testState;
    private Restaurant testRest;
    private Cart testCart;

    @BeforeEach
    void setUp() {
        testRest = new Restaurant();
        testCart = new Cart();
        testState = new ApplicationState(testRest, testCart);
    }

    @Test
    void testConstructor() {
        assertEquals(testRest, testState.getRestaurant());
        assertEquals(testCart, testState.getCart());

        testState.setCart(new Cart());
        testState.setRestaurant(new Restaurant());

        assertFalse(testState.getCart().equals(testCart));
        assertFalse(testState.getRestaurant().equals(testRest));

    }

}
