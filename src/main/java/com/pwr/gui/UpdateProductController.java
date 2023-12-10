package com.pwr.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.pwr.db.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateProductController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField productCarbohydratesField;

    @FXML
    private TextField productFatsField;

    @FXML
    private TextField productMassField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productProteinField;

    @FXML
    private Label updateProductLabel;

    @FXML
    void switchToMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ActionChooserView.fxml"));
        Parent parent = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.setTitle("DietBuilder-Menu");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void updateProduct(ActionEvent event)
    {
        String name = productNameField.getText();
        String mass = productMassField.getText();
        String carbohydrates = productCarbohydratesField.getText();
        String protein = productProteinField.getText();
        String fats = productFatsField.getText();
        if(!name.equals(""))
        {
            DataBase dbWorker = new DataBase();
            dbWorker.updateProductData(Double.parseDouble(mass),Double.parseDouble(carbohydrates),Double.parseDouble(fats),Double.parseDouble(protein),name,"UPDATE products SET mass = ?, carbohydrates = ?, fats = ?, protein = ? WHERE name = ?;");
        }
        updateProductLabel.setText("Product was updated");
        System.out.println("Your product is: " + name + " " +  mass + "g with: " + "carbohydrates" + carbohydrates + "g " +
                "protein" + protein +"g" + " fats" + fats + "g ");
    }


}
