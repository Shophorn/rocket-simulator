/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocketsimulator;

/**
 *
 * @author Samu
 */
public class FuelTank {
    private double fuelAmmount;
    private double maxAmmount;
    private double weight;

    public FuelTank(int maxAmmount) {
        this.fuelAmmount = maxAmmount;
        this.maxAmmount = this.fuelAmmount;
        this.weight = this.fuelAmmount*0.02;
    }

    public FuelTank() {
        this(0);
    }

    
    
    public double getFuelAmmount() {
        return fuelAmmount;
    }

    public double getMaxAmmount() {
        return maxAmmount;
    }

    public double getWeight() {
        return weight;
    }
    
    
    
    public void setFuelTankType(double i) {
        this.fuelAmmount = 50+i*50;
        this.maxAmmount = this.fuelAmmount;
        this.weight = i;
    } 
    
    
    public double useFuel(double usage) {
        if (this.fuelAmmount < usage) {
            return fuelAmmount/usage;
        } else {
            return 1;
        }
    }
}
