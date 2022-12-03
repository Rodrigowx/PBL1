package app.controller;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Tecnicos_InserirPage {

    @FXML
    private Button btnAddTec;

    @FXML
    private Button btnReturn;

    @FXML
    private ChoiceBox<?> choiceSelTec;

    @FXML
    private Label labelMessage;

    @FXML
    private TextField nomeTec;

    @FXML
    void btnAddTecAction(ActionEvent event) {

    }

    @FXML
    void btnReturnAction(ActionEvent event) {
    	Main.trocarTelas("TecnicoPage1");
    }

    @FXML
    void choiceBoxSelecoes(MouseEvent event) {

    }

}
