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
    private Part [] parts;
    
    // MOVEMENT
    private double altitude = 0;
    private double speed = 0.0;
    
    private RocketEndStatus endStatus;
    public RocketEndStatus getEndStatus () { return endStatus; }
    
    public Rocket(Engine engine, Hull hull, FuelTank fuelTank) {
        this.engine = engine;
        this.hull = hull;
        this.fuelTank = fuelTank;
        
        parts = new Part [] {engine, hull, fuelTank };
    }
    
    public double getAltitude() {
        return altitude;
    }

    public void setEngineConsumption(double consumption) {
        this.engine.setConsumption(consumption);
    }
    
    private double getCombinedWeight() {
        double weight = 0.0;
        for (Part part : parts)
        {
            weight += part.getWeight();
        }
        return weight;
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
    
    private double getFuelAmount()
    {
        return fuelTank.getAmount();
    }
    
    double gravityEscapeLimit = 0.1;
    public boolean go(Planet planet)
    {
        double weight = getCombinedWeight ();
        double fuelUsage = fuelTank.useFuel(engine.getConsumption());
        double thrustForce = engine.getThrust() * fuelUsage;
        double gravity = planet.getGravity(altitude, weight);
        double acceleration = (thrustForce - gravity) / weight; 
        
        Program.sendMessage(String.valueOf(weight));

        speed += acceleration;
         
        boolean goingUp = speed > 0.0;
        boolean outOfOrbit = gravity <= gravityEscapeLimit;

        if (goingUp && !outOfOrbit) {
            altitude += speed;
        } else {
            if (outOfOrbit){
                endStatus = RocketEndStatus.ESCAPED_ORBIT;
            }else if (altitude < 1) {
                endStatus = RocketEndStatus.FAILED_TO_TAKEOFF;
            } else if (getFuelAmount() <= 0) {
                endStatus = RocketEndStatus.OUT_OF_FUEL;
            } else {
                endStatus = RocketEndStatus.GENERIC_MISHAP;
            }
        }
        return goingUp;
    } 
}
