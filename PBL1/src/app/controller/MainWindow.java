package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import app.DadosArquivo.DadosPreCadastro;
import app.model.ArbitroDAOImpl;
import app.model.FaseGrupos;
import app.model.JogadorDAOImpl;
import app.model.SelecaoDAOImpl;
import app.model.TecnicoDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class MainWindow {
	
	private static SelecaoDAOImpl SelecaoDAO = new SelecaoDAOImpl();
	private static FaseGrupos GruposCRUD = new FaseGrupos();
	private static JogadorDAOImpl JogadorDAO = new JogadorDAOImpl();
	private static TecnicoDAOImpl TecnicoDAO = new TecnicoDAOImpl();
	private static ArbitroDAOImpl ArbitroDAO = new ArbitroDAOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnArbitros;

    @FXML
    private Button btnFaseG;

    @FXML
    private Button btnJogadores;

    @FXML
    private Button btnPreSet;

    @FXML
    private Button btnSelecoes;

    @FXML
    private Button btnTecnicos;

    @FXML
    void goArbitrosPage1(ActionEvent event) throws Exception {
    	Parent fxmlArbitro = FXMLLoader.load(getClass().getResource("/app/view/ArbitroPage.fxml"));
    	Main.trocarTelas1(fxmlArbitro);
    }

    @FXML
    void goFaseGruposPage1(ActionEvent event) throws Exception {
    	Parent fxmlFaseGrupos = FXMLLoader.load(getClass().getResource("/app/view/FaseGruposPage.fxml"));
    	Main.trocarTelas1(fxmlFaseGrupos);
    	//Main.trocarTelas("FaseGruposPage");
    }

    @FXML
    void goJogadoresPage1(ActionEvent event) throws Exception {
    	Parent fxmlJogador1 = FXMLLoader.load(getClass().getResource("/app/view/JogadorPage1.fxml"));
    	Main.trocarTelas1(fxmlJogador1);
    	//Main.trocarTelas("JogadorPage1"); 	
    }

    @FXML
    void goSelecoesPage1(ActionEvent event) throws Exception { 
    	Parent fxmlSelecoes1 = FXMLLoader.load(getClass().getResource("/app/view/SelecoesPage1.fxml"));
    	Main.trocarTelas1(fxmlSelecoes1);
    	//Main.trocarTelas("SelecoesPage1");
    }

    @FXML
    void goTecnicosPage1(ActionEvent event) throws Exception {
    	Parent fxmlTecnico = FXMLLoader.load(getClass().getResource("/app/view/TecnicoPage.fxml"));
    	Main.trocarTelas1(fxmlTecnico);
    	//Main.trocarTelas("TecnicoPage1");
    }

    @FXML
    void preSetAction(ActionEvent event) {
    	DadosPreCadastro.LeituraArquivos(SelecaoDAO, JogadorDAO, GruposCRUD);
    	DadosPreCadastro.LeituraTecnicoArbitro(SelecaoDAO, TecnicoDAO, ArbitroDAO, GruposCRUD);
    	this.btnPreSet.setDisable(true); //o botão é desabilitado pois não pode ser acionado duas vezes o cadastro automático
    	
    }

    @FXML
    void initialize() {
        assert btnArbitros != null : "fx:id=\"btnArbitros\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnFaseG != null : "fx:id=\"btnFaseG\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnJogadores != null : "fx:id=\"btnJogadores\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnPreSet != null : "fx:id=\"btnPreSet\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnSelecoes != null : "fx:id=\"btnSelecoes\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnTecnicos != null : "fx:id=\"btnTecnicos\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }
    
    @FXML
    void selectedBtn1(MouseEvent event) {
    	this.btnSelecoes.setBorder(null);    	
    }
    
    @FXML
    void selectedBtn2(MouseEvent event) {
    	this.btnJogadores.setBorder(null);
    }

    @FXML
    void selectedBtn3(MouseEvent event) {
    	this.btnTecnicos.setBorder(null);
    }

    @FXML
    void selectedBtn4(MouseEvent event) {
    	this.btnArbitros.setBorder(null);
    }
    
    @FXML
    void selectedBtn5(MouseEvent event) {

    }

    @FXML
    void selectedBtn6(MouseEvent event) {

    }

}