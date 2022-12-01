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
    private Button btnEditExcJog;

    @FXML
    private Button btnInserirJog;

    @FXML
    private Button btnListarJog;

    @FXML
    private Button btnReturnJog;

    @FXML
    void btnEditExcJogAction(ActionEvent event) {
    	Main.trocarTelas("Jogador_EditarExcluirPage");
    }

    @FXML
    void btnInserirJogAction(ActionEvent event) {
    	Main.trocarTelas("Jogador_InserirPage");
    }

    @FXML
    void btnListarJogAction(ActionEvent event) {
    	Main.trocarTelas("Jogador_ListarPage");
    }

    @FXML
    void btnReturnJogAction(ActionEvent event) {
    	Main.trocarTelas("MainWindow");
    }

    @FXML
    void initialize() {
        assert btnEditExcJog != null : "fx:id=\"btnEditarJog\" was not injected: check your FXML file 'JogadorPage1.fxml'.";
        assert btnInserirJog != null : "fx:id=\"btnInserirJog\" was not injected: check your FXML file 'JogadorPage1.fxml'.";
        assert btnListarJog != null : "fx:id=\"btnListarJog\" was not injected: check your FXML file 'JogadorPage1.fxml'.";
        assert btnReturnJog != null : "fx:id=\"btnReturnJog\" was not injected: check your FXML file 'JogadorPage1.fxml'.";

    }

}
