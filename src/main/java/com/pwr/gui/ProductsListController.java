package com.pwr.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.pwr.db.DataBase;
import com.pwr.db.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ProductsListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textArea;

    @FXML
    void getContent(ActionEvent event) {
        List<Product> products = new ArrayList<>();
        DataBase dbWorker = new DataBase();
        products = dbWorker.getProductsData("SELECT * FROM products;");
        textArea.appendText("Products:");
        textArea.appendText("\n");
        for(Product product : products)
        {
            textArea.appendText(product.getName() + " (" + product.getMass() + "g):\n");
            textArea.appendText(" - Carbohydrates (g): " + product.getCarbohydrates() + ",\n");
            textArea.appendText(" - Fats (g): " + product.getFats() + ",\n");
            textArea.appendText(" - Protein (g): " + product.getProtein() + ",\n");
            textArea.appendText(" - Category: " + product.getCategory() + "\n");
            textArea.appendText("\n");
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
