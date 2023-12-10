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

public class UpdateMealController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField newAmountField;

    @FXML
    private TextField productNameField;

    @FXML
    private Label updateInfoLabel;

    @FXML
    void updateToBreakfast(ActionEvent event)
    {
        String name = productNameField.getText();
        String amount = newAmountField.getText();
        if(!name.equals("") && !amount.equals(""))
        {
            DataBase dbWorker = new DataBase();
            dbWorker.updateMeal(name,Double.parseDouble(amount),"UPDATE breakfast SET amount = ? WHERE name = ?;");
            updateInfoLabel.setText("Product was updated to breakfast");
        }
        else {
            updateInfoLabel.setText("ERROR.You have empty fields");
        }
    }

    @FXML
    void updateToLunch(ActionEvent event)
    {
        String name = productNameField.getText();
        String amount = newAmountField.getText();
        if(!name.equals("") && !amount.equals(""))
        {
            DataBase dbWorker = new DataBase();
            dbWorker.updateMeal(name,Double.parseDouble(amount),"UPDATE lunch SET amount = ? WHERE name = ?;");
            updateInfoLabel.setText("Product was updated to lunch");
        }
        else {
            updateInfoLabel.setText("ERROR.You have empty fields");
        }
    }

    @FXML
    void updateToDinner(ActionEvent event)
    {
        String name = productNameField.getText();
        String amount = newAmountField.getText();
        if(!name.equals("") && !amount.equals(""))
        {
            DataBase dbWorker = new DataBase();
            dbWorker.updateMeal(name,Double.parseDouble(amount),"UPDATE breakfast SET amount = ? WHERE name = ?;");
            updateInfoLabel.setText("Product was updated to dinner");
        }
        else {
            updateInfoLabel.setText("ERROR.You have empty fields");
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
