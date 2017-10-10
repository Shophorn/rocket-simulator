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
public class Engine extends Part 
{
    // one more time from scratch
    // thrust on se mitä säädetään
    // jos tätä haluu säätää, ni se olis sit tyliin engineQuality, tms.
    // https://en.wikipedia.org/wiki/Thrust_specific_fuel_consumption#Typical_values_of_SFC_for_thrust_engines
    private final double tsfc = 0.250; // kg /(kN*s), eli kuinka monta kilogrammaa löpöä menee kun tuotetaan sekunniksi kN työntöä, riippuu moottorin muotoilusta
    private double thrust; 
    private double weight;

    public Engine (double thrust)
    {
        this.thrust = thrust;
    }

    public double getThrust()
    {
        // convert kN to N
        return thrust * 1_000;
    }
    
    public double getConsumption()
    {
        return thrust * tsfc;
    }
    
    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return ("weight: "+this.getWeight()+ ", thrust: "+this.getThrust());
    }
}
