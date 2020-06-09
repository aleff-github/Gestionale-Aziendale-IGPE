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
		for(int i = 0; i < ControllerLibroGiornale.tableViewCopia.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableViewCopia.getItems().get(i).getReparto().equals("Fabbricazione e Montaggio")) 
				toReturn += ControllerLibroGiornale.tableViewCopia.getItems().get(i).getDare();
		return toReturn;
	}
	public static Double ricaviTotaliFabbricazioneEMontaggio() {
		Double toReturn = 0.0;
		for(int i = 0; i < ControllerLibroGiornale.tableViewCopia.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableViewCopia.getItems().get(i).getReparto().equals("Fabbricazione e Montaggio")) 
				toReturn += ControllerLibroGiornale.tableViewCopia.getItems().get(i).getAvere();
		return toReturn;
	}
	public static Integer vociTotaliFabbricazioneEMontaggio() {
		Integer toReturn = 0;
		for(int i = 0; i < ControllerLibroGiornale.tableViewCopia.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableViewCopia.getItems().get(i).getReparto().equals("Fabbricazione e Montaggio")) 
				toReturn ++;
		return toReturn;
	}
	
//	TEST DI RESISTENZA AMBIENTALE
	public static Double costiTotaliTestDiResistenzaAmbientale() {
		Double toReturn = 0.0;
		for(int i = 0; i < ControllerLibroGiornale.tableViewCopia.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableViewCopia.getItems().get(i).getReparto().equals("Test di Resistenza Ambientale")) 
				toReturn += ControllerLibroGiornale.tableViewCopia.getItems().get(i).getDare();
		return toReturn;
	}
	public static Double ricaviTotaliTestDiResistenzaAmbientale() {
		Double toReturn = 0.0;
		for(int i = 0; i < ControllerLibroGiornale.tableViewCopia.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableViewCopia.getItems().get(i).getReparto().equals("Test di Resistenza Ambientale")) 
				toReturn += ControllerLibroGiornale.tableViewCopia.getItems().get(i).getAvere();
		return toReturn;
	}
	public static Integer vociTotaliTestDiResistenzaAmbientale() {
		Integer toReturn = 0;
		for(int i = 0; i < ControllerLibroGiornale.tableViewCopia.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableViewCopia.getItems().get(i).getReparto().equals("Test di Resistenza Ambientale")) 
				toReturn ++;
		return toReturn;
	}
	
