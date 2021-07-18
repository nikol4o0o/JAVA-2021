package calculator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControllerCalculator extends AnchorPane
{

    // Стринг, в който да използваме според бутоните на дадена операция
    private String operation = new String();

    //Променлива, в която да пазим първото число
    private double firstDigit;

    //Променлива, в която да пазим второто число
    private double secondDigit;

    private double result;
    //Променлива, на която присвояваме текущото число, когато е натиснат бутона M
    private double mDigit;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnZero;

    @FXML
    private Button btnTwoZero;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnResult;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnC;

    @FXML
    private Button btnCA;

    @FXML
    private Button btnOFF;

    @FXML
    private Button btnM;

    @FXML
    private Button btnMPlus;

    @FXML
    private Button btnMMinus;

    @FXML
    private Button btnMClear;
    //Конструктора, който намираме в лекциите на проф. Кръстев, лекция 9С
    public ControllerCalculator()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/calculator/CalculatorFXML.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }

    //Метод за сетване на стойност на първото число
    public void setFirstDigit(String inputDigit){
        if(!inputDigit.equals(""))
        {
            firstDigit = Double.parseDouble(inputDigit);

        }
        else
        {
            firstDigit = 0;
        }
    }

    //Метод за сетване на стойност на първото число
    public void setSecondDigit(String inputDigit){
        if(!inputDigit.equals(""))
        {
            secondDigit = Double.parseDouble(inputDigit);

        }
        else
        {
            secondDigit = 0;
        }
    }
    //Getter for the result
    public double getResult()
    {
        return result;
    }

    @FXML
    void btnTwoZeroOnAction(ActionEvent event)
    {
        showDigitOnTextField("00");
    }

    @FXML
    void btnZeroOnAction(ActionEvent event)
    {
        showDigitOnTextField("0");
    }

    @FXML
    void btnOneOnAction(ActionEvent event)
    {
        showDigitOnTextField("1");
    }

    @FXML
    void btnTwoOnAction(ActionEvent event)
    {
        showDigitOnTextField("2");
    }

    @FXML
    void btnThreeOnAction(ActionEvent event)
    {
        showDigitOnTextField("3");
    }

    @FXML
    void btnFourOnAction(ActionEvent event)
    {
        showDigitOnTextField("4");
    }

    @FXML
    void btnFiveOnAction(ActionEvent event)
    {
        showDigitOnTextField("5");
    }

    @FXML
    void btnSixOnAction(ActionEvent event)
    {
        showDigitOnTextField("6");
    }

    @FXML
    void btnSevenOnAction(ActionEvent event)
    {
        showDigitOnTextField("7");
    }

    @FXML
    void btnEightOnAction(ActionEvent event)
    {
        showDigitOnTextField("8");
    }

    @FXML
    void btnNineOnAction(ActionEvent event)
    {
        showDigitOnTextField("9");
    }

    //Метод, чрез който показваме текста в текстовото поле, когато се натисне бутона
    private void showDigitOnTextField(String digit) {
        String text = txtInput.getText();
        if (!text.equals("0"))
        {
            txtInput.setText(text + digit);

        } else
        {
            txtInput.setText(digit);

        }
    }

    //Взимаме въведено число и запазваме операцията
    private void doOperation(String opertate)
    { // get entered digit from text field and keep operation
        setFirstDigit(txtInput.getText());
        operation = opertate;
        txtInput.setText("0");
    }

    @FXML
    void btnCAOnAction(ActionEvent event)
    {
        txtInput.setText("0");
        operation = "";
    }

    @FXML
    void btnCOnAction(ActionEvent event)
    {
        txtInput.setText("0");
    }

    @FXML
    void btnResultOnAction(ActionEvent event)
    { // calculate result of entered digits with given operation
        setSecondDigit(txtInput.getText());
        switch (operation) {

            case "DIVIDE":
                result = firstDigit / secondDigit;
                break;
            case "MINUS":
                result = firstDigit - secondDigit;
                break;
            case "PLUS":
                result = firstDigit + secondDigit;
                break;
            case "MULTIPLY":
                result = firstDigit * secondDigit;
                break;

            default:
                return;
        }
        //Показваме резултат на калкулатора и зануляваме операцията, за следващата
        txtInput.setText("" + result);
        operation = "";
    }

    @FXML
    void btnDivideOnAction(ActionEvent event)
    {
        doOperation("DIVIDE");
    }

    @FXML
    void btnDotOnAction(ActionEvent event)
    {
        showDigitOnTextField(".");
    }

    @FXML
    void btnMultiplyOnAction(ActionEvent event)
    {
        doOperation("MULTIPLY");
    }

    @FXML
    void btnOFFOnAction(ActionEvent event)
    { 
        System.exit(0);
    }

    @FXML
    void btnPlusOnAction(ActionEvent event)
    {
        doOperation("PLUS");
    }

    @FXML
    void btnMinusOnAction(ActionEvent event)
    {
        doOperation("MINUS");
    }

    @FXML
    void btnMClearOnAction(ActionEvent event)
    {
        mDigit = 0;
        txtInput.setText("0"); // премахваме запазеното число от текстовото поле
    }

    @FXML
    void btnMMinusOnAction(ActionEvent event)
    {
        double resultSubstr = checkMDigit(txtInput.getText()) - mDigit;
        txtInput.setText("" + resultSubstr);
    }

    @FXML
    void btnMOnAction(ActionEvent event)
    { //запазваме въведеното число от М в паметта
        mDigit = checkMDigit(txtInput.getText());
    }

    @FXML
    void btnMPlusOnAction(ActionEvent event)
    {
        double resultSum = mDigit + checkMDigit(txtInput.getText());
        txtInput.setText("" + resultSum);
    }

    private double checkMDigit(String inputDigit){
        if(inputDigit.equals("")){
            return 0;
        }
        else
        {
            return Double.parseDouble(inputDigit);
        }
    }

    @FXML
    void initialize() {

    }
}
