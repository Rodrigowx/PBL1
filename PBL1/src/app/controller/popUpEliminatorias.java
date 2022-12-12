package app.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class popUpEliminatorias {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSim;

    @FXML
    void btnSimAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnSim != null : "fx:id=\"btnSim\" was not injected: check your FXML file 'popUpEliminatorias.fxml'.";

    }

}
