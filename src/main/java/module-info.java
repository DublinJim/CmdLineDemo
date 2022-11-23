module com.example.cmdlinedemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cmdlinedemo to javafx.fxml;
    exports com.example.cmdlinedemo;
}