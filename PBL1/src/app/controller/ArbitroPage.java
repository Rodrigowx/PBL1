package app.controller;

import java.io.IOException;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    void btnReturnAction(ActionEvent event) throws Exception {
    	Parent fxmlMainW = FXMLLoader.load(getClass().getResource("/app/view/MainWindow.fxml"));
    	Main.trocarTelas(fxmlMainW);
    }

    @FXML
    void exibirArbitros(MouseEvent event) {

    }

}
