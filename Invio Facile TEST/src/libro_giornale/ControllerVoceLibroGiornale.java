package libro_giornale;

import java.sql.Connection;
import java.sql.SQLException;
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
import util_package.DatabaseConnector;
import util_package.Messaggi;

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
					@FXML
				    private Label labelAggiungiVoce;
					@FXML
				    private Label labelIPear;
				@FXML
			    private BorderPane borderPanePulsanti;
					@FXML
				    private HBox hBoxPulsanti;
						@FXML
					    private BorderPane borderPaneAggiungi;
							@FXML
						    private Button pulsanteAggiungi;
						@FXML
					    private BorderPane borderPaneAnnulla;
							@FXML
						    private Button pulsanteAnnulla;
				@FXML
			    private GridPane gridPaneAggiungiVoce;
					@FXML
				    private Text textData;
						@FXML
					    private DatePicker dataPicker;
					@FXML
				    private Text textDocumentoNumero;
						@FXML
					    private TextField textFieldNumero;
					@FXML
				    private Text textDescrizione;
						@FXML
					    private TextField textFieldDescrizione;
					@FXML
				    private Text textReparto;
						@FXML
					    private ComboBox<String> scegliReparto;
					@FXML
				    private Text textIva;
						@FXML
					    private ComboBox<Integer> scegliIva;
					@FXML
				    private Text textDare;
						@FXML
					    private TextField textFieldDare;
					@FXML
				    private Text textAvere;
						@FXML
					    private TextField textFieldAvere;
	
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
		
		//NUMERO DOCUMENTO
		Integer documentoNumero = -1;
		try {
			documentoNumero = Integer.parseInt(textFieldNumero.getText());
			if(documentoNumero < 0) {
				Messaggi.erroreDocumentoNegativo();
				flag = false;
			}
			else if (documentoNumero > 10000) {
				Messaggi.erroreDocumentoSuperiore();
				flag = false;
			}
		}catch(NumberFormatException errore){ //TODO eccezione void
			Messaggi.erroreDocumentoGenerico();
			flag = false;
		}
		
		//DESCRIZIONE
		String descrizione = textFieldDescrizione.getText();
		
		//REPARTO
		if(scegliReparto.getValue() == null) {
			Messaggi.erroreRepartoGenerico();
			flag = false;
		}
		String repartoScelto = scegliReparto.getValue();
		
		//IVA

		Integer ivaScelta = scegliIva.getValue();
		if (ivaScelta == null) {
			Messaggi.erroreIvaGenerico();
			flag = false;
		}

		//DARE && AVERE
		//String dareString = dareField.getText(), avereString = avereField.getText();
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
//				public VoceLibroGiornale(String data, Integer documentoNumero, String descrizione, String reparto, Integer iva, Double dare, Double avere)
		if(flag) {
			//TODO
			String query = "INSERT INTO `invio_facile`.`data` 	"
					+ "(`data`, `descrizione`, `reparto`, `iva`, `dare`, `avere`) 	"
					+ "VALUES ('" + data + "', '" + descrizione + "', 	"
							+ "'" + repartoScelto + "', '" + ivaScelta + "', 	"
									+ "'" + dare + "', '" + avere + "');";
			try {
				Connection con = DatabaseConnector.getConnection();
				con.createStatement().executeUpdate(query);			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }

    @FXML
    void annullaVoce(ActionEvent event) {
    	Messaggi.annullaVoce();
    }


}
