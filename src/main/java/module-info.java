module com.javamemorystack.javamemorystack {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javamemorystack.javamemorystack to javafx.fxml;
    exports com.javamemorystack.javamemorystack;
}