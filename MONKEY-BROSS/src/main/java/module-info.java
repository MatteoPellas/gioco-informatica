module com.example.monkeybross {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.monkeybross to javafx.fxml;
    exports com.example.monkeybross;

}