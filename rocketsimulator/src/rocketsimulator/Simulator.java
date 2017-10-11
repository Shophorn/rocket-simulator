package rocketsimulator;

public class Simulator {
    // ROCKET SPECS
    private double fuelTankCapacity = 0.0;
    private double engineThrust = 0.0;
       
    // PLANET FOR TAKEOFF
    private Planet planet = Planet.EARTH;
    
    public void setPlanet (String planetName)
    {
        Planet temp = Planet.getPlanet(planetName);
        planet = temp != null ? temp : planet;
        System.out.println (temp + "   " + planet);
        /*
        switch(planetName){
            case "Earth":
                planet = Planet.EARTH;
                break;
            case "Moon":
                planet = Planet.MOON;
                break;
            case "Mars":
                planet = Planet.MARS;
                break;
            default:
                System.out.println("Hmm");
        }
        System.out.println(planetName);
*/
    }

    
    public void setFuelConsumption(double consumption){
//        rocket.setEngineConsumption(consumption);
    }
    

    public String launch() {

        Engine engine = new Engine(engineThrust);
        Hull hull = new Hull();
        FuelTank fuelTank = new FuelTank(fuelTankCapacity);
        
        Rocket rocket = new Rocket(engine, hull, fuelTank);
        
        // SAMPO SIIRSIN NÄMÄ TÄNNE
        int time = 0;
        String launchResult = "No result yet.";
        
        boolean go = true;
        while(go) {       
            go = rocket.go(planet);
            time++;
        }
        
        
        switch(rocket.getEndStatus()){
            case OUT_OF_FUEL:
                launchResult = String.format ("Rocket ran out of fuel at: %d s", rocket.getOutOfFuelTime());
                break;
            case FAILED_TO_TAKEOFF:
                // Pitäiskö tollanen due to juttu?
                launchResult = "Rocket failed to take off";// due to: ";
                break;
            case ESCAPED_ORBIT:
                launchResult = "Rocket has escaped the orbit! Congratulation! ";
                break;
            case GENERIC_MISHAP:
                
                launchResult = "An unexpected error occured";
            default:
                
        }
        launchResult += String.format(
                "\nRocket reached the altitude of: %.2f km\nTime elapsed: %d s",
                rocket.getAltitude() / 1_000, // convert to km
                time
        );
        
        if (openLog) {
            Program.saveTextFile(rocket.getFlightLog());
        }
        
        return launchResult;
        
    }
    
    private boolean openLog = false;
    public void toggleOpenLog()
    {
        openLog = !openLog;
    }
    public boolean getOpenLog()
    {
        return openLog;
    }
    
    public void setRocketStat(RocketStat type, double value) {
        switch (type) {
            case FUELTANK_CAPACITY:
                fuelTankCapacity = value;
                break;
            case ENGINE_POWER:
                engineThrust = value;
                break;
        }
    }
    
    
}
