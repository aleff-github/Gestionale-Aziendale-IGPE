package util_package;

import catalogo_e_magazzino.Prodotto;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import libro_giornale.VoceLibroGiornale;

public class Util {
	private static Application app;
	
	public Util () {}
	
	public static void setApplication (Application app) {
		Util.app = app;
	}
	
	public static void inviaEmail() {
		app.getHostServices().showDocument("mailto:" + "nonameon@protonmail.ch");
	}
	public static void inviaEmailVeloce() {
		app.getHostServices().showDocument("mailto:");
	}

	public static void restart(Stage stage) throws Exception {
		Platform.exit();
//		Platform.runLater(  );
		//TODO
	}
	
	/* * * * * * * * **
	 *                *
	 *SFONDO GENERICO *
	 *                *
	 * * * * * * * * */
	
	public static void sfondoGenerico (Pane a) {
		Image immagineSfondoPannelloLogin = new Image("/backgrounds/sfondo_generico.png");
		// BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
		BackgroundSize backgroundPannelloSize = new BackgroundSize(100, 100, true, true, true, true);
		// new BackgroundImage(image, repeatX, repeatY, position, size)
		BackgroundImage backgroundPannelloLogin= new BackgroundImage(immagineSfondoPannelloLogin,	
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
				backgroundPannelloSize );
		a.setBackground(new Background(backgroundPannelloLogin));
	}
	
	/* * * * * * * * **
	 *                *
	 *    PRODOTTO    *
	 *                *
	 * * * * * * * * */
	
	private static ObservableList<Prodotto> incastratoreDiProdotti;
	private static Prodotto ultimoProdottoAggiunto;
	
	public static ObservableList<Prodotto> creaTableViewProdotti (){
		incastratoreDiProdotti = FXCollections.observableArrayList(
				new Prodotto(1, "iPear 8", "Smartphone", 220.0),
				new Prodotto(2, "iPear 9", "Smartphone", 550.0),
				new Prodotto(3, "iPear 6", "Smartphone", 680.0),
				new Prodotto(4, "iPear 4", "Smartphone", 500.0),
				new Prodotto(5, "iPear 6s", "Smartphone", 460.0),
				new Prodotto(6, "Capsula D'Aria", "Gadget", 480.0),
				new Prodotto(7, "Cuffie P46", "Gadget", 670.0),
				new Prodotto(8, "ACR 37", "Gadget", 860.0),
				new Prodotto(9, "Kan 92", "Gadget", 850.0),
				new Prodotto(10, "Piffh", "Gadget", 440.0),
				new Prodotto(11, "Ginfix", "Gadget", 610.0),
				new Prodotto(12, "Pinous", "Gadget", 420.0),
				new Prodotto(13, "Trinky", "Gadget", 190.0),
				new Prodotto(14, "Franchi", "Computer", 280.0),
				new Prodotto(15, "ACERbo", "Computer", 250.0),
				new Prodotto(16, "asusina", "Computer", 340.0),
				new Prodotto(17, "pinononpino", "Computer", 250.0),
				new Prodotto(18, "cose non cose", "Computer", 430.0),
				new Prodotto(19, "computer stupendo", "Computer", 540.0),
				new Prodotto(20, "Computer della asan", "Computer", 960.0),
				new Prodotto(21, "gianna nannini", "Computer", 770.0),
				new Prodotto(22, "pino loricato", "Computer", 300.0)
				);
		return incastratoreDiProdotti;
	}
	
	public static void aggiungiVoceProdotto (Prodotto v) {
		incastratoreDiProdotti.add(v);
		ultimoProdottoAggiunto = v;
	}
	
	public static ObservableList<Prodotto> tableViewProdottiAggiornata (){
		return incastratoreDiProdotti;
	}
	
	/* * * * * * * * **
	 *                *
	 * LIBRO GIORNALE *
	 *                *
	 * * * * * * * * */
	
	private static ObservableList<VoceLibroGiornale> incastratoreDiLibri;
	private static VoceLibroGiornale ultimaVoceAggiunta;
	
