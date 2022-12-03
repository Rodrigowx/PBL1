package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    void btnEditExcTecAction(ActionEvent event) {
    	Main.trocarTelas("Tecnicos_EditarExcluirPage");
    }

    @FXML
    void btnInserirTecAction(ActionEvent event) {
    	Main.trocarTelas("Tecnicos_InserirPage");
    }

    @FXML
    void btnListarTecAction(ActionEvent event) {
    	Main.trocarTelas("Tecnicos_ListarPage");
    }

    @FXML
    void btnReturnTecAction(ActionEvent event) {
    	Main.trocarTelas("MainWindow");
    }

    @FXML
    void initialize() {
        assert btnEditExcTec != null : "fx:id=\"btnEditarTec\" was not injected: check your FXML file 'TecnicoPage1.fxml'.";
        assert btnInserirTec != null : "fx:id=\"btnInserirTec\" was not injected: check your FXML file 'TecnicoPage1.fxml'.";
        assert btnListarTec != null : "fx:id=\"btnListarTec\" was not injected: check your FXML file 'TecnicoPage1.fxml'.";
        assert btnReturnTec != null : "fx:id=\"btnReturnTec\" was not injected: check your FXML file 'TecnicoPage1.fxml'.";

    }

}
