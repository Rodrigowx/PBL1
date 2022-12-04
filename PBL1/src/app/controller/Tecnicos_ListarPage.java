package app.controller;

import app.Main;
import app.model.Tecnico;
import app.model.TecnicoDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class Tecnicos_ListarPage extends Tecnicos_EditarExcluirPage {
	
	//herda da classe Editar/Excluir para a exibição da tabela de Técnicos

    @FXML
    private Button btnReturn;

    @FXML
    private Label labelTotalTec;

    @FXML
	private TableView<Tecnico> tabelaTecnicos;

    @FXML
    void btnReturnAction(ActionEvent event) {
    	Main.trocarTelas("TecnicoPage1");
    }
    
    @FXML
    void exibirTotal(MouseEvent event) {
    	this.labelTotalTec.setText("TOTAL: " + TecnicoDAOImpl.getLista1().size() + " técnicos");
    }

}