	public static ObservableList<VoceLibroGiornale> creaTableViewLibroGiornale (){
		incastratoreDiLibri = FXCollections.observableArrayList(
				new VoceLibroGiornale ( "11-01-2020", 123, "Merci c/Acquisti", "Fabbricazione e Montaggio" , 22, 150.0, 0.0),
				new VoceLibroGiornale ( "02-01-2020", 321, "Merci c/Acquisti", "Fabbricazione e Montaggio" , 22, 130.0, 0.0),
				new VoceLibroGiornale ( "23-01-2020", 1223, "Merci c/Acquisti", "Fabbricazione e Montaggio" , 22, 210.0, 0.0),
				new VoceLibroGiornale ( "04-01-2020", 4321, "Merci c/Acquisti", "Fabbricazione e Montaggio" , 22, 3120.0, 0.0),
				new VoceLibroGiornale ( "15-01-2020", 321, "Merci c/Acquisti", "Fabbricazione e Montaggio" , 22, 310.0, 0.0),
				new VoceLibroGiornale ( "06-01-2020", 532, "Merci c/Acquisti", "Fabbricazione e Montaggio" , 22, 3210.0, 0.0),
				new VoceLibroGiornale ( "27-01-2020", 312, "Merci c/Acquisti", "Fabbricazione e Montaggio" , 22, 2130.0, 0.0),
				new VoceLibroGiornale ( "08-01-2020", 412, "Merci c/Acquisti", "Test di Resistenza Ambientale", 22, 120.0, 0.0),
				new VoceLibroGiornale ( "19-01-2020", 1234, "Merci c/Acquisti", "Test di Resistenza Ambientale", 22, 1250.0, 0.0),
				new VoceLibroGiornale ( "14-01-2020", 512, "Merci c/Acquisti", "Test di Resistenza Ambientale", 22, 30.0, 0.0),
				new VoceLibroGiornale ( "21-01-2020", 142, "Merci c/Acquisti", "Test di Resistenza Ambientale", 22, 10.0, 0.0),
				new VoceLibroGiornale ( "11-01-2020", 532, "Merci c/Vendite", "Test di Resistenza Ambientale", 22, 50.0, 0.0),
				new VoceLibroGiornale ( "31-01-2020", 34, "Merci c/Vendite", "Test di Resistenza Ambientale", 22, 13120.0, 0.0),
				new VoceLibroGiornale ( "21-01-2020", 567, "Merci c/Vendite", "Test di Resistenza Ambientale", 22, 120.0, 0.0),
				new VoceLibroGiornale ( "27-01-2020", 967, "Merci c/Vendite", "Pulizzia e Imballaggio", 22, 1320.0, 0.0),
				new VoceLibroGiornale ( "31-01-2020", 235, "Merci c/Vendite", "Pulizzia e Imballaggio", 22, 14210.0, 0.0),
				new VoceLibroGiornale ( "17-01-2020", 321, "Merci c/Vendite", "Pulizzia e Imballaggio", 22, 13420.0, 0.0),
				new VoceLibroGiornale ( "23-01-2020", 643, "Merci c/Vendite", "Pulizzia e Imballaggio", 22, 430.0, 0.0),
				new VoceLibroGiornale ( "24-01-2020", 532, "Merci c/Vendite", "Pulizzia e Imballaggio", 22, 650.0, 0.0),
				new VoceLibroGiornale ( "15-01-2020", 856, "Merci c/Vendite", "Pulizzia e Imballaggio", 22, 430.0, 0.0)
				
			);
		return incastratoreDiLibri;
	}
	
	public static void aggiungiVoce (VoceLibroGiornale v) {
		incastratoreDiLibri.add(v);
		ultimaVoceAggiunta = v;
	}
	
	public static ObservableList<VoceLibroGiornale> tableViewAggiornata (){
		return incastratoreDiLibri;
	}
	
	public static Double getDare () {
		return ultimaVoceAggiunta.getDare();
	}
	
	public static Double getAvere () {
		return ultimaVoceAggiunta.getAvere();
	}
	
	
	
}
