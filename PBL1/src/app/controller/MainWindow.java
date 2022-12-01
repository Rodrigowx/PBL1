package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnArbitros;

    @FXML
    private Button btnFaseG;

    @FXML
    private Button btnJogadores;

    @FXML
    private Button btnPreSet;

    @FXML
    private Button btnSelecoes;

    @FXML
    private Button btnTecnicos;

    @FXML
    void goArbitrosPage1(ActionEvent event) {
    	Main.trocarTelas("ArbitroPage1");
    }

    @FXML
    void goFaseGruposPage1(ActionEvent event) {

    }

    @FXML
    void goJogadoresPage1(ActionEvent event) {
    	Main.trocarTelas("JogadorPage1"); 	
    }

    @FXML
    void goSelecoesPage1(ActionEvent event) { 
    	Main.trocarTelas("SelecoesPage1");
    }

    @FXML
    void goTecnicosPage1(ActionEvent event) {
    	Main.trocarTelas("TecnicoPage1");
    }

    @FXML
    void preSetAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnArbitros != null : "fx:id=\"btnArbitros\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnFaseG != null : "fx:id=\"btnFaseG\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnJogadores != null : "fx:id=\"btnJogadores\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnPreSet != null : "fx:id=\"btnPreSet\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnSelecoes != null : "fx:id=\"btnSelecoes\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnTecnicos != null : "fx:id=\"btnTecnicos\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }

}
