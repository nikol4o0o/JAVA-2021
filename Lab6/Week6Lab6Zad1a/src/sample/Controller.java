package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnCompute;

    @FXML
    private Label lblA;

    @FXML
    private Label lblGCD;

    @FXML
    private Label lblB;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtGCD;

    @FXML
    private TextField txtB;

    @FXML
    void btnComputeAction(ActionEvent event) {
        int a = Integer.parseInt(txtA.getText());
        int b = Integer.parseInt(txtB.getText());
        txtGCD.setText(String.valueOf(compute(a,b)));
    }

    private int compute(int a, int b) {
       if( b==0){
           return a;
       }

       return compute(b,a %b);
    }

    @FXML
    void btnQuitAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnCompute != null : "fx:id=\"btnCompute\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblA != null : "fx:id=\"lblA\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblGCD != null : "fx:id=\"lblGCD\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblB != null : "fx:id=\"lblB\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtA != null : "fx:id=\"txtA\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtGCD != null : "fx:id=\"txtGCD\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtB != null : "fx:id=\"txtB\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
