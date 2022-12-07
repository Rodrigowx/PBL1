package app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import app.Funcoes;
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

public class PartidasPage {

	@FXML
	private Button btnAddPart;

	@FXML
	private Button btnDelPart;

	@FXML
	private Button btnEditPart;

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
	private TextField localPartida;

	@FXML
	private TableView<Partida> tabelaPartidas;
	
	private ObservableList<Partida> dadosPartidas;

	@FXML
	void btnAddPartAction(ActionEvent event) {
		try {
			//tirando os valores informados
			String grupo = this.choiceGrupoPart.getValue();
			String partidaTimes = this.choicePartida.getValue();
			LocalDate getDate = this.datePickerPart.getValue();
			String horario = this.horaPartida.getText();
			String local = this.localPartida.getText();
			
			//verificação dos dados informados
			if (grupo == null || partidaTimes == null || getDate == null || horario.isBlank() || local.isBlank()) {
        		labelMessage.setText("Há espaços em branco!");
        		return;
			} else if (Funcoes.verificaHorario(horario)) {
				labelMessage.setText("Formato Inválido do Horário!");
				return;
			}
			
			//colocando a data no formato brasileiro
			String data = getDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			//encontrando o objeto seleção dos times da partida informados
			String[] selecoes = partidaTimes.split(" X ");
					
			Selecao time1 = SelecaoDAOImpl.verificaSelecao(selecoes[0]);
			Selecao time2 = SelecaoDAOImpl.verificaSelecao(selecoes[1]);
			
			//verificando se essa partida já está cadastrada
			if (PartidaGerenciar.verificaPartida(time1, time2)) {
				labelMessage.setText("Essa partida já está cadastrada!");
			}
			
			
			
			//lembrar de atualizar o map de partidas geradas, pra não mostra de novo no comboBox!! E também atualizar quando for excluir
			//Ouuuuu deixar a partida no comboBox se a pessoa quiser editar!! E a tabela seria mais pra listar mesmo e dixar editar e excluir no
			//combo box mesmo!
			
		} catch(Exception e) {
			this.labelMessage.setText("Erro ao cadastrar partida!");
		}
	}

	@FXML
	void btnDelPartAction(ActionEvent event) {

	}

	@FXML
	void btnEditPartAction(ActionEvent event) {

	}

	@FXML
	void exibirPartidasDoGrupo(MouseEvent event) {
		this.partidasGrupo.clear(); //limpa a lista para o comboBox para não exibir as mesmo itens
		carregarPartidas();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
	void initialize() {
		carregarGrupos();
		
		// Adicionando as colunas na tabela
     	TableColumn time1Col = new TableColumn("Time 1");
     	TableColumn gols1Col = new TableColumn("Gols");
     	TableColumn time2Col = new TableColumn("Time 2");
     	TableColumn gols2Col = new TableColumn("Gols");
     	TableColumn dataCol = new TableColumn("Data");
     	TableColumn horarioCol = new TableColumn("Horário");
     	TableColumn localCol = new TableColumn("Local");
     	TableColumn grupoCol = new TableColumn("Grupo");
     	

     	time1Col.setCellValueFactory(new PropertyValueFactory<Partida, String>("time1"));
     	gols1Col.setCellValueFactory(new PropertyValueFactory<Partida, Integer>("golsTime1"));
     	time2Col.setCellValueFactory(new PropertyValueFactory<Partida, String>("time2"));
     	gols2Col.setCellValueFactory(new PropertyValueFactory<Partida, Integer>("golsTime2"));
     	dataCol.setCellValueFactory(new PropertyValueFactory<Partida, String>("data"));
     	horarioCol.setCellValueFactory(new PropertyValueFactory<Partida, String>("horario"));
     	localCol.setCellValueFactory(new PropertyValueFactory<Partida, String>("local"));
     	grupoCol.setCellValueFactory(new PropertyValueFactory<Partida, String>("grupo"));

     	this.tabelaPartidas.getColumns().addAll(time1Col, gols1Col, time2Col, gols2Col, dataCol, horarioCol, localCol, grupoCol);
     	
     	//exibindo os dados na tabela
     	this.dadosPartidas = FXCollections.observableArrayList(PartidaGerenciar.getMapPartidas().values());
		this.tabelaPartidas.setItems(dadosPartidas);
		
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
				partidasGrupo.add(partidas.get(0).getTime1() + " X " + partidas.get(0).getTime2());
				partidasGrupo.add(partidas.get(1).getTime1() + " X " + partidas.get(1).getTime2());
				partidasGrupo.add(partidas.get(2).getTime1() + " X " + partidas.get(2).getTime2());
				partidasGrupo.add(partidas.get(3).getTime1() + " X " + partidas.get(3).getTime2());
				partidasGrupo.add(partidas.get(4).getTime1() + " X " + partidas.get(4).getTime2());
				partidasGrupo.add(partidas.get(5).getTime1() + " X " + partidas.get(5).getTime2());

				obsPartidas = FXCollections.observableArrayList(partidasGrupo);
				choicePartida.setItems(obsPartidas);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
