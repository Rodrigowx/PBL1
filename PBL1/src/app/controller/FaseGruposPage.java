package app.controller;

import java.util.List;
import java.util.Map;

import app.Main;
import app.model.FaseGrupos;
import app.model.Partida;
import app.model.PartidaGerenciar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
    
    private static Stage stage = new Stage();
    
    @FXML
    void btnClassificaAction(ActionEvent event) {

    }

    @FXML
    void btnEliminatoriasAction(ActionEvent event) throws Exception {
    	Integer totalPartidas = PartidaGerenciar.getMapPartidas().size();
    	
    	//chamar função de verificação PartidaGerenciar - todasPartidasCadastradas
    	if (null) {
    		labelMessage.setText("Não é possível ir para as Fases Eliminatórias, pois ainda faltam cadastrar " + " partidas!");
    	} else {
    		//abrir popUp para o usuário confirmar			
			Parent fxmlPopUpEl = FXMLLoader.load(getClass().getResource("/app/view/popUpEliminatorias.fxml"));
			Scene scene = new Scene(fxmlPopUpEl);
			
			stage.setScene(scene);
			stage.setResizable(false);
			stage.showAndWait();
    	}
    	
    	//fazer um if e colocar isso dentro do else
    	Parent fxmlEliminatorias = FXMLLoader.load(getClass().getResource("/app/view/EliminatoriasPage.fxml"));
    	Main.trocarTelas(fxmlEliminatorias);
    }

    @FXML
    void btnListAction(ActionEvent event) throws Exception {
    	Parent fxmlListagens = FXMLLoader.load(getClass().getResource("/app/view/ListagensPage.fxml"));
    	Main.trocarTelas(fxmlListagens);
    }

    @FXML
    void btnPartidasAction(ActionEvent event) throws Exception {
    	Parent fxmlPartidas = FXMLLoader.load(getClass().getResource("/app/view/PartidasPage.fxml"));
    	Main.trocarTelas(fxmlPartidas);
    }

	public static Map<String, List<Partida>> getPartidasGeradas() {
		return PartidasGeradas;
	}
	
	public static void fecharPopUp() {
    	stage.close();
    }

}
