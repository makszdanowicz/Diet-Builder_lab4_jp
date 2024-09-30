module Lab4 {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires itextpdf;
    requires org.apache.pdfbox;

    opens com.pwr;
    opens com.pwr.gui;
    opens com.pwr.db;
}