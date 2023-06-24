package com.example.controlebb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField name;
    @FXML
    private PasswordField pwd;
 @FXML
    protected void login() throws IOException {
     if (name.getText().equals("admin") && pwd.getText().equals("admin")) {
         Stage s= (Stage) name.getScene().getWindow();
         FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene2.fxml"));
         Scene scene = new Scene(fxmlLoader.load());
         s.setScene(scene);

     }
     else {
         Alert alert=new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Authentification Error");
         alert.setHeaderText("userneme or password is incorrect!");
         alert.setContentText("Change your information and enter the correct info");
         alert.show();

     }
 }

}