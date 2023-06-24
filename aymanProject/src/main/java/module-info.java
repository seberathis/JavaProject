module com.example.controlebb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.controlebb to javafx.fxml;
    exports com.example.controlebb;
}