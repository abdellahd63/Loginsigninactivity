package com.example.pharmacom;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;
import java.sql.Connection;

public class SigninpageController implements Initializable {
    @FXML
    private Button login_signin;
    @FXML
    private TextField nom_signin;
    @FXML
    private TextField prenom_signin;
    @FXML
    private TextField password_signin;
    @FXML
    private TextField email_signin;
    @FXML
    private TextField username_signin;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_signin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                databaseconn connectnow = new databaseconn();
                Connection connectdb= connectnow.getconnection();
                String qry="INSERT INTO `pharmacom`.`useraccount`(`id`, `nom`, `prenom`, `email`, `username`, `passsword`) VALUES('"+nom_signin.getText()+"','"+prenom_signin.getText()+"','"+username_signin.getText()+"','"+email_signin.getText()+"','"+password_signin.getText()+"');";
                Statement stat= null;
                try {
                    stat = connectdb.createStatement();
                    ResultSet result =stat.executeQuery(qry);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}
