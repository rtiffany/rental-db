package com.rentaldb.controller;

import com.rentaldb.mainApp.rentaldb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    public LoginController() {

    }

    @FXML
    private Button loginButton;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        //loginButton.setText("click");
        System.out.println("test");
        Parent windowParent = FXMLLoader.load(rentaldb.class.getResource("Equipment-view.fxml"));
        Scene equipmentScene = new Scene(windowParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Equipment Sales");
        window.setScene(equipmentScene);
    }
}