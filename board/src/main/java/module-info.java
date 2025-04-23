module com.work {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    
    opens com.work to javafx.base, javafx.graphics, javafx.fxml;
    opens com.work.Controller to javafx.fxml;
    opens com.work.DTO to javafx.base;
    exports com.work;
}
