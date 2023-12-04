package com.pwr;

import com.pwr.gui.InformationCollector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        InformationCollector collector = new InformationCollector();
        //collector.getDecision();
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainView.fxml"));
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene scene = new Scene(root,640,480);
        stage.setTitle("DietBuilder");
        stage.setScene(scene);
        stage.show();
    }
}
