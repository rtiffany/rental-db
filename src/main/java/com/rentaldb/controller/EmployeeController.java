package com.rentaldb.controller;

import com.rentaldb.table.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmployeeController {

    //
    // Table
    //

    @FXML
    private TableView employeeTable;

    @FXML
    private TableColumn<Employee, Integer> employeeSSNCol;

    @FXML
    private TableColumn<Employee, Integer> employeeIdCol;

    @FXML
    private TableColumn<Employee, String> employeeFnameCol;

    @FXML
    private TableColumn<Employee, String> employeeLnameCol;

    @FXML
    private TableColumn<Employee, String> employeeLicCol;

    @FXML
    private TableColumn<Employee, Boolean> employeeDotStatusCol;


    //
    // TextFields
    //

    @FXML
    private TextField employeeSearchField;

    @FXML
    private TextField employeeSSNField;

    @FXML
    private TextField employeeIdField;

    @FXML
    private TextField employeeFnameField;

    @FXML
    private TextField employeeLnameField;

    @FXML
    private TextField employeeLicNumField;

    @FXML
    private TextField employeeDotStatusField;

    //
    // Initialize
    //

    @FXML
    private void initialize() {
        employeeSSNCol.setCellValueFactory(cellData -> cellData.getValue().ssnProperty().asObject());
        employeeIdCol.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        employeeFnameCol.setCellValueFactory(cellData -> cellData.getValue().fnameProperty());
        employeeLnameCol.setCellValueFactory(cellData -> cellData.getValue().lnameProperty());
        employeeLicCol.setCellValueFactory(cellData -> cellData.getValue().licenseNumProperty());
        employeeDotStatusCol.setCellValueFactory(cellData -> cellData.getValue().dotStatusProperty());
        // todo: populate table on login
    }

    //
    // Button functions
    //









}
