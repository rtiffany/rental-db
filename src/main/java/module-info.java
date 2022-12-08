module com.rentaldb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.rentaldb.mainApp to javafx.fxml;
    exports com.rentaldb.mainApp;
    exports com.rentaldb.controller;
    opens com.rentaldb.controller to javafx.fxml;
}