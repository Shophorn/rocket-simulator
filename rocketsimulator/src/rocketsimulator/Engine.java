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
public class Engine {
    private double thrust;
    private double consumption;
    private double weight;

    public Engine(double thrust, double consumption, double weight) {
        this.thrust = thrust;
        this.consumption = consumption;
        this.weight = weight;
    }

    public Engine() {
        this.thrust = 0;
        this.consumption = 0;
        this.weight = 0;
    }
    

    public double getThrust() {
        return thrust;
    }

    public double getConsumption() {
        return consumption;
    }
    
    public double getWeight() {
        return weight;
    }

    public void setThrust(double thrust) {
        this.thrust = thrust;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return ("weight: "+this.getWeight()+ ", thrust: "+this.getThrust());
    }
    
    public double go(double fuel) {
        return (fuel-this.consumption);
    }
    
    
}
