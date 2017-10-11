package rocketsimulator;

/**
 *
 * @author Leo Tamminen
 */
public class Planet
{
    public final String name;
    private final double mass;
    private final double radius; 
    
    private static final double GRAVITATIONAL_CONSTANT = 6.673e-11;
    
    public static final Planet EARTH = new Planet ("Earth", 5.972e24, 6.378e6);
    public static final Planet MOON = new Planet ("Moon", 7.348e22, 1.7382e6);
    public static final Planet MARS = new Planet ("Mars", 6.420e23, 3.397e6);
    
    public static final String [] PLANET_NAMES = { EARTH.name, MOON.name, MARS.name };
    private static final Planet [] PLANETS = {
        new Planet ("Earth", 5.972e24, 6.378e6),
        new Planet ("Moon", 7.348e22, 1.7382e6),
        new Planet ("Mars", 6.420e23, 3.397e6)
    };
    
    public static final Planet getPlanet (String planetName)
    {
        Planet planet = null;
        for (int i = 0; i < PLANETS.length; i++)
        {
            if (planetName.equals(PLANETS[i].name))
            {
                planet = PLANETS[i];
                break;
            }
        }
        return planet;
    }
    
    private Planet (String name, double mass, double radius)
    {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }
    
    public double getDrag (double altitude, double objectMass)
    {
        double totalHeight = altitude + radius;
        return GRAVITATIONAL_CONSTANT * (this.mass * objectMass) / (totalHeight * totalHeight);
    }
    
    public double getEscapeVelocity (double altitude)
    {
        return Math.sqrt((2 * GRAVITATIONAL_CONSTANT * mass) / altitude + radius);
    }
    
    @Override
    public String toString ()
    {
        return name;
    }

}
