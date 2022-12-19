package com.rentaldb.table;

import com.rentaldb.mainApp.DBUtil;
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
        Employee employee = new Employee();
        while (rs.next()) {
            employee.setSSN(rs.getInt("ssn"));
            employee.setId(rs.getInt("id"));
            employee.setFName(rs.getString("fname"));
            employee.setLName(rs.getString("lname"));
            employee.setLicenseNum(rs.getString("license_num"));
            employee.setDOB(rs.getDate("dob"));
            employee.setDateOfHire(rs.getDate("date_of_hire"));
            employee.setDotStatus(rs.getBoolean("dot_status"));
            empList.add(employee);
        }
        return empList;
    }

    private static Employee getEmployeeFromResultSet(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        if (rs.next()) {
            employee.setSSN(rs.getInt("ssn"));
            employee.setId(rs.getInt("id"));
            employee.setFName(rs.getString("fname"));
            employee.setLName(rs.getString("lname"));
            employee.setLicenseNum(rs.getString("license_num"));
            employee.setDOB(rs.getDate("dob"));
            employee.setDateOfHire(rs.getDate("date_of_hire"));
            employee.setDotStatus(rs.getBoolean("dot_status"));
        }
        return employee;
    }

    //
    // Database Operations
    //

    public static ObservableList<Employee> showAllEmployees() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM Employee";

        try {
            ResultSet rsEquip = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Employee> employeeList = getEmployeeList(rsEquip);
            return employeeList;
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }
    }


}
