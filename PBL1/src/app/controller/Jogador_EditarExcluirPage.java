package app.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Jogador_EditarExcluirPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDelJog;

    @FXML
    private Button btnEditJog;

    @FXML
    private Button btnReturn;

    @FXML
    private ChoiceBox<?> choicePosicao;

    @FXML
    private ChoiceBox<?> choiceSelJog;

    @FXML
    private Label labelMessage;

    @FXML
    private TextField nomeJog;

    @FXML
    private TableView<?> tabelaJogadores;

    @FXML
    void btnDelJogAction(ActionEvent event) {

    }

    @FXML
    void btnEditJogAction(ActionEvent event) {

    }

    @FXML
    void btnReturnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnDelJog != null : "fx:id=\"btnDelJog\" was not injected: check your FXML file 'Jogador_EditarExcluirPage.fxml'.";
        assert btnEditJog != null : "fx:id=\"btnEditJog\" was not injected: check your FXML file 'Jogador_EditarExcluirPage.fxml'.";
        assert btnReturn != null : "fx:id=\"btnReturn\" was not injected: check your FXML file 'Jogador_EditarExcluirPage.fxml'.";
        assert choicePosicao != null : "fx:id=\"choicePosicao\" was not injected: check your FXML file 'Jogador_EditarExcluirPage.fxml'.";
        assert choiceSelJog != null : "fx:id=\"choiceSelJog\" was not injected: check your FXML file 'Jogador_EditarExcluirPage.fxml'.";
        assert labelMessage != null : "fx:id=\"labelMessage\" was not injected: check your FXML file 'Jogador_EditarExcluirPage.fxml'.";
        assert nomeJog != null : "fx:id=\"nomeJog\" was not injected: check your FXML file 'Jogador_EditarExcluirPage.fxml'.";
        assert tabelaJogadores != null : "fx:id=\"tabelaJogadores\" was not injected: check your FXML file 'Jogador_EditarExcluirPage.fxml'.";

    }

}
