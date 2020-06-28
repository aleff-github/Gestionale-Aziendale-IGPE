package statistiche_package;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
import util_package.GestisciInterfacce;
import util_package.Messaggi;
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
					    void apriLibroGiornale(ActionEvent event) { GestisciInterfacce.setFinestra("Libro Giornale"); }
					@FXML
					private MenuItem menuRepartiDiProduzione;
						@FXML
					    void apriRepartoDiProduzione(ActionEvent event) { GestisciInterfacce.setFinestra("Reparti Di Produzione"); }
					@FXML
					private MenuItem menuCatalogoEMagazzino;
						@FXML
					    void apriCatalogoEMagazzino(ActionEvent event) { GestisciInterfacce.setFinestra("Catalogo E Magazzino"); }
					@FXML
					private MenuItem menuStatistiche;
						@FXML
					    void apriStatistiche(ActionEvent event) { Messaggi.erroreApriStatistiche(); }
				@FXML
				private Menu menuOpzioni;
					@FXML
				    private MenuItem opzioneLeggiCommento;
				@FXML
			    private Menu menuAiuto;
				    @FXML
				    private MenuItem menuCrediti;
				    @FXML
				    void crediti(ActionEvent event) { Messaggi.crediti(); }
				    @FXML
				    private MenuItem menuContattaLAssistenza;
					    @FXML
					    void contattaLAssistenza(ActionEvent event) { Util.inviaEmail(); }			
    
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
							    private Button pulsanteLeggiCommentoAziendale;
							    @FXML
							    private TextArea areaDiTestoAdibitoAlCommentoAziendale;
						    @FXML
						    private BarChart andamentoAziendale;					    
							    @FXML
							    private CategoryAxis categoryAxisAziendale;
							    @FXML
							    private NumberAxis numberAxisAziendale;

							    private ObservableList<XYChart.Series<String, Double>> answer;
 
	public void initialize() {
    	categoryAxisAziendale.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
    			   "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER")));
    	categoryAxisAziendale.autosize();
//    	categoryAxisAziendale.setTickLength(100);
//    	categoryAxisAziendale.setTickLabelGap(100);
    	categoryAxisAziendale.setTickLabelRotation(500);
    	categoryAxisAziendale.setLabel("Reparto");
    	numberAxisAziendale.setLabel("Utile €");
        andamentoAziendale.setData(Util.acquisisciDatiStatistici());
        andamentoAziendale.setTitle("Andamento Aziendale");
	}
    @FXML
    void leggiCommentoAziendalePulsantePremuto(ActionEvent event) {
    	areaDiTestoAdibitoAlCommentoAziendale.appendText(Util.generaCommentoAndamentoAziendale());
    }
    @FXML
    void visualizzaCommentoAndamentoAziendale(ActionEvent event) {
    	areaDiTestoAdibitoAlCommentoAziendale.appendText(Util.generaCommentoAndamentoAziendale());
    }
    
}
