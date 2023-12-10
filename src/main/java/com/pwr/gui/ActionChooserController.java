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
    private SplitMenuButton productMenuButton;

    @FXML
    private SplitMenuButton mealMenuButton;

    @FXML
    private SplitMenuButton shopListButton;

    @FXML
    void switchToInstructionScene(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/InstructionView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-Instruction");
        stage.setResizable(false);
        stage.show();
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
    void switchToShowProduct(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProductsListView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) productMenuButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-ProductList");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void switchToAddMeal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddMealView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) mealMenuButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-AddMeal");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void switchToUpdateMeal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UpdateMealView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) mealMenuButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-UpdateMeal");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void switchToDeleteMeal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DeleteMealView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) mealMenuButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-DeleteMeal");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void switchToBreakfastShopList(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BreakfastShopListView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) shopListButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-BreakfastShopList");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void switchToLunchShopList(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LunchShopListView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) shopListButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-LunchShopList");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void switchToDinnerShopList(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DinnerShopListView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) shopListButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("DietBuilder-DinnerShopList");
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
