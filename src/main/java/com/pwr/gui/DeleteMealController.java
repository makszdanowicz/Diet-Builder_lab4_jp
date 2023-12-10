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

public class DeleteMealController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label deleteMealLabel;

    @FXML
    private TextField productNameField;

    @FXML
    void deleteFromBreakfast(ActionEvent event)
    {
        String name = productNameField.getText();
        if(!name.equals(""))
        {
            DataBase dbWorker = new DataBase();
            dbWorker.deleteProductData(name,"DELETE FROM breakfast where name = ?;");
            deleteMealLabel.setText("Product was deleted from breakfast");
        }
        else {
            deleteMealLabel.setText("ERROR.You have empty field!");
        }
    }

    @FXML
    void deleteFromLunch(ActionEvent event)
    {
        String name = productNameField.getText();
        if(!name.equals(""))
        {
            DataBase dbWorker = new DataBase();
            dbWorker.deleteProductData(name,"DELETE FROM lunch where name = ?;");
            deleteMealLabel.setText("Product was deleted from lunch");
        }
        else {
            deleteMealLabel.setText("ERROR.You have empty field!");
        }
    }

    @FXML
    void deleteFromDinner(ActionEvent event)
    {
        String name = productNameField.getText();
        if(!name.equals(""))
        {
            DataBase dbWorker = new DataBase();
            dbWorker.deleteProductData(name,"DELETE FROM dinner where name = ?;");
            deleteMealLabel.setText("Product was deleted from dinner");
        }
        else {
            deleteMealLabel.setText("ERROR.You have empty field!");
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
