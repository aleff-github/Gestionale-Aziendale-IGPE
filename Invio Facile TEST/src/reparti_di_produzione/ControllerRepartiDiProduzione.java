package reparti_di_produzione;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import util_package.GestisciInterfacce;
import util_package.Util;

public class ControllerRepartiDiProduzione {
	
	@FXML
	public void initialize () {
	}
	
	@FXML
    private AnchorPane anchorPaneRepartiDiProduzione;
		@FXML
	    private BorderPane baseBorderPane;
			@FXML
		    private MenuBar barraMenu;
				@FXML
			    private Menu menuFile;
					@FXML
				    private MenuItem menuHome;
						@FXML
					    void vaiAllaHome(ActionEvent event) { GestisciInterfacce.setFinestra("Imprenditore"); }
					@FXML
				    private MenuItem menuDatiAziendali;
						@FXML
					    void vediDatiAziendali(ActionEvent event) { 
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
					    void esci(ActionEvent event) {GestisciInterfacce.setFinestra("Login"); }
				@FXML
			    private Menu menuVisualizza;
					@FXML
				    private MenuItem menuLibroGiornale;
						@FXML
					    void vaiALibroGiornale(ActionEvent event) {}
					@FXML
				    private MenuItem menuRepartiDiProduzione;
						@FXML
					    void vaiARepartiDiProduzione(ActionEvent event) { }
					@FXML
				    private MenuItem menuCatalogoEMagazzino;
						@FXML
					    void vaiACatalogoEMagazzino(ActionEvent event) {}
					@FXML
				    private MenuItem menuStatistiche;
						@FXML
					    void vaiAStatistiche(ActionEvent event) { }
				@FXML
			    private Menu menuOpzioni;
					@FXML
				    private MenuItem menuFabbricazioneEMontaggio;
					@FXML
				    private MenuItem menuTestDiResistenzaAmbientale;
					@FXML
				    private MenuItem menuPulizziaEImballaggio;
				@FXML
			    private Menu menuAiuto;
					@FXML
				    private MenuItem menuCrediti;
						@FXML
					    void visualizzaCrediti(ActionEvent event) {
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Invio Facile!");
							alert.setHeaderText(null);
							alert.setContentText("Questo software è stato creato al fine del superamento dell'esame di IGPE da Alessandro Greco.\nUniversità Della Calabria - UNICAL");
						
							alert.showAndWait();
						}
					@FXML
				    private MenuItem menuContattaLAssistenza;
						@FXML
					    void mandaEmailAllAssistenza(ActionEvent event) {
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
				    private MenuItem menuRiavviaProgramma;
						@FXML
					    void riavviaIlProgramma(ActionEvent event) {
							//TODO
							//CREARE UN COLLEGAMENTO CON IL MAIN
						}
	
			@FXML
			private SplitPane splitPane;
				@FXML
			    private AnchorPane anchorPaneSinistro;
					@FXML
				    private VBox vBoxMenu;
						@FXML
					    private BorderPane borderPaneFabbricazioneEMontaggio;
							@FXML
						    private Text fabbricazioneEMontaggioTitolo; 
							@FXML
						    private HBox hBoxFabbricazioneEMontaggio;
								@FXML
							    private ImageView iconaFabbricazioneEMontaggio;
							@FXML
							private BorderPane borderPanePulsanteFabbricazioneEMontaggio;
								@FXML
							    private Button pulsanteInformazioneFabbricazioneEMontaggio;
					@FXML
					private Separator separatoreUno;
					@FXML
				    private BorderPane borderPaneTestDiResistenzaAmbientale;
						@FXML
					    private Text testDiResistenzaAmbientaleTitolo;
						@FXML
					    private HBox hBoxTestDiResistenzaAmbientale;
							@FXML
						    private ImageView iconaTestDiResistenzaAmbientale;
							@FXML
						    private BorderPane borderPanePulsanteTestDiResistenzaEImballaggio;
								@FXML
							    private Button pulsanteInformazioneTestDiResistenzaAmbientale;
					@FXML
					private Separator separatoreDue;
					@FXML
				    private BorderPane borderPanePulizziaEImballaggio;
						@FXML
					    private Text pulizziaEImballaggioTitolo;
						@FXML
					    private HBox hBoxPulizziaEImballaggio;
							@FXML
						    private ImageView iconaPulizziaEImballaggio;
						@FXML
						private BorderPane borderPanePulsantePulizziaEImballaggio;
							@FXML
						    private Button pulsanteInformazionePulizziaEImballaggio;
		
				@FXML
				private AnchorPane anchorPaneDiDestra;
					@FXML
					private BorderPane borderPaneDiDestra;
	    @FXML
	    void visualizzaInformazioniFabbricazioneEMontaggio(ActionEvent event) {
	    	visualizzaDati("Fabbricazione_e_Montaggio");
	    }
	
	    @FXML
	    void visualizzaInformazioniTestDiResistenzaAmbientale(ActionEvent event) {}
	
	    @FXML
	    void visualizzaInformazioniPulizziaEImballaggio(ActionEvent event) { }

	    void visualizzaDati (String url) {
	    	
					try {
						Parent root = null;
						FXMLLoader loader=new FXMLLoader(getClass().getResource ("/reparti_di_produzione/reparti/" + url + ".fxml"));
						root = loader.load(); //Carico il file
						borderPaneDiDestra.setCenter((ScrollPane) root);
					} catch (IOException ecc) {
						System.out.println("---");
						ecc.printStackTrace();
						System.out.println("---");
					}
					
			    }
	    
}
