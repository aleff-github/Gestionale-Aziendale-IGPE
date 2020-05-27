package util_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ControllerDatiAziendali {
	
	@FXML
    private AnchorPane anchorPaneDatiAziendali;
		@FXML
	    private BorderPane borderPaneDatiAziendali;
			@FXML
		    private HBox hBoxMenuDatiAziendali;
				@FXML
			    private ImageView logoAziendale;
				@FXML
			    private VBox vBoxTitoloAzienda;
					@FXML
				    private Label labelDatiAziendali;
					@FXML
				    private Label labelIPear;
				@FXML
			    private BorderPane borderPanePulsanti;
					@FXML
				    private Button pulsanteModifica;
					@FXML
				    private Button pulsanteSalvaEChiudi;
					@FXML
				    private Button pulsanteAnnulla;
				@FXML
			    private HBox hBoxDatiAziendali;
					@FXML
				    private GridPane griPaneDatiAziendali;
						@FXML
					    private Label ragioneSocialeLabel;
						@FXML
					    private TextField ragioneSocialeField;
						@FXML
					    private Label partitaIvaLabel;
						@FXML
					    private TextField partitaIvaField;
						@FXML
					    private Label codiceUnivocoLabel;
						@FXML
					    private TextField codiceUnivocoField;
						@FXML
					    private Label titolareLabel;
						@FXML
					    private TextField titolareField;
						@FXML
					    private Label emailLabel;
						@FXML
					    private TextField emailField;
						@FXML
					    private Label capitaleSocialeLabel;
						@FXML
					    private TextField capitaleSocialeField;
 
	
	
	@FXML
	public void initialize() {
		ragioneSocialeField.setText(Util.ragioneSociale);
		partitaIvaField.setText(Util.partitaIva);
		codiceUnivocoField.setText(Util.codiceUnivoco);
		titolareField.setText(Util.titolare);
		emailField.setText(Util.email);
		capitaleSocialeField.setText(Util.capitaleSociale); 
		
		ragioneSocialeField.setEditable(false);
		partitaIvaField.setEditable(false);
		codiceUnivocoField.setEditable(false);
		titolareField.setEditable(false);
		emailField.setEditable(false);
		capitaleSocialeField.setEditable(false);
		
	}
	
    @FXML
    void salvaEChiudi(ActionEvent event) {
    	Util.datiAziendaliCambiati(ragioneSocialeField.getText(),	
						    			partitaIvaField.getText(),	
						    			codiceUnivocoField.getText(), 	
						    			titolareField.getText(), 	
						    			emailField.getText(), 	
						    			capitaleSocialeField.getText());
    	
    	ragioneSocialeField.setEditable(false);
		partitaIvaField.setEditable(false);
		codiceUnivocoField.setEditable(false);
		titolareField.setEditable(false);
		emailField.setEditable(false);
		capitaleSocialeField.setEditable(false);
    }

    @FXML
    void modificaDatiAziendali(ActionEvent event) {
    	 
    	ragioneSocialeField.setEditable(true);
		partitaIvaField.setEditable(true);
		codiceUnivocoField.setEditable(true);
		titolareField.setEditable(true);
		emailField.setEditable(true);
		capitaleSocialeField.setEditable(true);
    }

    @FXML
    void annullaModifiche(ActionEvent event) {
    	//RIPRISTINO LE MODIFICHE
    	ragioneSocialeField.setText(Util.ragioneSociale);
		partitaIvaField.setText(Util.partitaIva);
		codiceUnivocoField.setText(Util.codiceUnivoco);
		titolareField.setText(Util.titolare);
		emailField.setText(Util.email);
		capitaleSocialeField.setText(Util.capitaleSociale);
    	
    	ragioneSocialeField.setEditable(false);
		partitaIvaField.setEditable(false);
		codiceUnivocoField.setEditable(false);
		titolareField.setEditable(false);
		emailField.setEditable(false);
		capitaleSocialeField.setEditable(false);
    }

}
