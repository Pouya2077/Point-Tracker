package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFood {
    private Food testFood;

    @BeforeEach 
    void runBefore() {
        testFood = new Food("Donut", 10, 2.30, 2);
    }

    @Test 
    void testConstructor() {
        assertEquals("Donut", testFood.getName());
        assertEquals(10, testFood.getCostInPoints());
        assertEquals(2.30, testFood.getCostInMoney());
        assertEquals(2, testFood.getPointsWorth());

    }



}
