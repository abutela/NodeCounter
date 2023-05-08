module com.example.nodecounter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires javafx.media;

    opens com.example.nodecounter to javafx.fxml;
    exports com.example.nodecounter;
}