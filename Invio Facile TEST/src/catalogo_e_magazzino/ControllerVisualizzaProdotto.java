package catalogo_e_magazzino;

import java.io.File;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import util_package.Util;

public class ControllerVisualizzaProdotto {
	
	@FXML
    private AnchorPane anchorPaneVisualizzaProdotto;
		@FXML
	    private BorderPane borderPaneVisualizzaProdotto;
			@FXML
		    private HBox hBoxGrigliaVisualizzaProdotto;
				@FXML
			    private ImageView logoAziendale;
				@FXML
			    private VBox vBoxTitoloAzienda;
					@FXML
				    private Label visualizzaProdottoLabel;
				    @FXML
				    private Label labelIPear;
			    @FXML
			    private BorderPane borderPanePulsanti;
				    @FXML
				    private HBox hBoxPulsanti;
					    @FXML
					    private Button pulsanteModifica;
					    @FXML
					    private Button pulsanteAnnulla;
		    @FXML
		    private HBox hBoxMenuVisualizzaProdotto;
			    @FXML
			    private GridPane griPaneVisualizzaProdotto;
			    @FXML
			    private Label idProdottoLabel; @FXML private TextField idProdottoField;
			    @FXML
			    private Label nomeLabel; @FXML private TextField nomeField;
			    @FXML
			    private Label repartoLabel; @FXML private ComboBox<String> scegliReparto;
			    @FXML
			    private Label prezzoLabel; @FXML private TextField prezzoField;
			    @FXML
			    private Label ivaLabel; @FXML private ComboBox<Integer> scegliIva;
			    @FXML
			    private Label fotoDelProdottoLabel; @FXML private ImageView fotoDelProdotto;
				    @FXML
				    private BorderPane borderPaneFoto; @FXML private Button pulsanteCaricaFoto;
				@FXML
				private Label descrizioneLabel; @FXML private TextArea descrizioneTextArea;


    @FXML
    void caricaFoto(ActionEvent event) {
      	FileChooser scegliFoto = new FileChooser();
    	scegliFoto.setTitle("Seleziona immagine");
    	scegliFoto.getExtensionFilters().addAll(	
    	       new ExtensionFilter("Immagine in formato PNG", "*.png")
    	       );
	    File fileSelezionato = scegliFoto.showOpenDialog(null);
	    
	    Image immagine = new Image(fileSelezionato.toURI().toString());
	    
	    if(fileSelezionato != null) {
	    	
	    	fotoDelProdotto.setImage(immagine);
	    }
    }
    
    public static boolean flag = true;

    @FXML
    Prodotto modificaProdotto(ActionEvent event) {
    	
    	//ID PRODOTTO
    	Integer id = -1;
    	try{
    		Integer idDaInput = Integer.valueOf(idProdottoField.getText());
    		id = Util.gestisciIdPerUnNuovoProdotto(idDaInput);
    		if(id == -1) {
    			
    			Alert alert = new Alert(AlertType.ERROR);
    	    	alert.setTitle("Errore nell'inserimento dell'Id");
    	    	alert.setHeaderText(null);
    	    	alert.setContentText("L'id inserito non è valito o è già presente un altro prodotto con questo id. Vuoi gerenarne uno automaticamente?");
    	    	ButtonType continua = new ButtonType ("Genera automaticamente");
    	    	ButtonType nonContinuare = new ButtonType ("Annulla operazione");
    	    	alert.getButtonTypes().setAll(continua, nonContinuare);
    	    	
    	    	Optional<ButtonType> opzioneScelta = alert.showAndWait();
    	    	if(opzioneScelta.get() == continua) {
    	    		id = Util.gestisciIdPerUnNuovoProdotto(null);
    	    		Alert alertInterno = new Alert(AlertType.INFORMATION);
    	    		alertInterno.setTitle("Id generato");
    	    		alertInterno.setHeaderText(null);
    	    		alertInterno.setContentText("Id generato correttamente: " + id);
    	    		alertInterno.showAndWait();
    	    	}
    	    	else if( opzioneScelta.get() == nonContinuare) flag = false;
    		}
    	}catch(NumberFormatException ecc){
    		flag = false;
    	}
    	//NOME
    	String nome = nomeField.getText();
    	if(nome.equals(null)) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore in nome prodotto");
			alert.setHeaderText(null);
			alert.setContentText("Per continuare devi necessariamente inserire il nome del prodotto.");

			alert.showAndWait();
			flag = false;
    	}
    	//REPARTO
    	if(scegliReparto.getValue() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore in scegli reparto");
			alert.setHeaderText(null);
			alert.setContentText("Per continuare devi necessariamente scegliare un reparto.");

			alert.showAndWait();
			flag = false;
		}
		String repartoScelto = scegliReparto.getValue();
    	
    	//PREZZO
		Double prezzo = 0.0;
		try {
			String valoreInserito = prezzoField.getText();
			prezzo = Double.valueOf(valoreInserito);
			if(prezzo <= 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Errore in prezzo");
				alert.setHeaderText(null);
				alert.setContentText("Devi necessariamente inserire un valore superiore a zero quando inserisci il prezzo, e ricorda di inserirlo SENZA iva");

				alert.showAndWait();
				flag = false;
			}
		}catch(NumberFormatException errore) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore in prezzo");
			alert.setHeaderText(null);
			alert.setContentText("Devi necessariamente inserire un valore in prezzo per continuare. Assicurati di non aver inserito altri caratteri.");

			alert.showAndWait();
			flag = false;
		}
		//IVA
		Integer ivaScelta = scegliIva.getValue();
		if (ivaScelta == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore in scegli iva");
			alert.setHeaderText(null);
			alert.setContentText("Per continuare devi necessariamente scegliare un iva.");

			alert.showAndWait();
			flag = false;
		}
		
    	//FOTO DEL PRODOTTO
		
    	//DESCRIZIONE
		String descrizioneProdotto = descrizioneTextArea.getText();
		if(descrizioneProdotto.equals(null)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore in descrizione");
			alert.setHeaderText(null);
			alert.setContentText("Devi necessariamente inserire una descrizione per continuare.");

			alert.showAndWait();
			flag = false;
		}
		
		return new Prodotto (id, nome, repartoScelto, prezzo, ivaScelta, fotoDelProdotto, descrizioneProdotto);
		
    }

    @FXML
    void annullaModifiche(ActionEvent event) {
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Annullamento");
		alert.setHeaderText(null);
		alert.setContentText("Hai annullato l'inserimento del nuovo prodotto, non sono stati applicati ulteriori cambiamenti.");

		alert.showAndWait();
    }

}
