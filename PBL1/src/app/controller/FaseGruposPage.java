package app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import app.Main;
import app.model.FaseGrupos;
import app.model.Partida;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FaseGruposPage {
	
	private static Map<String, List<Partida>> PartidasGeradas = FaseGrupos.gerarPartidas();

	@FXML
    private Button btnClassifica;
	
	@FXML
    private Button btnEliminatorias;

    @FXML
    private Button btnList;

    @FXML
    private Button btnPartidas;
    
    @FXML
    private Label labelMessage;
    
    @FXML
    void btnClassificaAction(ActionEvent event) {

    }

    @FXML
    void btnEliminatoriasAction(ActionEvent event) throws Exception {
    	
    	//chamar função de verificação PartidaGerenciar - todasPartidasCadastradas
    	
    	//fazer um if e colocar isso dentro do else
    	Parent fxmlEliminatorias = FXMLLoader.load(getClass().getResource("/app/view/EliminatoriasPage.fxml"));
    	Main.trocarTelas(fxmlEliminatorias);
    }

    @FXML
    void btnListAction(ActionEvent event) throws Exception {
    	
    }

    @FXML
    void btnPartidasAction(ActionEvent event) throws Exception {
    	Parent fxmlPartidas = FXMLLoader.load(getClass().getResource("/app/view/PartidasPage.fxml"));
    	Main.trocarTelas(fxmlPartidas);
    	//Main.trocarTelas("PartidasPage");
    }

	public static Map<String, List<Partida>> getPartidasGeradas() {
		return PartidasGeradas;
	}

}
