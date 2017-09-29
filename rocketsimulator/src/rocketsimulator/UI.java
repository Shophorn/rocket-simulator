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
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class UI extends GridPane
{
    // Gridpane with one row and two columns
    // Left column is input,  right is output
    
    public UI ()
    {   
        GridPane inputGrid = new GridPane ();
        GridPane outputGrid = new GridPane ();
        
        addRow (0, inputGrid, outputGrid);
        
        Label fuelLabel = new Label ("Fuel amount");
        Label consumptionLabel = new Label("Fuel consumption");
        
        TextField fuelField = new TextField ();
        TextField consumptionField = new TextField ();
       
        Slider fuelSlider = new Slider (Values.minRocketFuel, Values.maxRocketFuel, Values.minRocketFuel);
        Slider consumptionSlider = new Slider (Values.minRocketFuelConsumption, Values.maxRocketFuelConsumption, Values.minRocketFuelConsumption);
        
        inputGrid.addRow(0, fuelLabel, fuelSlider, fuelField);
        inputGrid.addRow(1, consumptionLabel, consumptionSlider, consumptionField);
        
        
        Label outputLabel = new Label ("Testing output");
  
        outputGrid.add(outputLabel, 0, 0);
    }
    
}
