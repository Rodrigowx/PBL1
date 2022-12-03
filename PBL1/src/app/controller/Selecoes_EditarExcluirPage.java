package app.controller;

import java.util.ArrayList;
import java.util.List;

import app.Main;
import app.model.Jogador;
import app.model.Selecao;
import app.model.SelecaoDAOImpl;
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

public class Selecoes_EditarExcluirPage extends Selecoes_InserirPage {

    @FXML
    private TextField novoNomeSel;

    @FXML
    private Button btnDelSel;

    @FXML
    private Button btnEditSel;

    @FXML
    private Button btnReturn;
    
    @FXML
    private ChoiceBox<String> choiceGrupoSel;

    @FXML
    private ChoiceBox<String> choiceSelecoes;
    
    private List<String> nomesSelecoes = new ArrayList<>();
    
    private ObservableList<String> obsSelecoes;

    @FXML
    private Label labelMessage;

    @FXML
    void btnDelSelAction(ActionEvent event) {
    	try {
    		labelMessage.setTextFill(Color.RED);
    		
    		String escolhaSelecao = this.choiceSelecoes.getValue();    		
    		
    		//verificando se a choice box está vazia
    		if (escolhaSelecao == null) {
        		labelMessage.setText("Espaço em branco!");
        		return;
    		}
    		Selecoes_InserirPage.SelecaoDAO.excluir(escolhaSelecao);//excluindo a seleção

		} catch (Exception e) {
			this.labelMessage.setText("Não foi possível excluir a Seleção!");
		}
   	
    	labelMessage.setTextFill(Color.GREEN);
    	labelMessage.setText("Seleção Excluída com Sucesso!");
    	this.novoNomeSel.clear();
		this.choiceSelecoes.setValue(null);
    }

    @FXML
    void btnEditSelAction(ActionEvent event) {
    	try {
    		labelMessage.setTextFill(Color.RED);
    		
    		String escolhaSelecao = this.choiceSelecoes.getValue();      		
    		Selecao selecaoObj = SelecaoDAOImpl.verificaSelecao(escolhaSelecao);//pega o objeto da seleção escolhida
    		
    		String novoNome = novoNomeSel.getText();
    		String novoGrupo = choiceGrupoSel.getValue();
    		
    		//verificando se os espaços estão vazios, se o grupo informado já está completo (com 4 seleções) e se o nome é repetido
    		if (escolhaSelecao == null || novoNome.isBlank() || novoGrupo == null) {
        		labelMessage.setText("Espaços em branco!");
        		return;
    		} else if (GruposCRUD.verificaGrupos(novoGrupo) && !(selecaoObj.getGrupo().equals(novoGrupo))) {
				labelMessage.setText("Esse Grupo já está completo!");
				return;
			} else if (SelecaoDAOImpl.checarNome(novoNome)) {
				labelMessage.setText("Essa Selecao já está cadastrada!");
				return;
			}
    		
    		Selecoes_InserirPage.SelecaoDAO.editar(escolhaSelecao, novoNome, novoGrupo);//editando a seleção

		} catch (Exception e) {
			this.labelMessage.setText("Não foi possível editar a Seleção!");
		}
   	
    	labelMessage.setTextFill(Color.GREEN);
    	labelMessage.setText("Seleção Editada com Sucesso!");
    	this.novoNomeSel.clear();
		this.choiceSelecoes.setValue(null);
    }

    @FXML
    void btnReturnAction(ActionEvent event) {
    	Main.trocarTelas("SelecoesPage1");
    }
    
    //função para carregar as seleções na choice box e atualizar a cada vez que ela é clicada
    @FXML
    void choiceBoxSelecoes(MouseEvent event) {
    	nomesSelecoes = SelecaoDAOImpl.getLista2();
    	obsSelecoes = FXCollections.observableArrayList(nomesSelecoes);
    	choiceSelecoes.setItems(obsSelecoes);
    }

}
