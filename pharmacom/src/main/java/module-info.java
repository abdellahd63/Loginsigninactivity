module com.example.pharmacom {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pharmacom to javafx.fxml;
    exports com.example.pharmacom;
}