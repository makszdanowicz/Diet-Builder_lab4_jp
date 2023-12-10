package com.pwr.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Map;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BreakfastShopListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textArea;

    FileChooser fileChooser = new FileChooser();

    @FXML
    void getContent(ActionEvent event)
    {
        DataBase dbWorker = new DataBase();
        Map<Product,Double> breakfast = dbWorker.getMealData("SELECT * FROM breakfast;");
        textArea.appendText("BREAKFAST SHOP LIST");
        textArea.appendText("\n");
        textArea.appendText("Products:");
        textArea.appendText("\n");
        for(Map.Entry<Product,Double> entry : breakfast.entrySet())
        {
            textArea.appendText(entry.getKey().getName() + " (" + entry.getKey().getMass() + "g) " + "x " + entry.getValue().toString());
            textArea.appendText("\n");
        }
    }
    @FXML
    void saveToPdf(MouseEvent event) {
        File file = fileChooser.showSaveDialog(new Stage());
        if(file != null)
        {
            saveSystem(file, textArea.getText());
        }
    }

    public void saveSystem(File file, String content)
    {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(content);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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

