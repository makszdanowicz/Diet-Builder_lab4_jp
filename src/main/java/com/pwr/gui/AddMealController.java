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

public class AddMealController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label addMealLabel;

    @FXML
    private TextField amountField;

    @FXML
    private TextField productNameField;

    @FXML
    void addToBreakfast(ActionEvent event)
    {
        String name = productNameField.getText();
        String amount = amountField.getText();
        if(!name.equals("") && !amount.equals(""))
        {
            DataBase dbWorker = new DataBase();
            Product product = dbWorker.getProductData(name,"SELECT * FROM products WHERE name = ?;");
            dbWorker.addToMeal(product,Double.parseDouble(amount),"INSERT INTO breakfast(name,mass,carbohydrates,fats,protein,category,amount) VALUE(?, ?, ?, ?, ?, ?, ?);");
            addMealLabel.setText("Product was added to breakfast");
        }
        else
        {
            addMealLabel.setText("ERROR.You have empty fields");
        }
    }

    @FXML
    void addToLunch(ActionEvent event)
    {
        String name = productNameField.getText();
        String amount = amountField.getText();
        if(!name.equals("") && !amount.equals(""))
        {
            DataBase dbWorker = new DataBase();
            Product product = dbWorker.getProductData(name,"SELECT * FROM products WHERE name = ?;");
            dbWorker.addToMeal(product,Double.parseDouble(amount),"INSERT INTO lunch(name,mass,carbohydrates,fats,protein,category,amount) VALUE(?, ?, ?, ?, ?, ?, ?);");
            addMealLabel.setText("Product was added to lunch");
        }
        else
        {
            addMealLabel.setText("ERROR.You have empty fields");
        }
    }

    @FXML
    void addToDinner(ActionEvent event)
    {
        String name = productNameField.getText();
        String amount = amountField.getText();
        if(!name.equals("") && !amount.equals(""))
        {
            DataBase dbWorker = new DataBase();
            Product product = dbWorker.getProductData(name,"SELECT * FROM products WHERE name = ?;");
            dbWorker.addToMeal(product,Double.parseDouble(amount),"INSERT INTO dinner(name,mass,carbohydrates,fats,protein,category,amount) VALUE(?, ?, ?, ?, ?, ?, ?);");
            addMealLabel.setText("Product was added to dinner");
        }
        else
        {
            addMealLabel.setText("ERROR.You have empty fields");
        }
    }

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

}
