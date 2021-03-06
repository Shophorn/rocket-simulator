package rocketsimulator;

public class Planet
{
    public final String name;
    private final double mass;
    private final double radius; 
    
    private static final double GRAVITATIONAL_CONSTANT = 6.673e-11;
    
    private static final Planet [] PLANETS = {
        new Planet ("Earth", 5.972e24, 6.378e6),
        new Planet ("Moon", 7.348e22, 1.7382e6),
        new Planet ("Mars", 6.420e23, 3.397e6),
        new Planet ("Venus", 4.875e24, 6.052e6),
        new Planet ("Mercurius", 3.306e23, 2.439e6),
        new Planet ("Uranus", 8.686e25, 26.320e6),
        new Planet ("Neptune", 1.029e26, 24.300e6),
        new Planet ("Pluto", 1.194e22, 1.150e6),
        new Planet ("XO-2Nb", 0.597e22, 1.019e6)
    };
    
    public static final String [] getPlanetNames ()
    {
        String [] names = new String [PLANETS.length];
        for (int i = 0; i < PLANETS.length; i++)
        {
            names [i] = PLANETS [i].name;
        }
        return names;
    }

    
    public static final Planet getPlanet (String planetName)
    {
        Planet result = null;
        for (Planet planet : PLANETS)
        {
            if (planet.name.equals(planetName)){
                result = planet;
            }
        }
        return result;
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
