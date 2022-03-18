module se2203b.assignments.adminapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens se2203b.assignments.adminapp to javafx.fxml;
    exports se2203b.assignments.adminapp;
}