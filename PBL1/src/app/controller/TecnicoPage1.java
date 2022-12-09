package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class TecnicoPage1 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEditExcTec;

    @FXML
    private Button btnInserirTec;

    @FXML
    private Button btnListarTec;

    @FXML
    private Button btnReturnTec;

    @FXML
    void btnEditExcTecAction(ActionEvent event) throws Exception {
    	Parent fxmlEditarExcluirTec = FXMLLoader.load(getClass().getResource("/app/view/Tecnicos_EditarExcluirPage.fxml"));
    	Main.trocarTelas(fxmlEditarExcluirTec);
    }

    @FXML
    void btnInserirTecAction(ActionEvent event) throws Exception {
    	Parent fxmlInserirTec = FXMLLoader.load(getClass().getResource("/app/view/Tecnicos_InserirPage.fxml"));
    	Main.trocarTelas(fxmlInserirTec);
    }

    @FXML
    void btnListarTecAction(ActionEvent event) {
    	
    }

    @FXML
    void btnReturnTecAction(ActionEvent event) throws Exception {
    	Parent fxmlMainW = FXMLLoader.load(getClass().getResource("/app/view/MainWindow.fxml"));
    	Main.trocarTelas(fxmlMainW);
    }

    @FXML
    void initialize() {
        assert btnEditExcTec != null : "fx:id=\"btnEditarTec\" was not injected: check your FXML file 'TecnicoPage1.fxml'.";
        assert btnInserirTec != null : "fx:id=\"btnInserirTec\" was not injected: check your FXML file 'TecnicoPage1.fxml'.";
        assert btnListarTec != null : "fx:id=\"btnListarTec\" was not injected: check your FXML file 'TecnicoPage1.fxml'.";
        assert btnReturnTec != null : "fx:id=\"btnReturnTec\" was not injected: check your FXML file 'TecnicoPage1.fxml'.";

    }

}
