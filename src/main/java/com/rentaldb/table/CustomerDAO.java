package com.rentaldb.table;

import com.rentaldb.mainApp.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    //
    // CustomerDAO Util Functions
    //

    private static ObservableList<Customer> getCustomerList(ResultSet rs) throws SQLException {
        ObservableList<Customer> custList = FXCollections.observableArrayList();
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setCustomerNum(rs.getInt("customer_num"));
            customer.setFName(rs.getString("fname"));
            customer.setLName(rs.getString("lname"));
            customer.setPhoneNum(rs.getString("phone_num"));
            custList.add(customer);
        }
        return custList;
    }

    private static Customer getCustomerFromResultSet(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        if (rs.next()) {
            customer.setCustomerNum(rs.getInt("customer_num"));
            customer.setFName(rs.getString("fname"));
            customer.setLName("lname");
            customer.setPhoneNum(rs.getString("phone_num"));
        }
        return customer;
    }

    //
    // Select Statements
    //

    public static ObservableList<Customer> showAllCustomers() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM Customer";

        try {
            ResultSet rsCustomer = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Customer> customerList = getCustomerList(rsCustomer);
            return customerList;
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }
    }
}
