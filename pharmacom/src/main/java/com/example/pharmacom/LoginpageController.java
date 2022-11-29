package com.example.pharmacom;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginpageController implements Initializable {
   @FXML
    private Button loginbtn;
    @FXML
    private TextField username;
    @FXML
    private TextField password;


    private Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        loginbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(username.getText().isBlank()==false && password.getText().isBlank()==false){
                    validateconnection();
                }
            }
        });

    }
    public void validateconnection(){
        databaseconn connectnow = new databaseconn();
        Connection connectdb= connectnow.getconnection();
        String verifylogin="SELECT count(1) FROM pharmacom.useraccount WHERE username='"+username.getText()+"'password='"+password.getText()+ "'";

        try{
            Statement stat=connectdb.createStatement();
            ResultSet res =stat.executeQuery(verifylogin);

            if(res.next()){
               try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homepage.fxml"));
                    Parent rootl = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();

                    stage.setTitle("home");
                    stage.setScene(new Scene(rootl));
                    stage.show();
                }catch(Exception e){
                    System.out.println("Can't load new window");
                }
                //Parent root=FXMLLoader.load(getClass().getResource("homepage.fxml"));
                //stage=(Stage)(node)
            }
        }catch (Exception e){

        }
    }
}
