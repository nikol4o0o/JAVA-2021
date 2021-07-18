module registration {
    requires javafx.fxml;
    requires javafx.controls;
    requires validation;

    opens login to javafx.fxml;
    exports login to javafx.graphics;
}