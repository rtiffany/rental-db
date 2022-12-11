package com.rentaldb.controller;

import com.rentaldb.mainApp.DBUtil;
import com.rentaldb.mainApp.rentaldb;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.SQLException;

public class LoginController {

    // Create DBUtil instance to share between the scenes
    DBUtil dbUtil = DBUtil.getInstance();

    @FXML
    private Button loginButton;
    @FXML
    private TextField loginHostname;
    @FXML
    private TextField loginUsername;
    @FXML
    private PasswordField loginPassword;
    @FXML
    private Label loginError;

    @FXML
    private void initialize() {
        // Set the focus of loginUsername field on program startup
        Platform.runLater(() -> loginUsername.requestFocus());
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {

        String hostname = loginHostname.getText();
        String username = loginUsername.getText();
        String password = loginPassword.getText();

        dbUtil.set(hostname, username, password);

        try {
            dbUtil.connect();
            Parent windowParent = FXMLLoader.load(rentaldb.class.getResource("Database-view.fxml"));
            Scene databaseScene = new Scene(windowParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Welcome");
            window.setScene(databaseScene);
        } catch (SQLException e) {
            e.printStackTrace();
            loginError.setText(e.getMessage());
        }
    }
}