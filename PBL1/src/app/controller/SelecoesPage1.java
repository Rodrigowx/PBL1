package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SelecoesPage1 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEditarSel;

    @FXML
    private Button btnExcluirSel;

    @FXML
    private Button btnInserirSel;

    @FXML
    private Button btnListarSel;

    @FXML
    private Button btnReturn;

    @FXML
    void btnEditarSelAction(ActionEvent event) {

    }

    @FXML
    void btnExcluirSelAction(ActionEvent event) {

    }

    @FXML
    void btnInserirSelAction(ActionEvent event) {
    	Main.trocarTelas("Selecoes_InserirPage");
    }

    @FXML
    void btnListarSelAction(ActionEvent event) {

    }

    @FXML
    void btnReturnAction(ActionEvent event) {
    	Main.trocarTelas("MainWindow");
    }

    @FXML
    void initialize() {
        assert btnEditarSel != null : "fx:id=\"btnEditarSel\" was not injected: check your FXML file 'SelecoesPage1.fxml'.";
        assert btnExcluirSel != null : "fx:id=\"btnExcluirSel\" was not injected: check your FXML file 'SelecoesPage1.fxml'.";
        assert btnInserirSel != null : "fx:id=\"btnInserirSel\" was not injected: check your FXML file 'SelecoesPage1.fxml'.";
        assert btnListarSel != null : "fx:id=\"btnListarSel\" was not injected: check your FXML file 'SelecoesPage1.fxml'.";
        assert btnReturn != null : "fx:id=\"btnReturn\" was not injected: check your FXML file 'SelecoesPage1.fxml'.";

    }

}
