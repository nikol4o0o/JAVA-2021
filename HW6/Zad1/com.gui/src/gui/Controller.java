package gui;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import providers.CipherGenerator;
import providers.Result;
import providers.Wrapper;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSeed;

    @FXML
    private TextField txtSize;

    @FXML
    private Button btnGenerate;

    @FXML
    private Button btnRandom;

    @FXML
    private Button btnQuit;

    @FXML
    void btnGenerateOnAction(ActionEvent event)
    {
        String stringSeed = new String();
        stringSeed = txtSeed.getText();
        Wrapper wrap = new Wrapper(Integer.parseInt(txtSize.getText()));
        Result result = CipherGenerator.countDistinct(wrap.makeFixedRandom(), Integer.parseInt(stringSeed));

        Alert alertSeed = new Alert(Alert.AlertType.INFORMATION);
        alertSeed.setTitle("Generate random sequence");
        alertSeed.setHeaderText("Count distinct characters out of " + txtSize.getText());
        alertSeed.setContentText("Chars: " + Arrays.toString(result.getChars()) + "\n" + "Result: " + result.getData());
        alertSeed.showAndWait();
    }

    @FXML
    void btnQuitOnAction(ActionEvent event)
    {
        System.exit(0);
    }

    @FXML
    void btnRandomOnAction(ActionEvent event)
    {
        Wrapper wrap = new Wrapper(Integer.parseInt(txtSize.getText()));
        Result result = CipherGenerator.countDistinct(wrap.makeFixedSelection(), 0);

        Alert alertRandom = new Alert(Alert.AlertType.INFORMATION);
        alertRandom.setTitle("Random subsequence of letter A-Z");
        alertRandom.setHeaderText("Count distinct characters out of " + txtSize.getText());
        alertRandom.setContentText("Chars: " + Arrays.toString(result.getChars()) + "\n" + "Result: " + result.getData());
        alertRandom.showAndWait();
    }

    @FXML
    void initialize() {
        assert txtSeed != null : "fx:id=\"txtSeed\" was not injected: check your FXML file 'gui.fxml'.";
        assert txtSize != null : "fx:id=\"txtSize\" was not injected: check your FXML file 'gui.fxml'.";
        assert btnGenerate != null : "fx:id=\"btnGenerate\" was not injected: check your FXML file 'gui.fxml'.";
        assert btnRandom != null : "fx:id=\"btnRandom\" was not injected: check your FXML file 'gui.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'gui.fxml'.";

    }
}
