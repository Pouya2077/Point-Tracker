package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

// tests for the Cart class
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
    void testAddMultipleFood() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<Food> cart = testCart.getCart();
        ArrayList<String> foodNames = testCart.getFoodNames();
        assertEquals(2, cart.size());
        assertEquals(2, foodNames.size());
    }

    @Test
    void testRemoveOneFood() {
        testCart.addFood(f1);
        ArrayList<Food> cart = testCart.getCart();
        ArrayList<String> foodNames = testCart.getFoodNames();
        assertEquals(1, cart.size());
        assertEquals(1, foodNames.size());

        testCart.removeFood(f1);
        foodNames = testCart.getFoodNames();
        assertEquals(0, cart.size());
        assertEquals(0, foodNames.size());
    }

    @Test
    void testRemoveMultipleFood() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<Food> cart = testCart.getCart();
        ArrayList<String> foodNames = testCart.getFoodNames();
        assertEquals(2, cart.size());
        assertEquals(2, foodNames.size());

        testCart.removeFood(f1);
        testCart.removeFood(f2);
        foodNames = testCart.getFoodNames();
        assertEquals(0, cart.size());
        assertEquals(0, foodNames.size());

    }

    @Test
    void testRemoveNothingFromCart() {
        testCart.addFood(f1);
        testCart.removeFood(f2);
        ArrayList<Food> cart = testCart.getCart();
        ArrayList<String> foodNames = testCart.getFoodNames();
        assertEquals(1, cart.size());
        assertEquals(1, foodNames.size());

    }

    @Test
    void testRemoveFromEmptyList() {
        testCart.removeFood(f1);
        ArrayList<Food> cart = testCart.getCart();
        ArrayList<String> foodNames = testCart.getFoodNames();
        assertTrue(cart.isEmpty());
        assertTrue(foodNames.isEmpty());
    }

    @Test
    void testCalculateTotalPoints() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        assertEquals(6, testCart.totalPoints());
    }

    @Test
    void testCalculateTotalCost() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        assertEquals(4.8, testCart.totalMoney());
    }

    @Test
    void testCanPurchaseNoneWithPoints() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<String> canPurhcase = testCart.canPurchaseList(0);
        assertEquals(0, canPurhcase.size());
    }

    @Test
    void testCanPurchaseOneWithPoints() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<String> canPurhcase = testCart.canPurchaseList(10);
        assertEquals(1, canPurhcase.size());
    }

    @Test
    void testCanPurhcaseMultipleWithPoints() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<String> canPurchase = testCart.canPurchaseList(14);
        assertEquals(2, canPurchase.size());

    }

    @Test
    void testCanPurchaseWithDuplicate() {
        testCart.addFood(f1);
        testCart.addFood(f1);
        ArrayList<String> canPurchase = testCart.canPurchaseList(14);
        assertEquals(1, canPurchase.size());
    }

    @Test
    void testPurchaseOneWithPoints() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<Food> cart = testCart.getCart();
        assertEquals(2, cart.size());
        int checkPoints = testCart.purchaseWithPoints(10);
        assertEquals(0, checkPoints);
        assertEquals(2, cart.size());

    }

    @Test
    void testPurchaseMultipleWithPoints() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<Food> cart = testCart.getCart();
        assertEquals(2, cart.size());
        int checkPoints = testCart.purchaseWithPoints(23);
        assertEquals(1, checkPoints);
        assertEquals(2, cart.size());
    }

    @Test
    void testPurchaseNoneWithPoints() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<Food> cart = testCart.getCart();
        assertEquals(2, cart.size());
        int checkPoints = testCart.purchaseWithPoints(5);
        assertEquals(5, checkPoints);
        assertEquals(2, cart.size());
    }

    @Test
    void testPurchaseWhenNoneInCartPoints() {
        ArrayList<Food> cart = testCart.getCart();
        assertEquals(0, cart.size());
        int checkPoints = testCart.purchaseWithPoints(30);
        assertEquals(30, checkPoints);
        assertEquals(0, cart.size());
    }

    @Test
    void testPurchaseOneWithMoney() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<Food> cart = testCart.getCart();
        assertEquals(2, cart.size());
        int checkPoints = testCart.purchaseWithMoney(2.3);
        assertEquals(2, checkPoints);
        assertEquals(2, cart.size());

    }

    @Test
    void testPurchaseMultipleWithMoney() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<Food> cart = testCart.getCart();
        assertEquals(2, cart.size());
        int checkPoints = testCart.purchaseWithMoney(4.8);
        assertEquals(6, checkPoints);
        assertEquals(2, cart.size());

    }

    @Test
    void testPurchaseNoneWithMoney() {
        testCart.addFood(f1);
        testCart.addFood(f2);
        ArrayList<Food> cart = testCart.getCart();
        assertEquals(2, cart.size());
        int checkPoints = testCart.purchaseWithMoney(1.2);
        assertEquals(0, checkPoints);
        assertEquals(2, cart.size());
    }

    @Test
    void testPurchaseWhenNoneInCartMoney() {
        ArrayList<Food> cart = testCart.getCart();
        assertEquals(0, cart.size());
        int checkPoints = testCart.purchaseWithMoney(5.2);
        assertEquals(0, checkPoints);
        assertEquals(0, cart.size());
    }

}
