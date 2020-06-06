package util_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import catalogo_e_magazzino.Prodotto;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import libro_giornale.VoceLibroGiornale;

public class Util {
	private static Application app;
	
	public Util () {
	}
	
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
	
	public static Random random = new Random();

	
	/* * * * * * * * **
	 *                *
	 * DATI AZIENDALI *
	 *                *
	 * * * * * * * * */
	
	public static String ragioneSociale;
	public static String partitaIva;
	public static String codiceUnivoco;
	public static String titolare;
	public static String email;
	public static String capitaleSociale; 
	
	public static void settaDatiPrimitiviAziendali () {
		ragioneSociale = "iPear, azienda di produzione di oggetti tecnologici e informatici.";
		partitaIva = "IT 11359591002";
		codiceUnivoco = "ZJ1UHX";
		titolare = "Stefano Mestieri";
		email = "info@ipear.com";
		capitaleSociale = "2.402.550.510,11"; //Data e morte di Steve Jobs 
	}
	
	public static void datiAziendaliCambiati (String ragioneSociale_, String partitaIva_, String codiceUnivoco_, String titolare_, String email_, String capitaleSociale_) {
		ragioneSociale = ragioneSociale_;
		partitaIva = partitaIva_;
		codiceUnivoco = codiceUnivoco_;
		titolare = titolare_;
		email = email_;
		capitaleSociale = capitaleSociale_;
	}
	
	/* * * * * * * * **
	 *                *
	 *    PRODOTTO    *
	 *                *
	 * * * * * * * * */
	
	private static ObservableList<Prodotto> incastratoreDiProdotti;
	private static Prodotto ultimoProdottoAggiunto;
	private static ArrayList<Integer> listaId = new ArrayList<Integer>();
	
	public static ObservableList<Prodotto> creaTableViewProdotti (){
		incastratoreDiProdotti = FXCollections.observableArrayList(
				new Prodotto(1, "iPear 8", "Smartphone", 220.0, 22, null, "Descrizione prodotto"),
				new Prodotto(2, "iPear 9", "Smartphone", 550.0, 22, null, "Descrizione prodotto"),
				new Prodotto(3, "iPear 6", "Smartphone", 680.0, 22, null, "Descrizione prodotto"),
				new Prodotto(4, "iPear 4", "Smartphone", 500.0, 22, null, "Descrizione prodotto"),
				new Prodotto(5, "iPear 6s", "Smartphone", 460.0, 22, null, "Descrizione prodotto"),
				new Prodotto(6, "Capsula D'Aria", "Gadget", 480.0, 22, null, "Descrizione prodotto"),
				new Prodotto(7, "Cuffie P46", "Gadget", 670.0, 22, null, "Descrizione prodotto"),
				new Prodotto(8, "ACR 37", "Gadget", 860.0, 22, null, "Descrizione prodotto"),
				new Prodotto(9, "Kan 92", "Gadget", 850.0, 22, null, "Descrizione prodotto"),
				new Prodotto(10, "Piffh", "Gadget", 440.0, 22, null, "Descrizione prodotto"),
				new Prodotto(11, "Ginfix", "Gadget", 610.0, 22, null, "Descrizione prodotto"),
				new Prodotto(12, "Pinous", "Gadget", 420.0, 22, null, "Descrizione prodotto"),
				new Prodotto(13, "Trinky", "Gadget", 190.0, 22, null, "Descrizione prodotto"),
				new Prodotto(14, "Franchi", "Computer", 280.0, 22, null, "Descrizione prodotto"),
				new Prodotto(15, "ACERbo", "Computer", 250.0, 22, null, "Descrizione prodotto"),
				new Prodotto(16, "asusina", "Computer", 340.0, 22, null, "Descrizione prodotto"),
				new Prodotto(17, "pinononpino", "Computer", 250.0, 22, null, "Descrizione prodotto"),
				new Prodotto(18, "cose non cose", "Computer", 430.0, 22, null, "Descrizione prodotto"),
				new Prodotto(19, "computer stupendo", "Computer", 540.0, 22, null, "Descrizione prodotto"),
				new Prodotto(20, "Computer della asan", "Computer", 960.0, 22, null, "Descrizione prodotto"),
				new Prodotto(21, "gianna nannini", "Computer", 770.0, 22, null, "Descrizione prodotto"),
				new Prodotto(22, "pino loricato", "Computer", 300.0, 22, null, "Descrizione prodotto")
				);
		return incastratoreDiProdotti;
	}
	
	public static void aggiungiVoceProdotto (Prodotto v) {
		incastratoreDiProdotti.add(v);
		ultimoProdottoAggiunto = v;
		listaId.add(v.getId());
	}
	
	public static ObservableList<Prodotto> tableViewProdottiAggiornata (){
		return incastratoreDiProdotti;
	}
	
	public static void aggiungiProdotto (Prodotto p) {
		incastratoreDiProdotti.add(p);
	}
	
	public static Integer gestisciIdPerUnNuovoProdotto (Integer id) {
		if(id == null) 
			do
				id = random.nextInt();
			while(listaId.contains(id));
		else if (listaId.contains(id))
			return -1;
		return id;
	}
	
	/* * * * * * * * **
	 *                *
	 * LIBRO GIORNALE *
	 *                *
	 * * * * * * * * */
	
	private static ObservableList<VoceLibroGiornale> incastratoreDiLibri = FXCollections.observableArrayList();
	private static VoceLibroGiornale ultimaVoceAggiunta;
	public static boolean eStataAggiuntaUnaVoce = false;
	
	public static Connection con;
	public static ResultSet rs;
	
	
	public static ObservableList<VoceLibroGiornale> creaTableViewLibroGiornale (){
		
		try {
            con = DatabaseConnector.getConnection(); // Acquisisco la connessione
            PreparedStatement statement = con.prepareStatement("SELECT * FROM data");//Preparo la query
            rs = statement.executeQuery(); //Eseguo la query salvando i dati in rs
            
            while(rs.next()) { //Finché ci sono righe da analizzare
            	String dataX = rs.getString("data");
            	Integer documentoX = Integer.parseInt(rs.getString("numeroDocumento"));
            	String descrizioneX = rs.getString("descrizione");
            	String repartoX = rs.getString("reparto");
            	Integer ivaX = Integer.parseInt(rs.getString("iva"));
            	Double dareX = Double.parseDouble(rs.getString("dare"));
            	Double avereX = Double.parseDouble(rs.getString("avere"));
            	
//            	new VoceLibroGiornale(data, documentoNumero, descrizione, reparto, iva, dare, avere)
            	incastratoreDiLibri.add(new VoceLibroGiornale(dataX,documentoX,descrizioneX,repartoX,ivaX,dareX,avereX));
            	//Creo e aggiungo gli oggetti che popoleranno la TableView
            }
            
		} catch (Exception e) {
			e.printStackTrace();
	    }
		//TableView popolata
	 
		return incastratoreDiLibri;
	}
	
	public static void aggiungiVoce (VoceLibroGiornale v) {
		incastratoreDiLibri.add(v);
		ultimaVoceAggiunta = v;
		eStataAggiuntaUnaVoce = true;
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
