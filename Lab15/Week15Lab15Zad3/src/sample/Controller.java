package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtFromCelsius;

    @FXML
    private TextField txtToFahrenheit;

    @FXML
    private TextField txtFromFahrenheit;

    @FXML
    private TextField txtToCelsius;

    @FXML
    void initialize() {
        assert txtFromCelsius != null : "fx:id=\"txtFromCelsius\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtToFahrenheit != null : "fx:id=\"txtToFahrenheit\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtFromFahrenheit != null : "fx:id=\"txtFromFahrenheit\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtToCelsius != null : "fx:id=\"txtToCelsius\" was not injected: check your FXML file 'sample.fxml'.";

//        //Fluent API
//        //txtFromCelcisus -> txtToFahrenheit
//        DoubleBinding celcInp = new DoubleBinding() {
//            {
//                super.bind(txtFromCelsius.textProperty());
//            }
//
//            @Override
//            protected double computeValue() {
//                String inp = txtFromCelsius.textProperty().get();
//                if(inp.isBlank()){
//                    return 0;
//                }
//                return Double.parseDouble(inp);
//            }
//        };
//
//        txtToFahrenheit.textProperty()
//                .bind(celcInp.multiply(9.0/5.0).add(32).asString("%.2f"));
//
//        //Fluent API
//        //txtToFahrenheit-> txtFromCelcisus
//        DoubleBinding fahrInp = new DoubleBinding() {
//            {
//                super.bind(txtFromFahrenheit.textProperty());
//            }
//
//            @Override
//            protected double computeValue() {
//                String inp = txtFromFahrenheit.textProperty().get();
//                if(inp.isBlank()){
//                    return 0;
//                }
//                return Double.parseDouble(inp);
//            }
//        };
//
//        txtToCelsius.textProperty()
//                .bind(fahrInp.subtract(32).multiply(5.0/9.0).asString("%.2f"));
//

        // static method of Bindings class
        DoubleBinding celInp = Bindings.createDoubleBinding(() -> {
            String inp = txtFromCelsius.textProperty().get();
            if(inp.isBlank()){
                return 0.0;
            }
            return Double.parseDouble(inp);
        }, txtFromCelsius.textProperty());

        txtToFahrenheit.textProperty()
                .bind(Bindings.format("%.2f", Bindings.add(Bindings.multiply(celInp,9.0/5.0),32 )));

        DoubleBinding fahrInp = Bindings.createDoubleBinding(() -> {
            String inp = txtFromFahrenheit.textProperty().get();
            if(inp.isBlank()){
                return 0.0;
            }
            return Double.parseDouble(inp);
        }, txtFromFahrenheit.textProperty());

        txtToCelsius.textProperty()
                .bind(Bindings.format("%.2f", Bindings.multiply(Bindings.subtract(fahrInp,32),5.0/9.0)));
    }
}

