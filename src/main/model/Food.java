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
    // an appropriate name, price in money,
    // price in user points, and how many
    // points it is worth when bought with money
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + costInPoints;
        long temp;
        temp = Double.doubleToLongBits(costInMoney);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + pointsWorth;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Food other = (Food) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (costInPoints != other.costInPoints)
            return false;
        if (Double.doubleToLongBits(costInMoney) != Double.doubleToLongBits(other.costInMoney))
            return false;
        if (pointsWorth != other.pointsWorth)
            return false;
        return true;
    }

    
}
