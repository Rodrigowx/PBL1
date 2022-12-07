package app.controller;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ArbitroPage {

    @FXML
    private Button btnAddArb;

    @FXML
    private Button btnDelArb;

    @FXML
    private Button btnEditArb;

    @FXML
    private Button btnReturn;

    @FXML
    private Label labelMessage;

    @FXML
    private TextField nomeArb;

    @FXML
    private TableView<String> tabelaArbitros;

    @FXML
    void btnAddArbAction(ActionEvent event) {

    }

    @FXML
    void btnDelArbAction(ActionEvent event) {

    }

    @FXML
    void btnEditArbAction(ActionEvent event) {

    }

    @FXML
    void btnReturnAction(ActionEvent event) {
    	Main.trocarTelas("MainWindow");
    }

    @FXML
    void exibirArbitros(MouseEvent event) {

    }

}
