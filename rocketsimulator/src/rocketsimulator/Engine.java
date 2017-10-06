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
public class Engine extends Part {
    private double thrust;
    private double consumption;
    private double weight;
    //kaikki arvot tonneissa, thrust tuhatta newtonia
    /*
    public Engine(double thrust, double consumption, double weight) {
        this.thrust = thrust;
        this.consumption = consumption;
        this.weight = weight;
    }

    public Engine() {
        this(0,0,0);
    }
    */
    public Engine (double power)
    {
        // JOTAI TÄLLASTA EHKÄ
        thrust = power;
        consumption = power * 0.2;
        weight = power * 0.2;
    }
    
    public double getThrust() {
        // DO CALCULATIONS HERE https://www.grc.nasa.gov/www/k-12/airplane/rockth.html
        return thrust;
    }

    public double getConsumption() {
        return consumption;
    }
    
    @Override
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
    public void chooseMotor(double number) {
        this.weight = 10+1.5*number;
        this.thrust = 2000+400*number;
        this.consumption = 0.002+0.0004*number;
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
}
