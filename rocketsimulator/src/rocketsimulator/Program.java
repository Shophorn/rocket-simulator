/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocketsimulator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @author Leo Tamminen
 */
public class Program extends Application {
    
    private static UI ui;
    
    @Override
    public void start(Stage primaryStage) {
        
        Simulator simulator = new Simulator ();
        ui = new UI (simulator);
        
        primaryStage.setTitle ("Rocket Simulator");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene (ui));
        primaryStage.show();
        
        sendMessage ("SpaceY Rocket Launcher");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void sendMessage (String message)
    {
        ui.printMessage (message);
    }
    
}
