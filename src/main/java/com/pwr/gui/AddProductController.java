package com.pwr.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.pwr.db.DataBase;
import com.pwr.db.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProductController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TextField productCarbohydratesField;

    @FXML
    private TextField productCategoryField;

    @FXML
    private TextField productFatsField;

    @FXML
    private TextField productMassField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productProteinField;

    @FXML
    private Label createProductLabel;

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
    void createProduct(ActionEvent event)
    {
        String name = productNameField.getText();
        String mass = productMassField.getText();
        String carbohydrates = productCarbohydratesField.getText();
        String protein = productProteinField.getText();
        String fats = productFatsField.getText();
        String category = productCategoryField.getText();
        if(!name.equals("") && !mass.equals("") && !carbohydrates.equals("") && !protein.equals("") && !fats.equals("") && !category.equals(""))
        {
            try{
                Double.parseDouble(mass);
                Double.parseDouble(carbohydrates);
                Double.parseDouble(fats);
                Double.parseDouble(protein);
                createProductLabel.setText("Product was created");
                Product product = new Product(name,Double.parseDouble(mass),Double.parseDouble(carbohydrates),Double.parseDouble(fats),Double.parseDouble(protein),category);
                DataBase dbWorker = new DataBase();
                dbWorker.addProductData(product,"INSERT INTO products(name,mass,carbohydrates,fats,protein,category) VALUE(?, ?, ?, ?, ?, ?);");
            }
            catch(NumberFormatException e)
            {
                System.out.println("Entered value is not a number!" + e.getMessage());
                createProductLabel.setText("Please provide numbers like in example!");
            }
        }
        else {
            createProductLabel.setText("You have empty fields!");
        }
        System.out.println("Your product is: " + name + " " +  mass + "g with: " + "carbohydrates" + carbohydrates + "g " +
                "protein" + protein +"g" + " fats" + fats + "g " + "CATEGORY - " + category);
    }

}
