package model;

// Represents a menu item at the restaurant
// with a cost in points, a cost in money,
// a name, and how many points it is worth 
// when bought with money
public class Food {
    private String name;
    private int costInPoints;
    private double costInMoney;
    private int pointsWorth;

    // MODIFIES: this
    // EFFECTS: initializes a menu item with
    //          an appropriate name, price in money,
    //          price in user points, and how many
    //          points it is worth when
    //          bought with money
    public Food(String name, int pointsToBuy, double money, int pointsWorth) {
        this.name = name;
        this.costInPoints = pointsToBuy;
        this.costInMoney = money;
        this.pointsWorth = pointsWorth;
    }

    public String getName() {
        return this.name;
    }

    public int getCostInPoints() {
        return this.costInPoints; 
    }

    public double getCostInMoney() {
        return this.costInMoney;
    }

    public int getPointsWorth() {
        return this.pointsWorth;
    }
}