//	TEST DI RESISTENZA AMBIENTALE
	public static Double costiTotaliPuliziaEImballaggio() {
		Double toReturn = 0.0;
		for(int i = 0; i < ControllerLibroGiornale.tableViewCopia.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableViewCopia.getItems().get(i).getReparto().equals("Pulizia e Imballaggio")) 
				toReturn += ControllerLibroGiornale.tableViewCopia.getItems().get(i).getDare();
		return toReturn;
	}
	public static Double ricaviTotaliPuliziaEImballaggio() {
		Double toReturn = 0.0;
		for(int i = 0; i < ControllerLibroGiornale.tableViewCopia.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableViewCopia.getItems().get(i).getReparto().equals("Pulizia e Imballaggio")) 
				toReturn += ControllerLibroGiornale.tableViewCopia.getItems().get(i).getAvere();
		return toReturn;
	}
	public static Integer vociTotaliPuliziaEImballaggio() {
		Integer toReturn = 0;
		for(int i = 0; i < ControllerLibroGiornale.tableViewCopia.getItems().size() ; i++) 
			if(ControllerLibroGiornale.tableViewCopia.getItems().get(i).getReparto().equals("Pulizia e Imballaggio")) 
				toReturn ++;
		return toReturn;
	}
	
	/* * * * * * * * * * * **
	 *                      *
	 * CATALOGO E MAGAZZINO *
	 *                      *
	 * * * * * * * * * * * **/
	
	private static ObservableList<Prodotto> incastratoreDiProdotti = FXCollections.observableArrayList();
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
            connectionProdotto.close();
		} catch (Exception e) {
			e.printStackTrace();
	    }
		return incastratoreDiProdotti;
	}
	
	public static void aggiungiVoceProdotto (Prodotto p) {
		try {
			connectionProdotto = DatabaseConnector.getConnectionCatalogoProdotti();
			preparedStatementProdotto = connectionProdotto.prepareStatement("INSERT INTO 'prodotti' ('nome', 'reparto', 'prezzo', 'iva', 'descrizione') VALUES (?,?,?,?,?)");
			preparedStatementProdotto.setString(1, p.getNome());
			preparedStatementProdotto.setString(2, p.getReparto());
			preparedStatementProdotto.setDouble(3, p.getPrezzo());
			preparedStatementProdotto.setInt(4, p.getIva());
			preparedStatementProdotto.setString(5, p.getDescrizione());
			preparedStatementProdotto.executeUpdate();
			
			String queryLastId = "SELECT * FROM prodotti WHERE id =(SELECT MAX(id) FROM prodotti);";
			preparedStatementProdotto = connectionProdotto.prepareStatement(queryLastId);
			resultProdotto = preparedStatementProdotto.executeQuery();
			p.setId(resultProdotto.getInt("id"));
			
			connectionProdotto.close();
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
			connectionProdotto = DatabaseConnector.getConnectionCatalogoProdotti();
	    	String queryCancellaVoce = "DELETE FROM prodotti WHERE id = ?";
	    	preparedStatementProdotto = connectionProdotto.prepareStatement(queryCancellaVoce);
	    	preparedStatementProdotto.setInt(1, id);
	    	
	    	preparedStatementProdotto.executeUpdate();
	    	connectionProdotto.close();
		} catch (Exception e) { Messaggi.erroreDiConnessioneAlDataBaseGenerico(); }
	}
	
	public static void prodottoDaModificare (Prodotto p) {
		prodottoDaModificare = p;
	}
	
	public static void modificaVoceProdotto(Prodotto p) {
		try {
			connectionProdotto = DatabaseConnector.getConnectionCatalogoProdotti();
			String queryModifica = "UPDATE prodotti SET nome=?, reparto=?, prezzo=?, iva=?, descrizione=? WHERE id=?";
			preparedStatementProdotto = connectionProdotto.prepareStatement(queryModifica);
			preparedStatementProdotto.setString(1, p.getNome());
			preparedStatementProdotto.setString(2, p.getReparto());
			preparedStatementProdotto.setDouble(3, p.getPrezzo());
			preparedStatementProdotto.setInt(4, p.getIva());
			preparedStatementProdotto.setString(5, p.getDescrizione());
			preparedStatementProdotto.setInt(6, p.getId());
			
			preparedStatementProdotto.executeUpdate();
			connectionProdotto.close();
		} catch (SQLException e) { Messaggi.erroreDiConnessioneAlDataBaseGenerico(); }
		
		int size = incastratoreDiProdotti.size();
		for(int index=0; index < size; index++)
		   if(incastratoreDiProdotti.get(index).getId() == p.getId())
			   incastratoreDiProdotti.set(index, p); //Modifica nella tabella
	}
	
	public static ObservableList<Prodotto> effettuaRicerca (String ricerca) {
		try { 
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
							"	id = '" + ricerca + "' OR" + 
							"	prezzo = '" + ricerca + "' OR" +   
							"	iva = '" + ricerca + "' OR" + 
							"	prezzo*(1+(iva/100)) = '" + ricerca + "'"; 
					
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
				}catch(SQLException e) {Messaggi.erroreDiConnessioneAlDataBaseGenerico();}
			}
		
		try {
			String ricercaStringa = "SELECT * " + 
					"FROM prodotti " + 
					"WHERE " + 
					"	nome LIKE '%" + ricerca + "%' OR" + // Se ci� che � stato cercato � incluso nel nome  
					"	descrizione LIKE '%" + ricerca + "%' OR" + // Se � incluso nella descrizione
					"	reparto LIKE '%" + ricerca + "%'"; // Se � incluso nel reparto
			
			preparedStatementProdotto = connectionProdotto.prepareStatement(ricercaStringa);
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
		}catch(SQLException e) {Messaggi.erroreDiConnessioneAlDataBaseGenerico();}
		
		return incastratoreDiProdotti;
	}
	
	public static Integer vociTotaliCatalogoEMagazzino () {
		try {
			connectionProdotto = DatabaseConnector.getConnectionCatalogoProdotti();
			String size = "SELECT count(*) FROM prodotti";
			
			statementProdotto = connectionProdotto.createStatement();
			resultProdotto = statementProdotto.executeQuery(size);
			
			Integer vociTotali = resultProdotto.getInt("count(*)"); 
			connectionProdotto.close();
			return vociTotali;
		} catch (Exception e) { Messaggi.erroreDiConnessioneAlDataBaseGenerico(); }
		
		return 0;
	}
	
	
	/* * * * * * * * **
	 *                *
	 * LIBRO GIORNALE *
	 *                *
	 * * * * * * * * */
