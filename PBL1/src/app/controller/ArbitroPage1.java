package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ArbitroPage1 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEditarArb;

    @FXML
    private Button btnExcluirArb;

    @FXML
    private Button btnInserirArb;

    @FXML
    private Button btnListarArb;

    @FXML
    private Button btnReturnArb;

    @FXML
    void btnEditarArbAction(ActionEvent event) {

    }

    @FXML
    void btnExcluirArbAction(ActionEvent event) {

    }

    @FXML
    void btnInserirArbAction(ActionEvent event) {

    }

    @FXML
    void btnListarArbAction(ActionEvent event) {

    }

    @FXML
    void btnReturnArbAction(ActionEvent event) {
    	Main.trocarTelas("MainWindow");
    }

    @FXML
    void initialize() {
        assert btnEditarArb != null : "fx:id=\"btnEditarArb\" was not injected: check your FXML file 'ArbitroPage1.fxml'.";
        assert btnExcluirArb != null : "fx:id=\"btnExcluirArb\" was not injected: check your FXML file 'ArbitroPage1.fxml'.";
        assert btnInserirArb != null : "fx:id=\"btnInserirArb\" was not injected: check your FXML file 'ArbitroPage1.fxml'.";
        assert btnListarArb != null : "fx:id=\"btnListarArb\" was not injected: check your FXML file 'ArbitroPage1.fxml'.";
        assert btnReturnArb != null : "fx:id=\"btnReturnArb\" was not injected: check your FXML file 'ArbitroPage1.fxml'.";

    }

}
