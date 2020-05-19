package catalogo_e_magazzino;

import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import javafx.scene.layout.VBox;
import util_package.GestisciInterfacce;
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
			    		void visualizzaDatiAziendali(ActionEvent event) {}
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
			  		void apriCatalogoEMagazzino(ActionEvent event) { 
			  			Alert alert = new Alert (AlertType.INFORMATION);
			  			alert.setTitle("Apri catalogo e magazzino");
			  			alert.setHeaderText("Stai cercando di accedere a catalogo e magazzino.");
			  			alert.setContentText("Sei già all'interno di Catalogo e Magazzino, se desideri uscire puoi andare alla Home oppure, cliccando il tasto esci, tornerai alla schermata di Login.");
			  			
			  			alert.showAndWait();
			  		}
					@FXML
					private MenuItem menuStatistiche;
					@FXML
			   		void apriStatistiche (ActionEvent event) { GestisciInterfacce.setFinestra("Statistiche"); } 
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
						 void crediti(ActionEvent event) {
						   	Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Invio Facile!");
							alert.setHeaderText(null);
							alert.setContentText("Questo software è stato creato al fine del superamento dell'esame di IGPE da Alessandro Greco.\nUniversità Della Calabria - UNICAL");
						
							alert.showAndWait();
						}
					@FXML
				    private MenuItem menuContattaLAssistenza;
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
				    private MenuItem menuRiavviaIlProgramma;
					  @FXML
					    void riavviaIlProgramma(ActionEvent event) {
					    	//TODO
							//CREARE UN COLLEGAMENTO CON IL MAIN
					    }
				
	@FXML
	private TableView<Prodotto> tableViewProdotti;
		@FXML
		private TableColumn<Prodotto, Integer> tableColumnIdProdotto = new TableColumn<Prodotto, Integer>("Id Prodotto");
		@FXML
		private TableColumn<Prodotto, String> tableColumnNomeProdotto = new TableColumn<Prodotto, String>("Nome");
		@FXML
	    private TableColumn<Prodotto, String> tableColumnLivelloReparto = new TableColumn<Prodotto, String>("Reparto");
		@FXML
		private TableColumn<Prodotto, Double> tableColumnPrezzo = new TableColumn<Prodotto, Double>("Prezzo");
		
	@FXML
	public void initialize() {
		ObservableList<Prodotto> incastratoreDiProdotti = Util.creaTableViewProdotti();
		
		tableColumnIdProdotto.setCellValueFactory(new PropertyValueFactory<Prodotto, Integer>("id"));
		tableColumnNomeProdotto.setCellValueFactory(new PropertyValueFactory<Prodotto, String>("nome"));
		tableColumnLivelloReparto.setCellValueFactory(new PropertyValueFactory<Prodotto, String>("reparto"));
		tableColumnPrezzo.setCellValueFactory(new PropertyValueFactory<Prodotto, Double>("prezzo"));
		
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
				    private Button pulsanteCerca;
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
		    private Label prodottiTitolo;

    

    @FXML
    void effettuaRicercaDelProdotto(ActionEvent event) {

    }

    @FXML
    void aggiungiUnProdotto(ActionEvent event) {

    }

    @FXML
    void modificaProdotto(ActionEvent event) {

    }

    @FXML
    void eliminaProdotto(ActionEvent event) {

    }

}
