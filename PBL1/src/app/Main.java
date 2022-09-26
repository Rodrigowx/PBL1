package app;

import java.util.*;

import app.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

import java.text.SimpleDateFormat;

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
	
	public static boolean checarNome(String nome, List<String> nomes){
		if (nomes.isEmpty()) {
			return false;
		}else {
			if(nomes.contains(nome)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		//launch(args);
		Scanner scan = new Scanner(System.in);
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
		
		System.out.println(sdf.format(data));
		
	}
}
