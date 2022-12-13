package com.rentaldb.table;

import javafx.beans.property.*;

import java.sql.Date;

public class Employee {

    private IntegerProperty ssn;
    private IntegerProperty id;
    private StringProperty fname;
    private StringProperty lname;
    private IntegerProperty license_num;
    private SimpleObjectProperty<Date> dob;
    private SimpleObjectProperty<Date> date_of_hire;
    private StringProperty dot_status;

    public Employee () {
        this.ssn = new SimpleIntegerProperty();
        this.id = new SimpleIntegerProperty();
        this.fname = new SimpleStringProperty();
        this.lname = new SimpleStringProperty();
        this.license_num = new SimpleIntegerProperty();
        this.dob = new SimpleObjectProperty<>();
        this.date_of_hire = new SimpleObjectProperty<>();
        this.dot_status = new SimpleStringProperty();
    }

    // ssn
    public int getSSN() {
        return ssn.get();
    }
    public void setSSN(int ssn) {
        this.ssn.set(ssn);
    }
    public IntegerProperty ssnProperty() {
        return ssn;
    }

    // id
    public int getId() {
        return id.get();
    }
    public void setId(int id) {
        this.id.set(id);
    }
    public IntegerProperty idProperty() {
        return id;
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
    public void setLLame(String lname) {
        this.lname.set(lname);
    }
    public StringProperty lnameProperty() {
        return lname;
    }

    // license_num
    public int getLicenseNum() {
        return license_num.get();
    }
    public void setLicenseNum(int licenseNum) {
        this.license_num.set(licenseNum);
    }
    public IntegerProperty licenseNumProperty() {
        return license_num;
    }

    // dob
    public Object getDOB() {
        return dob.get();
    }
    public void setDOB(Date dob) {
        this.dob.set(dob);
    }
    public SimpleObjectProperty<Date> dobProperty() {
        return dob;
    }

    // date_of_hire
    public Object getDateOfHire() {
        return date_of_hire.get();
    }
    public void setDateOfHire(Date dateOfHire) {
        this.date_of_hire.set(dateOfHire);
    }
    public SimpleObjectProperty<Date> dateOfHireProperty() {
        return date_of_hire;
    }

    // dot_status
    public String getDotStatus() {
        return dot_status.get();
    }
    public void setDotStatus(String dotStatus) {
        this.dot_status.set(dotStatus);
    }
    public StringProperty dotStatusProperty() {
        return dot_status;
    }
}
