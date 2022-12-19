package com.rentaldb.controller;

import com.rentaldb.table.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.SQLException;

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

    @FXML
    void showAllEmployees(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Employee> employeeData = EmployeeDAO.showAllEmployees();
            populateEmployees(employeeData);
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }



    }





    //
    // Util
    //

    private void populateEmployee (Employee employee) throws ClassNotFoundException{
        //Declare and ObservableList for table view
        ObservableList<Employee> employeeData = FXCollections.observableArrayList();
        employeeData.add(employee);
        employeeTable.setItems(employeeData);
    }

    // Shows a single employee
    @FXML
    private void populateAndShowEmployee(Employee employee) throws ClassNotFoundException {
        if (employee != null) {
            populateEmployee(employee);
        } else {
            // todo: add Label in Employee-view.fxml
            System.out.println("This Employee Does not Exist");
        }
    }

    private void populateEmployees (ObservableList<Employee> employeeData) throws ClassNotFoundException {
        employeeTable.setItems(employeeData);
    }








}
