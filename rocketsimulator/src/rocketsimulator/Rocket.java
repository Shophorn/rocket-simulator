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
    // PARTS
    private Engine engine;
    private Hull hull;
    private FuelTank fuelTank;

    // MOVEMENT
    private double altitude = 0;
    private double speed = 0;
    
    private RocketEndStatus endStatus;
    public RocketEndStatus getEndStatus () { return endStatus; }
    
    public Rocket() {
        engine = new Engine ();
        hull = new Hull ();
        fuelTank = new FuelTank ();
    }
    
    public double getAltitude() {
        return altitude;
    }
    
    public void setFuelAmmount(double value) {
        this.fuelAmount = value;
    }


    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    
    
    
    
    public void setEngineConsumption(double consumption) {
        this.engine.setConsumption(consumption);
    }
    
    private double getCombinedWeight() {
        return engine.getWeight() + hull.getWeight() + fuelTank.getWeight();
    }
    
    public void chooseEngine(double i) {
        this.engine.chooseMotor(i);
    }
    
    //tarkistaa "rungon kestävyyden", nopee netistä luin et 90%bensaa ja oliko noin4% painosta
    //muuta kuin itse kiinteää rakettia niin edel oleval taval vois tarkistaa räjähtääkö
    //se raketti sen takia ettei rungko oo tarpeeks tukeva
    public boolean hullFailure() {
        return hull.getWeight() < getCombinedWeight() /20;
    }
    
    public boolean go(Planet planet)
    {
        double weight = getCombinedWeight ();
        double fuelUsage = fuelTank.useFuel(engine.getConsumption());
        double thrustForce = engine.getThrust() * fuelUsage;
        double gravity = planet.getGravity(altitude, weight);
        double acceleration = (thrustForce - gravity) / weight; 
        
        speed += acceleration;
        
        boolean goingUp = speed > 0.0;
        if (goingUp) {
            altitude += speed;
        }
        return goingUp;
    } 
}
