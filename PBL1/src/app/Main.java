package app;

import java.util.*;

import app.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("app.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//launch(args);
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite nome do arbitro");
		Arbitro arbitro = new Arbitro();
		arbitro.setNome(scan.nextLine());
		System.out.println(arbitro.getNome());
		ArbitroDAOImpl arbitroDAOImpl = new ArbitroDAOImpl();
		arbitroDAOImpl.inserir(arbitro);
		arbitroDAOImpl.listar();
	}
}
