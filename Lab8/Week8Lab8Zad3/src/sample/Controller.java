package sample;

import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblUnsortedArray;

    @FXML
    private Label lblAscendingOrder;

    @FXML
    private Label lblSortedArray;

    @FXML
    private Button btnSort;

    @FXML
    private Button btnQuit;

    @FXML
    private TextArea txaUnsortedArray;

    @FXML
    private TextArea txaSortedArray;

    @FXML
    private TextField txtAscendingOrder;

    private Random random;

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnSortOnAction(ActionEvent event) {
        String[] numberAsText = txaUnsortedArray.getText().split("\\s+");
        if (numberAsText.length > 0) {
            int[] numbers = new int[numberAsText.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(numberAsText[i]);
            }
            boolean ascendingOrder = txtAscendingOrder.getText().matches("[yY]");
            Arrays.sort(numbers);
            if (!ascendingOrder) {
                int middle = numbers.length / 2;
                int index = 0;
                for (int i = numbers.length - 1; i >= middle; i--) {
                    int temp = numbers[i];
                    numbers[i] = numbers[index];
                    numbers[index] = temp;
                    index++;
                }
            }
            txaSortedArray.setText(Arrays.toString(numbers));
        }
    }

    @FXML
    void initialize() {
        assert lblUnsortedArray != null : "fx:id=\"lblUnsortedArray\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblAscendingOrder != null : "fx:id=\"lblAscendingOrder\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblSortedArray != null : "fx:id=\"lblSortedArray\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSort != null : "fx:id=\"btnSort\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";
        assert txaUnsortedArray != null : "fx:id=\"txaUnsortedArray\" was not injected: check your FXML file 'sample.fxml'.";
        assert txaSortedArray != null : "fx:id=\"txaSortedArray\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtAscendingOrder != null : "fx:id=\"txtAscendingOrder\" was not injected: check your FXML file 'sample.fxml'.";

        random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 40; i++) {
            sb.append(10 + random.nextInt(91)) // числата в интервала[10, 100]
                    .append(" ");
        }
        txaUnsortedArray.setText(sb.toString());
    }
}
