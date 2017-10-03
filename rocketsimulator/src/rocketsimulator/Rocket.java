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
    private double fuelAmount;
    private Engine engine;
    
    private int height;
    private double speed;


    public Rocket(double fuelAmount, Engine engine) {
        this.speed = 100;
        this.height = 0;
        this.fuelAmount = fuelAmount;
        this.engine = engine;
    }

    public Rocket() {
        this.speed = 100;
        this.height = 0;
        this.fuelAmount = 0;
        this.engine = new Engine();
    }
    
    

    public double getHeight() {
        return height;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getSpeed() {
        return speed;
    }

    public Engine getEngine() {
        return engine;
    }
    
    

    public void setFuelAmmount(double fuelAmmount) {
        this.fuelAmount = fuelAmmount;
        System.out.println("test succesfull");
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
        String info = new String();
        while(this.fuelAmount > 0) {
            this.fuelAmount = this.engine.go(this.getFuelAmount());
            this.height += this.speed;
            if (this.height>300000000) {
                info = "Rocket has succesfully escaped the gravity of earth!\n";
                break;
            }
            info = "Rocket is out of fuel\n";
        }
        return info;
    }
    
    
    
    
    
}
