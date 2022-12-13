package com.rentaldb.controller;

import com.rentaldb.table.Equipment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DatabaseController {

    @FXML
    private TableView equipmentTable;
    @FXML
    private TableColumn<Equipment, Integer> equipIdCol;

    @FXML
    private TableColumn<Equipment, Boolean> equipIsAvailableCol;

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
        equipIsAvailableCol.setCellValueFactory(cellData -> cellData.getValue().isAvailableProperty());
    }

    private void populateEquipment(Equipment equip) throws ClassNotFoundException{
        //Declare and ObservableList for table view
        ObservableList<Equipment> empData = FXCollections.observableArrayList();
        //Add equipment to the ObservableList
        empData.add(equip);
        //Set items to the equipmentTable
        equipmentTable.setItems(empData);
    }








}
