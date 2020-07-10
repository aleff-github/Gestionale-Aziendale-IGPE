package imprenditore_package;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import util_package.GestisciInterfacce;
import util_package.Messaggi;
import util_package.Util;

public class InterfacciaImprenditore  {

	
@FXML
private AnchorPane imprenditoreAnchorPane;  

	@FXML
	private MenuBar barraMenu;
		@FXML
	    private Menu menuFile;
			@FXML
			private MenuItem menuHome;
				@FXML
	    		void tornaAllaHome(ActionEvent event) { Messaggi.erroreApriHome(); }
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
		   		void apriCatalogoEMagazzino(ActionEvent event) { GestisciInterfacce.setFinestra("Catalogo E Magazzino"); }
			@FXML
		    private MenuItem menuStatistiche;
				@FXML
		   		void apriStatistiche (ActionEvent event) { GestisciInterfacce.setFinestra("Statistiche"); } 
		   		
		@FXML
	    private Menu menuOpzioni;
			@FXML
		    private MenuItem menuDatiLibroGiornale;
			@FXML
		    private MenuItem menuDatiRepartiDiProduzione;
			@FXML
		    private MenuItem menuDatiStatistici;
			@FXML
		    private MenuItem menuDatiCatalogoEMagazzino;
			
		@FXML
	    private Menu menuAiuto;
		    @FXML
		    private MenuItem pulsanteCrediti;
		    @FXML
		    void crediti(ActionEvent event) { Messaggi.crediti(); }
		    @FXML
		    private MenuItem pulsanteContattaLAssistenza;
			    @FXML
			    void contattaLAssistenza(ActionEvent event) { Messaggi.contattaAssistenza(); }
		   
	@FXML
	private SplitPane splitPaneImprenditore;	
		@FXML
	    private AnchorPane anchorPaneSinistra;
			@FXML
			private ScrollPane scrollPaneMenuDiSinistra;
				@FXML
				private VBox vBoxMeniDiSinistra;
					@FXML
					private BorderPane borderPaneMenuDiSinistraLibroGiornale;
					    @FXML
					    private Text textLibroGiornale;
						    @FXML
						    private ImageView iconaLibroGiornale;
						    @FXML
						    private Button apriDatiLibroGiornale; //PULSANTE LIBRO GIORNALE
						    @FXML
						    private Separator separatorUno;
					@FXML
					private BorderPane borderPaneMenuRepartiDiProduzione;
						@FXML
					    private Text textRepartiDiProduzione;
							@FXML
						    private ImageView iconaRepartiDiProduzione;	
							@FXML
						    private Button apriDatiRepartiDiProduzione;
							@FXML
						    private Separator separatorDue;
					@FXML
					private BorderPane borderPaneMenuDiSinistraCatalogoEMagazzino;
					    @FXML
					    private Text textCatalogoEMagazzino;
						    @FXML
						    private ImageView iconaCatalogoEMagazzino;
						    @FXML
						    private Button apriDatiCatalogoMagazzino;
						    @FXML
						    private Separator separatorTre;
					@FXML
					private BorderPane borderPaneMenuDiSinistraStatistiche;
					    @FXML
					    private Text textStatistiche;
						    @FXML
						    private ImageView iconaStatistica;
						    @FXML
						    private Button apriDatiStatistiche;
						    @FXML
						    private Separator separatorQuattro;
			    
	@FXML
	private AnchorPane anchorPaneDestra;
	    @FXML
		private BorderPane borderpaneDiDestra;
	    @FXML
	    private ScrollPane scrollPaneInternoDiDestra;
	    @FXML
	    private AnchorPane anchorPaneDiScrollPaneDiDestra;
		    @FXML
			void visualizzaDatiDelLibroGiornale(ActionEvent event) {
		    	visualizzaDati ("DatiLibroGiornale");
		    }
		    @FXML
		    void visualizzaDatiDeiRepartiDiProduzione(ActionEvent event) {
		    	visualizzaDati ("DatiRepartiDiProduzione");
		    }
		    @FXML
		    void visualizzaDatiDelCatalogoEDelMagazzino(ActionEvent event) {
		    	visualizzaDati ("DatiCatalogoEMagazzino");
		    }
		
		    @FXML
		    void visualizzaDatiDelleStatistiche(ActionEvent event) {
		    	visualizzaDati ("DatiStatistiche");
		    }
		    void visualizzaDati (String url) {
		    	
				try {
					Parent root = null;
					FXMLLoader loader=new FXMLLoader(getClass().getResource ("/imprenditore_package/Dati/" + url + ".fxml"));
					root = loader.load(); //Carico il file
					anchorPaneDiScrollPaneDiDestra.getChildren().clear();
					anchorPaneDiScrollPaneDiDestra.getChildren().add(root);
				} catch (IOException ecc) {
					ecc.printStackTrace();
				}
				
		    }
		    

}