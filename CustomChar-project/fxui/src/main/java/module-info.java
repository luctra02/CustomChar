module customChar.ui {
    requires com.fasterxml.jackson.databind;

    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    requires customChar.core;

    opens customChar.ui to javafx.graphics, javafx.fxml;
}