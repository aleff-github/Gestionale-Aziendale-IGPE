package libro_giornale;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import util_package.GestisciInterfacce;
import util_package.Util;

public class ControllerLibroGiornale {
//	ROOT
	@FXML
    private AnchorPane rootLibroGiornale;

//	DATI LIBRO GIORNALE
	//VOCI
	private static int vociTotali;
	public static int getVociTotali () { return vociTotali; }
	//DARE
	private static double dareTotale;
	public static double getDareTotale() { return dareTotale; }
	private double calcolaTotaleDare() {
		double sommaDaTornare = 0.0;
		for(int i = 0 ; i < getVociTotali() ; i++) {
			sommaDaTornare += tableView.getItems().get(i).getDare();
		}
		return sommaDaTornare;
	}
	//AVERE
	private static double avereTotale; 
	private double calcolaTotaleAvere() {
		double sommaDaTornare = 0.0;
		for(int i = 0 ; i < getVociTotali() ; i++) {
			sommaDaTornare += tableView.getItems().get(i).getAvere();
		}
		return sommaDaTornare;
	}
	public static double getAvereTotale() {return avereTotale;}
	
//	VOCI
    @FXML
    private TableView<VoceLibroGiornale> tableView;
    @FXML
    private TableColumn<VoceLibroGiornale, String> tableColumnData = new TableColumn<VoceLibroGiornale, String>("Data"); 
    @FXML
    private TableColumn<VoceLibroGiornale, Integer> tableColumnDocumento = new TableColumn<VoceLibroGiornale, Integer>("Documento"); 
    @FXML
    private TableColumn<VoceLibroGiornale, String> tableColumnDescrizione = new TableColumn<VoceLibroGiornale, String>("Descrizione"); 
    @FXML
    private TableColumn<VoceLibroGiornale, String> tableColumnReparto = new TableColumn<VoceLibroGiornale, String>("Reparto");
    @FXML
    private TableColumn<VoceLibroGiornale, Integer> tableColumnIva = new TableColumn<VoceLibroGiornale, Integer>("IVA"); 
    @FXML
    private TableColumn<VoceLibroGiornale, Double> tableColumnDare = new TableColumn<VoceLibroGiornale, Double>("Dare"); 
    @FXML
    private TableColumn<VoceLibroGiornale, Double> tableColumnAvere = new TableColumn<VoceLibroGiornale, Double>("Avere"); 

    @FXML
	public void initialize() {
//    	TABLEVIEW - UTIL
    	ObservableList<VoceLibroGiornale> incastratoreDiLibri = Util.creaTableViewLibroGiornale();
	
		tableColumnData.setCellValueFactory(new PropertyValueFactory<VoceLibroGiornale, String>("data"));
		tableColumnDocumento.setCellValueFactory(new PropertyValueFactory<VoceLibroGiornale, Integer>("documentoNumero"));
		tableColumnDescrizione.setCellValueFactory(new PropertyValueFactory<VoceLibroGiornale, String>("descrizione"));
		tableColumnReparto.setCellValueFactory(new PropertyValueFactory<VoceLibroGiornale, String>("reparto"));
		tableColumnIva.setCellValueFactory(new PropertyValueFactory<VoceLibroGiornale, Integer>("iva"));
		tableColumnDare.setCellValueFactory(new PropertyValueFactory<VoceLibroGiornale, Double>("dare"));
		tableColumnAvere.setCellValueFactory(new PropertyValueFactory<VoceLibroGiornale, Double>("avere"));
	
		tableView.setItems(incastratoreDiLibri);
		
		vociTotali = tableView.getItems().size();
		dareTotale = calcolaTotaleDare();
		avereTotale = calcolaTotaleAvere();
		
	}
    
//AGGIUNGI VOCE MANUALMENTE
    @FXML
    private AnchorPane anchorPaneAggiungiVoce;
	    @FXML
	    private Text testoAggiungiVoce;
			    @FXML
			    private Button pulsanteAggiungi;
			    
