package com.rentaldb.controller;

import com.rentaldb.table.EmployeeDAO;
import com.rentaldb.table.Equipment;

import com.rentaldb.table.EquipmentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class EquipmentController {

    @FXML
    private TextField equipmentIdField;

    @FXML
    private TextField equipmentIsAvailField;

    @FXML
    private TextField equipmentMakeField;

    @FXML
    private TextField equipmentModelField;

    @FXML
    private TextField equipmentRateField;

    @FXML
    private Button equipmentSearchButton;

    @FXML
    private TextField equipmentSearchField;

    @FXML
    private Button showAllButton;

    @FXML
    private Button showAvailableButton;

    @FXML
    private Button showUnavailableButton;

    @FXML
    private Button insertEquipmentButton;

    @FXML
    private Button updateEquipmentButton;

    @FXML
    private Button deleteEquipmentButton;

    // Table
    @FXML
    private TableView equipmentTable;
    @FXML
    private TableColumn<Equipment, Integer> equipIdCol;
    @FXML
    private TableColumn<Equipment, Boolean> equipIsAvailCol;
    @FXML
    private TableColumn<Equipment, String> equipMakeCol;
    @FXML
    private TableColumn<Equipment, String> equipModelCol;
    @FXML
    private TableColumn<Equipment, Double> equipRateCol;

    @FXML
    private void initialize() {
        equipIdCol.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        equipRateCol.setCellValueFactory(cellData -> cellData.getValue().rateProperty().asObject());
        equipModelCol.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        equipMakeCol.setCellValueFactory(cellData -> cellData.getValue().makeProperty());
        equipIsAvailCol.setCellValueFactory(cellData -> cellData.getValue().isAvailableProperty());
        // todo: populate table on login
    }

    @FXML
    private void searchEquipment (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            // Get equipment info
            Equipment equipment = EquipmentDAO.searchEquipment(equipmentSearchField.getText());
            // Populate Equipment on TableView
            // Todo: populate on TextFields
            populateAndShowEquipment(equipment);
        } catch (SQLException e) {
            // e.printStackTrace();
            System.out.println("controller searchEqipment sql error: ");
            throw e;
        }
    }

    @FXML
    private void showAllEquipment (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            ObservableList<Equipment> equipData = EquipmentDAO.showAllEquipment();
            populateEquipments(equipData);
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }
    }

    @FXML
    private void showAvailableEquipment (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            ObservableList<Equipment> equipData = EquipmentDAO.showAvailableEquipment();
            populateEquipments(equipData);
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }
    }

    @FXML
    private void showUnavailableEquipment (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            ObservableList<Equipment> equipData = EquipmentDAO.showUnavailableEquipment();
            populateEquipments(equipData);
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }
    }

    private void populateEquipment(Equipment equip) throws ClassNotFoundException{
        //Declare and ObservableList for table view
        ObservableList<Equipment> equipData = FXCollections.observableArrayList();
        //Add equipment to the ObservableList
        equipData.add(equip);
        //Set items to the equipmentTable
        equipmentTable.setItems(equipData);
    }

    // Shows a single employee
    @FXML
    private void populateAndShowEquipment(Equipment equipment) throws ClassNotFoundException {
        if (equipment != null) {
            populateEquipment(equipment);
        } else {
            // Todo: add Label in Equipment-view.fxml
            System.out.println("This Employee Does not Exist");
        }
    }

    private void populateEquipments (ObservableList<Equipment> equipData) throws ClassNotFoundException {
        equipmentTable.setItems(equipData);
    }

    @FXML
    private void insertEquipment(ActionEvent event) throws SQLException, ClassNotFoundException {
        Double rate = Double.valueOf(equipmentRateField.getText());
        String model = equipmentModelField.getText();
        String make = equipmentMakeField.getText();
        Boolean isAvailable = true;
        EquipmentDAO.insertEquipment(rate, model, make, isAvailable);
    }

    @FXML
    private void updateEquipment (ActionEvent event) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(equipmentIdField.getText());
        Double rate = Double.valueOf(equipmentRateField.getText());
        String model = equipmentModelField.getText();
        String make = equipmentMakeField.getText();
        Boolean isAvailable = Boolean.valueOf(equipmentIsAvailField.getText());
        EquipmentDAO.updateEquipment(id, rate, model, make, isAvailable);
    }

    @FXML
    private void deleteEquipmentById (ActionEvent event) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(equipmentIdField.getText());
        EquipmentDAO.deleteEquipmentById(id);
    }
}