//	private static ObservableList<Prodotto> incastratoreDiProdotti = FXCollections.observableArrayList();;
	private static ObservableList<VoceLibroGiornale> incastratoreDiVociLibroGiornale = FXCollections.observableArrayList();
	private static VoceLibroGiornale ultimaVoceAggiunta;
	public static VoceLibroGiornale voceDaModificare;
	public static boolean eStataAggiuntaUnaVoce = false;
	
	private static PreparedStatement preparedStatementLibroGiornale;
	private static Statement statementLibroGiornale;
    private static ResultSet resultLibroGiornale;
    private static Connection connectionLibroGiornale;
	
//	C R E A
	public static ObservableList<VoceLibroGiornale> creaTableViewLibroGiornale (){
		try {
			connectionLibroGiornale = DatabaseConnector.getConnectionLibroGiornale(); 
			preparedStatementLibroGiornale = connectionLibroGiornale.prepareStatement("SELECT * FROM 'data'");
			resultLibroGiornale = preparedStatementLibroGiornale.executeQuery(); 
            
            while(resultLibroGiornale.next()) { 
            	String data = resultLibroGiornale.getString("data");
            	Integer documento = Integer.parseInt(resultLibroGiornale.getString("numeroDocumento"));
            	String descrizione= resultLibroGiornale.getString("descrizione");
            	String reparto = resultLibroGiornale.getString("reparto");
            	Integer iva = Integer.parseInt(resultLibroGiornale.getString("iva"));
            	Double dare = Double.parseDouble(resultLibroGiornale.getString("dare"));
            	Double avere = Double.parseDouble(resultLibroGiornale.getString("avere"));
            	
            	incastratoreDiVociLibroGiornale.add(new VoceLibroGiornale(data,documento,descrizione,reparto,iva,dare,avere));
            	
            }
            connectionLibroGiornale.close();
		} catch (Exception e) { Messaggi.erroreDiConnessioneAlDataBaseGenerico(); }
	 
		return incastratoreDiVociLibroGiornale;
	}
	
	//A G G I U N G I
	public static void aggiungiVoceLibroGiornale (VoceLibroGiornale v) {
		try {
			connectionLibroGiornale = DatabaseConnector.getConnectionLibroGiornale();
			preparedStatementLibroGiornale = connectionLibroGiornale.prepareStatement("INSERT INTO data ('data', 'descrizione', 'reparto', 'iva', 'dare', 'avere') VALUES (?,?,?,?,?,?)");
			preparedStatementLibroGiornale.setString(1, v.getData());
			preparedStatementLibroGiornale.setString(2, v.getDescrizione());
			preparedStatementLibroGiornale.setString(3, v.getReparto());
			preparedStatementLibroGiornale.setInt(4, v.getIva());
			preparedStatementLibroGiornale.setDouble(5, v.getDare());
			preparedStatementLibroGiornale.setDouble(6, v.getAvere());
			preparedStatementLibroGiornale.executeUpdate();
			
			String queryLastVoice = "SELECT * FROM data WHERE numeroDocumento =(SELECT MAX(numeroDocumento) FROM data);";
			preparedStatementLibroGiornale = connectionLibroGiornale.prepareStatement(queryLastVoice);
			resultLibroGiornale = preparedStatementLibroGiornale.executeQuery();
			v.setDocumentoNumero(resultLibroGiornale.getInt("numeroDocumento"));
			
			connectionLibroGiornale.close();
		} catch (SQLException e) { Messaggi.erroreDiConnessioneAlDataBaseGenerico(); }
		incastratoreDiVociLibroGiornale.add(v);
		ultimaVoceAggiunta = v;
	}
	
	public static void aggiungiVoce (VoceLibroGiornale v) {
		incastratoreDiVociLibroGiornale.add(v);
		ultimaVoceAggiunta = v;
		eStataAggiuntaUnaVoce = true;
	}
	
	public static ObservableList<VoceLibroGiornale> tableViewAggiornata (){
		return incastratoreDiVociLibroGiornale;
	}
	
	public static Double getUltimoDare () {
		return ultimaVoceAggiunta.getDare();
	}
	
	public static Double getUltimoAvere () {
		return ultimaVoceAggiunta.getAvere();
	}
	
