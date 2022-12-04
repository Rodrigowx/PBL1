package app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.Main;
import app.model.Jogador;
import app.model.JogadorDAOImpl;
import app.model.PartidaJogador;
import app.model.Selecao;
import app.model.SelecaoDAOImpl;
import app.model.Tecnico;
import app.model.TecnicoDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Tecnicos_InserirPage {
	
	protected static TecnicoDAOImpl TecnicoDAO = new TecnicoDAOImpl();

    @FXML
    private Button btnAddTec;

    @FXML
    private Button btnReturn;

    @FXML
    private ChoiceBox<String> choiceSelTec;
    
    private List<String> nomesSelecoes = new ArrayList<>();
    
    private ObservableList<String> obsSelecoes;

    @FXML
    private Label labelMessage;

    @FXML
    private TextField nomeTec;

    @FXML
    void btnAddTecAction(ActionEvent event) {
    	try {
    		labelMessage.setTextFill(Color.RED);
    		String nomeTecnico = this.nomeTec.getText();
    		String nomeSelecao = this.choiceSelTec.getValue();
    		Selecao selecaoTec = SelecaoDAOImpl.verificaTecnico(nomeSelecao);
    		
    		//verificando se os espaços estão vazios, se esse jogador já está cadastrado ou se já alcançou o total de 26 jogadores por seleção
    		if (nomeTecnico.isBlank() || nomeSelecao == null) {
        		labelMessage.setText("Espaços em branco!");
        		return;
    		} else if (TecnicoDAOImpl.checarNome(nomeTecnico)) {
				labelMessage.setText("Esse Técnico já está cadastrado!");
				return;
			} else if (selecaoTec == null) {
				labelMessage.setText("Essa Selecao já possui um Técnico!");
				return;
			}
    		
    		Tecnico novoTecnico = new Tecnico(nomeTecnico);
    		
    		this.TecnicoDAO.inserir(novoTecnico);
    		selecaoTec.setTecnico(novoTecnico);
    		
    		labelMessage.setTextFill(Color.GREEN);
        	labelMessage.setText("Técnico Inserido com Sucesso!"); 

		} catch (Exception e) {
			this.labelMessage.setText("Não foi possível cadastrar o Técnico!");
		}
    	
    	this.nomeTec.clear();
		this.choiceSelTec.setValue(null);
    }

    @FXML
    void btnReturnAction(ActionEvent event) {
    	labelMessage.setText("");
    	Main.trocarTelas("TecnicoPage1");
    }

    @FXML
    void choiceBoxSelecoes(MouseEvent event) {
    	nomesSelecoes = SelecaoDAOImpl.getLista2();
    	obsSelecoes = FXCollections.observableArrayList(nomesSelecoes);
    	choiceSelTec.setItems(obsSelecoes);
    	
    	//Avisando ao usuário que não é possível cadastrar um Técnico pois não há seleções cadastradas
    	if (nomesSelecoes.isEmpty()) {
    		labelMessage.setText("Ainda não há Seleções cadastradas!");
    	}
    }

}
