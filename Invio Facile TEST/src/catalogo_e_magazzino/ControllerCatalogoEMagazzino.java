package catalogo_e_magazzino;

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
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import util_package.GestisciInterfacce;
import util_package.Messaggi;
import util_package.Util;

public class ControllerCatalogoEMagazzino {
	
	@FXML
    private AnchorPane anchorPaneBase;
		@FXML
	    private BorderPane borderPaneBase;
			@FXML
		    private MenuBar barraMenu;
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
				    private MenuItem menuEsci;
					    @FXML
					    void effettuaLogout(ActionEvent event) { GestisciInterfacce.setFinestra("Login"); }
				@FXML
				private Menu menuVisualizza;
					@FXML
				    private MenuItem menuLibroGiornale;
						@FXML
						void apriLibroGiornale (ActionEvent event) { GestisciInterfacce.setFinestra("Libro Giornale"); }
					@FXML
					private MenuItem menuRepartiDiProduzione;
						@FXML
				   		void apriRepartoDiProduzione (ActionEvent event) { GestisciInterfacce.setFinestra("Reparti Di Produzione"); }
					@FXML
				    private MenuItem menuCatalogoEMagazzino;
			  		@FXML
			  		void apriCatalogoEMagazzino(ActionEvent event) { Messaggi.erroreApriCatalogoEMagazzino();}
					@FXML
					private MenuItem menuStatistiche;
					@FXML
			   		void apriStatistiche (ActionEvent event) {  GestisciInterfacce.setFinestra("Statistiche"); } 
				@FXML
				private Menu menuOpzioni;
					@FXML
				    private MenuItem menuCerca;
					@FXML
				    private MenuItem menuAggiungi;
					@FXML
					private MenuItem menuModifica;
					@FXML
				    private MenuItem menuElimina;
				@FXML
				private Menu menuAiuto;
					@FXML
				    private MenuItem menuCrediti;
						 @FXML
						 void crediti(ActionEvent event) { Messaggi.crediti(); }
					@FXML
				    private MenuItem menuContattaLAssistenza;
						@FXML
					    void contattaLAssistenza(ActionEvent event) { Messaggi.contattaAssistenza(); }
					
	@FXML
	private TableView<Prodotto> tableViewProdotti;
		@FXML private TableColumn<Prodotto, Integer> tableColumnIdProdotto = new TableColumn<Prodotto, Integer>("Id Prodotto");
		
		@FXML private TableColumn<Prodotto, String> tableColumnNomeProdotto = new TableColumn<Prodotto, String>("Nome");
		
		@FXML private TableColumn<Prodotto, String> tableColumnDescrizione = new TableColumn<Prodotto, String>("Descrizione");
		
		@FXML private TableColumn<Prodotto, String> tableColumnLivelloReparto = new TableColumn<Prodotto, String>("Reparto");
		
		@FXML private TableColumn<Prodotto, Double> tableColumnPrezzo = new TableColumn<Prodotto, Double>("Prezzo");
		
		@FXML private TableColumn<Prodotto, Integer> tableColumnIva = new TableColumn<Prodotto, Integer>("Iva");
		
		@FXML private TableColumn<Prodotto, Double> tableColumnPrezzoFinale = new TableColumn<Prodotto, Double>("Prezzo Finale");
		
	@FXML
	public void initialize() {
		ObservableList<Prodotto> incastratoreDiProdotti = Util.creaTableViewProdotti();
		
		tableColumnIdProdotto.setCellValueFactory(new PropertyValueFactory<Prodotto, Integer>("id"));
		tableColumnNomeProdotto.setCellValueFactory(new PropertyValueFactory<Prodotto, String>("nome"));
		tableColumnDescrizione.setCellValueFactory(new PropertyValueFactory<Prodotto, String>("descrizione"));
		tableColumnLivelloReparto.setCellValueFactory(new PropertyValueFactory<Prodotto, String>("reparto"));
		tableColumnPrezzo.setCellValueFactory(new PropertyValueFactory<Prodotto, Double>("prezzo"));
		tableColumnIva.setCellValueFactory(new PropertyValueFactory<Prodotto, Integer>("iva"));
		tableColumnPrezzoFinale.setCellValueFactory(new PropertyValueFactory<Prodotto, Double>("prezzoFinale"));
		
		tableViewProdotti.setItems(incastratoreDiProdotti);
		
	}
	
