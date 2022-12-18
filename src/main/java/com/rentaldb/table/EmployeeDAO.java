package com.rentaldb.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    //
    // Util Functions
    //

    private static ObservableList<Employee> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Employee> empList = FXCollections.observableArrayList();
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setSSN(rs.getInt("ssn"));
            employee.setId(rs.getInt("id"));
            employee.setFName(rs.getString("fname"));
            employee.setLName(rs.getString("lname"));
            // todo: add more
            empList.add(employee);
        }
        return empList;
    }


}
