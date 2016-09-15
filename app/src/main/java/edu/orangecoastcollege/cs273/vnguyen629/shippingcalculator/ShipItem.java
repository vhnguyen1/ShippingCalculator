package edu.orangecoastcollege.cs273.vnguyen629.shippingcalculator;

/**
 * Calculates the shipping charges of a product in accordance
 * to the total weight (in ounces).
 * @author Vincent Nguyen
 */
public class ShipItem {
    private int mWeight;
    private double mBaseCost;
    private double mAddedCost;
    private double mTotalCost;
    //private static final int BASE_WEIGHT = 16;

    public ShipItem()
    {
        this.mWeight = 0;
        this.mBaseCost = 3.00;
        this.mAddedCost = 0.00;
        this.mTotalCost = 0.00;
    }

    public double getWeight() {
        return this.mWeight;
    }

    public double getBaseCost() {
        return this.mBaseCost;
    }

    public double getAddedCost() {
        return this.mAddedCost;
    }

    public double getTotalCost() {
        return this.mTotalCost;
    }

    public void setWeight(int newWeight) {
        this.mWeight = newWeight;
        this.mTotalCost = this.mBaseCost;

        if (this.mWeight > 16) {
            //this.mAddedCost = ((this.mWeight - BASE_WEIGHT) / 4.00) * 0.50;
            this.mAddedCost = ((this.mWeight - 16) / 4.00) * 0.50;

            if (this.mWeight % 4 != 0)
                this.mAddedCost += 0.50;

            this.mTotalCost += this.mAddedCost;
        }
    }
}
