module com.example.exam_list {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exam_list to javafx.fxml;
    exports com.example.exam_list;
}