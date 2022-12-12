package app.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.Funcoes;
import app.Main;
import app.model.Partida;
import app.model.PartidaGerenciar;
import app.model.Selecao;
import app.model.SelecaoDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class PartidasOitavasPage {

	@FXML
	private Button btnAddPart;

	@FXML
	private Button btnListDelPart;

	@FXML
	private Button btnReturn;

	@FXML
	private ComboBox<Selecao> choiceGanhador;
	
	private List<Selecao> timesPartida = new ArrayList<>();

	private ObservableList<Selecao> obsTimes;

	@FXML
	private ChoiceBox<String> choiceGruposOitavas;

	private List<String> grupos = new ArrayList<>();

	private ObservableList<String> obsGrupos;

	@FXML
	private ComboBox<String> choicePartida;

	private List<String> partidasGrupo = new ArrayList<>();

	private ObservableList<String> obsPartidas;

	@FXML
	private ComboBox<Integer> comboGolsTime1;

	@FXML
	private ComboBox<Integer> comboGolsTime2;

	@FXML
	private DatePicker datePickerPart;

	@FXML
	private TextField horaPartida;

	@FXML
	private Label labelExibirTime1;

	@FXML
	private Label labelExibirTime2;

	@FXML
	private Label labelMessage;

	@FXML
	private TextField localPartida;

	@FXML
	void atualizarLabels(MouseEvent event) {
		String partidaTimes = choicePartida.getValue();
		if (partidaTimes != null) {
			String[] selecoes = partidaTimes.split(" X ");

			Selecao time1 = SelecaoDAOImpl.verificaSelecao(selecoes[0]);
			Selecao time2 = SelecaoDAOImpl.verificaSelecao(selecoes[1]);

			this.labelExibirTime1.setText(time1.getNome().toUpperCase());
			this.labelExibirTime2.setText(time2.getNome().toUpperCase());
			
			//atualizando o choice de ganhador
			this.timesPartida.add(time1);
			this.timesPartida.add(time2);
			
			obsTimes = FXCollections.observableArrayList(timesPartida);
			choiceGanhador.setItems(obsTimes);
		}
	}

	@FXML
	void btnAddPartAction(ActionEvent event) {
		try {
			labelMessage.setTextFill(Color.RED);

			// tirando os valores informados
			String grupo = this.choiceGruposOitavas.getValue();
			String partidaTimes = this.choicePartida.getValue();
			LocalDate getDate = this.datePickerPart.getValue();
			String horario = this.horaPartida.getText();
			String local = this.localPartida.getText();
			
			Integer golsTime1 = this.comboGolsTime1.getValue();
			Integer golsTime2 = this.comboGolsTime2.getValue();
			
			Selecao ganhador = choiceGanhador.getValue();

			// verificação dos dados informados
			if (verificaEspacos()) {
				return;
			}

			// colocando a data no formato brasileiro
			String data = getDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			// encontrando o objeto seleção dos times da partida informados
			String[] selecoes = partidaTimes.split(" X ");

			Selecao time1 = SelecaoDAOImpl.verificaSelecao(selecoes[0]);
			Selecao time2 = SelecaoDAOImpl.verificaSelecao(selecoes[1]);

			// buscando a partida na lista de partidas geradas das Oitavas
			

			// setando as informações
			
			
			labelMessage.setTextFill(Color.GREEN);
			labelMessage.setText("Partida Oitavas cadastrada com sucesso!");

		} catch (Exception e) {
			this.labelMessage.setText("Erro ao cadastrar partida!");
		}
	}

	@FXML
	void btnListDelPartAction(ActionEvent event) {

	}

	@FXML
	void btnReturnAction(ActionEvent event) throws Exception {
		Parent fxmlEliminatorias = FXMLLoader.load(getClass().getResource("/app/view/EliminatoriasPage.fxml"));
		Main.trocarTelas(fxmlEliminatorias);
	}

	@FXML
	void exibirPartidasDosGrupos(MouseEvent event) {
		carregarPartidas();
	}

	public void carregarGrupos() {
		grupos.add("A e B");
		grupos.add("C e D");
		grupos.add("E e F");
		grupos.add("G e H");

		obsGrupos = FXCollections.observableArrayList(grupos);
		choiceGruposOitavas.setItems(obsGrupos);
	}

	public void carregarPartidas() {
		// buscando a lista onde está armazenado as partidas geradas das oitavas de
		// final

		obsPartidas = FXCollections.observableArrayList(partidasGrupo);
		choicePartida.setItems(obsPartidas);
	}

	public boolean verificaEspacos() {

		if (this.choiceGruposOitavas.getValue() == null || this.choicePartida.getValue() == null
				|| this.datePickerPart.getValue() == null || this.horaPartida.getText().isBlank()
					|| this.localPartida.getText().isBlank()) {
			
			labelMessage.setText("Há espaços em branco!");
			return true;
		}
		return false;
	}

	@FXML
	void initialize() {
		carregarGrupos();
	}

}
