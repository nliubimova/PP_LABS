module com.example.presentsss {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.presentsss to javafx.fxml;
    exports com.example.presentsss;
}