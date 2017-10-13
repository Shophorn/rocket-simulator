package rocketsimulator;

public class Engine extends Part 
{
    // https://en.wikipedia.org/wiki/Thrust_specific_fuel_consumption
    // tsfc here is totally not anything close to proper values, but it works here, so we're using it.
    private final static double TSFC = 0.01; // 0.250; // kg /(kN*s), ie. how many kg of propellant is needed to create 1kN thrust for one second
    private final static double THRUST_TO_WEIGHT = 100;
    private final double thrust; // kN
    private final double weight;
    private final double consumption;
    
    
    public Engine (double thrust)
    {
        this.thrust = thrust;
        
        consumption = thrust * TSFC;
        weight = thrust / THRUST_TO_WEIGHT;
    }

    public double getThrust()
    {
        // TSFC ongelma on ehkä getThrustissa, kun muutetaan mittakaavaa
        // convert kN to N
        return thrust * 1_000;
    }
    
    public double getConsumption()
    {
        return consumption;
    }
    
    @Override
    public double getWeight()
    {
        return weight;
    }
}
