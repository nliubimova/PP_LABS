module com.example.presents {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.presents to javafx.fxml;
    exports com.example.presents;
}