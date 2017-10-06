
package rocketsimulator;

/**
 *
 * @author Leo Tamminen
 */
public class Planet {
    public final String name;
    public final double atmosphereHeight;
    
    private final double mass;
    private final double surfaceHeight; 
    
    private static final double GRAV_CONSTANT = 6.673e-11;

    public static final Planet EARTH = new Planet ("Earth", 10_000_000.0, 5.972e24, 6.378e6);
    public static final Planet MOON = new Planet ("Moon", 0.0, 7.348e22, 1.7382e3);
    
    private Planet (String name, double atmosphere, double mass, double surfaceHeight)
    {
        this.name = name;
        this.atmosphereHeight = atmosphere;
        this.mass = mass;
        this.surfaceHeight = surfaceHeight;
    }
    
    public double getGravity (double altitude, double objectMass)
    {
        altitude += surfaceHeight;
        return GRAV_CONSTANT * (this.mass * objectMass) / (altitude * altitude);
    }
    
    @Override
    public String toString ()
    {
        return name;
    }

}
