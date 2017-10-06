
package rocketsimulator;


public class Planet {
    public final String name;
    public final double atmosphere;
    public final double gravity;

    public static final Planet EARTH = new Planet ("Earth", 10_000_000, 9.81);
    
    private Planet (String name, double atmosphere, double gravity)
    {
        this.name = name;
        this.atmosphere = atmosphere;
        this.gravity = gravity;
    }

    @Override
    public String toString ()
    {
        return name;
    }

}
