module com.example.polinamueller_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.polinamueller_javafx to javafx.fxml;
    exports com.example.polinamueller_javafx;
}