package catalogo_e_magazzino;

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

    
    public static boolean flag = true;

    @FXML
    Prodotto modificaProdotto(ActionEvent event) {
    	//NOME
    	String nome = nomeField.getText();
    	if(nome.equals(null)) {
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
		if(descrizioneProdotto.equals(null)) {
			Messaggi.erroreDescrizioneProdotto();
			flag = false;
		}
		return new Prodotto (0, nome, repartoScelto, prezzo, ivaScelta, descrizioneProdotto);
    }

    @FXML
    void annullaModifiche(ActionEvent event) {
    	Messaggi.annullaModifiche();
    }

}
