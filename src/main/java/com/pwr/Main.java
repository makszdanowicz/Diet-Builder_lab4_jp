package com.pwr;

import com.pwr.gui.InformationCollector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        InformationCollector collector = new InformationCollector();
        //collector.getDecision();
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new StackPane(),640,480);
        stage.setTitle("Diet-Builder");
        stage.setScene(scene);
        stage.show();
    }
}
