package com.rentaldb.table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {

    private IntegerProperty customer_num;
    private StringProperty fname;
    private StringProperty lname;
    private StringProperty phone_num;

    public Customer() {
        this.customer_num = new SimpleIntegerProperty();
        this.fname = new SimpleStringProperty();
        this.lname = new SimpleStringProperty();
        this.phone_num = new SimpleStringProperty();
    }

    // customer_num
    public int getCustomerNum() {
        return customer_num.get();
    }
    public void setCustomerNum(int customerNum) {
        this.customer_num.set(customerNum);
    }
    public IntegerProperty customerNumProperty() {
        return customer_num;
    }

    // fname
    public String getFName() {
        return fname.get();
    }
    public void setFName(String fname) {
        this.fname.set(fname);
    }
    public StringProperty fnameProperty() {
        return fname;
    }

    // lname
    public String getLName() {
        return lname.get();
    }
    public void setLName(String lname) {
        this.lname.set(lname);
    }
    public StringProperty lnameProperty() {
        return lname;
    }

    // phone_num
    public String getPhoneNum() {
        return phone_num.get();
    }
    public void setPhoneNum(String phoneNum) {
        this.phone_num.set(phoneNum);
    }
    public StringProperty phoneNumProperty() {
        return phone_num;
    }
}