	@FXML
	private SplitPane splitPane;
		@FXML
	    private AnchorPane anchorPaneSinistra;
			@FXML
		    private VBox vBoxSinistra;
				@FXML
			    private BorderPane borderPaneDiRicerca;
					@FXML
					private HBox hBoxCercaPulsanti;
						@FXML
						private BorderPane borderPanePulsantiCerca;
							@FXML private Button pulsanteCerca; @FXML private Button pulsanteAnnulla;
							@FXML
						    private TextField cercaProdottoField;
				@FXML
			    private BorderPane borderPaneAggiungi;
					@FXML
				    private Button pulsanteAggiungi;
				@FXML
			    private BorderPane borderPaneModifica;
					@FXML
				    private Button pulsanteModifica;
				@FXML
			    private BorderPane borderPaneElimina;
				    @FXML
				    private Button pulsanteElimina;
		@FXML
	    private AnchorPane anchorPaneDiDestra;
			@FXML
			private VBox vBoxTabellaProdotti;
				@FXML
			    private Label prodottiTitolo;

    

    @FXML
    void effettuaRicercaDelProdotto(ActionEvent event) {
    	if(cercaProdottoField.getText().equals(""))
    		Messaggi.campoDiRicercaVuota();
    	String ricerca = cercaProdottoField.getText();
    	ObservableList<Prodotto> incastratoreDiProdotti = Util.effettuaRicerca(ricerca);
    }
    
    @FXML
    void ripristinaTableView(ActionEvent event) {
    	tableViewProdotti.getItems().clear();
    	initialize();
    	cercaProdottoField.setText("");
    }

    @FXML
    void aggiungiUnProdotto(ActionEvent event) {
    	Alert dialogo = new Alert(AlertType.INFORMATION); 
		dialogo.setTitle("Aggiungi prodotto");
		dialogo.setHeaderText("Se riscontri problemi nell'inserimento dei dati contatta l'assistenza.");
		dialogo.setResizable(true); 
		
		try {
			AnchorPane aggiungiProdotto = (AnchorPane) FXMLLoader.load(getClass().getResource( "AggiungiProdotto.fxml" ));
			dialogo.getDialogPane().setContent(aggiungiProdotto);
			
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
					aggiungiUnProdotto(event);
				}
				else {/*CHIUDI*/}
			} else {/*CHIUDI*/}
		}catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void modificaProdotto(ActionEvent event) {
    	Prodotto prodottoSelezionato = tableViewProdotti.getSelectionModel().getSelectedItem();
    	if(prodottoSelezionato == null) {
    		Messaggi.prodottoNonSelezionato();
    		return;
    	}
   		Util.prodottoDaModificare(prodottoSelezionato);
   		
   		Alert dialogo = new Alert(AlertType.INFORMATION); 
		dialogo.setTitle("Modifica prodotto");
		dialogo.setHeaderText("Se riscontri problemi nell'inserimento dei dati contatta l'assistenza.");
		dialogo.setResizable(true); 
		
		try {
			AnchorPane modificaProdotto = (AnchorPane) FXMLLoader.load(getClass().getResource( "ModificaProdotto.fxml" ));
			dialogo.getDialogPane().setContent(modificaProdotto);
			
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
					aggiungiUnProdotto(event);
				}
				else {/*CHIUDI*/}
			} else {/*CHIUDI*/}
		}catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void eliminaProdotto(ActionEvent event) {
    	Integer id = tableViewProdotti.getSelectionModel().getSelectedItem().getId();
    	Util.eliminaProdotto(id, tableViewProdotti.getSelectionModel().getSelectedItem());
    	tableViewProdotti.getItems().removeAll(tableViewProdotti.getSelectionModel().getSelectedItems());
    }

}
