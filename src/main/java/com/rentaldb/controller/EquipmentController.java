package com.rentaldb.controller;

import com.rentaldb.mainApp.rentaldb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EquipmentController {

    public EquipmentController() {

    }

    @FXML
    void onEmployeesButtonClick(ActionEvent event) throws IOException {
        System.out.println("test");
        Parent windowParent = FXMLLoader.load(rentaldb.class.getResource("Employee-view.fxml"));
        Scene employeeScene = new Scene(windowParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Employees");
        window.setScene(employeeScene);
    }

    @FXML
    void onEquipmentAddButtonClick(ActionEvent event) {

    }

    @FXML
    void onEquipmentCheckInOutButtonClick(ActionEvent event) {

    }

    @FXML
    void onEquipmentEditButtonClick(ActionEvent event) throws IOException {

    }

    @FXML
    void onEquipmentSalesButtonClick(ActionEvent event) throws IOException {
        System.out.println("test");
        Parent windowParent = FXMLLoader.load(rentaldb.class.getResource("Equipment-view.fxml"));
        Scene equipmentScene = new Scene(windowParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Equipment Sales");
        window.setScene(equipmentScene);
    }

}