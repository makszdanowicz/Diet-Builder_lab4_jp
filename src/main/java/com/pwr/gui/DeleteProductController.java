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
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeleteProductController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label deleteLabel;

    @FXML
    private TextField productNameField;


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
    void deleteProduct(ActionEvent event)
    {
        String name = productNameField.getText();
        if(!name.equals(""))
        {
            deleteLabel.setText("Product was deleted");
            DataBase dbWorker = new DataBase();
            dbWorker.deleteProductData(name,"DELETE FROM products where name = ?;");
        }
        else {
            deleteLabel.setText("Type the name, you have empty field!");
        }
        //deleteLabel.setText("Product was deleted");
        System.out.println("NAME is " + name);

    }

}
