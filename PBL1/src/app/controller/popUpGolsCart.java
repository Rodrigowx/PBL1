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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class popUpGolsCart {

    @FXML
    private Button btnOk;
    
    @FXML
	private ComboBox<Jogador> choiceJogador;

	private List<Jogador> jogadoresTime = new ArrayList<>();

	private ObservableList<Jogador> obsJogadores;

    @FXML
    private Label labelFaltam;

    @FXML
    private Label labelGolOuCart;

    @FXML
    private Label labelQuantJog;

    @FXML
    private Label labelQuantTotal;

    @FXML
    private Label labelSelectJog;

    @FXML
    private Label labelTimes;

    @FXML
    private Label labelTotal;

    @FXML
    private ProgressBar progressBar;
    
    @FXML
    private ComboBox<Integer> quantJog;
    
    private List<Integer> quantCombo = new ArrayList<>();

	private ObservableList<Integer> obsQuant;
    
    public void popGolsTime(Partida partida, Selecao time, int total) {
    	
    	Jogador jogador = null;
    	Integer quantGols = null;
    	
    	this.labelGolOuCart.setText("GOLS");
    	this.labelTimes.setText(time.getNome().toUpperCase());
    	this.labelTotal.setText("TOTAL DE GOLS:");
    	this.labelQuantTotal.setText("" + total);
    	this.labelSelectJog.setText("SELECIONE UM JOGADOR QUE MARCOU GOL:");
    	this.labelQuantJog.setText("QUANTOS GOLS ESSE JOGADOR FEZ?");
    	this.carregarJogadores(time);
    	
    	int faltam = total;
    	
    	while(faltam != 0) {
    		jogador = this.choiceJogador.getValue();
        	quantGols = this.quantJog.getValue();
        	
        	//exibindo a quantidade no combo box
        	for (Integer i = 1; i <= faltam; i++) {
        		quantCombo.add(i);
        	}
        	obsQuant = FXCollections.observableArrayList(quantCombo);
			choiceJogador.setItems(obsJogadores);
        	
    		Funcoes.cadastrarGolsPartida(jogador, quantGols, partida, time);
    		this.labelFaltam.setText("FALTAM" + faltam + "GOLS");
    		faltam = faltam - quantGols;
    		abrirPopUp();
    	}
    }
    
    public void popCartaoVTime(Selecao time, int total) {
    	this.labelGolOuCart.setText("CARTÕES VERMELHOS");
    	this.labelTimes.setText(time.getNome().toUpperCase());
    	this.labelTotal.setText("TOTAL CARTÕES:");
    	this.labelQuantTotal.setText(null);
    	this.labelSelectJog.setText("SELECIONE UM JOGADOR QUE RECEBEU CARTÃO VERMELHO:");
    	this.labelQuantJog.setText("QUANTOS CARTÕES FORAM?");
    	//this.labelFaltam.setText("FALTAM" + quant + "CARTÕES");
    	
    	abrirPopUp();
    }
    
    public void popCartaoAmTime1(Selecao time, int total) {
    	this.labelGolOuCart.setText("CARTÕES AMARELOS");
    	this.labelTimes.setText(time.getNome().toUpperCase());
    	this.labelTotal.setText("TOTAL CARTÕES:");
    	this.labelQuantTotal.setText(null);
    	this.labelSelectJog.setText("SELECIONE UM JOGADOR QUE RECEBEU CARTÃO AMARELO:");
    	this.labelQuantJog.setText("QUANTOS CARTÕES FORAM?");
    	//this.labelFaltam.setText("FALTAM" + quant + "CARTÕES");
    	
    	abrirPopUp();
    }
    
    public void cadastrarGols(Partida partida, Selecao time1, Selecao time2, int totalGolsTime1, int totalGolsTime2) {
    	popGolsTime(partida, time1, totalGolsTime1);
    	popGolsTime(partida, time2, totalGolsTime2);
    	
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
