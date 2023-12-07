package com.pwr.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;

public class ActionChooserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button endButton;

    @FXML
    private Button listProductButton;

    @FXML
    private SplitMenuButton mealsButton;

    @FXML
    private SplitMenuButton productMenuButton;

    @FXML
    void initialize() {
        //
    }

    @FXML
    void switchToInstructionScene(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/InstructionView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-Instruction");
        stage.setResizable(false);
        stage.show();


        /*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/InstructionView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-Instruction");
        stage.setResizable(false);
        stage.showAndWait();
        */

    }

    @FXML
    void switchToAddProduct(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddProductView.fxml"));
        Parent root = loader.load();
        //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-AddProduct");
        stage.setResizable(false);
        stage.show();
    }

}
