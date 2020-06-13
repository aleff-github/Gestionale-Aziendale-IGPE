package libro_giornale;

import java.time.LocalDate;
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

public class ControllerVoceLibroGiornale {
	
	@FXML
    private AnchorPane anchorPaneAggiungiVoceBase;
		@FXML
	    private BorderPane borderPaneAggiungiVoce;
			@FXML
		    private HBox hBoxMenuAggiungiVocePulsanti;
				@FXML
			    private ImageView logoAziendale;
				@FXML
			    private VBox vBoxTitoloAzienda;
					@FXML private Label labelAggiungiVoce; @FXML private Label labelIPear;
				@FXML
			    private BorderPane borderPanePulsanti;
					@FXML
				    private HBox hBoxPulsanti;
						@FXML private BorderPane borderPaneAggiungi; @FXML private Button pulsanteAggiungi;
						
						@FXML private BorderPane borderPaneAnnulla; @FXML private Button pulsanteAnnulla;
				@FXML
			    private GridPane gridPaneAggiungiVoce;
					@FXML private Text textData; @FXML private DatePicker dataPicker;
					
					@FXML private Text textDocumentoNumero; @FXML private TextField textFieldNumero;
					
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
	}
    
    public static boolean flag = true;

    @FXML
    void aggiungiVoce(ActionEvent event) {
		//DATA
		LocalDate localData = dataPicker.getValue();
		String data = localData.toString();
		if(data.equals("")) {
			Messaggi.erroreData();
			flag = false;
		}
		
		//DESCRIZIONE
		String descrizione = textFieldDescrizione.getText();
		if(descrizione.equals("")) {
			Messaggi.erroreDescrizioneVoceLibroGiornale();
		}
		
		//REPARTO
		String reparto = scegliReparto.getValue();
		if(reparto.equals("")) {
			Messaggi.erroreRepartoGenerico();
			flag = false;
		}
		
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
			Util.aggiungiVoceLibroGiornale(new VoceLibroGiornale(data, 0, descrizione, reparto, iva, dare, avere));
    }

    @FXML
    void annullaVoce(ActionEvent event) {
    	Messaggi.annullaVoce();
    }
}
