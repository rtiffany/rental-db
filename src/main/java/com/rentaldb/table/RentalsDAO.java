package com.rentaldb.table;

import com.rentaldb.mainApp.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentalsDAO {

    //
    // Util Functions
    //

    private static ObservableList<Rentals> getRentalsList(ResultSet rs) throws SQLException {
        ObservableList<Rentals> rentalList = FXCollections.observableArrayList();
        Rentals rentals = new Rentals();
        while (rs.next()) {
            rentals.setTransactionID(rs.getInt("transactionID"));
            rentals.setCustomerID(rs.getInt("customerID"));
            rentals.setEmployeeID(rs.getInt("employeeID"));
            rentals.setEquipmentID(rs.getInt("equipmentID"));
            rentalList.add(rentals);
        }
        return rentalList;
    }

    public static Rentals getRentalsFromResultSet(ResultSet rs) throws SQLException {
        Rentals rentals = new Rentals();
        if (rs.next()) {
            rentals.setTransactionID(rs.getInt("transactionID"));
            rentals.setCustomerID(rs.getInt("customerID"));
            rentals.setEmployeeID(rs.getInt("employeeID"));
            rentals.setEquipmentID(rs.getInt("equipmentID"));
        }
        return rentals;
    }

    //
    // Database Operations
    //

    public static ObservableList<Rentals> showAllRentals() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM Rentals";
        try {
            ResultSet rsRentals = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Rentals> rentalsList = getRentalsList(rsRentals);
            return rentalsList;
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }
    }

}
