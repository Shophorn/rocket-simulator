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

    private double getCombinedWeight() {
        double weight = 0.0;
        for (Part part : parts)
        {
            weight += part.getWeight();
        }
        return weight;
    }
  
    
    /*
    //tarkistaa "rungon kestävyyden", nopee netistä luin et 90%bensaa ja oliko noin4% painosta
    //muuta kuin itse kiinteää rakettia niin edel oleval taval vois tarkistaa räjähtääkö
    //se raketti sen takia ettei rungko oo tarpeeks tukeva
    public boolean hullFailure() {
        return hull.getWeight() < calculateCombinedWeight() /20;
    }
    */
    
    private double getFuelAmount()
    {
        return fuelTank.getAmount();
    }
    
    private String flightLog = "";
    public String getFlightLog () { return flightLog; }
    private int time = 0;
    private boolean outOfFuel = false;
    private int outOfFuelTime;
    public int getOutOfFuelTime () { return outOfFuelTime; }
    public boolean go(Planet planet)
    {
        // Check if fuel left
        // Check if velocity higher than escapeVelocity
        double fuelUsePercent = fuelTank.useFuel(engine.getConsumption());
        if (fuelUsePercent == 0 && !outOfFuel) {
            outOfFuelTime = time;
            outOfFuel = true;
        }
        
        double weight = getCombinedWeight();
        System.out.println(weight);
        double thrust = engine.getThrust() * fuelUsePercent;
        
        double drag = planet.getDrag(altitude, weight);
        
        double acceleration = (thrust - drag) / weight;
        speed += acceleration;
        
        double escapeSpeed = planet.getEscapeVelocity(altitude);
        boolean escaped = speed >= escapeSpeed;
        boolean goingUp = speed > 0.0;
        
        boolean done = escaped || !goingUp;
        
        // LOG STUFF
        flightLog += String.format("t:%-5d thrust:%-10.2f drag:%-10.2f accel:%-10.2f speed:%-10.2f fuel:%-10.2f altitude:%-10.2f\r\n",
                time,
                thrust,
                drag,
                acceleration,
                speed,
                fuelTank.getAmount(),
                altitude
        );
        time++;
        
        if (!done) {
            altitude += speed;
        } else {
            if (escaped) {
                endStatus = RocketEndStatus.ESCAPED_ORBIT;
            } else if (altitude <= 0.0) {
                endStatus = RocketEndStatus.FAILED_TO_TAKEOFF;
            } else if (fuelTank.getAmount() <= 0.0){
                endStatus = RocketEndStatus.OUT_OF_FUEL;
            } else {
                endStatus = RocketEndStatus.GENERIC_MISHAP;
            }
        }
        return !done;
    } 
}
