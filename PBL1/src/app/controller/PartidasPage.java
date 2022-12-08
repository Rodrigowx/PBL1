package app.controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import app.Funcoes;
import app.Main;
import app.model.Jogador;
import app.model.JogadorDAOImpl;
import app.model.Partida;
import app.model.PartidaGerenciar;
import app.model.Selecao;
import app.model.SelecaoDAOImpl;
import app.model.TecnicoDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PartidasPage extends popUpGolsCart {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");

	@FXML
	private Button btnAddPart;
	
	@FXML
	private Button btnListDelJog;
	
	@FXML
    private Button btnPopUp;
	
	@FXML
    private Button btnReturn;

	@FXML
	private TextField cartaoAmTime1;

	@FXML
	private TextField cartaoAmTime2;

	@FXML
	private TextField cartaoVTime1;

	@FXML
	private TextField cartaoVTime2;

	@FXML
	private ChoiceBox<String> choiceGrupoPart;

	private List<String> grupos = new ArrayList<>();

	private ObservableList<String> obsGrupos;

	@FXML
	private ComboBox<String> choicePartida;

	private List<String> partidasGrupo = new ArrayList<>();

	private ObservableList<String> obsPartidas;

	@FXML
	private DatePicker datePickerPart;

	@FXML
	private TextField golsTime1;

	@FXML
	private TextField golsTime2;

	@FXML
	private TextField horaPartida;

	@FXML
	private Label labelMessage;
	
	@FXML
    private Label labelTime1;

    @FXML
    private Label labelTime2;

	@FXML
	private TextField localPartida;

	@FXML
	void btnAddPartAction(ActionEvent event) {
		try {
			labelMessage.setTextFill(Color.RED);
			
			//tirando os valores informados
			String grupo = this.choiceGrupoPart.getValue();
			String partidaTimes = this.choicePartida.getValue();
			LocalDate getDate = this.datePickerPart.getValue();
			String horario = this.horaPartida.getText();
			String local = this.localPartida.getText();
			
			String golsTime1 = this.golsTime1.getText();
			String golsTime2 = this.golsTime2.getText();
			String cartVTime1 = this.cartaoVTime1.getText();
			String cartVTime2 = this.cartaoVTime2.getText();
			String cartATime1 = this.cartaoAmTime1.getText();
			String cartATime2 = this.cartaoAmTime2.getText();
			
			//verificação dos dados informados
			if (grupo == null || partidaTimes == null || getDate == null || horario.isBlank() || local.isBlank() ||
					golsTime1.isBlank() || golsTime2.isBlank() || cartVTime1.isBlank() || cartVTime2.isBlank() || 
						cartATime1.isBlank() || cartATime2.isBlank()) {
        		labelMessage.setText("Há espaços em branco!");
        		return;
			}
			
			//colocando a data no formato brasileiro
			String data = getDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			//encontrando o objeto seleção dos times da partida informados
			String[] selecoes = partidaTimes.split(" X ");
					
			Selecao time1 = SelecaoDAOImpl.verificaSelecao(selecoes[0]);
			Selecao time2 = SelecaoDAOImpl.verificaSelecao(selecoes[1]);
			
			//procurando o objeto da Partida informada pelo usuário na lista de Partidas geradas
			List<Partida> listaDePartidas = FaseGruposPage.getPartidasGeradas().get(grupo);
			Partida partidaEscolhida = null;
			for (Partida partAtual : listaDePartidas) {
				if (partAtual.getTime1().equals(time1.getNome()) && partAtual.getTime2().equals(time2.getNome())) {
					partidaEscolhida = partAtual;
				}
			}
			
			//setando as informações
			Date dataP = new Date();
			String codPart = sdf.format(dataP);
			partidaEscolhida.setCodPart(codPart);
			
			partidaEscolhida.setData(data);
			partidaEscolhida.setHorario(horario);
			partidaEscolhida.setLocal(local);
			
			// Inserindo partida em todos jogadores.
			Funcoes.inserirPartidaJog(partidaEscolhida, new SelecaoDAOImpl());
			
			/**
			 * COLOCAR AQUI A PARTE DOS GOLS E CARTÔES
			 */
			//verificar se fez tudoo, ver como
			
			
			PartidaGerenciar.inserir(partidaEscolhida);
			listaDePartidas.remove(partidaEscolhida);
			
			
			labelMessage.setTextFill(Color.GREEN);
        	labelMessage.setText("Partida cadastrada com Sucesso!"); 
			
		} catch(Exception e) {
			this.labelMessage.setText("Erro ao cadastrar partida!");
		}
		this.clearAll();
	}
	
	@FXML
    void btnListDelJogAction(ActionEvent event) throws Exception {
		Parent fxmlPartListExc = FXMLLoader.load(getClass().getResource("/app/view/partidaListarExcluirPage.fxml"));
		Main.trocarTelas1(fxmlPartListExc);
    }
	
	@FXML
    void btnPopUpAction(ActionEvent event) {
		
		//tirando os valores informados
		String partidaTimes = this.choicePartida.getValue();
		String grupo = this.choiceGrupoPart.getValue();
		
		Integer golsTime1 = this.golsTime1.getText();
		String golsTime2 = this.golsTime2.getText();
		String cartVTime1 = this.cartaoVTime1.getText();
		String cartVTime2 = this.cartaoVTime2.getText();
		String cartATime1 = this.cartaoAmTime1.getText();
		String cartATime2 = this.cartaoAmTime2.getText();
		
		String[] selecoes = partidaTimes.split(" X ");
		
		Selecao time1 = SelecaoDAOImpl.verificaSelecao(selecoes[0]);
		Selecao time2 = SelecaoDAOImpl.verificaSelecao(selecoes[1]);
		
		//procurando o objeto da Partida informada pelo usuário na lista de Partidas geradas
		List<Partida> listaDePartidas = FaseGruposPage.getPartidasGeradas().get(grupo);
		Partida partida = null;
		for (Partida partAtual : listaDePartidas) {
			if (partAtual.getTime1().equals(time1.getNome()) && partAtual.getTime2().equals(time2.getNome())) {
				partida = partAtual;
			}
		}
		
		this.cadastrarGols(partida, time1, time2, golsTime1, golsTime2);
		this.cadastrarCartoes(partida, totalCartVTime1, totalCartVTime2, totalCartATime1, totalCartATime2);
    }
	
	@FXML
    void atualizarLabels(MouseEvent event) {
		String partidaTimes = choicePartida.getValue();
		if (partidaTimes != null) {
			String[] selecoes = partidaTimes.split(" X ");
		
			Selecao time1 = SelecaoDAOImpl.verificaSelecao(selecoes[0]);
			Selecao time2 = SelecaoDAOImpl.verificaSelecao(selecoes[1]);
		
			labelTime1.setText(time1.getNome().toUpperCase());
			labelTime2.setText(time2.getNome().toUpperCase());
			
			if (!(golsTime1.getText().isBlank() || golsTime2.getText().isBlank() || cartaoVTime1.getText().isBlank() 
					|| cartaoVTime2.getText().isBlank() || cartaoAmTime1.getText().isBlank() || cartaoAmTime2.getText().isBlank())) {
				this.btnPopUp.setDisable(false);
			}
			
		}
    }

	@FXML
	void exibirPartidasDoGrupo(MouseEvent event) {
		this.partidasGrupo.clear(); //limpa a lista para o comboBox para não exibir as mesmo itens
		carregarPartidas();
	}
	
	@FXML
    void btnReturnAction(ActionEvent event) throws Exception {
		Parent fxmlFaseGrupos = FXMLLoader.load(getClass().getResource("/app/view/FaseGruposPage.fxml"));
    	Main.trocarTelas1(fxmlFaseGrupos);
    }

	@FXML
	void initialize() {
		carregarGrupos();
		this.btnPopUp.setDisable(true);
	}

	public void carregarGrupos() {
		grupos.add("A");
		grupos.add("B");
		grupos.add("C");
		grupos.add("D");
		grupos.add("E");
		grupos.add("F");
		grupos.add("G");
		grupos.add("H");

		obsGrupos = FXCollections.observableArrayList(grupos);
		choiceGrupoPart.setItems(obsGrupos);
	}

	
	public void carregarPartidas() {	
		try {
			
			String grupo = this.choiceGrupoPart.getValue();
			
			if (grupo != null) {
				List<Partida> partidas = FaseGruposPage.getPartidasGeradas().get(grupo);

				// pegando os times das partidas geradas do grupo para exibir nas opções do
				// choiche box
				
				for (int i = 0; i < partidas.size(); i++) {
					partidasGrupo.add(partidas.get(i).getTime1() + " X " + partidas.get(i).getTime2());
				}

				obsPartidas = FXCollections.observableArrayList(partidasGrupo);
				choicePartida.setItems(obsPartidas);
			
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void clearAll() {
		this.choiceGrupoPart.setValue(null);
		this.choicePartida.setValue(null);
		this.datePickerPart.setValue(null);
		this.horaPartida.clear();
		this.localPartida.clear();
		this.golsTime1.clear();
		this.golsTime2.clear();
		this.cartaoVTime1.clear();
		this.cartaoVTime2.clear();
		this.cartaoAmTime1.clear();
		this.cartaoAmTime2.clear();
		this.btnPopUp.setDisable(true);
	}

}
