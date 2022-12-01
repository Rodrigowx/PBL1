package app.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class Jogador_ListarPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnReturn;

    @FXML
    private TableView<?> tabelaJogadores;

    @FXML
    void btnReturnAction(ActionEvent event) {

    }

    @FXML
    void exibirJogadores(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert btnReturn != null : "fx:id=\"btnReturn\" was not injected: check your FXML file 'Jogador_ListarPage.fxml'.";
        assert tabelaJogadores != null : "fx:id=\"tabelaJogadores\" was not injected: check your FXML file 'Jogador_ListarPage.fxml'.";

    }

}
