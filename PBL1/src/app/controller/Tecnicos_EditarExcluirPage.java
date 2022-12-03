package app.controller;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Tecnicos_EditarExcluirPage {

    @FXML
    private Button btnDelTec;

    @FXML
    private Button btnEditTec;

    @FXML
    private Button btnReturn;

    @FXML
    private ChoiceBox<?> choiceSelTec;

    @FXML
    private Label labelMessage;

    @FXML
    private TextField nomeTec;

    @FXML
    private TableView<?> tabelaTecnicos;

    @FXML
    void btnDelTecAction(ActionEvent event) {

    }

    @FXML
    void btnEditTecAction(ActionEvent event) {

    }

    @FXML
    void btnReturnAction(ActionEvent event) {
    	Main.trocarTelas("TecnicoPage1");
    }

    @FXML
    void choiceBoxSelecoes(MouseEvent event) {

    }

    @FXML
    void exibirTecnicos(MouseEvent event) {

    }

}
