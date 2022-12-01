module PBL1 {
	exports app;
	exports app.model;

	requires javafx.controls;
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.graphics;
	requires org.junit.jupiter.api;
	
	opens app.controller to javafx.graphics, javafx.fxml;
	opens app.model;
}