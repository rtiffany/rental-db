package com.rentaldb.table;

import com.rentaldb.mainApp.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentDAO {

    //
    // EquipmentDAO Util Functions
    //

    private static ObservableList<Equipment> getEquipmentList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Equipment> equipList = FXCollections.observableArrayList();
        while (rs.next()) {
            Equipment equipment = new Equipment();
            equipment.setId(rs.getInt("id"));
            equipment.setRate(rs.getDouble("rate"));
            equipment.setModel(rs.getString("model"));
            equipment.setMake(rs.getString("make"));
            equipment.setIsAvailable(rs.getBoolean("isAvailable"));
            equipList.add(equipment);
        }
        return equipList;
    }

    private static Equipment getEquipmentFromResultSet(ResultSet rs) throws SQLException {
        Equipment equipment = new Equipment();
        if (rs.next()) {
            equipment.setId(rs.getInt("id"));
            equipment.setRate(rs.getDouble("rate"));
            equipment.setModel(rs.getString("model"));
            equipment.setMake(rs.getString("make"));
            equipment.setIsAvailable(rs.getBoolean("isAvailable"));
        }
        return equipment;
    }


    //
    // Select Statements
    //


    // Searches a piece of equipment by ID
    public static Equipment searchEquipment (String equipID) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM Equipment WHERE id="+equipID;

        try {
            ResultSet rsEquip = DBUtil.dbExecuteQuery(selectStmt);
            Equipment equipment = getEquipmentFromResultSet(rsEquip);
            return equipment;
        } catch (SQLException e) {
            System.out.println("EquipmentDAO searchEquipment sql error: " + e);
            throw e;
        }
    }

    // Show all Equipment
    public static ObservableList<Equipment> showAllEquipment() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM Equipment";

        try {
            ResultSet rsEquip = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Equipment> equipList = getEquipmentList(rsEquip);
            return equipList;
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }
    }

    public static ObservableList<Equipment> showAvailableEquipment() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM Equipment WHERE isAvailable=1";

        try {
            ResultSet rsEquip = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Equipment> equipList = getEquipmentList(rsEquip);
            return equipList;
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }
    }

    public static ObservableList<Equipment> showUnavailableEquipment() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM Equipment WHERE isAvailable=0";

        try {
            ResultSet rsEquip = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Equipment> equipList = getEquipmentList(rsEquip);
            return equipList;
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }
    }


    //
    // Database Modify
    //

    public static void insertEquipment (Double rate, String model, String make, Boolean isAvailable) throws SQLException, ClassNotFoundException {
        String insertStmt = "INSERT INTO Equipment\n" +
                "(id, rate, model, make, isAvailable)\n" +
                "VALUES\n" +
                "(NULL, " + rate + ", '" + model + "', '" + make + "', " + isAvailable + ");";
        // Execute INSERT Operation
        try {
            DBUtil.dbExecuteUpdate(insertStmt);
        } catch (SQLException e) {
            System.out.println("insertEquipment sql error: " + e);
            throw e;
        }
    }

    public static void updateEquipment (Integer id, Double rate, String model, String make, Boolean isAvailable) throws SQLException, ClassNotFoundException {
        String updateStmt = "UPDATE Equipment set rate = " + rate + ", model = '" + model + "', make = '" + make + "', isAvailable=" + isAvailable +
                " WHERE id=" + id + ";";
        // Do DB operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.println("update equipment sql error: " + e);
            throw e;
        }
    }

    public static void deleteEquipmentById (int equipmentId) throws SQLException, ClassNotFoundException {
        // Delete Statement
        String deleteStmt = "DELETE FROM Equipment WHERE id=" + equipmentId + ";";
        // Execute Statement
        try {
            DBUtil.dbExecuteUpdate(deleteStmt);
        } catch (SQLException e) {
            System.out.println("deleteEquipmentById sql error: " + e);
            throw e;
        }
    }
}
