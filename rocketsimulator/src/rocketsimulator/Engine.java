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
    //kaikki arvot tonneissa, thrust tuhatta newtonia
    
    public Engine(double thrust, double consumption, double weight) {
        this.thrust = thrust;
        this.consumption = consumption;
        this.weight = weight;
    }

    public Engine() {
        this(0,0,0);
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
    
    
    //runkoa valintapohjaiselle moottorille, esim liukuri jossa 10 eri moottoria
    //jotka paranee lineaarisesti tai mitä sliderille keksiikään tehdä. Voi toteuttaa
    //vaikka switchinäkin mutta tällä toteutuksella ei tavallaan väliä sillä millaiset
    //rajat laittaa.
    public void chooseMotor(int number) {
        this.weight = 100+15*number;
        this.thrust = 2000+500*number;
        this.consumption = 0.0001+0.000025*number;
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
