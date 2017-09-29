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
    private double weight;

    public Engine(double thrust, double weight) {
        this.thrust = thrust;
        this.weight = weight;
    }

    public double getThrust() {
        return thrust;
    }

    public double getWeight() {
        return weight;
    }

    public void setThrust(double thrust) {
        this.thrust = thrust;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return ("weight: "+this.getWeight()+ ", thrust: "+this.getThrust());
    }
    
    
}
