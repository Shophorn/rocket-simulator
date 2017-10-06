/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocketsimulator;

/**
 *
 * @author Leo
 */
public class Simulator {


    
    private double fuelTankCapacity = 0.0;
    private double enginePower = 0.0;
    
//    private Rocket rocket = new Rocket(engine, hull, fuelTank);
    
    private Planet planet = Planet.EARTH;
    
    public void setPlanet (Planet value)
    {
        planet = value;
    }

    
    public void setFuelConsumption(double consumption){
//        rocket.setEngineConsumption(consumption);
    }
    

    public String launch() {

        Engine engine = new Engine(enginePower);
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
                launchResult = "Rocket ran out of fuel";
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
        launchResult += String.format("\nRocket reached the altitude of: %f\nTime elapsed: %d",rocket.getAltitude(),time);
        
        return launchResult;
        
    }
    
    public void setRocketStat(RocketStat type, double value) {
        switch (type) {
            case FUELTANK_CAPACITY:
                fuelTankCapacity = value;
                break;
            case ENGINE_POWER:
                enginePower = value;
                break;
        }
    }
    
    
}
