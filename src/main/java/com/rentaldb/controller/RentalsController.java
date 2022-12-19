package com.rentaldb.controller;

import com.rentaldb.table.Employee;
import com.rentaldb.table.Rentals;
import com.rentaldb.table.RentalsDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;

public class RentalsController {

    @FXML
    private TableView rentalsTable;

    @FXML
    private TableColumn<Rentals, Integer> rentalsCustomerIDCol;

    @FXML
    private TableColumn<Rentals, Integer> rentalsEmployeeIDCol;

    @FXML
    private TableColumn<Rentals, Integer> rentalsEquipmentIDCol;

    @FXML
    private TableColumn<Rentals, Integer> rentalsTransactionIDCol;

    @FXML
    private Button showAllRentals;

    @FXML
    private void initialize() {
        rentalsTransactionIDCol.setCellValueFactory(cellData -> cellData.getValue().transactionIDProperty().asObject());
        rentalsCustomerIDCol.setCellValueFactory(cellData -> cellData.getValue().customerIDProperty().asObject());
        rentalsEmployeeIDCol.setCellValueFactory(cellData -> cellData.getValue().employeeIDProperty().asObject());
        rentalsEquipmentIDCol.setCellValueFactory(cellData -> cellData.getValue().equipmentIDProperty().asObject());
    }

    @FXML
    void showAllCustomers(ActionEvent event) throws SQLException, ClassNotFoundException{
        try {
            ObservableList<Rentals> rentalsData = RentalsDAO.showAllRentals();
            populateRentals(rentalsData);
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }

    }




    //
    // Util
    //

    private void populateRentals (Rentals rentals) throws ClassNotFoundException{
        //Declare and ObservableList for table view
        ObservableList<Rentals> rentalsData = FXCollections.observableArrayList();
        rentalsData.add(rentals);
        rentalsTable.setItems(rentalsData);
    }

    // Shows a single employee
    @FXML
    private void populateAndShowRentals(Rentals rentals) throws ClassNotFoundException {
        if (rentals != null) {
            populateRentals(rentals);
        } else {
            // todo: add Label in Employee-view.fxml
            System.out.println("This Rentals Does not Exist");
        }
    }

    private void populateRentals (ObservableList<Rentals> rentalData) throws ClassNotFoundException {
        rentalsTable.setItems(rentalData);
    }

}
