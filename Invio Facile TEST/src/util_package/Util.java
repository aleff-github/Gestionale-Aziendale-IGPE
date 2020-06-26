package util_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

import catalogo_e_magazzino.Prodotto;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TextField;
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
	
//	DATI UTILI PER ANNULLARE LA MODIFICA
	public static String ragioneSociale;
	public static String partitaIva;
	public static String codiceUnivoco;
	public static String titolare;
	public static String email;
	public static String capitaleSociale; 
	
	private static PreparedStatement preparedStatementDatiAziendali;
	private static Statement statementDatiAziendali;
    private static ResultSet resultDatiAziendali;
    private static Connection connectionDatiAziendali;
	
	public static void assegnaValoriDatiAziendali(TextField ragioneSocialeField, TextField partitaIvaField,
			TextField codiceUnivocoField, TextField titolareField, TextField emailField,
			TextField capitaleSocialeField) {
		
		try {
			String datiAziendali = "SELECT * FROM dati_aziendali";
			connectionDatiAziendali = DatabaseConnector.getConnectionDatabase();
			preparedStatementDatiAziendali = connectionDatiAziendali.prepareStatement(datiAziendali);
			resultDatiAziendali = preparedStatementDatiAziendali.executeQuery();
			
			ragioneSocialeField.setText(resultDatiAziendali.getString("Ragione_Sociale"));	
			partitaIvaField.setText(resultDatiAziendali.getString("P_Iva"));
			codiceUnivocoField.setText(resultDatiAziendali.getString("Codice_Univoco"));			
			titolareField.setText(resultDatiAziendali.getString("Titolare"));
			emailField.setText(resultDatiAziendali.getString("Email"));
			capitaleSocialeField.setText(resultDatiAziendali.getString("Capitale_Sociale"));
			
			connectionDatiAziendali.close();
		} catch (Exception e) { Messaggi.erroreDiConnessioneAlDataBaseGenerico(); }
		
		aggiornaDatiTemp(ragioneSocialeField.getText(),	
    			partitaIvaField.getText(),	
    			codiceUnivocoField.getText(), 	
    			titolareField.getText(), 	
    			emailField.getText(), 	
    			capitaleSocialeField.getText());
	}
	
	public static void datiAziendaliCambiati (String ragioneSociale, String partitaIva, String codiceUnivoco, String titolare, String email, String capitaleSociale) {
		try {
			String cambiaDatiAziendali = "UPDATE dati_aziendali SET Ragione_Sociale=?, P_Iva=?, Codice_Univoco=?, Titolare=?, Email=?, Capitale_Sociale=? WHERE id=1";
			connectionDatiAziendali = DatabaseConnector.getConnectionDatabase();	
			preparedStatementDatiAziendali = connectionDatiAziendali.prepareStatement(cambiaDatiAziendali);
			preparedStatementDatiAziendali.setString(1, ragioneSociale);			
			preparedStatementDatiAziendali.setString(2, partitaIva);
			preparedStatementDatiAziendali.setString(3, codiceUnivoco);
			preparedStatementDatiAziendali.setString(4, titolare);
			preparedStatementDatiAziendali.setString(5, email);
			preparedStatementDatiAziendali.setString(6, capitaleSociale);
			preparedStatementDatiAziendali.executeUpdate();
			
			connectionDatiAziendali.close();
		} catch (Exception e) { Messaggi.erroreDiConnessioneAlDataBaseGenerico(); }
		aggiornaDatiTemp(ragioneSociale, partitaIva, codiceUnivoco, titolare, email, capitaleSociale);
	}
	
	public static void annullaModifiche(TextField ragioneSocialeField, TextField partitaIvaField,
			TextField codiceUnivocoField, TextField titolareField, TextField emailField,
			TextField capitaleSocialeField) {
		ragioneSocialeField.setText(Util.ragioneSociale);
		partitaIvaField.setText(Util.partitaIva);
		codiceUnivocoField.setText(Util.codiceUnivoco);
		titolareField.setText(Util.titolare);
		emailField.setText(Util.email);
		capitaleSocialeField.setText(Util.capitaleSociale);
	}
	
	private static void aggiornaDatiTemp ( String ragioneSociale,
									String partitaIva, 
									String codiceUnivoco,	
									String titolare,
									String email,
									String capitaleSociale) {
		Util.ragioneSociale = ragioneSociale;
		Util.partitaIva = partitaIva;
		Util.codiceUnivoco = codiceUnivoco;
		Util.titolare = titolare;
		Util.email = email;
		Util.capitaleSociale = capitaleSociale;
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
	public static String generaCommentoRepartoFabbricazioneEMontaggio () {
		String commento = "";
		Double costi = costiTotaliFabbricazioneEMontaggio();
		Double ricavi = ricaviTotaliFabbricazioneEMontaggio();
		if(costi > ricavi) 
			commento = "Il reparto Fabbricazione e Montaggio risulta avere una contabilità complessivamente negativa per via "
					+ "del fatto che i costi totali risultano essere superiori dei ricavi totali.";
		else
			commento = "Il reparto Fabbricazione e Montaggio risulta avere una contabilità complessivamente positiva per via "
					+ "del fatto che i ricavi totali risultano essere superiori ai costi totali.";
		return commento;
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
	public static String generaCommentoRepartoTestDiResistenzaAmbientale () {
		String commento = "";
		Double costi = costiTotaliTestDiResistenzaAmbientale();
		Double ricavi = ricaviTotaliTestDiResistenzaAmbientale();
		if(costi > ricavi) 
			commento = "Il reparto Test Di Resistenza Ambientale risulta avere una contabilità complessivamente negativa per via "
					+ "del fatto che i costi totali risultano essere superiori dei ricavi totali.";
		else
			commento = "Il reparto Test Di Resistenza Ambientale risulta avere una contabilità complessivamente positiva per via "
					+ "del fatto che i ricavi totali risultano essere superiori dei costi totali.";
		return commento;
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
	public static String generaCommentoRepartoPuliziaEImballaggio() {
		String commento = "";
		Double costi = costiTotaliPuliziaEImballaggio();
		Double ricavi = ricaviTotaliPuliziaEImballaggio();
		if(costi > ricavi) 
			commento = "Il reparto Pulizia e Imballaggio risulta avere una contabilità complessivamente negativa per via "
					+ "del fatto che i costi totali risultano essere superiori dei ricavi totali.";
		else
			commento = "Il reparto Pulizia e Imballaggio risulta avere una contabilità complessivamente positiva per via "
					+ "del fatto che i ricavi totali risultano essere superiori dei costi totali.";
		return commento;
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
			connectionProdotto = DatabaseConnector.getConnectionDatabase();
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
			connectionProdotto = DatabaseConnector.getConnectionDatabase();
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
			connectionProdotto = DatabaseConnector.getConnectionDatabase();
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
			connectionProdotto = DatabaseConnector.getConnectionDatabase();
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
			connectionProdotto = DatabaseConnector.getConnectionDatabase(); 
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
			connectionProdotto = DatabaseConnector.getConnectionDatabase();
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
			connectionLibroGiornale = DatabaseConnector.getConnectionDatabase(); 
			preparedStatementLibroGiornale = connectionLibroGiornale.prepareStatement("SELECT * FROM libro_giornale");
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
			connectionLibroGiornale = DatabaseConnector.getConnectionDatabase();
			preparedStatementLibroGiornale = connectionLibroGiornale.prepareStatement("INSERT INTO libro_giornale ('data', 'descrizione', 'reparto', 'iva', 'dare', 'avere') VALUES (?,?,?,?,?,?)");
			preparedStatementLibroGiornale.setString(1, v.getData());
			preparedStatementLibroGiornale.setString(2, v.getDescrizione());
			preparedStatementLibroGiornale.setString(3, v.getReparto());
			preparedStatementLibroGiornale.setInt(4, v.getIva());
			preparedStatementLibroGiornale.setDouble(5, v.getDare());
			preparedStatementLibroGiornale.setDouble(6, v.getAvere());
			preparedStatementLibroGiornale.executeUpdate();
			
			String queryLastVoice = "SELECT * FROM libro_giornale WHERE numeroDocumento =(SELECT MAX(numeroDocumento) FROM libro_giornale);";
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
			connectionLibroGiornale = DatabaseConnector.getConnectionDatabase();
			String queryCancellaVoce = "DELETE FROM libro_giornale WHERE numeroDocumento = ?";
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
			connectionLibroGiornale = DatabaseConnector.getConnectionDatabase();
			String queryModifica = "UPDATE libro_giornale SET data=?, descrizione=?, reparto=?, iva=?, dare=?, avere=? WHERE numeroDocumento=?";
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
	
	/* * * * * * * * **
	 *                *
	 *  STATISTICHE   *
	 *                *
	 * * * * * * * * */
	private static PreparedStatement preparedStatementStatistiche;
	private static Statement statementStatistiche;
    private static ResultSet resultStatistiche;
    private static Connection connectionStatistiche;
    private static ObservableList<XYChart.Series<String, Double>> answer;
    
    private static Double andamentoReparto1;
    private static Double andamentoReparto2;
    private static Double andamentoReparto3;
    
    public static Integer MESI_DA_CONTROLLARE = 6;
    
  public static ObservableList<XYChart.Series<String, Double>> acquisisciDatiStatistici() {
	  andamentoReparto1 = 0.0;
	  andamentoReparto2 = 0.0;
	  andamentoReparto3 = 0.0;
	  //CREO UN OBSERVABLE LIST DI SERIES
	  answer = FXCollections.observableArrayList();
	//CREO I SERIES
	  Series<String, Double> fabbricazioneEMontaggio = new Series<String, Double>();
	  Series<String, Double> testDiResistenzaAmbientale = new Series<String, Double>();
	  Series<String, Double> puliziaEImballaggio = new Series<String, Double>();
	  fabbricazioneEMontaggio.setName("Fabbricazione e Montaggio");
	  testDiResistenzaAmbientale.setName("Test di Resistenza Ambientale");
	  puliziaEImballaggio.setName("Pulizia e Imballaggio");
	  
	  Double utileReparto1 = 0.0;
	  Double utileReparto2 = 0.0;
	  Double utileReparto3 = 0.0;
	  
	  Calendar calendario = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY); //Prende la data attuale
	  Date dataDiOggi = calendario.getTime();
	  LocalDate finoA = dataDiOggi.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Acquisisce la data nel formato corretto -> yyyy/MM/dd
	  LocalDate da = finoA.minusMonths(MESI_DA_CONTROLLARE); // Acquisisce la data da quando deve partire il controllo
	  Integer mesiControllati = 0;
	  try {//Acquisisco tutte le voci per ogni singolo giorno
		connectionStatistiche = DatabaseConnector.getConnectionDatabase(); 		
	  //ASSEGNO DEI VALORI
	  while(da.isBefore(finoA)) {
		  preparedStatementStatistiche = connectionStatistiche.prepareStatement("SELECT * FROM libro_giornale WHERE data=?");
		  preparedStatementStatistiche.setString(1, da.toString());
		  resultStatistiche = preparedStatementStatistiche.executeQuery(); 
	          while(resultStatistiche.next()) { 
	          	if( resultStatistiche.getString("reparto").equals("Fabbricazione e Montaggio")) {
	          		Integer iva = Integer.parseInt(resultStatistiche.getString("iva"));
	              	Double dare = Double.parseDouble(resultStatistiche.getString("dare"));
	              	Double avere = Double.parseDouble(resultStatistiche.getString("avere"));
	              	utileReparto1 += (avere*iva);
	              	utileReparto1 -= (dare*iva);
	          	}
	          	else if( resultStatistiche.getString("reparto").equals("Test di Resistenza Ambientale")) {
	          		Integer iva = Integer.parseInt(resultStatistiche.getString("iva"));
	              	Double dare = Double.parseDouble(resultStatistiche.getString("dare"));
	              	Double avere = Double.parseDouble(resultStatistiche.getString("avere"));
	              	utileReparto2 += (avere*iva);
	              	utileReparto2 -= (dare*iva);
	          	}
	          	else if( resultStatistiche.getString("reparto").equals("Pulizia e Imballaggio")) {
	          		Integer iva = Integer.parseInt(resultStatistiche.getString("iva"));
	              	Double dare = Double.parseDouble(resultStatistiche.getString("dare"));
	              	Double avere = Double.parseDouble(resultStatistiche.getString("avere"));
	              	utileReparto3 += (avere*iva);
	              	utileReparto3 -= (dare*iva);
	          	}
	          }
	         
	  	//Verifico se cambio mese
	      if(da.plusDays(1).getMonth() != da.getMonth()) {
	    	  switch(mesiControllati) {
	    	  case 1:
	    		  fabbricazioneEMontaggio.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto1));
	    		  testDiResistenzaAmbientale.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto2));
	    		  puliziaEImballaggio.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto3));
	    	  break;
	    	  case 2:
	    		  fabbricazioneEMontaggio.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto1));
	    		  testDiResistenzaAmbientale.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto2));
	    		  puliziaEImballaggio.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto3));
	    	  break;
	    	  case 3:
	    		  fabbricazioneEMontaggio.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto1));
	    		  testDiResistenzaAmbientale.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto2));
	    		  puliziaEImballaggio.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto3));
	    	  break;
	    	  case 4:
	    		  fabbricazioneEMontaggio.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto1));
	    		  testDiResistenzaAmbientale.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto2));
	    		  puliziaEImballaggio.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto3));
	    	  break;
	    	  case 5:
	    		  fabbricazioneEMontaggio.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto1));
	    		  testDiResistenzaAmbientale.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto2));
	    		  puliziaEImballaggio.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto3));
	    	  break;
	    	  case 6:
	    		  fabbricazioneEMontaggio.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto1));
	    		  testDiResistenzaAmbientale.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto2));
	    		  puliziaEImballaggio.getData().add(new XYChart.Data(da.getMonth().toString(), utileReparto3));
		      break;
	    	  default: break;
	    	  }
	    	
	    	andamentoReparto1 += utileReparto1;
	    	andamentoReparto2 += utileReparto2;
	    	andamentoReparto3 += utileReparto3;
	      	mesiControllati++;
	      	utileReparto1 = 0.0;
	        utileReparto2 = 0.0;
	        utileReparto3 = 0.0;
	      }
	  	da = da.plusDays(1);
	  }
  	 connectionStatistiche.close();
	} catch (Exception e) { Messaggi.erroreDiConnessioneAlDataBaseGenerico(); }
