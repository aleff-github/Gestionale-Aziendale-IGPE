package catalogo_e_magazzino;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CatalogoEMagazzino extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader start = new FXMLLoader (getClass().getResource("CatalogoEMagazzino.fxml"));
		AnchorPane rootStart = (AnchorPane) start.load();
		Scene scena = new Scene(rootStart, 1550, 900);
		
		primaryStage.setResizable(true);
		primaryStage.setMinHeight(500);
		primaryStage.setMinWidth(600);
		primaryStage.setTitle("Catalogo e Magazzino!");
		primaryStage.setScene(scena);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
