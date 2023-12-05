package com.pwr.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button launchAppButton;

    @FXML
    void initialize() {
        launchAppButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                launchAppButton.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/InstructionView.fxml"));
                try {
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("DietBuilder-Instruction");
                    stage.setResizable(false);
                    stage.showAndWait();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }
}
