package app.controller;

import java.io.IOException;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EliminatoriasPage {

    @FXML
    private Button btnFinal;

    @FXML
    private Button btnListar;

    @FXML
    private Button btnOitavas;

    @FXML
    private Button btnQuartas;

    @FXML
    private Button btnSemis;

    @FXML
    private Label labelMessage;

    @FXML
    void btnFinalAction(ActionEvent event) throws Exception {
    	//verificar se todas as partidas das semis estão cadastradas
    	
    	Parent fxmlFinal = FXMLLoader.load(getClass().getResource("/app/view/PartidaFinalPage.fxml"));
    	Main.trocarTelas(fxmlFinal);
    }

    @FXML
    void btnListarAction(ActionEvent event) {

    }

    @FXML
    void btnOitavasAction(ActionEvent event) throws Exception {
    	Parent fxmlOitavas = FXMLLoader.load(getClass().getResource("/app/view/PartidasOitavasPage.fxml"));
    	Main.trocarTelas(fxmlOitavas);
    }

    @FXML
    void btnQuartasAction(ActionEvent event) {

    }

    @FXML
    void btnSemisAction(ActionEvent event) {

    }

}
