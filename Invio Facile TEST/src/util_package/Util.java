package util_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public static Prodotto prodottoDaModificare;
	
	private static PreparedStatement preparedStatementProdotto;
	private static Statement statementProdotto;
    private static ResultSet resultProdotto;
    private static Connection connectionProdotto;
	
	public static ObservableList<Prodotto> creaTableViewProdotti (){
		try {
			connectionProdotto = DatabaseConnector.getConnectionCatalogoProdotti(); 
			preparedStatementProdotto = connectionProdotto.prepareStatement("SELECT * FROM 'prodotti'");
            resultProdotto = preparedStatementProdotto.executeQuery(); 
            
            while(resultProdotto.next()) { 
            	Integer id = Integer.parseInt(resultProdotto.getString("id"));
            	String nome = resultProdotto.getString("nome");
            	String reparto = resultProdotto.getString("reparto");
            	Double prezzo = Double.parseDouble(resultProdotto.getString("prezzo"));
            	Integer iva = Integer.parseInt(resultProdotto.getString("iva"));
            	String descrizione = resultProdotto.getString("descrizione");
            	
            	incastratoreDiProdotti.add(new Prodotto(id,nome,reparto,prezzo,iva,descrizione));
            }
            
		} catch (Exception e) {
			e.printStackTrace();
	    }
		return incastratoreDiProdotti;
	}
	
	//Comunicazione con il database
	public static void aggiungiVoceProdotto (Prodotto p) {
		try {
			String query = "INSERT INTO 'prodotti' ('nome', 'reparto', 'prezzo', 'iva', 'descrizione') 	"
					+ "VALUES ('" + p.getNome() + "', '" 	
					+ p.getReparto() + "', '"	
					+ p.getPrezzo() + "', '"	
					+ p.getIva() + "', '"	
					+ p.getDescrizione() + "');";
			connectionProdotto = DatabaseConnector.getConnectionCatalogoProdotti(); //creo la connessione con il database
			connectionProdotto.createStatement().executeUpdate(query); //eseguo la queri -> Aggiungi prodotto
			
			String queryLastId = "SELECT * FROM prodotti WHERE id =(SELECT MAX(id) FROM prodotti);";
			statementProdotto = connectionProdotto.createStatement(); //acquisisco la connesione con lo statement
			resultProdotto = statementProdotto.executeQuery(queryLastId); //eseguo la query -> Seleziona prodotto
			
			p.setId(resultProdotto.getInt("id"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		incastratoreDiProdotti.add(p);
		ultimoProdottoAggiunto = p;
	}
	
	public static ObservableList<Prodotto> tableViewProdottiAggiornata (){
		return incastratoreDiProdotti;
	}
	
	public static void aggiungiProdotto (Prodotto p) {
		incastratoreDiProdotti.add(p);
	}
	
	public static void eliminaProdotto (Integer id, Prodotto p) {
		try {
    	String queryCancellaVoce = "DELETE FROM prodotti WHERE id = " + id + "";
	    	incastratoreDiProdotti.remove(p);
	    	connectionProdotto = DatabaseConnector.getConnectionCatalogoProdotti();
	    	connectionProdotto.createStatement().executeUpdate(queryCancellaVoce);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void modificaProdotto (Prodotto p) {
		prodottoDaModificare = p;
	}
	
	public static void modificaVoceProdotto(Prodotto p) {
//		new Prodotto(id, nome, reparto, prezzo, iva, descrizione)
//		UPDATE prodotti SET nome = 'cambiato' WHERE id = 23
		try {
			String queryModifica = "UPDATE prodotti 	"
								+ "SET nome = '" + p.getNome() + "', "
								+ "reparto = '" + p.getReparto() + "', "
								+ "prezzo = '" + p.getPrezzo() + "', "
								+ "iva= '" + p.getIva() + "', "
								+ "descrizione = '" + p.getDescrizione() + "' "
								+ "WHERE id = " + p.getId();
			statementProdotto = connectionProdotto.createStatement(); //acquisisco la connesione con lo statement
			connectionProdotto.createStatement().executeUpdate(queryModifica); //eseguo la query -> Seleziona prodotto
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int size = incastratoreDiProdotti.size();
		for(int index=0; index<size; index++){
		   if(incastratoreDiProdotti.get(index).getId() == p.getId()){
			   incastratoreDiProdotti.set(index, p); //Modifica nella tabella
		   }
		}  
	}
	
	public static ObservableList<Prodotto> effettuaRicerca (String ricerca) {
		
		try { //Creo la connessione
			connectionProdotto = DatabaseConnector.getConnectionCatalogoProdotti(); 
		}catch(SQLException e) { Messaggi.erroreDiConnessioneAlDataBaseGenerico(); return incastratoreDiProdotti;}
		
		incastratoreDiProdotti.clear();
		
		boolean isDouble = true;
			try {
				Double numeroDouble = Double.parseDouble(ricerca);
				
			}catch(NumberFormatException e) {
				isDouble = false;
			}
			if(isDouble) {
				try {
					String ricercaDouble = "SELECT * " + 
							"FROM prodotti " + 
							"WHERE " + 
							"	id = '" + ricerca + "' OR" + // Se 'ricerca' è uguale all'id  
							"	prezzo = '" + ricerca + "' OR" + // Se 'ricerca' è uguale al prezzo  
							"	iva = '" + ricerca + "' OR" + // Se 'ricerca' è uguale all'iva
							"	prezzo*(1+(iva/100)) = '" + ricerca + "'"; // Se 'ricerca' è uguale al prezzo compreso iva
					
					preparedStatementProdotto = connectionProdotto.prepareStatement(ricercaDouble);
					resultProdotto = preparedStatementProdotto.executeQuery();
					
					while(resultProdotto.next()) { 
		            	Integer id = Integer.parseInt(resultProdotto.getString("id"));
		            	String nome = resultProdotto.getString("nome");
		            	String reparto = resultProdotto.getString("reparto");
		            	Double prezzo = Double.parseDouble(resultProdotto.getString("prezzo"));
		            	Integer iva = Integer.parseInt(resultProdotto.getString("iva"));
		            	String descrizione = resultProdotto.getString("descrizione");
		            	
		            	incastratoreDiProdotti.add(new Prodotto(id,nome,reparto,prezzo,iva,descrizione));
		            }
					
					return incastratoreDiProdotti;
				}catch(SQLException e) {}
			}
		
		//E' una stringa
			
		
		try {
			String ricercaDouble = "SELECT * " + 
					"FROM prodotti " + 
					"WHERE " + 
					"	nome LIKE '%" + ricerca + "%' OR" + // Se ciò che è stato cercato è incluso nel nome  
					"	descrizione LIKE '%" + ricerca + "%' OR" + // Se è incluso nella descrizione
					"	reparto LIKE '%" + ricerca + "%'"; // Se è incluso nel reparto
			
			preparedStatementProdotto = connectionProdotto.prepareStatement(ricercaDouble);
			resultProdotto = preparedStatementProdotto.executeQuery();
			
			while(resultProdotto.next()) { 
            	Integer id = Integer.parseInt(resultProdotto.getString("id"));
            	String nome = resultProdotto.getString("nome");
            	String reparto = resultProdotto.getString("reparto");
            	Double prezzo = Double.parseDouble(resultProdotto.getString("prezzo"));
            	Integer iva = Integer.parseInt(resultProdotto.getString("iva"));
            	String descrizione = resultProdotto.getString("descrizione");
            	
            	incastratoreDiProdotti.add(new Prodotto(id,nome,reparto,prezzo,iva,descrizione));
            }
		}catch(SQLException e) {}
		
		return incastratoreDiProdotti;
	}
	
	public static Double calcolaPrezzoFinale (Double prezzo, Integer iva) {
		return (prezzo * (1 + (iva /= 100) ) );
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
