module com.example.test1bloginpage {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.test1bloginpage to javafx.fxml;
    exports com.example.test1bloginpage;
}