    @FXML
    public void aggiungiVoceManualmente(ActionEvent event) {
    	Alert dialogo = new Alert(AlertType.INFORMATION); 
		dialogo.setTitle("Aggiungi voce");
		dialogo.setHeaderText("Se riscontri problemi nell'inserimento dei dati contatta l'assistenza.");
		dialogo.setResizable(true); 
		
		try {
			AnchorPane aggiungiVoce = (AnchorPane) FXMLLoader.load(getClass().getResource( "PopupAggiungiVoce.fxml" ));
			dialogo.getDialogPane().setContent(aggiungiVoce);
			
			dialogo.getButtonTypes().clear();
			ButtonType termina = new ButtonType("Termina");
			dialogo.getButtonTypes().add(termina);
			Optional<ButtonType> res1 = dialogo.showAndWait();
			if (res1.get() == termina){
				Alert alert = new Alert(AlertType.WARNING); 
				alert.setTitle("Attenzione!");
				alert.setHeaderText("Sei sicuro di voler chiudere? I dati non salvati andranno persi.");
				alert.setResizable(true); 
				
				ButtonType conferma = new ButtonType("Conferma");
				ButtonType annulla = new ButtonType("Annulla");
				alert.getButtonTypes().clear();
				alert.getButtonTypes().addAll(conferma, annulla);
				
				Optional<ButtonType> res2 = alert.showAndWait();
				if(res2.get() == annulla) {
					aggiungiVoceManualmente(event);
				}
				else {/*CHIUDI*/}
			} else {/*CHIUDI*/}
			
			if(Util.eStataAggiuntaUnaVoce) {
	    		tableView.setItems(Util.tableViewAggiornata());
	    		vociTotali++;
	    	    dareTotale += Util.getDare();
	    	 	avereTotale += Util.getAvere();
	    	 	Util.eStataAggiuntaUnaVoce = false;
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
    }


    @FXML
    private Menu menuFile;
    	@FXML 
    	private MenuItem menuHome;
    		@FXML
    		void tornaAllaHome(ActionEvent event) { GestisciInterfacce.setFinestra("Imprenditore"); }
    	@FXML 
    	private MenuItem menuDatiAziendali;
    		@FXML 
    		void visualizzaDatiAziendali(ActionEvent event) {
    			Alert dialogo = new Alert(AlertType.INFORMATION); 
				dialogo.setTitle("Dati aziendali");
				dialogo.setResizable(true); 

				try {
					AnchorPane datiAziendali = (AnchorPane) FXMLLoader.load(getClass().getResource( "/util_package/DatiAziendali.fxml" ));
					dialogo.getDialogPane().setContent(datiAziendali);
					dialogo.showAndWait();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	@FXML 
    	private MenuItem menuEmailVeloce;
    		@FXML
    		void mandaEmailVeloce(ActionEvent event) { Util.inviaEmailVeloce(); }
    	@FXML
	    private SeparatorMenuItem separatoreMenu0;
    	@FXML 
    	private MenuItem menuEsci;
		    @FXML
		    void effettuaLogout(ActionEvent event) { GestisciInterfacce.setFinestra("Login"); }
	@FXML
	private Menu menuVisualizza;
	  	@FXML 
	   	private MenuItem menuVisualizzaLibroGiornale;
	  		@FXML
	  		void apriLibroGiornale(ActionEvent event) { 
	  			Alert alert = new Alert (AlertType.INFORMATION);
	  			alert.setTitle("Apri libro giornale");
	  			alert.setHeaderText("Stai cercando di accedere il libro giornale.");
	  			alert.setContentText("Sei già all'interno del Libro Giornale, se desideri uscire puoi andare alla Home oppure, cliccando il tasto esci, tornerai alla schermata di Login.");
	  			
	  			alert.showAndWait();
	  		}
	   	@FXML 
	   	private MenuItem menuVisualizzaRepartiDiProduzione;
	   		@FXML
	   		void apriRepartoDiProduzione (ActionEvent event) { GestisciInterfacce.setFinestra("Reparti Di Produzione"); }
	   	@FXML 
	   	private MenuItem menuVisualizzaCatalogoEMagazzino;
	   		@FXML
	   		void apriCatalogoEMagazzino(ActionEvent event) { GestisciInterfacce.setFinestra("Catalogo E Magazzino"); }
	   	@FXML 
	   	private MenuItem menuVisualizzaStatistiche;
	   		@FXML
	   		void apriStatistiche (ActionEvent event) { GestisciInterfacce.setFinestra("Statistiche"); } 
	   		
    @FXML
    private Menu menuOpzioniLibroGiornale;
	    @FXML
	    private MenuItem pulsanteSvuotaLibroGiornale;
	    @FXML
	    void svuotaLibroGiornale(ActionEvent event) { 
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Stai svuotando il libro giornale!");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Sei sicuro di voler svuotare completamente il libro giornale? TUTTI i dati andranno persi.\nSe vuoi continuare clicca su \"Voglio perdere tutti i dati\".");
	    	ButtonType continua = new ButtonType ("Voglio perdere tutti i dati");
	    	ButtonType nonContinuare = new ButtonType ("Non continuare");
	    	alert.getButtonTypes().setAll(continua, nonContinuare);
	    	
	    	Optional<ButtonType> opzioneScelta = alert.showAndWait();
	    	if(opzioneScelta.get() == continua) {
	    		Alert alertInterno = new Alert(AlertType.INFORMATION);
	    		alertInterno.setTitle("Stai svuotando il libro giornale!");
	    		alertInterno.setHeaderText(null);
	    		alertInterno.setContentText("Vuoi effettuare un backup prima di continuare?");
	    		ButtonType continuaBackup = new ButtonType ("Crea backup");
	    		ButtonType nonFareIlBackup = new ButtonType ("Continua SENZA backup");
	    		alertInterno.getButtonTypes().setAll(continuaBackup, nonFareIlBackup);
	    		Optional<ButtonType> opzioneSceltaInterna = alertInterno.showAndWait();
	    		if(opzioneSceltaInterna.get() == continuaBackup)
	    			scaricaLibroGiornale();
	    		
	    		tableView.getItems().clear(); 
	    	}
	    	else if( opzioneScelta.get() == nonContinuare) return;
	    }
	    @FXML
	    private MenuItem pulsanteAggiornaLibroGiornale;
		    @FXML
		    void aggiornaLibroGiornale(ActionEvent event) { tableView.refresh(); }
	    @FXML
	    private SeparatorMenuItem separatoreMenu2;
	    @FXML
	    private MenuItem pulsanteScaricaInFormatoCSV;
		    @FXML
		    void scaricaInFormatoCSV(ActionEvent event) {
		    	FileChooser acquisisciPosizione = new FileChooser();
		    	FileChooser.ExtensionFilter filtriDiSalvataggio = 	
		    			new FileChooser.ExtensionFilter("File CSV (*.csv)", "*.csv");
		    	acquisisciPosizione.getExtensionFilters().add(filtriDiSalvataggio);
		    	creaFileDiTesto(acquisisciPosizione);
		    }
	    @FXML
	    private MenuItem pulsanteScaricaInFormatoEXCEL;
		    @FXML
		    void scaricaInFormatoEXCEL(ActionEvent event) {
		    	FileChooser acquisisciPosizione = new FileChooser();
		    	FileChooser.ExtensionFilter filtriDiSalvataggio = 	
		    			new FileChooser.ExtensionFilter("File Excel (*.xlsx)", "*.xlsx");
		    	acquisisciPosizione.getExtensionFilters().add(filtriDiSalvataggio);
		    	creaFileDiTesto(acquisisciPosizione);
		    }
	    @FXML
	    private MenuItem pulsanteScaricaInFormatoTXT;
		    @FXML
		    void scaricaInFormatoTXT(ActionEvent event) {
		    	FileChooser acquisisciPosizione = new FileChooser();
		    	FileChooser.ExtensionFilter filtriDiSalvataggio = 	
		    			new FileChooser.ExtensionFilter("File di testo semplice (*.txt)", "*.txt");
		    	acquisisciPosizione.getExtensionFilters().add(filtriDiSalvataggio);
		    	creaFileDiTesto(acquisisciPosizione);
		    }
	    
	    public File creaFileDiTesto (FileChooser posizioneEdEstensione){
	    	
	    	StringBuilder contenuto = new StringBuilder();
	    	contenuto.append("Data" + ";" + "Documento N." + ";" + "Descrizione" + ";" + "Reparto" + ";" + "IVA%" + ";" + "Dare" + ";" + "Avere" + "\n");
	    	for(int i = 0 ; i < tableView.getItems().size(); i++) {
	    		contenuto.append( tableView.getItems().get(i).getData() + ";");
	    		contenuto.append(tableView.getItems().get(i).getDocumentoNumero() + ";");
	    		contenuto.append(tableView.getItems().get(i).getDescrizione() + ";");
	    		contenuto.append(tableView.getItems().get(i).getReparto() + ";");
	    		contenuto.append(tableView.getItems().get(i).getIva() + ";");
	    		contenuto.append(tableView.getItems().get(i).getDare() + ";");
	    		contenuto.append(tableView.getItems().get(i).getAvere() + ";" );
	    		contenuto.append("\n");
	    	}
	    	File fileDaSalvare = posizioneEdEstensione.showSaveDialog(null);
	    	if(fileDaSalvare != null) {
	    		try {
					FileWriter scritturaNuovoFile = new FileWriter(fileDaSalvare);
					scritturaNuovoFile.write(contenuto.toString()); 
					scritturaNuovoFile.close();
	    		} catch (IOException e) {
					Alert alert = new Alert(AlertType.ERROR);
			    	alert.setTitle("Errore nel salvataggio");
			    	alert.setHeaderText(null);
			    	alert.setContentText("E' stato riscontrato un errore generico, t'invidiamo a riprovare. Se l'errore persiste contatta l'assistenza.");
			
			    	alert.showAndWait();
				}
	    		
	    	}
	    	else {
	    		Alert alert = new Alert(AlertType.ERROR);
		    	alert.setTitle("Errore nel salvataggio");
		    	alert.setHeaderText(null);
		    	alert.setContentText("Scegli una cartella correttamente, se credi di averne scelta una correttamente contatta l'assistenza.");
		
		    	alert.showAndWait();
	    	}
	    	
	    	return fileDaSalvare;
	    	
	    }
	     
	    @FXML
	    private Button pulsanteScaricaLibroGiornale;
	    
	    @FXML
	    void scaricaLibroGiornale(/*ActionEvent event*/) {
    	FileChooser acquisisciPosizione = new FileChooser();
    	FileChooser.ExtensionFilter filtroDiSalvataggioTXT = new FileChooser.ExtensionFilter("File di testo semplice (*.txt)", "*.txt");
    	FileChooser.ExtensionFilter filtroDiSalvataggioEXCEL = new FileChooser.ExtensionFilter("File Excel (*.xlsx)", "*.xlsx");
    	FileChooser.ExtensionFilter filtroDiSalvataggioCSV = new FileChooser.ExtensionFilter("File CSV (*.csv)", "*.csv");
    	acquisisciPosizione.getExtensionFilters().add(filtroDiSalvataggioTXT);
    	acquisisciPosizione.getExtensionFilters().add(filtroDiSalvataggioEXCEL);
    	acquisisciPosizione.getExtensionFilters().add(filtroDiSalvataggioCSV);
    	creaFileDiTesto(acquisisciPosizione);
    }
    
    @FXML
    private Menu menuAiuto;
	    @FXML
	    private MenuItem pulsanteCrediti;
	    @FXML
	    void crediti(ActionEvent event) {
	    	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Invio Facile!");
			alert.setHeaderText(null);
			alert.setContentText("Questo software è stato creato al fine del superamento dell'esame di IGPE da Alessandro Greco.\nUniversità Della Calabria - UNICAL");
		
			alert.showAndWait();
		}
	    @FXML
	    private MenuItem pulsanteContattaLAssistenza;
		    @FXML
		    void contattaLAssistenza(ActionEvent event) {
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Contatta l'assistenza");
		    	alert.setHeaderText(null);
		    	alert.setContentText("Stai contattando l'assistenza, se desideri un consulto immediato contatta il numero:\n+39 327 83 21 517");
		    	ButtonType inviaUnaEmail = new ButtonType ("Invia una email");
		    	alert.getButtonTypes().setAll(inviaUnaEmail);
		    	
		    	Optional<ButtonType> opzioneScelta = alert.showAndWait();
		    	if(opzioneScelta.get() == inviaUnaEmail) {
		    		//TODO
		    		Util.inviaEmail();
		    	}
		    }
	    @FXML
	    private MenuItem pulsanteRiavviaIlProgramma;
		    @FXML
		    void riavviaIlProgramma(ActionEvent event) {
		    	//TODO
				//CREARE UN COLLEGAMENTO CON IL MAIN
		    }
	    
}
