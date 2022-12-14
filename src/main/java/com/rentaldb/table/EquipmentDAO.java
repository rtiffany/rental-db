package com.rentaldb.table;

import com.rentaldb.mainApp.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentDAO {

    public static Equipment searchEquipment (String equipID) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM Equipment where id="+equipID;

        try {
            ResultSet rsEquip = DBUtil.dbExecuteQuery(selectStmt);
            Equipment equipment = getEquipmentFromResultSet(rsEquip);
            return equipment;
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }
    }

    private static Equipment getEquipmentFromResultSet(ResultSet rs) throws SQLException {
        Equipment equipment = null;
        if (rs.next()) {
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



}
