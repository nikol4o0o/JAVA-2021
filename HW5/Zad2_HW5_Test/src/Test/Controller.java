package Test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane apCalculatorApp;

    @FXML
    void initialize() {
        assert apCalculatorApp != null : "fx:id=\"apCalculatorApp\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
