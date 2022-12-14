package com.rentaldb.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmployeeController {

    @FXML
    private TableColumn<?, ?> employeeDotStatusCol;

    @FXML
    private TextField employeeDotStatusField;

    @FXML
    private TableColumn<?, ?> employeeFnameCol;

    @FXML
    private TextField employeeFnameField;

    @FXML
    private TableColumn<?, ?> employeeIdCol;

    @FXML
    private TextField employeeIdField;

    @FXML
    private TableColumn<?, ?> employeeLicCol;

    @FXML
    private TextField employeeLicNumField;

    @FXML
    private TableColumn<?, ?> employeeLnameCol;

    @FXML
    private TextField employeeLnameField;

    @FXML
    private TableColumn<?, ?> employeeSSNCol;

    @FXML
    private TextField employeeSSNField;

    @FXML
    private Button employeeSearchButton;

    @FXML
    private TextField employeeSearchField;

    @FXML
    private TableView<?> employeeTable;

    @FXML
    private Button showAllButton;

    @FXML
    private Button showAvailableButton;

    @FXML
    private Button showUnavailableButton;

}
