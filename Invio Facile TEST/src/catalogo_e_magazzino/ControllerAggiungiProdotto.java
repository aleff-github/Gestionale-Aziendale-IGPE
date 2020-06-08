package catalogo_e_magazzino;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import util_package.Messaggi;
import util_package.Util;

public class ControllerAggiungiProdotto {

	@FXML
	private AnchorPane anchorPaneAggiungiProdotto;
		@FXML
	    private BorderPane borderPaneAggiungiProdotto;
			@FXML
		    private HBox hBoxMenuAggiungiProdotto;
				@FXML
			    private ImageView logoAziendale;
				@FXML
				private VBox vBoxTitoloAzienda;
					@FXML
				    private Label labelAggiungiProdotto;
					@FXML
				    private Label labelIPear;
				@FXML
			    private BorderPane borderPanePulsanti;
					@FXML
					private HBox hBoxPulsanti;
						@FXML
					    private Button pulsanteAggiungi;
						@FXML
					    private Button pulsanteAnnulla;
				@FXML
			    private HBox hBoxGrigliaAggiungiProdotto;
					@FXML
				    private GridPane griPaneAggiungiProdotto;
						@FXML private Label nomeLabel; @FXML private TextField nomeField;
						
						@FXML private Label repartoLabel; @FXML private ComboBox<String> scegliReparto;
						
						@FXML private Label prezzoLabel; @FXML private TextField prezzoField;
						
						@FXML private Label ivaLabel; @FXML private ComboBox<Integer> scegliIva;
						
						@FXML private Label descrizioneLabel; @FXML private TextArea descrizioneTextArea;
						


    
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
    void aggiungiProdotto(ActionEvent event) {
    	//NOME
    	String nome = nomeField.getText();
    	if(nome.equals("")) {
    		Messaggi.erroreNomeProdotto();
			flag = false;
    	}
    	//REPARTO
    	if(scegliReparto.getValue() == null) {
			Messaggi.erroreSceltaRepartoProdotto();
			flag = false;
		}
		String repartoScelto = scegliReparto.getValue();
    	
    	//PREZZO
		Double prezzo = 0.0;
		try {
			String valoreInserito = prezzoField.getText();
			prezzo = Double.valueOf(valoreInserito);
			if(prezzo <= 0) {
				Messaggi.errorePrezzoNegativoProdotto();
				flag = false;
			}
		}catch(NumberFormatException errore) {
			Messaggi.erroreGenericoPrezzoProdotto();
			flag = false;
		}
		//IVA
		Integer ivaScelta = scegliIva.getValue();
		if (ivaScelta == null) {
			Messaggi.erroreIvaSceltaProdotto();
			flag = false;
		}
		
    	//DESCRIZIONE
		String descrizioneProdotto = descrizioneTextArea.getText();
		if(descrizioneProdotto.equals("")) {
			Messaggi.erroreDescrizioneProdotto();
			flag = false;
		}
		if(flag)
			Util.aggiungiVoceProdotto(new Prodotto (0, nome, repartoScelto, prezzo, ivaScelta, descrizioneProdotto));
    }

    @FXML
    void annullaModifiche(ActionEvent event) {
    	Messaggi.annullaModifiche();
    }
    

}
