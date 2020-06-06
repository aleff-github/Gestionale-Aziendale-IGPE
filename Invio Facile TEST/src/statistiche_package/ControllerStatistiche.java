package statistiche_package;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import util_package.Util;

public class ControllerStatistiche {

	@FXML
    private AnchorPane anchorPaneBase;
		@FXML
	    private BorderPane borderPaneBase;
			@FXML
		    private MenuBar menuBar;
				@FXML
			    private Menu menuFile;
					@FXML
				    private MenuItem menuHome;
						@FXML
					    void tornaAllaHome(ActionEvent event) {
	
					    }
				    @FXML
				    private MenuItem menuDatiAziendali;
					    @FXML
					    void visualizzaDatiAziendali(ActionEvent event) {
	
					    }
					@FXML
					private MenuItem menuEmailVeloce;
						@FXML
					    void mandaEmailVeloce(ActionEvent event) {
	
					    }
					@FXML
					private MenuItem menuEsci;
						@FXML
					    void effettuaLogout(ActionEvent event) {
	
					    }
				@FXML
				private Menu menuVisualizza;
					@FXML
				    private MenuItem menuLibroGiornale;
						@FXML
					    void apriLibroGiornale(ActionEvent event) {
	
					    }
					@FXML
					private MenuItem menuRepartiDiProduzione;
						@FXML
					    void apriRepartoDiProduzione(ActionEvent event) {
	
					    }
					@FXML
					private MenuItem menuCatalogoEMagazzino;
						@FXML
					    void apriCatalogoEMagazzino(ActionEvent event) {
	
					    }
					@FXML
					private MenuItem menuStatistiche;
						@FXML
					    void apriStatistiche(ActionEvent event) {
			
					    }
				@FXML
				private Menu menuOpzioni;
					@FXML
				    private MenuItem impostaTuttoA6Mesi;
						@FXML
					    void actionImpostaTuttoA6Mesi(ActionEvent event) {
			
					    }
					@FXML
				    private MenuItem impostaTuttoA12Mesi;
						@FXML
					    void actionImpostaTuttoA12Mesi(ActionEvent event) {
			
					    }
					@FXML
				    private MenuItem impostaTuttoA24Mesi;
						@FXML
					    void actionImpostaTuttoA24Mesi(ActionEvent event) {
			
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
		    private ScrollPane scrollBar;			
			    @FXML
			    private AnchorPane anchorPaneScrollPane;					
				    @FXML
				    private VBox vBoxScrollPane;
					    @FXML
					    private HBox hBoxScrollPane;
						    @FXML
						    private AnchorPane anchorPaneAziendale;
							    @FXML
							    private Text funzionalitaTextAziendale;
							    @FXML
							    private ComboBox<?> periodoDiTempoAzienda;
							    @FXML
							    private Button pulsanteLeggiCommentoAziendale;
							    @FXML
							    private TextArea areaDiTestoAdibitoAlCommentoBitcoin;
						    @FXML
						    private BarChart<?, ?> andamentoAziendale;						    
							    @FXML
							    private CategoryAxis categoryAzisAziendale;
							    @FXML
							    private NumberAxis numberAxisAziendale;
				    
						@FXML
					    private HBox hBoxBitcoin;  
							@FXML
						    private AnchorPane anchorPaneBitcoin;
								@FXML
							    private Text funzionalitaTextBitcoin;
								@FXML
							    private ComboBox<?> periodoDiTempoBitcoin;
								@FXML
							    private Button pulsanteLeggiCommentoBitcoind;
								@FXML
							    private TextArea areaDiTestoAdibitoAlCommentoAziendale;
							@FXML
						    private LineChart<?, ?> andamentoBitcoin;
								@FXML
							    private CategoryAxis categoryAzisBitcoin;
								@FXML
							    private NumberAxis numberAxisBitcoin;
								
								

    
    @FXML
    void periodoDiTempoAziendaleSelezionato(ActionEvent event) {

    }
    @FXML
    void leggiCommentoAziendalePulsantePremuto(ActionEvent event) {

    }
    @FXML
    void visualizzaCommentoAndamentoAziendale(ActionEvent event) {

    }
    @FXML
    void periodoDiTempoBitcoinSelezionato(ActionEvent event) {

    }
    @FXML
    void leggiCommentoBitcoinPulsantePremuto(ActionEvent event) {

    }
    
}
