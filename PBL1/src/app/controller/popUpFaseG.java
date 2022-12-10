package app.controller;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class popUpFaseG {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSim;
    
    private static Stage stageHere;

    @FXML
    void btnCancelAction(ActionEvent event) throws Exception {
    	Parent fxmlMainW = FXMLLoader.load(getClass().getResource("/app/view/MainWindow.fxml"));
    	Main.trocarTelas(fxmlMainW);
    	stageHere.close();
    }

    @FXML
    void btnSimAction(ActionEvent event) throws Exception {
    	Parent fxmlFaseGrupos = FXMLLoader.load(getClass().getResource("/app/view/FaseGruposPage.fxml"));
    	Main.trocarTelas(fxmlFaseGrupos);
    }

    public static void fechar(Stage stage) {
    	stageHere = stage;
    }
}
