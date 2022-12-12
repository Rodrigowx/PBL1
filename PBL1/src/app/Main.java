/**
Autores: Rodrigo de Matos Ferreira e Nathielle Cerqueira Alves
Componente Curricular: MI Algoritmos II
Concluido em: 03/10/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
**/

package app;

import java.text.SimpleDateFormat;
import java.util.*;

import app.DadosArquivo.DadosPreCadastro;
import app.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * Classe MAIN, responsável por toda logística de execução do sistema. E também,
 * Instanciamento dos objetos.
 * 
 */

public class Main extends Application {	
	
	//declarando os DAO's como atributo para melhor acesso de toda a aplicação
	private static ArbitroDAOImpl ArbitroDAO = new ArbitroDAOImpl();
	private static JogadorDAOImpl JogadorDAO = new JogadorDAOImpl();
	private static SelecaoDAOImpl SelecaoDAO = new SelecaoDAOImpl();
	private static TecnicoDAOImpl TecnicoDAO = new TecnicoDAOImpl();

	private static FaseGrupos GruposCRUD = new FaseGrupos();
	private static PartidaGerenciar PartGerenciar = new PartidaGerenciar();
	
	private static Stage stage;
	
	private static Scene MainScene;

	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			Parent fxmlMainW = FXMLLoader.load(getClass().getResource("/app/view/MainWindow.fxml"));
			MainScene = new Scene(fxmlMainW);
			
			primaryStage.setScene(MainScene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArbitroDAOImpl getArbitroDAO() {
		return ArbitroDAO;
	}

	public static JogadorDAOImpl getJogadorDAO() {
		return JogadorDAO;
	}

	public static SelecaoDAOImpl getSelecaoDAO() {
		return SelecaoDAO;
	}

	public static TecnicoDAOImpl getTecnicoDAO() {
		return TecnicoDAO;
	}

	public static FaseGrupos getGruposCRUD() {
		return GruposCRUD;
	}

	public static PartidaGerenciar getPartGerenciar() {
		return PartGerenciar;
	}
	
	public static void trocarTelas(Parent parent) {
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
		
	}

}
