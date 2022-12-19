package com.rentaldb.table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Rentals {
    private IntegerProperty transactionID;
    private IntegerProperty customerID;
    private IntegerProperty employeeID;
    private IntegerProperty equipmentID;

    public Rentals() {
        this.transactionID = new SimpleIntegerProperty();
        this.customerID = new SimpleIntegerProperty();
        this.employeeID = new SimpleIntegerProperty();
        this.equipmentID = new SimpleIntegerProperty();
    }

    // transactionID
    public int getTransactionID() {
        return transactionID.get();
    }
    public void setTransactionID(int transactionID) {
        this.transactionID.set(transactionID);
    }
    public IntegerProperty transactionIDProperty() {
        return transactionID;
    }

    // customerid
    public int getCustomerID() {
        return customerID.get();
    }
    public void setCustomerID(int customerID) {
        this.customerID.set(customerID);
    }
    public IntegerProperty customerIDProperty() {
        return customerID;
    }

    // employeeID
    public int getEmployeeID() {
        return employeeID.get();
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID.set(employeeID);
    }
    public IntegerProperty employeeIDProperty() {
        return employeeID;
    }

    // equipment id
    public int getEquipmentID() {
        return equipmentID.get();
    }
    public void setEquipmentID(int equipmentID) {
        this.equipmentID.set(equipmentID);
    }
    public IntegerProperty equipmentIDProperty () {
        return equipmentID;
    }
}
