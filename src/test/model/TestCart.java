package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestCart {
    private Cart testCart;
    private Food f1;
    private Food f2;

    @BeforeEach 
    void runBefore() {
        testCart = new Cart();
        f1 = new Food("Donut", 10, 2.3, 2);
        f2 = new Food("Coffee", 12, 2.5, 4);

    }

    @Test 
    void testConstructor() {
        ArrayList<Food> cart = testCart.getCart();
        assertEquals(0, cart.size());
    }

    @Test 
    void testAddOneFood() {
        testCart.addFood(f1);
        ArrayList<Food> cart = testCart.getCart();
        ArrayList<String> foodNames = testCart.getFoodNames();
        assertEquals(1, cart.size());
        assertEquals(1, foodNames.size());

    }

    @Test 
    void testMultipleFood() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<Food> cart = testCart.getCart();
        ArrayList<String> foodNames = testCart.getFoodNames();
        assertEquals(2, cart.size());
        assertEquals(2, foodNames.size());
    }

    @Test 
    void removeOneFood() {
        testCart.addFood(f1);
        ArrayList<Food> cart = testCart.getCart();
        ArrayList<String> foodNames = testCart.getFoodNames();
        assertEquals(1, cart.size());
        assertEquals(1, foodNames.size());

        testCart.removeFood(f1);
        cart = testCart.getCart();
        foodNames = testCart.getFoodNames();
        assertEquals(0, cart.size());
        assertEquals(0, foodNames.size());
    }

    @Test 
    void removeMultipleFood() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<Food> cart = testCart.getCart();
        ArrayList<String> foodNames = testCart.getFoodNames();
        assertEquals(2, cart.size());
        assertEquals(2, foodNames.size());

        testCart.removeFood(f1);
        testCart.removeFood(f2);
        cart = testCart.getCart();
        foodNames = testCart.getFoodNames();
        assertEquals(0, cart.size());
        assertEquals(0, foodNames.size());


    }

    @Test 
    void removeNothingFromCart() {
        testCart.addFood(f1);
        testCart.removeFood(f2);
        ArrayList<Food> cart = testCart.getCart();
        ArrayList<String> foodNames = testCart.getFoodNames();
        assertEquals(1, cart.size());
        assertEquals(1, foodNames.size());


    }

    @Test 
    void removeFromEmptyList() {
        testCart.removeFood(f1);
        ArrayList<Food> cart = testCart.getCart();
        ArrayList<String> foodNames = testCart.getFoodNames();
        assertTrue(cart.isEmpty());
        assertTrue(foodNames.isEmpty());
    }

}
