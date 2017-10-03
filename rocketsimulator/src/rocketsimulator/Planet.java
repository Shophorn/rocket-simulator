
package rocketsimulator;


public class Planet {
    private double atmosphereLimit;
    private String name;

    public Planet() {
        this.atmosphereLimit = 10000000;
        this.name = "Earth";
    }

    public Planet(double atmosphereLimit, String name) {
        this.atmosphereLimit = atmosphereLimit;
        this.name = name;
    }

    public void setAtmosphereLimit(double atmosphereLimit) {
        this.atmosphereLimit = atmosphereLimit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAtmosphereLimit() {
        return atmosphereLimit;
    }

    public String getName() {
        return name;
    }
    
    
    
    
    
}
