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
    /**
     * set in Constructor
     * @param thrust
     * @deprecated
     */
    @Deprecated
    public void setThrust(double thrust) {
        this.thrust = thrust;
    }
    
    //runkoa valintapohjaiselle moottorille, esim liukuri jossa 10 eri moottoria
    //jotka paranee lineaarisesti tai mitä sliderille keksiikään tehdä. Voi toteuttaa
    //vaikka switchinäkin mutta tällä toteutuksella ei tavallaan väliä sillä millaiset
    //rajat laittaa.
    @Deprecated
    public void chooseMotor(double number) {
        this.weight = 10+1.5*number;
        this.thrust = 2000+400*number;

    }
    
    @Deprecated
    public void setConsumption(double consumption) {
       
    }
    
    @Deprecated
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return ("weight: "+this.getWeight()+ ", thrust: "+this.getThrust());
    }
}
