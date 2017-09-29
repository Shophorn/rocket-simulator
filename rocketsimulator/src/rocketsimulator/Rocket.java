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
public class Rocket {
    private double fuelAmmount;
    private Engine engine;
    
    private int height;
    private double speed;


    public Rocket(double fuelAmmount, Engine engine) {
        this.speed = 100;
        this.height = 0;
        this.fuelAmmount = fuelAmmount;
        this.engine = engine;
    }

    public Rocket() {
        this.speed = 100;
        this.height = 0;
        this.fuelAmmount = 0;
        this.engine = new Engine();
    }
    
    

    public double getHeight() {
        return height;
    }

    public double getFuelAmmount() {
        return fuelAmmount;
    }

    public double getSpeed() {
        return speed;
    }

    public Engine getEngine() {
        return engine;
    }
    
    

    public void setFuelAmmount(double fuelAmmount) {
        this.fuelAmmount = fuelAmmount;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    
    public void setEngineConsumption(double consumption) {
        this.engine.setConsumption(consumption);
    }
    
    public String go() {
        while(this.fuelAmmount > 0) {
            this.fuelAmmount = this.engine.go(this.getFuelAmmount());
            this.height += this.speed;
            
        }
        return "Out of fuel";
    }
    
    
    
    
    
}
