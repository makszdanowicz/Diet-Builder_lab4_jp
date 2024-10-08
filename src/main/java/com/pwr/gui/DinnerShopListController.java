package com.pwr.gui;

import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.pwr.db.CaloriesCounter;
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

public class DinnerShopListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textArea;
    FileChooser fileChooser = new FileChooser();

    @FXML
    void getContent(ActionEvent event) {
        DataBase dbWorker = new DataBase();
        Map<Product,Double> dinner = dbWorker.getMealData("SELECT * FROM dinner;");
        textArea.appendText("DINNER SHOP LIST");
        textArea.appendText("\n");
        textArea.appendText("Products:");
        textArea.appendText("\n");
        for(Map.Entry<Product,Double> entry : dinner.entrySet())
        {
            CaloriesCounter caloriesCounter = new CaloriesCounter();
            double calories = caloriesCounter.countCaloriesInProduct(entry.getKey().getCarbohydrates(),entry.getKey().getFats(),entry.getKey().getProtein(),entry.getValue());
            textArea.appendText(entry.getKey().getName() + " (" + entry.getKey().getMass() + "g) " + "x " + entry.getValue().toString() + " | Calories (" + calories + "cal)");
            textArea.appendText("\n");
        }
    }

    @FXML
    void saveToPdf(MouseEvent event) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document,new FileOutputStream("DinnerShopList.pdf"));
        document.open();
        String textFromTextArea = textArea.getText();
        Paragraph paragraph = new Paragraph(textFromTextArea);
        document.add(paragraph);
        System.out.println(textFromTextArea);
        document.close();
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
