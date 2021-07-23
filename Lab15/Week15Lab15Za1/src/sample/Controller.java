package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Slider sldInput;

    @FXML
    private TextField txtInput;

    @FXML
    private Label lblInput;

    @FXML
    void initialize() {
        assert sldInput != null : "fx:id=\"sldInput\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblInput != null : "fx:id=\"lblInput\" was not injected: check your FXML file 'sample.fxml'.";


        // Fluent API
//        txtInput.textProperty().bind(sldInput.valueProperty().asString("%.2f"));
//        lblInput.textProperty().bind(sldInput.valueProperty().asString("%.2f"));

        // static methods of class Bindings
//        txtInput.textProperty().bind(Bindings.format("%.2f", sldInput.valueProperty()));
//        lblInput.textProperty().bind(Bindings.format("%.2f", sldInput.valueProperty()));

        // low level binding
//        StringBinding binding = new StringBinding() {
//            {
//                super.bind(sldInput.valueProperty());
//            }
//
//            @Override
//            protected String computeValue() {
//                return String.format("%.2f",sldInput.valueProperty().get());
//            }
//        };
//        txtInput.textProperty().bind(binding);
//        lblInput.textProperty().bind(binding);

        // change listener - anonymous classs
//        sldInput.valueProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number oldVal, Number newVal) {
//                txtInput.setText(String.format("%.2f",newVal));
//                lblInput.setText(String.format("%.2f",newVal));
//            }
//        });

        // change listener -lambda
        sldInput.valueProperty().addListener((obsVal, oldVal, newVal) -> {
            txtInput.setText(String.format("%.2f", newVal));
            lblInput.setText(String.format("%.2f", newVal));
        });
    }
}
