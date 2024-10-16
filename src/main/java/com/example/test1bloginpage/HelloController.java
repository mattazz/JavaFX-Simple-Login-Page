package com.example.test1bloginpage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField inputUsername;
    @FXML
    private PasswordField inputPassword;
    @FXML
    private Label loginMessage;
    @FXML
    private Label loginAttemptsMessage;
    @FXML
    private Button loginButton;

//    I need this outside to prevent it from resetting.
    Integer loginAttempts = 0;

    @FXML
    protected void ValidateLogin() {
        String VALID_USERNAME = "Matt";
        String VALID_PASSWORD = "1234";



        String userName = inputUsername.getText();
        String password = inputPassword.getText();


//        Validating empty fields
        if (userName.isEmpty() && password.isEmpty()) {
            loginMessage.setText("Please Provide a Username and Password");
        } else if (userName.isEmpty()) {
            loginMessage.setText("Please provide a Username");
        }
        else if (password.isEmpty()) {
            loginMessage.setText("Please provide a Password");
        } else{ //Sucessful validation
            loginMessage.setText("");

            //        Validating correct credentials
            if (userName.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)){
                loginMessage.setStyle("-fx-text-fill: green;");
                loginMessage.setText("Success!");
            } else{
                loginMessage.setStyle("-fx-text-fill: red;");
                loginMessage.setText("Sorry, invalid Username or Password");
                loginAttempts += 1;
            }
            loginAttemptsMessage.setText("Login attempts: " + loginAttempts.toString());
        }


//        Check if login attempts > 5
        if (loginAttempts >= 5){
            loginButton.setVisible(false);

            loginMessage.setStyle("-fx-text-fill: red;");
            loginMessage.setText("Sorry, your account is locked.");
        }




    }
}