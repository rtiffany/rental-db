module com.example.rentaldb {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.rentaldb to javafx.fxml;
    exports com.example.rentaldb;
}