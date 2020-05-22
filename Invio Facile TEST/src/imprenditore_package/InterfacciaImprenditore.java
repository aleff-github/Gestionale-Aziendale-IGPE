package imprenditore_package;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import util_package.GestisciInterfacce;
import util_package.Util;

public class InterfacciaImprenditore  {
	
	@FXML
	public void initialize () {
		Image immagineSfondoPannelloLogin = new Image("/backgrounds/sfondo_generico.png"); //Prendo l'immagine
		// BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
		BackgroundSize backgroundPannelloSize = new BackgroundSize(100, 100, true, true, true, true); //Setto le impostazioni del background
		// new BackgroundImage(image, repeatX, repeatY, position, size)
		BackgroundImage backgroundPannelloLogin= new BackgroundImage(immagineSfondoPannelloLogin,	//Creo il background
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
				backgroundPannelloSize );
		splitPaneImprenditore.setBackground(new Background(backgroundPannelloLogin)); //Setto il background
	}
	
@FXML
private AnchorPane imprenditoreAnchorPane;  

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
		    void crediti(ActionEvent event) {
		    	Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Invio Facile!");
				alert.setHeaderText(null);
				alert.setContentText("Questo software � stato creato al fine del superamento dell'esame di IGPE da Alessandro Greco.\nUniversit� Della Calabria - UNICAL");
			
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
			    }
			    
    
				
	 
	@FXML
	private SplitPane splitPaneImprenditore;	
		@FXML
	    private AnchorPane anchorPaneSinistra;
		    @FXML
		    private Text textLibroGiornale;
			    @FXML
			    private ImageView iconaLibroGiornale;
			    @FXML
			    private Button apriDatiLibroGiornale; //PULSANTE LIBRO GIORNALE
			    @FXML
			    private Separator separatorUno;
			@FXML
		    private Text textRepartiDiProduzione;
				@FXML
			    private ImageView iconaRepartiDiProduzione;	
				@FXML
			    private Button apriDatiRepartiDiProduzione;
				@FXML
			    private Separator separatorDue;
		    @FXML
		    private Text textCatalogoEMagazzino;
			    @FXML
			    private ImageView iconaCatalogoEMagazzino;
			    @FXML
			    private Button apriDatiCatalogoMagazzino;
			    @FXML
			    private Separator separatorTre;
		    @FXML
		    private Text textStatistiche;
			    @FXML
			    private ImageView iconaStatistica;
			    @FXML
			    private Button apriDatiStatistiche;
			    
	@FXML
	private AnchorPane anchorPaneDestra;
	    @FXML
		private BorderPane borderpaneDiDestra;
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
		    	visualizzaDati ("Catalogo E Magazzino");
		    }
		
		    @FXML
		    void visualizzaDatiDelleStatistiche(ActionEvent event) {
		
		    }
		    void visualizzaDati (String url) {
		    	
				try {
					Parent root = null;
					FXMLLoader loader=new FXMLLoader(getClass().getResource ("/imprenditore_package/Dati/" + url + ".fxml"));
					root = loader.load(); //Carico il file
					borderpaneDiDestra.setCenter((HBox) root); //Il primo elemento � un HBox per ogni file di Dati
				} catch (IOException ecc) {
					System.out.println("---");
					ecc.printStackTrace();
					System.out.println("---");
				}
				
		    }
		    

}