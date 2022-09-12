module PBL1 {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens app to javafx.graphics, javafx.fxml;
}
