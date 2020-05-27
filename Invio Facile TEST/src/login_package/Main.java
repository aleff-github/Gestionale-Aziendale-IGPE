package login_package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util_package.GestisciInterfacce;
import util_package.Util;

public class Main extends Application{
	
	@Override 
	public void start(Stage primaryStage) throws Exception {
//		Setto Util
		Util.setApplication(this);
//		Setto gli utenti registrati
		LoginController.init("admin", "admin");
//		Dati aziendali iniziali
		Util.settaDatiPrimitiviAziendali();
		
//		Schermata login
		FXMLLoader login = new FXMLLoader (getClass().getResource("/login_package/Login.fxml"));
		AnchorPane rootLogin = (AnchorPane) login.load();
		Scene scenaIniziale = new Scene (rootLogin, 1550, 900);
		GestisciInterfacce.inizio(scenaIniziale);
		GestisciInterfacce.add("Login", rootLogin);
		
//		Schermata imprenditore
		FXMLLoader imprenditore = new FXMLLoader (getClass().getResource("/imprenditore_package/Imprenditore.fxml"));
		AnchorPane rootImprenditore = (AnchorPane) imprenditore.load();
		GestisciInterfacce.add("Imprenditore", rootImprenditore);
		
//    	LIBRO GIORNALE
		FXMLLoader libroGiornale = new FXMLLoader (getClass().getResource("/libro_giornale/LibroGiornaleJavaFX.fxml"));
		AnchorPane rootLibroGiornale = (AnchorPane) libroGiornale.load();
    	GestisciInterfacce.add("Libro Giornale", rootLibroGiornale);
    	
//    	REPARTI DI PRODUZIONE
    	FXMLLoader repartiDiProduzione = new FXMLLoader (getClass().getResource("/reparti_di_produzione/RepartiDiProduzione.fxml"));
		AnchorPane rootRepartiDiProduzione = (AnchorPane) repartiDiProduzione.load();
    	GestisciInterfacce.add("Reparti Di Produzione", rootRepartiDiProduzione);
    	
//    	CATALOGO E PRODOTTI
    	FXMLLoader catalogoEProdotti = new FXMLLoader (getClass().getResource("/catalogo_e_magazzino/CatalogoEMagazzino.fxml"));
    	AnchorPane rootCatalogoEMagazzino = (AnchorPane) catalogoEProdotti.load();
    	GestisciInterfacce.add("Catalogo E Magazzino", rootCatalogoEMagazzino);
		
		primaryStage.setResizable(true);
		primaryStage.setMinHeight(500);
		primaryStage.setMinWidth(600);
		primaryStage.setTitle("Invio Facile!");
		primaryStage.setScene(scenaIniziale);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
