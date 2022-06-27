module com.sys.facsys {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens system to javafx.fxml;
    exports system;
    exports controller;
    opens controller to javafx.fxml;
}