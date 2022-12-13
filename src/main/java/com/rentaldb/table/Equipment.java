package com.rentaldb.table;

import javafx.beans.property.*;

public class Equipment {

    private IntegerProperty id;
    private DoubleProperty rate;
    private StringProperty model;
    private StringProperty make;
    private BooleanProperty isAvailable;

    public Equipment() {
        this.id = new SimpleIntegerProperty();
        this.rate = new SimpleDoubleProperty();
        this.model = new SimpleStringProperty();
        this.make = new SimpleStringProperty();
        this.isAvailable = new SimpleBooleanProperty();
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

    // rate
    public double getRate() {
        return rate.get();
    }
    public void setRate(double rate) {
        this.rate.set(rate);
    }
    public DoubleProperty rateProperty() {
        return rate;
    }

    // model
    public String getModel() {
        return model.get();
    }
    public void setModel(String model) {
        this.model.set(model);
    }
    public StringProperty modelProperty() {
        return model;
    }

    // make
    public String getMake() {
        return make.get();
    }
    public void setMake(String make) {
        this.make.set(make);
    }
    public StringProperty makeProperty() {
        return make;
    }

    // is available

    public Boolean getIsAvailable() {
        return isAvailable.get();
    }
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable.set(isAvailable);
    }
    public BooleanProperty isAvailableProperty() {
        return isAvailable;
    }
}
