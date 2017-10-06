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
    private Hull hull;
    
    private int height;
    private double speed;


    public Rocket(double fuelAmount, Engine engine, Hull hull) {
        this.speed = 100;
        this.height = 0;
        this.fuelAmount = fuelAmount;
        this.engine = engine;
        this.hull = hull;
    }

    public Rocket() {
        this(0, new Engine(), new Hull());
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
    
    public Hull getHull() {
        return hull;
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
    
    public void getEngineConsumption() {
        this.engine.getConsumption();
    }
    
    
    public double currentWeight() {
        return this.engine.getWeight()+this.hull.getWeight()+this.getFuelAmount();
    }
    
    public void chooseEngine(int i) {
        this.engine.chooseMotor(i);
    }
    
    //tarkistaa "rungon kestävyyden", nopee netistä luin et 90%bensaa ja oliko noin4% painosta
    //muuta kuin itse kiinteää rakettia niin edel oleval taval vois tarkistaa räjähtääkö
    //se raketti sen takia ettei rungko oo tarpeeks tukeva
    public boolean hullFailure() {
        if (this.hull.getWeight() < this.currentWeight()/20) {
            return true;
        } else {
            return false;
        }
    }
    
    public String go(Planet planet) {
        String info = new String();
        this.height = 0;
        double fuel = this.fuelAmount;
        while(fuel > 0) {
            fuel = this.engine.go(fuel);
            this.height += this.speed;
            if (this.height>planet.getAtmosphereLimit()) {
                info = "Rocket has succesfully escaped the atmosphere of earth!\n";
                break;
            }
            info = "Rocket is out of fuel\nRocket was "+this.height/1000+"km high when running out of fuel\n";
            
        }
        return info;
    }
    
    
    
    
    
}
