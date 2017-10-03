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
    
    
    
    public String go(Planet planet) {
        String info = new String();
        double fuel = this.fuelAmount;
        while(fuel > 0) {
            fuel = this.engine.go(fuel);
            this.height += this.speed;
            System.out.println("test2");
            if (this.height>planet.getAtmosphereLimit()) {
                info = "Rocket has succesfully escaped the gravity of earth!\n";
                break;
            }
            info = "Rocket is out of fuel\nRocket was "+this.height/1000+"km high when running out of fuel\n";
            
        }
        this.height = 0;
        return info;
    }
    
    
    
    
    
}
