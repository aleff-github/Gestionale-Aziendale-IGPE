package libro_giornale;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import util_package.Util;

public class ControllerVoceLibroGiornale {
	@FXML
	private GridPane gridPaneAggiungiVoce;
	
	@FXML
	 private Text textIva;
	@FXML 
	private Text textData;
	@FXML
	private Text textDocumentoNumero;
	@FXML 
	private Text textDescrizione;
	@FXML 
	private Text textReparto;
	@FXML 
	private Text textDare;
	@FXML 
	private Text textAvere;
	@FXML 
	private TextField textFieldNumero;
	@FXML 
	private TextField textFieldAvere;
	@FXML 
	private TextField textFieldDare;
	@FXML 
	private TextField textFieldDescrizione;
	@FXML
	private DatePicker dataPicker;
	@FXML
	private ComboBox<Integer> scegliIva;
	
	@FXML
	private ComboBox<String> scegliReparto;
	
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

	public boolean popupAggiungiVoce () throws IOException { 
		Alert dialogo = new Alert(AlertType.INFORMATION); 
		dialogo.setTitle("Aggiungi voce");
		dialogo.setHeaderText("Se riscontri problemi nell'inserimento dei dati contatta l'assistenza.");
		dialogo.setResizable(true); 
		
		try {
			GridPane rootAggiungiVoce = (GridPane) FXMLLoader.load(getClass().getResource( "PopupAggiungiVoce.fxml" )); 
			dialogo.getDialogPane().setContent(rootAggiungiVoce); 
			
			dialogo.getButtonTypes().clear();
			ButtonType buttonTypeAggiungi = new ButtonType("Aggiungi");
			dialogo.getButtonTypes().add(buttonTypeAggiungi);
			ButtonType buttonTypeAnnulla = new ButtonType("Annulla");
			dialogo.getButtonTypes().add(buttonTypeAnnulla);

			Optional<ButtonType> opzioneScelta = dialogo.showAndWait(); 
			try {
				if (opzioneScelta.get() == buttonTypeAggiungi) {
					//DATA
					String data = dataPicker.getValue().toString();
					System.out.println(dataPicker.getValue().toString());
					
					//NUMERO DOCUMENTO
					Integer documentoNumero;
					try {
						documentoNumero = Integer.parseInt(textFieldNumero.getText());
						if(documentoNumero < 0) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Errore d'inserimento in Documento N.");
							alert.setHeaderText(null);
							alert.setContentText("Non puoi inserire un numero negativo come numero del documento.");
	
							alert.showAndWait();
							return false;
						}
						else if (documentoNumero > 10000) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Errore d'inserimento in Documento N.");
							alert.setHeaderText(null);
							alert.setContentText("Non puoi inserire un numero del documento superiore a 10000.");
	
							alert.showAndWait();
							return false;
						}
					}catch(NumberFormatException errore){
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Errore d'inserimento in Documento N.");
						alert.setHeaderText(null);
						alert.setContentText("Puoi inserire solo un numero nel campo \"Documento N.\", non sono ammessi altri caratteri.");
	
						alert.showAndWait();
						return false;
					}
					//DESCRIZIONE
					String descrizione = textFieldDescrizione.getText();
					
					//REPARTO
					if (scegliReparto.getValue() == null) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Errore in scegli reparto");
						alert.setHeaderText(null);
						alert.setContentText("Per continuare devi necessariamente scegliare un reparto.");
	
						alert.showAndWait();
						return false;
					}
					
					//REPARTO
					if(scegliReparto.getValue() == null) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Errore in scegli reparto");
						alert.setHeaderText(null);
						alert.setContentText("Per continuare devi necessariamente scegliare un reparto.");
	
						alert.showAndWait();
						return false;
					}
					//else - non lo metto in un else perché altrimenti non viene visualizzato dopo
					String repartoScelto = scegliReparto.getValue();
					
					//IVA
					if (scegliIva.getValue() == null) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Errore in scegli iva");
						alert.setHeaderText(null);
						alert.setContentText("Per continuare devi necessariamente scegliare un iva.");
	
						alert.showAndWait();
						return false;
					}
					//else - non lo metto in un else perché altrimenti non viene visualizzato dopo
					Integer ivaScelta = scegliIva.getValue();
	
					//DARE && AVERE
					//String dareString = dareField.getText(), avereString = avereField.getText();
					Double dare = 0.0, avere = 0.0;
					try {
						dare = Double.parseDouble(textFieldDare.getText());
						avere = Double.parseDouble(textFieldAvere.getText());
	
						if(dare != 0.0 && avere != 0.0) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Errore d'inserimento in Dare o Avere");
							alert.setHeaderText(null);
							alert.setContentText("Non puoi inserire sia Dare che Avere");
	
							alert.showAndWait();
							return false;
						}
						else if(dare == 0.0 && avere == 0.0) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Errore d'inserimento in Dare o Avere");
							alert.setHeaderText(null);
							alert.setContentText("Devi inserire almeno un valore in Dare o in Avere");
	
							alert.showAndWait();
							return false;
						}
					}catch(NumberFormatException errore) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Errore d'inserimento in Dare o Avere");
						alert.setHeaderText(null);
						alert.setContentText("Puoi inserire solo un numero sia nel campo \"Dare\" che nel campo \"Avere\", non sono ammessi altri caratteri e ricorda di usare il punto e non la virgola. \nSe inserisci un valore in Dare ricorda di mettere 0 in Avere (e viceversa)");
	
						alert.showAndWait();
						return false;
					}
	//				public VoceLibroGiornale(String data, Integer documentoNumero, String descrizione, String reparto, Integer iva, Double dare, Double avere)
					
					Util.aggiungiVoce(new VoceLibroGiornale(data, documentoNumero, descrizione, repartoScelto, ivaScelta, dare, avere));
					return true;
				}
				else if (opzioneScelta.get() == buttonTypeAnnulla){
						dialogo.close();
						return false;
					}
			}catch(Exception eccPulsanti) {
				System.out.println("000");
				eccPulsanti.printStackTrace();
				System.out.println("000");
			}

		} catch (NullPointerException eccFile) {
			System.out.println("----");
			eccFile.printStackTrace();
			System.out.println("----");
			return false;
	
		}
		return false;
	}

}
