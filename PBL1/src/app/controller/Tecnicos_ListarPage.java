package app.controller;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class Tecnicos_ListarPage {

    @FXML
    private Button btnReturn;

    @FXML
    private Label labelTotalTec;

    @FXML
    private TableView<?> tabelaTecnicos;

    @FXML
    void btnReturnAction(ActionEvent event) {
    	Main.trocarTelas("TecnicoPage1");
    }

    @FXML
    void exibirTecnicos(MouseEvent event) {

    }

}
