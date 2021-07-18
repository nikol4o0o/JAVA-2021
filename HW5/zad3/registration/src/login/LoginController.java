package login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import valid.Validation;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblConfirmPassword;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblEmail;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCancel;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private Label lblFilled;

    @FXML
    private Label lblWrongUsername;

    @FXML
    private Label lblWrongPassword;

    @FXML
    private Label lblWrongConformationPassword;

    @FXML
    private Label lblWrongPhone;

    @FXML
    private Label lblWrongEmail;
    private Validation validation = new Validation();

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Alert alertExit = new Alert(Alert.AlertType.CONFIRMATION);
        alertExit.setTitle(null);
        alertExit.setHeaderText(null);
        alertExit.setContentText("Are you sure you want to exit?");
        Optional<ButtonType> result = alertExit.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            System.exit(0);
        }
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        if(validateInput()){
            clearWrongLabels(); // чисти нашите label за грешки
            Alert alertSuccess = new Alert(Alert.AlertType.INFORMATION);//правим алърт, който да ни уведоми за успех
            alertSuccess.setTitle("Congratulations!");
            alertSuccess.setContentText("You logged successfully!");
            alertSuccess.setHeaderText(null);
            alertSuccess.showAndWait();
        }
    }
    //метод, с който изчистваме лейбълите на лейбълите за грешки
    private void clearWrongLabels()
    {
        lblWrongEmail.setText("");
        lblWrongUsername.setText("");
        lblWrongPassword.setText("");
        lblWrongConformationPassword.setText("");
        lblWrongPhone.setText("");
    }
    //Метод, който да валидираме полетата от упражение по Java 
    boolean validateInput()
    {

       if(validation.checkEmpty(txtUsername.getText(), txtPassword.getText(), txtConfirmPassword.getText(),
                txtEmail.getText(), txtPhone.getText()))
       {
           return false;
       }

       boolean usernameValidity = validation.checkUsername(txtUsername.getText());
       boolean passwordValidity = validation.checkPassword(txtPassword.getText());
       boolean passwordConfirm = validation.checkConfirmingPassword(txtPassword.getText(), txtConfirmPassword.getText());
       boolean emailValidity = validation.checkEmail(txtEmail.getText());
       boolean phoneValidity = validation.checkPhone(txtPhone.getText());

       if(!phoneValidity)
       {
           lblWrongPhone.setText("Wrong phone format");
       }
       if(!usernameValidity)
       {
           lblWrongUsername.setText("Wrong username format");
       }
       if(!passwordValidity)
       {
           lblWrongPassword.setText("Wrong password format");
       }
       if(!passwordConfirm)
       {
           lblWrongConformationPassword.setText("The two passwords must be identical");
       }
       if(!emailValidity)
       {
           lblWrongEmail.setText("Wrong email format");
       }

       return usernameValidity && passwordValidity && passwordConfirm && emailValidity && phoneValidity;

    }

    @FXML
    void initialize() {
        assert lblUsername != null : "fx:id=\"lblUsername\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert lblPassword != null : "fx:id=\"lblPassword\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert lblConfirmPassword != null : "fx:id=\"lblConfirmPassword\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert lblPhone != null : "fx:id=\"lblPhone\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert lblEmail != null : "fx:id=\"lblEmail\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert txtPhone != null : "fx:id=\"txtPhone\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert txtConfirmPassword != null : "fx:id=\"txtConfirmPassword\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert lblFilled != null : "fx:id=\"lblFilled\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert lblWrongUsername != null : "fx:id=\"lblWrongUsername\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert lblWrongPassword != null : "fx:id=\"lblWrongPassword\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert lblWrongConformationPassword != null : "fx:id=\"lblWrongConformationPassword\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert lblWrongPhone != null : "fx:id=\"lblWrongPhone\" was not injected: check your FXML file 'LoginFXML.fxml'.";
        assert lblWrongEmail != null : "fx:id=\"lblWrongEmail\" was not injected: check your FXML file 'LoginFXML.fxml'.";
    }
}
