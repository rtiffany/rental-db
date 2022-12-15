package com.rentaldb.table;

import com.rentaldb.mainApp.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EquipmentDAO {

    // Searches a piece of equipment by ID
    public static Equipment searchEquipment (String equipID) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM Equipment WHERE id="+equipID;

        try {
            ResultSet rsEquip = DBUtil.dbExecuteQuery(selectStmt);
            //System.out.println(rsEquip.getString(2));
            Equipment equipment = getEquipmentFromResultSet(rsEquip);
            return equipment;
        } catch (SQLException e) {
            System.out.println("EquipmentDAO searchEquipment sql error: " + e);
            throw e;
        }
    }

    //
    private static Equipment getEquipmentFromResultSet(ResultSet rs) throws SQLException {
        // Equipment equipment = null;
        Equipment equipment = new Equipment();
        if (rs.next()) {
            //asdf
            equipment.setId(rs.getInt("id"));
            equipment.setRate(rs.getDouble("rate"));
            equipment.setModel(rs.getString("model"));
            equipment.setMake(rs.getString("make"));
            equipment.setIsAvailable(rs.getBoolean("isAvailable"));
        }
        return equipment;
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
    // Select * from equipment operation
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

    }



}
