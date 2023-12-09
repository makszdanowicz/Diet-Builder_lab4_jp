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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
        Stage stage = (Stage) productMenuButton.getScene().getWindow();//Здесь вы получаете ссылку на текущий объект Stage, к которому принадлежит SplitMenuButton
        //Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-AddProduct");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void switchToUpdateProduct(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UpdateProductView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) productMenuButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-UpdateProduct");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void switchToDeleteProduct(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DeleteProductView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) productMenuButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-DeleteProduct");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void closeProgram(ActionEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout!");
        alert.setContentText("Do you want to close the program? ");

        if(alert.showAndWait().get() == ButtonType.OK)
        {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            System.out.println("You successfully logged out!");
            stage.close();
        }

    }

}
