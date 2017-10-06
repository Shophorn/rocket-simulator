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
public class Hull {
    private double weight;
    private double gargoweight;

    public Hull(double weight, double gargoWeight) {
        this.weight = weight;
        this.gargoweight = gargoWeight;
    }

    public Hull() {
        this(0,0);
    }

    public double getWeight() {
        return weight;
    }

    public double getGargoweight() {
        return gargoweight;
    }

    
    
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setGargoweight(double gargoweight) {
        this.gargoweight = gargoweight;
    }
    
    
}
