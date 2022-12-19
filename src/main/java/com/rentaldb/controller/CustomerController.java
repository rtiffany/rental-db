package com.rentaldb.controller;

import com.rentaldb.table.Customer;
import com.rentaldb.table.CustomerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;

public class CustomerController {

    @FXML
    private TableView customerTable;

    @FXML
    private TableColumn<Customer, String> customerFNameCol;

    @FXML
    private TableColumn<Customer, String> customerLNameCol;

    @FXML
    private TableColumn<Customer, Integer> customerNumCol;

    @FXML
    private TableColumn<Customer, String> customerPhoneNoCol;

    @FXML
    private void initialize() {
        customerNumCol.setCellValueFactory(cellData -> cellData.getValue().customerNumProperty().asObject());
        customerFNameCol.setCellValueFactory(cellData -> cellData.getValue().fnameProperty());
        customerLNameCol.setCellValueFactory(cellData -> cellData.getValue().lnameProperty());
        customerPhoneNoCol.setCellValueFactory(cellData -> cellData.getValue().phoneNumProperty());
    }


    @FXML
    void showAllCustomers(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Customer> customerData = CustomerDAO.showAllCustomers();
            populateCustomers(customerData);
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }
    }

    //
    // Util
    //

    private void populateCustomer (Customer customer) throws ClassNotFoundException{
        //Declare and ObservableList for table view
        ObservableList<Customer> customerData = FXCollections.observableArrayList();
        customerData.add(customer);
        customerTable.setItems(customerData);
    }

    // Shows a single employee
    @FXML
    private void populateAndShowCustomer(Customer customer) throws ClassNotFoundException {
        if (customer != null) {
            populateCustomer(customer);
        } else {
            // todo: add Label in Employee-view.fxml
            System.out.println("This Customer Does not Exist");
        }
    }

    private void populateCustomers (ObservableList<Customer> customerData) throws ClassNotFoundException {
        customerTable.setItems(customerData);
    }

}
