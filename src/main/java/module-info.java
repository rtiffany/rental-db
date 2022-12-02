module com.example.rentaldb {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.rentaldb.hello to javafx.fxml;
    exports com.rentaldb.hello;
}