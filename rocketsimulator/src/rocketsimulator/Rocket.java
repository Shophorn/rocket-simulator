/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocketsimulator;

/**
 *
 * @author Samu Tikkanen, Leo Tamminen
 */
public class Rocket {
    private double fuelAmount;
    private Engine engine;
    private Hull hull;
    
    // private int height;
    // private double speed;

    // MOVEMENT
    private double altitude = 0;
    private double speed = 0;
    
    private RocketEndStatus endStatus;
    public RocketEndStatus getEndStatus () { return endStatus; }
    
    public Rocket(double fuelAmount, Engine engine, Hull hull) {
        this.fuelAmount = fuelAmount;
        this.engine = engine;
        this.hull = hull;
    }

    public Rocket() {
        this(0, new Engine(), new Hull());
    }
    
    public double getAltitude() {
        return altitude;
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
    
    

    public void setFuelAmmount(double value) {
        this.fuelAmount = value;
        System.out.println("test succesfull");
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
    
    
    public double getMass() {
        return this.engine.getWeight()+this.hull.getWeight()+this.getFuelAmount();
    }
    
    public void chooseEngine(double i) {
        this.engine.chooseMotor(i);
    }
    
    //tarkistaa "rungon kestävyyden", nopee netistä luin et 90%bensaa ja oliko noin4% painosta
    //muuta kuin itse kiinteää rakettia niin edel oleval taval vois tarkistaa räjähtääkö
    //se raketti sen takia ettei rungko oo tarpeeks tukeva
    public boolean hullFailure() {
        if (this.hull.getWeight() < this.getMass()/20) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean go(Planet planet)
    {
        speed += (engine.getThrust() + planet.getGravity(altitude, getMass())) / getMass();
        boolean goingUp = speed > 0.0;
        if (goingUp) {
            altitude += speed;
        }
        return goingUp;
    }
    
    
//    public String go(Planet planet, boolean badstuff) {
//        String info = new String();
//        this.height = 0;
//        double fuel = this.fuelAmount;
//        while(fuel > 0) {
//            fuel = this.engine.go(fuel);
//            this.height += this.speed;
//            if (this.height>planet.atmosphereHeight) {
//                info = "Rocket has succesfully escaped the atmosphere of "+planet.name+"!";
//                break;
//            }
//            info = "Rocket is out of fuel\nRocket was "+this.height/1000+"km high when running out of fuel\n";
//            
//        }
//        return info;
//    }
    
    
    
    
    
}
