package util_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import catalogo_e_magazzino.Prodotto;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import libro_giornale.ControllerLibroGiornale;
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
	
	/* * * * * * * * * * * *
	 *                     *
	 *REPARTI DI PRODUZIONE*
	 *                     *
	 * * * * * * * * * * * */
	
//	FABBRICAZIONE E MONTAGGIO
	public static Double costiTotaliFabbricazioneEMontaggio() {
		Double toReturn = 0.0;
		for(int i = 0; i < ControllerLibroGiornale.tableView.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableView.getItems().get(i).getReparto().equals("Fabbricazione e Montaggio")) 
				toReturn += ControllerLibroGiornale.tableView.getItems().get(i).getDare();
		return toReturn;
	}
	public static Double ricaviTotaliFabbricazioneEMontaggio() {
		Double toReturn = 0.0;
		for(int i = 0; i < ControllerLibroGiornale.tableView.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableView.getItems().get(i).getReparto().equals("Fabbricazione e Montaggio")) 
				toReturn += ControllerLibroGiornale.tableView.getItems().get(i).getAvere();
		return toReturn;
	}
	public static Integer vociTotaliFabbricazioneEMontaggio() {
		Integer toReturn = 0;
		for(int i = 0; i < ControllerLibroGiornale.tableView.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableView.getItems().get(i).getReparto().equals("Fabbricazione e Montaggio")) 
				toReturn ++;
		return toReturn;
	}
	
//	TEST DI RESISTENZA AMBIENTALE
	public static Double costiTotaliTestDiResistenzaAmbientale() {
		Double toReturn = 0.0;
		for(int i = 0; i < ControllerLibroGiornale.tableView.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableView.getItems().get(i).getReparto().equals("Test di Resistenza Ambientale")) 
				toReturn += ControllerLibroGiornale.tableView.getItems().get(i).getDare();
		return toReturn;
	}
	public static Double ricaviTotaliTestDiResistenzaAmbientale() {
		Double toReturn = 0.0;
		for(int i = 0; i < ControllerLibroGiornale.tableView.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableView.getItems().get(i).getReparto().equals("Test di Resistenza Ambientale")) 
				toReturn += ControllerLibroGiornale.tableView.getItems().get(i).getAvere();
		return toReturn;
	}
	public static Integer vociTotaliTestDiResistenzaAmbientale() {
		Integer toReturn = 0;
		for(int i = 0; i < ControllerLibroGiornale.tableView.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableView.getItems().get(i).getReparto().equals("Test di Resistenza Ambientale")) 
				toReturn ++;
		return toReturn;
	}
	
//	TEST DI RESISTENZA AMBIENTALE
	public static Double costiTotaliPuliziaEImballaggio() {
		Double toReturn = 0.0;
		for(int i = 0; i < ControllerLibroGiornale.tableView.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableView.getItems().get(i).getReparto().equals("Pulizia e Imballaggio")) 
				toReturn += ControllerLibroGiornale.tableView.getItems().get(i).getDare();
		return toReturn;
	}
	public static Double ricaviTotaliPuliziaEImballaggio() {
		Double toReturn = 0.0;
		for(int i = 0; i < ControllerLibroGiornale.tableView.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableView.getItems().get(i).getReparto().equals("Pulizia e Imballaggio")) 
				toReturn += ControllerLibroGiornale.tableView.getItems().get(i).getAvere();
		return toReturn;
	}
	public static Integer vociTotaliPuliziaEImballaggio() {
		Integer toReturn = 0;
		for(int i = 0; i < ControllerLibroGiornale.tableView.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableView.getItems().get(i).getReparto().equals("Pulizia e Imballaggio")) 
				toReturn ++;
		return toReturn;
	}
	
	/* * * * * * * * **
	 *                *
	 *    PRODOTTO    *
	 *                *
	 * * * * * * * * */
	
	private static ObservableList<Prodotto> incastratoreDiProdotti = FXCollections.observableArrayList();;
	private static Prodotto ultimoProdottoAggiunto;
	
	public static ObservableList<Prodotto> creaTableViewProdotti (){
		try {
            con = DatabaseConnector.getConnectionCatalogoProdotti(); 
            PreparedStatement statement = con.prepareStatement("SELECT * FROM 'prodotti'");
            rs = statement.executeQuery(); 
            
            while(rs.next()) { 
            	Integer id = Integer.parseInt(rs.getString("id"));
            	String nome = rs.getString("nome");
            	String reparto = rs.getString("reparto");
            	Double prezzo = Double.parseDouble(rs.getString("prezzo"));
            	Integer iva = Integer.parseInt(rs.getString("iva"));
            	String descrizione = rs.getString("descrizione");
            	
            	incastratoreDiProdotti.add(new Prodotto(id,nome,reparto,prezzo,iva,descrizione));
            }
            
		} catch (Exception e) {
			e.printStackTrace();
	    }
		return incastratoreDiProdotti;
	}
	
	public static void aggiungiVoceProdotto (Prodotto v) {
		System.out.println("Util 1");
		try {
			String query = "INSERT INTO 'prodotti' ('nome', 'reparto', 'prezzo', 'iva', 'descrizione') 	"
					+ "VALUES ('" + v.getNome() + "', '" 	
					+ v.getReparto() + "', '"	
					+ v.getPrezzo() + "', '"	
					+ v.getIva() + "', '"	
					+ v.getDescrizione() + "');";
			Connection con = DatabaseConnector.getConnectionCatalogoProdotti();
			con.createStatement().executeUpdate(query);
			
			System.out.println("Util 2");
			
			String queryLastId = "SELECT * FROM prodotti WHERE id =(SELECT MAX(id) FROM prodotti);";
			PreparedStatement statement = con.prepareStatement(queryLastId);
			
			System.out.println(rs.getInt("id"));
			rs = statement.executeQuery(queryLastId);
			v.setId(rs.getInt("id"));
			
			System.out.println("Util 3");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("QUA");
		incastratoreDiProdotti.add(v);
		ultimoProdottoAggiunto = v;
	}
	
	public static ObservableList<Prodotto> tableViewProdottiAggiornata (){
		return incastratoreDiProdotti;
	}
	
	public static void aggiungiProdotto (Prodotto p) {
		incastratoreDiProdotti.add(p);
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
            con = DatabaseConnector.getConnectionLibroGiornale(); // Acquisisco la connessione
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
