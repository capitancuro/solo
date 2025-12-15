package com.keno;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

// 1. Your main application class must extend javafx.application.Application
public class App extends Application {

    // 2. The start method is the entry point for all JavaFX applications
    @Override
    public void start(Stage stage) {
        
        // --- 3. Create the UI Content ---
        // A Label node holds the text "Hello World!"
        Label label = new Label("Hello JavaFX World!");
        
        // --- 4. Create the Scene ---
        // The Scene is the container for all content. 
        // We set the label as the root node and define the size of the window.
        Scene scene = new Scene(label, 320, 240); 
        
        // --- 5. Configure and Show the Stage (Window) ---
        // The Stage is the top-level window (like a JFrame in Swing)
        stage.setTitle("My JavaFX App"); // Set the title for the window
        stage.setScene(scene);         // Place the scene inside the stage
        stage.show();                  // Display the stage to the user
    }

    // 6. The main method just launches the JavaFX runtime environment
    public static void main(String[] args) {
        launch();
    }
}