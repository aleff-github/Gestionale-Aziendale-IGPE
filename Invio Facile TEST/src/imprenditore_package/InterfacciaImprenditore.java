package imprenditore_package;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
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
			private MenuItem menuDatiAziendali;
			@FXML
			private MenuItem menuEmailVeloce;
			@FXML
			private MenuItem menuEsci;
		@FXML
	    private Menu menuVisualizza;
			@FXML
		    private MenuItem menuLibroGiornale;
			@FXML
		    private MenuItem menuRepartiDiProduzione;
			@FXML
		    private MenuItem menuCatalogoEMagazzino;
			@FXML
		    private MenuItem menuStatistiche;
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
		    private MenuItem menuCrediti;
			@FXML
		    private MenuItem menuContattaLAssistenza;
			@FXML
		    private MenuItem menuRiavviaIlProgramma;
    
				
	 
	@FXML
	private SplitPane splitPaneImprenditore;	
		@FXML
	    private AnchorPane anchorPaneSinistra;
		    @FXML
		    private Text textLibroGiornale;
			    @FXML
			    private ImageView iconaLibroGiornale;
			    @FXML
			    private Button apriDatiLibroGiornale;
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
			void visualizzaDatiDelLibroGiornale(ActionEvent event) throws IOException {
		    	visualizzaDati ("DatiLibroGiornale");
		    }
		    @FXML
		    void pulsanteEntraDatiLibroGiornalePremuto(KeyEvent  event) { //OK
		    	visualizzaDati ("DatiLibroGiornale");
		    }
		    @FXML
		    void visualizzaDatiDeiRepartiDiProduzione(ActionEvent event) throws IOException {
		    	visualizzaDati ("DatiRepartiDiProduzione");
		    }
		    @FXML
		    void visualizzaDatiDelCatalogoEDelMagazzino(ActionEvent event) throws IOException{
		    	
		    }
		
		    @FXML
		    void visualizzaDatiDelleStatistiche(ActionEvent event) {
		
		    }
		    void visualizzaDati (String url) {
		    	Parent rootLibroGiornale = null;
				try {
					rootLibroGiornale = (HBox) FXMLLoader.load(getClass().getResource( "/imprenditore_package/Dati/" + url + ".fxml" ));
				} catch (IOException ecc) {
					ecc.printStackTrace();
				}
				borderpaneDiDestra.setCenter(rootLibroGiornale);
		    }
		    
	@FXML
	public void initialize () {
		Image immagineSfondoPannelloLogin = new Image("/backgrounds/sfondo_generico.png");
		// BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
		BackgroundSize backgroundPannelloSize = new BackgroundSize(100, 100, true, true, true, true);
		// new BackgroundImage(image, repeatX, repeatY, position, size)
		BackgroundImage backgroundPannelloLogin= new BackgroundImage(immagineSfondoPannelloLogin,	
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
				backgroundPannelloSize );
		splitPaneImprenditore.setBackground(new Background(backgroundPannelloLogin));
	}
}