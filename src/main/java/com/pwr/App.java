package com.pwr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("DietBuilder");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram(stage);
        });
    }

    void closeProgram(Stage stage)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout!");
        alert.setContentText("Do you want to close the program? ");

        if(alert.showAndWait().get() == ButtonType.OK)
        {
            System.out.println("You successfully logged out!");
            stage.close();
        }


    }
}