//	E L I M I N A
	public static void eliminaVoceLibroGiornale(Integer numeroDocumento) {
		try {
			connectionLibroGiornale = DatabaseConnector.getConnectionLibroGiornale();
			String queryCancellaVoce = "DELETE FROM data WHERE numeroDocumento = ?";
			preparedStatementLibroGiornale = connectionLibroGiornale.prepareStatement(queryCancellaVoce);
			preparedStatementLibroGiornale.setInt(1, numeroDocumento);
			
			preparedStatementLibroGiornale.executeUpdate();
			connectionLibroGiornale.close();
		}catch(Exception e) { Messaggi.erroreDiConnessioneAlDataBaseGenerico();}
	}

	public static void voceLibroGiornaleDaModificare (VoceLibroGiornale v) {
		voceDaModificare = v;
	}

	public static void modificaVoceLibroGiornale(VoceLibroGiornale v) {
		try {
			connectionLibroGiornale = DatabaseConnector.getConnectionLibroGiornale();
			String queryModifica = "UPDATE data SET data=?, descrizione=?, reparto=?, iva=?, dare=?, avere=? WHERE numeroDocumento=?";
			preparedStatementLibroGiornale = connectionLibroGiornale.prepareStatement(queryModifica);
			preparedStatementLibroGiornale.setString(1, v.getData()); //D A T A
			preparedStatementLibroGiornale.setString(2, v.getDescrizione()); //D E S C R I Z I O N E
			preparedStatementLibroGiornale.setString(3, v.getReparto()); //R E P A R T O
			preparedStatementLibroGiornale.setInt(4, v.getIva());//I V A
			preparedStatementLibroGiornale.setDouble(5, v.getDare()); //D A R E
			preparedStatementLibroGiornale.setDouble(6, v.getAvere());//A V E R E
			preparedStatementLibroGiornale.setInt(7, v.getDocumentoNumero());//N U M E R O   D O C U M E N T O
			
			preparedStatementLibroGiornale.executeUpdate();
			connectionLibroGiornale.close();
		} catch (SQLException e) { Messaggi.erroreDiConnessioneAlDataBaseGenerico(); }
		
		int size = incastratoreDiVociLibroGiornale.size();
		for(int index=0; index < size; index++)
		   if(incastratoreDiVociLibroGiornale.get(index).getDocumentoNumero() == v.getDocumentoNumero())
			   incastratoreDiVociLibroGiornale.set(index, v); 
	}
	

}
