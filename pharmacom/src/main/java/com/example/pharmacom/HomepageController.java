package com.example.pharmacom;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class HomepageController implements Initializable {
    private Button logoutbtn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
           logoutbtn.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent actionEvent) {

               }
           });
    }
}
