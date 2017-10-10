
package rocketsimulator;

/**
 *
 * @author Leo Tamminen
 */
public class Planet {
    public final String name;

    private final double mass;
    private final double radius; 
    
    private static final double GRAV_CONSTANT = 6.673e-11;

    
    public static final Planet EARTH = new Planet ("Earth", 5.972e24, 6.378e6);
    public static final Planet MOON = new Planet ("Moon", 7.348e22, 1.7382e6);
    public static final Planet MARS = new Planet ("Mars", 6.420e23, 3.397e6);
    
    public static final String [] planetNames = { EARTH.name, MOON.name, MARS.name };

    
    private Planet (String name, double mass, double radius)
    {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }
    
    public double getDrag (double altitude, double objectMass)
    {
        double totalHeight = altitude + radius;
        return GRAV_CONSTANT * (this.mass * objectMass) / (totalHeight * totalHeight);
    }
    
    public double getEscapeVelocity (double altitude)
    {
        return Math.sqrt((2 * GRAV_CONSTANT * mass) / altitude + radius);
    }
    
    @Override
    public String toString ()
    {
        return name;
    }

}
