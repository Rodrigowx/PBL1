package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import app.Funcoes;
import app.model.Jogador;
import app.model.Partida;
import app.model.Selecao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class popUpGolsCart {

	@FXML
	private Button btnOk;

	@FXML
	private ComboBox<Jogador> choiceJogador = new ComboBox<>();

	private List<Jogador> jogadoresTime = new ArrayList<>();

	private ObservableList<Jogador> obsJogadores;

	@FXML
	private Label labelFaltam = new Label();

	@FXML
	private Label labelExibir = new Label();

	@FXML
	private Label labelQuantJog = new Label();

	@FXML
	private Label labelQuantTotal = new Label();

	@FXML
	private Label labelSelectJog = new Label();

	@FXML
	private Label labelTimes = new Label();

	@FXML
	private Label labelTotal = new Label();

	@FXML
	private ProgressBar progressBar;

	@FXML
	private ComboBox<Integer> quantJog = new ComboBox<>();

	private List<Integer> quantCombo = new ArrayList<>();

	private ObservableList<Integer> obsQuant;

	public void popGolsTime(Partida partida, Selecao time, int total, ActionEvent event) {

		this.labelExibir.setText("GOLS");
		this.labelTimes.setText(time.getNome().toUpperCase());
		this.labelTotal.setText("TOTAL DE GOLS:");
		this.labelQuantTotal.setText("" + total);
		this.labelSelectJog.setText("SELECIONE UM JOGADOR QUE MARCOU GOL:");
		this.labelQuantJog.setText("QUANTOS GOLS ESSE JOGADOR FEZ?");
		this.carregarJogadores(time);

		int faltam = total;

		while (faltam != 0) {
			Jogador jogador = null;
			int quantGols = 0;
			
			// exibindo a quantidade no combo box
			for (Integer i = 1; i <= faltam; i++) {
				quantCombo.add(i);
			}
			obsQuant = FXCollections.observableArrayList(quantCombo);
			choiceJogador.setItems(obsJogadores);
			
			if (choiceJogador.getValue() != null && quantJog.getValue() != null) {
				jogador = this.choiceJogador.getValue();
				quantGols = this.quantJog.getValue();
			}

			Funcoes.cadastrarGolsPartida(jogador, quantGols, partida, time);
			this.labelFaltam.setText("FALTAM" + faltam + "GOLS");
			faltam = faltam - quantGols;
			abrirPopUp();
		}
	}

	public void popCartaoVTime(Selecao time, int total) {
		this.labelExibir.setText("CARTÕES VERMELHOS");
		this.labelTimes.setText(time.getNome().toUpperCase());
		this.labelTotal.setText("TOTAL CARTÕES:");
		this.labelQuantTotal.setText(null);
		this.labelSelectJog.setText("SELECIONE UM JOGADOR QUE RECEBEU CARTÃO VERMELHO:");
		this.labelQuantJog.setText("QUANTOS CARTÕES FORAM?");
		// this.labelFaltam.setText("FALTAM" + quant + "CARTÕES");

		abrirPopUp();
	}

	public void popCartaoAmTime1(Selecao time, int total) {
		this.labelExibir.setText("CARTÕES AMARELOS");
		this.labelTimes.setText(time.getNome().toUpperCase());
		this.labelTotal.setText("TOTAL CARTÕES:");
		this.labelQuantTotal.setText(null);
		this.labelSelectJog.setText("SELECIONE UM JOGADOR QUE RECEBEU CARTÃO AMARELO:");
		this.labelQuantJog.setText("QUANTOS CARTÕES FORAM?");
		// this.labelFaltam.setText("FALTAM" + quant + "CARTÕES");

		abrirPopUp();
	}

	public void cadastrarGols(Partida partida, Selecao time1, Selecao time2, int totalGolsTime1, int totalGolsTime2, ActionEvent event) {
		//popGolsTime(partida, time1, totalGolsTime1);
		popGolsTime(partida, time2, totalGolsTime2, event);

	}

	@FXML
	void initialize() {

	}

	public void abrirPopUp() {
		try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/popUpGolsCart.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setTitle("Gols e Cartôes");

			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.show();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void carregarJogadores(Selecao time) {
		try {
			jogadoresTime = time.getJogadores();

			obsJogadores = FXCollections.observableArrayList(jogadoresTime);
			choiceJogador.setItems(obsJogadores);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
