package app.controller;

import app.Main;
import app.model.Jogador;
import app.model.JogadorDAOImpl;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Tecnicos_EditarExcluirPage extends Tecnicos_InserirPage {

	@FXML
	private Button btnDelTec;

	@FXML
	private Button btnEditTec;

	@FXML
	private Button btnReturn;

	@FXML
	private ChoiceBox<String> choiceSelTec;

	@FXML
	private Label labelMessage;

	@FXML
	private TextField nomeTec;

	@FXML
	private TableView<Tecnico> tabelaTecnicos;

	private ObservableList<Tecnico> dadosTecnicos;

	@FXML
	void btnDelTecAction(ActionEvent event) {
		
		try {
			labelMessage.setTextFill(Color.RED);
			int tecIndex = this.tabelaTecnicos.getSelectionModel().getSelectedIndex();
			
			if (tecIndex >= 0) {
				Tecnico selectedTec = this.dadosTecnicos.get(tecIndex);
				
				TecnicoDAO.excluir(selectedTec.getNome());
				
			} else { //caso o usuário não tenha selecionado nada, um erro é exibido
				this.labelMessage.setText("Selecione um Técnico na tabela!");
				return;
			}
			
			labelMessage.setTextFill(Color.GREEN);
	    	labelMessage.setText("Técnico Excluído com sucesso!");
			
		} catch(Exception e) {
			this.labelMessage.setText("Não foi possível excluir o Técnico!");
			return;
		}
		
    	this.exibirTecnicos(null);
	}

	@FXML
	void btnEditTecAction(ActionEvent event) {
		try {
			labelMessage.setTextFill(Color.RED);
			int tecIndex = this.tabelaTecnicos.getSelectionModel().getSelectedIndex();
			Tecnico selectedTec;
			
			String novoNomeTec = this.nomeTec.getText();
    		String nomeSelecao = this.choiceSelTec.getValue();
    		Selecao novaSelecaoTec = SelecaoDAOImpl.verificaTecnico(nomeSelecao);
			
			if (tecIndex >= 0) {
				selectedTec = this.dadosTecnicos.get(tecIndex);
				
			} else { //caso o usuário não tenha selecionado nada, um erro é exibido
				this.labelMessage.setText("Selecione um Técnico na tabela!");
				return;
			}
			
			if (novoNomeTec.isBlank() && nomeSelecao == null) {
        		labelMessage.setText("Espaços em branco!");
        		return;
    		} else if (TecnicoDAOImpl.checarNome(novoNomeTec)) {
				labelMessage.setText("Esse Técnico já está cadastrado!");
				return;
			} else if (nomeSelecao != null && novaSelecaoTec == null) {
				labelMessage.setText("Essa Selecao já possui um Técnico!");
				return;
			}
			
			TecnicoDAO.editar(selectedTec.getNome(), novoNomeTec, novaSelecaoTec);
			labelMessage.setTextFill(Color.GREEN);
	    	labelMessage.setText("Técnico Editado com sucesso!");
			
		} catch(Exception e) {
			this.labelMessage.setText("Não foi possível editar o Técnico!");
			return;
		}
		
    	this.exibirTecnicos(null);
	}

	@FXML
	void btnReturnAction(ActionEvent event) {
		Main.trocarTelas("TecnicoPage1");
	}

	@FXML
	void exibirTecnicos(MouseEvent event) {
		this.dadosTecnicos = FXCollections.observableArrayList(TecnicoDAOImpl.getLista1());
		this.tabelaTecnicos.setItems(dadosTecnicos);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML
	void initialize() {
		// Adicionando as colunas na tabela
		TableColumn nomeCol = new TableColumn("Nome");
		TableColumn selecaoCol = new TableColumn("Seleção");

		nomeCol.setCellValueFactory(new PropertyValueFactory<Jogador, String>("nome"));
		selecaoCol.setCellValueFactory(new PropertyValueFactory<Jogador, String>("selecao"));

		this.tabelaTecnicos.getColumns().addAll(nomeCol, selecaoCol);
	}

}
