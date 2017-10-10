/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocketsimulator;

/**
 *
 * @author Samu Tikkanen and Leo Tamminen
 */
public class FuelTank extends Part{
    private double amount;
    private final double capacity;
    private final double fuelDensity = 0.8; // kg / dm3, density of Kerosene, can be made configurable
    private final double ownWeight;
    
    public FuelTank(double capacity) {
        this.amount = capacity;
        this.capacity = capacity;
        this.ownWeight = this.amount*0.02;
    }

    
    
    public double getAmount() {
        return amount;
    }
    
    @Deprecated
    public double getCapacity() {
        return capacity;
    }

    @Override
    public double getWeight() {
        return ownWeight + amount * fuelDensity;
    }
    
    
    
    
    
    public double useFuel(double usage) {
        if (amount < usage) {
            double percent = amount/usage;
            amount = 0;
            return percent;
        } else {
            amount -= usage;
            return 1;
        }
    }
}
