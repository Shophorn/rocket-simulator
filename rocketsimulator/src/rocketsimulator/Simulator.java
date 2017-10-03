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
    
    private Rocket rocket = new Rocket();
    
    public void setFuelAmmount(double fuel){
        rocket.setFuelAmmount(fuel);
    }
    
    public void setFuelConsumption(double consumption){
        rocket.setEngineConsumption(consumption);
    }
    
    public void simu(){
        setFuelAmmount(3);
        setFuelConsumption(1);
        double altitude;
        double atmosphere = 60000;
        
        
        rocket.go();
        System.out.println(rocket.getHeight());
    }
    
    public String launch() {
        String wallOfText;
        wallOfText = "Liftoff!\n";
        simu();
        if (rocket.getFuelAmmount()==0){
            wallOfText += "You tried to launch your rocket, but it had no fuel!\n";
        }
        
        
        return wallOfText;
    }
    
}
