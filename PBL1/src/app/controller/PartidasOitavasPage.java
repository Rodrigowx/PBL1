package app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class PartidasOitavasPage {

    @FXML
    private Button btnAddPart;

    @FXML
    private Button btnListDelPart;

    @FXML
    private Button btnReturn;

    @FXML
    private ComboBox<?> choiceGanhador;

    @FXML
    private ChoiceBox<?> choiceGruposOitavas;

    @FXML
    private ComboBox<?> choicePartida;

    @FXML
    private ComboBox<?> comboGolsTime1;

    @FXML
    private ComboBox<?> comboGolsTime2;

    @FXML
    private DatePicker datePickerPart;

    @FXML
    private HBox hBoxGolsCart;

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

    }

    @FXML
    void btnAddPartAction(ActionEvent event) {

    }

    @FXML
    void btnListDelPartAction(ActionEvent event) {

    }

    @FXML
    void btnReturnAction(ActionEvent event) {

    }

    @FXML
    void exibirPartidasDoGrupo(MouseEvent event) {

    }

}
