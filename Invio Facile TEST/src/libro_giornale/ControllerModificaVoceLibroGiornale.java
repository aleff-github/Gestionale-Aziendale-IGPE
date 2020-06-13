package libro_giornale;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import util_package.Messaggi;
import util_package.Util;

public class ControllerModificaVoceLibroGiornale {
	
	@FXML
    private AnchorPane anchorPaneModificaVoce;
		@FXML
	    private BorderPane borderPaneModificaVoce;
			@FXML
		    private HBox hBoxMenuModificaVoce;
				@FXML
			    private ImageView logoAziendale;
				@FXML
			    private VBox vBoxTitoloAzienda;
					@FXML private Label labelModificaVoce; @FXML private Label labelIPear;
				@FXML
			    private BorderPane borderPanePulsanti;
					@FXML
				    private HBox hBoxPulsanti;
						@FXML private BorderPane borderPaneModifica; @FXML private Button pulsanteModifica;
						
						@FXML private BorderPane borderPaneAnnulla; @FXML private Button pulsanteAnnulla;
				@FXML
			    private GridPane gridPaneModificaVoce;
					private Integer numeroDocumento;
					
					@FXML private Text textData; @FXML private DatePicker dataPicker;		
					
					@FXML private Text textDescrizione; @FXML private TextField textFieldDescrizione;
					
					@FXML private Text textReparto; @FXML private ComboBox<String> scegliReparto;
					
					@FXML private Text textIva; @FXML private ComboBox<Integer> scegliIva;
					
					@FXML private Text textDare; @FXML private TextField textFieldDare;
					
				    @FXML private Text textAvere; @FXML private TextField textFieldAvere;

    @FXML
	protected void initialize () {
		List<Integer> iva = new ArrayList<Integer>();
		iva.add(4);
		iva.add(10);
		iva.add(22);
		ObservableList o1 = FXCollections.observableArrayList(iva);
		scegliIva.getItems().clear();
		scegliIva.setItems(o1);
		scegliIva.setPromptText("Scegli");
		
		List<String> reparti = new ArrayList<String>();
		reparti.add("Fabbricazione e Montaggio");
		reparti.add("Test di Resistenza Ambientale");
		reparti.add("Pulizia e Imballaggio");
		ObservableList o2 = FXCollections.observableArrayList(reparti);
		scegliReparto.getItems().clear();
		scegliReparto.setItems(o2);
		scegliReparto.setPromptText("Scegli");
		

		
		VoceLibroGiornale voceSelezionata = Util.voceDaModificare;
		numeroDocumento = voceSelezionata.getDocumentoNumero();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		dataPicker.setValue(LocalDate.parse(voceSelezionata.getData()));
		
		textFieldDescrizione.setText(voceSelezionata.getDescrizione());
		scegliReparto.setValue(voceSelezionata.getReparto());
		scegliIva.setValue(voceSelezionata.getIva());
		textFieldDare.setText("" + voceSelezionata.getDare());
		textFieldAvere.setText("" + voceSelezionata.getAvere());
	}
			
    public static boolean flag = true;
    
    @FXML
    void modificaVoce(ActionEvent event) {
    	//DATA
		LocalDate localData = dataPicker.getValue();
		String data = localData.toString();
		
		//DESCRIZIONE
		String descrizione = textFieldDescrizione.getText();
		
		//REPARTO
		if(scegliReparto.getValue() == null) {
			Messaggi.erroreRepartoGenerico();
			flag = false;
		}
		String reparto = scegliReparto.getValue();
		
		//IVA

		Integer iva = scegliIva.getValue();
		if (iva == null) {
			Messaggi.erroreIvaGenerico();
			flag = false;
		}

		//DARE && AVERE
		Double dare = 0.0, avere = 0.0;
		try {
			dare = Double.parseDouble(textFieldDare.getText());
			avere = Double.parseDouble(textFieldAvere.getText());

			if(dare != 0.0 && avere != 0.0) {
				Messaggi.erroreDareEAvere();
				flag = false;
			}
			else if(dare == 0.0 && avere == 0.0) {
				Messaggi.erroreAlmenoUnValoreDareEAvere();
				flag = false;
			}
		}catch(NumberFormatException errore) {
			Messaggi.erroreGenericoDareEAvere();
			flag = false;
		}
		if(flag) 
			Util.modificaVoceLibroGiornale(new VoceLibroGiornale(data, numeroDocumento, descrizione, reparto, iva, dare, avere));
		
    }

    @FXML
    void annullaVoce(ActionEvent event) {

    }

}
