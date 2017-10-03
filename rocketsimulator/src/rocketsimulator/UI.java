/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocketsimulator;

/**
 *
 * @author Leo Tamminen
 */
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javafx.geometry.HPos;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;

public class UI extends BorderPane
{
    Simulator simulator;
    
    GridPane ioGrid;
    GridPane inputGrid;
    Label outputLabel;
    Label messageLabel;
    
    private int inputRow = 0;
    private int nextInputRow () { return inputRow++; }
    
    private final int insetsSize = 5;
    private final Insets labelInsets = new Insets (insetsSize);
    private final int fieldWidth = 50;
    private final int buttonWidth = 100;
    private final DecimalFormat decimalFormat;
    
    private static final String DEFAULT_OUTPUT = "Waiting for new launch";
    private static final String INPUT_TITLE = "ROCKET SPECS";
    private static final String OUTPUT_TITLE = "LAUNCH RESULTS";
    
    private static final int TITLE_ROW = 0;
    private static final int IO_ROW = 1;
    private static final int BUTTON_ROW = 2;
    private static final int TOTAL_ROWS = 3;
    
    public UI (Simulator simulator)
    {
        super ();
        this.simulator = simulator;
        
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.getDefault());
        formatSymbols.setDecimalSeparator('.');
        decimalFormat = new DecimalFormat("0.00", formatSymbols);
 
        // INIT ELEMENTS
        ioGrid = new GridPane ();
        inputGrid = new GridPane ();
        outputLabel = new Label();
        messageLabel = new Label ();

        // INPUT
        addSliderRow ("Fuel amount" , Values.minRocketFuel, Values.maxRocketFuel, RocketStat.FUEL_AMOUNT);
        addSliderRow ("Fuel consumption", Values.minRocketFuelConsumption, Values.maxRocketFuelConsumption, RocketStat.FUEL_CONSUMPTION);
        
          
        // OUTPUT
        clearOutput ();
        
        // BUTTONS
        Button launchButton = new Button ("LAUNCH");
        launchButton.setOnAction ((event)-> printOutput ());
        launchButton.setMinWidth (buttonWidth);
        ioGrid.add(launchButton, 0, BUTTON_ROW);
        GridPane.setHalignment (launchButton, HPos.CENTER);

        Button clearButton =  new Button ("CLEAR");
        clearButton.setOnAction ((event)-> clearOutput ());
        clearButton.setMinWidth (buttonWidth);
        ioGrid.add(clearButton, 2, BUTTON_ROW);
        GridPane.setHalignment (clearButton, HPos.CENTER);
        
        // TITLES
        Label inputTitleLabel = new Label (INPUT_TITLE);
        inputTitleLabel.setPadding(labelInsets);
        GridPane.setHalignment(inputTitleLabel, HPos.CENTER);
        
        Label outputTitleLabel = new Label (OUTPUT_TITLE);
        outputTitleLabel.setPadding (labelInsets);
        GridPane.setHalignment(outputTitleLabel, HPos.CENTER);
        
        // MESSAGE 
        Separator messageSeparator = new Separator ();
        messageLabel.setPadding (labelInsets);
        VBox messageBox = new VBox ();
        messageBox.getChildren().addAll(messageSeparator, messageLabel);
        
        // SUPERSTRUCTURE
        setCenter (ioGrid);
        setBottom (messageBox);
        
        Separator ioSeparator = new Separator (Orientation.VERTICAL);
        
        ioGrid.addRow (TITLE_ROW, inputTitleLabel, ioSeparator, outputTitleLabel);
        ioGrid.add (inputGrid, 0, IO_ROW);
        ioGrid.add (outputLabel, 2, IO_ROW);
        GridPane.setRowSpan(ioSeparator, TOTAL_ROWS);
        GridPane.setHalignment (outputLabel, HPos.CENTER);
        GridPane.setValignment (outputLabel, VPos.CENTER);
        
        ColumnConstraints cConstraint = new ColumnConstraints (300);
        ioGrid.getColumnConstraints().add (0, cConstraint);
        ioGrid.getColumnConstraints().add (1, new ColumnConstraints());
        ioGrid.getColumnConstraints().add (2, cConstraint);
        
        RowConstraints rConstraint = new RowConstraints (300);
        rConstraint.setVgrow(Priority.ALWAYS);
        ioGrid.getRowConstraints ().addAll(new RowConstraints (), rConstraint);
        
        ioGrid.setPadding (labelInsets);
    }
    
    public void printMessage (String message)
    {
        messageLabel.setText(message);
    }
    
    private void printOutput ()
    {
        GridPane.setValignment(outputLabel, VPos.TOP);
        outputLabel.setText (simulator.launch());
    }
    
    private void clearOutput ()
    {
       GridPane.setValignment(outputLabel, VPos.CENTER);
       outputLabel.setText(DEFAULT_OUTPUT);
    }
    
    private void addSliderRow (String labelText, double minValue, double maxValue, RocketStat type)
    {
        Label label = new Label (labelText);
        label.setPadding(labelInsets);
        
        Slider slider = new Slider (minValue, maxValue, minValue);
        TextField field = new TextField (Double.toString(minValue));
        
        slider.valueProperty().addListener (
            (observabelValue, oldValue, newValue) -> {
                double value = newValue.doubleValue ();
                field.setText(decimalFormat.format (value));
                simulator.setRocketStat(type, value);
            }
        );
        
        field.textProperty ().addListener(
            (observableValue, oldValue, newValue) -> {
                try {
                    Double.parseDouble(newValue);
                } catch (NumberFormatException e) {
                    if (!newValue.equals("")) {
                        field.setText (oldValue);
                    }
                }
            }
        );
       
        field.setOnAction (
            (event) -> slider.setValue (Double.parseDouble(field.getText()))
        );
        
        field.setMaxWidth(fieldWidth);
        
        inputGrid.addRow (nextInputRow(), label, slider, field);
    }
}
