package sample;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {

    @FXML
    private Rectangle shape;

    @FXML
    private Slider sldR;

    @FXML
    private Slider sldG;

    @FXML
    private Slider sldB;

    @FXML
    private Slider sldOpacity;

    @FXML
    void initialize() {
        ChangeListener<Number> changeListener = (((observableValue, number, newVal) -> {
            shape.setFill(Color.rgb( (int) sldR.getValue(),(int) sldG.getValue(),(int) sldB.getValue(), sldOpacity.getValue()));
        }));

        sldR.valueProperty().addListener(changeListener);
        sldB.valueProperty().addListener(changeListener);
        sldG.valueProperty().addListener(changeListener);
        sldOpacity.valueProperty().addListener(changeListener);
    }

}


