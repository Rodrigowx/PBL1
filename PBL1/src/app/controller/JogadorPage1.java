package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class JogadorPage1 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEditarJog;

    @FXML
    private Button btnExcluirJog;

    @FXML
    private Button btnInserirJog;

    @FXML
    private Button btnListarJog;

    @FXML
    private Button btnReturnJog;

    @FXML
    void btnEditarJogAction(ActionEvent event) {

    }

    @FXML
    void btnExcluirJogAction(ActionEvent event) {

    }

    @FXML
    void btnInserirJogAction(ActionEvent event) {

    }

    @FXML
    void btnListarJogAction(ActionEvent event) {

    }

    @FXML
    void btnReturnJogAction(ActionEvent event) {
    	Main.trocarTelas("MainWindow");
    }

    @FXML
    void initialize() {
        assert btnEditarJog != null : "fx:id=\"btnEditarJog\" was not injected: check your FXML file 'JogadorPage1.fxml'.";
        assert btnExcluirJog != null : "fx:id=\"btnExcluirJog\" was not injected: check your FXML file 'JogadorPage1.fxml'.";
        assert btnInserirJog != null : "fx:id=\"btnInserirJog\" was not injected: check your FXML file 'JogadorPage1.fxml'.";
        assert btnListarJog != null : "fx:id=\"btnListarJog\" was not injected: check your FXML file 'JogadorPage1.fxml'.";
        assert btnReturnJog != null : "fx:id=\"btnReturnJog\" was not injected: check your FXML file 'JogadorPage1.fxml'.";

    }

}
