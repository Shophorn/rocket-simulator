
package rocketsimulator;


public class Planet {
    public final String name;
    public final double atmosphere;
    public final double gravity;
    
    /**
     * No public constructors available, use static instances instead, eg. Planet.EARTH
     * 
     * @deprecated
     */
    @Deprecated
    public Planet() {
        name = "no name";
        atmosphere = 0.0;
        gravity = 0.0;
    }
    
    /**
     * No public constructors available, use static instances instead, eg. Planet.EARTH
     * @param atmosphereLimit
     * @param name
     * @deprecated
     */
    @Deprecated
    public Planet(double atmosphereLimit, String name) {
        this.atmosphere= atmosphereLimit;
        this.name = name;
        gravity = 0.0;
    }

    public static final Planet EARTH = new Planet ("Earth", 10_000_000, 9.81);
    
    private Planet (String name, double atmosphere, double gravity)
    {
        this.name = name;
        this.atmosphere = atmosphere;
        this.gravity = gravity;
    }
    

    
    
    /**
     * Planet is now immutable
     * @param atmosphereLimit
     * @deprecated
     */
    @Deprecated
    public void setAtmosphereLimit(double atmosphereLimit) {
    }
    /**
     * Planet is now immutable
     * @param name
     * @deprecated
     */
    @Deprecated
    public void setName(String name) {
    }
    
    /**
     * Use atmosphere instead
     * @return
     * @deprecated
     */
    @Deprecated
    public double getAtmosphereLimit() {
        return atmosphere;
    }
    
    @Override
    public String toString ()
    {
        return name;
    }

}
