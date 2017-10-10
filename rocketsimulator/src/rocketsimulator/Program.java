/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocketsimulator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void sendMessage (String message)
    {
        ui.printMessage (message);
    }
    
    public static void saveTextFile (String text)
    {   
        boolean fileSaved = false;
        try {
            PrintWriter out = new PrintWriter("flightLog.txt");
            out.write (text);
            out.close();
            fileSaved = true;
        } catch (FileNotFoundException e){
        } 
        if (fileSaved) {
            try {
                ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "flightLog.txt");
                pb.start();
            } catch (IOException e) {
                
            }
        }
    }
}