//ASSEGNO I SERIES ALL'OBSERVABLE LIST
  answer.addAll(fabbricazioneEMontaggio, testDiResistenzaAmbientale, puliziaEImballaggio);
  return answer;
}

	public static String generaCommentoAndamentoAziendale() {
		String commento = "";
		if(andamentoReparto1 > 0) 
			commento = commento + "Il reparto 1, ovvero Fabbricazione e Montaggio, "
					+ " complessivamente riporta un risultato positivo. La fabbricazione dei prodotti "
					+ "prosegue correttametne e non sono state riportati problemi di gestione. ";
		else
			commento = commento + "Il reparto 1, ovvero Fabbricazione e Montaggio, "
					+ " complessivamente riporta un risultato negativo. Il reparto potrebbe "
					+ "avere dei problemi nella fabbricazione o nella gestione, è consigliato "
					+ "effettuare delle manove di recupero.";
		if(andamentoReparto2 > 0)
			commento = commento + "\nIl reparto 2, ovvero Test di Resistenza Ambientale, "
					+ " complessivamente riporta un risultato positivo. In questo reparto vengono "
					+ "effettuati i test sulla resistenza ambientale dei dispositivi prodotti e, "
					+ "stando ai movimenti economici e finanziari, l'andamento è buono visto che "
					+ "si riescono a ricoprire interamente le spese avendo anche un utile.";
		else
			commento = commento + "\nIl reparto 2, ovvero Test di Resistenza Ambientale, "
					+ " complessivamente riporta un risultato negativo. In questo reparto vengono "
					+ "effettuati i test sulla resistenza ambientale dei dispositivi prodotti e, "
					+ "stando ai movimenti economici e finanziari, l'andamento è pessimo visto che "
					+ "tramite gli utili non è possibile ricoprire le spese andando così in perdita. "
					+ "E' fortemente consigliato controllare la gestione del reparto e diminuire le spese.";
		if(andamentoReparto3 > 0)
			commento = commento + "\nIl reparto 3, ovvero Pulizia e Imballaggio, "
					+ " complessivamente riporta un risultato positivo. Questo è l'ultimo reparto e forse "
					+ "il più importante visto che tramite esso si gestisce il confezionamento prima dell'imballaggio"
					+ " e quindi della spedizione/vendita. Tramite i movimenti economici e finanziari positivi"
					+ ", riportati nel libro giornale, si può determinare un utile quindi la gestione del reparto è "
					+ "buona.";
		else
			commento = commento + "\nIl reparto 3, ovvero Pulizia e Imballaggio, "
					+ " complessivamente riporta un risultato negativo. Questo è l'ultimo reparto e forse "
					+ "il più importante visto che tramite esso si gestisce il confezionamento prima dell'imballaggio"
					+ " e quindi della spedizione/vendita. Tramite i movimenti economici e finanziari negativi"
					+ ", riportati nel libro giornale, si può determinare una perdita, è fortemente consigliato "
					+ "ricontrollare la gestione.";
		return commento;
	}

	public static String vociTotaliPerMese() {
		String testo = "";
		Integer vociPerMese = 0;
		Calendar calendario = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY); 
		  Date dataDiOggi = calendario.getTime();
		  LocalDate finoA = dataDiOggi.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		  LocalDate da = finoA.minusMonths(MESI_DA_CONTROLLARE); 
		  try {
			connectionStatistiche = DatabaseConnector.getConnectionDatabase(); 		

		  while(da.isBefore(finoA)) {
			  preparedStatementStatistiche = connectionStatistiche.prepareStatement("SELECT * FROM libro_giornale WHERE data=?");
			  preparedStatementStatistiche.setString(1, da.toString());
			  resultStatistiche = preparedStatementStatistiche.executeQuery(); 
		          while(resultStatistiche.next()) 
		          	vociPerMese += 1;
		          
		      if(da.plusDays(1).getMonth() != da.getMonth()) {
		    	  testo = testo + da.getMonth().toString() + ": " + vociPerMese + "\n";
		    	  vociPerMese = 0;
		      }
		  	da = da.plusDays(1);
		  }
	  	 connectionStatistiche.close();
		} catch (SQLException e) { Messaggi.erroreDiConnessioneAlDataBaseGenerico(); }
		
		return testo;
	}
  
}
