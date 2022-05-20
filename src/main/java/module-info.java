module com.example.piratesandcannons {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.piratesandcannons to javafx.fxml;
    exports com.example.piratesandcannons;
}