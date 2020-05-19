package imprenditore_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import libro_giornale.ControllerLibroGiornale;
import util_package.GestisciInterfacce;

public class ControllerDatiDaStampare {
	
	@FXML
	public void initialize() {
//		LIBRO GIORNALE
			try {
				String vociTotali = String.valueOf( ControllerLibroGiornale.getVociTotali() );
					numeroVociTotale.setText(vociTotali);
				String dareTotale = String.valueOf(ControllerLibroGiornale.getDareTotale());
					numeroDareTotale.setText(dareTotale);
				String avereTotale = String.valueOf(ControllerLibroGiornale.getAvereTotale());
				numeroAvvereTotale.setText(avereTotale);
			}catch(IllegalArgumentException ecc) {
				ecc.printStackTrace();
			}
	}
	
	/* * * * * * * * * * * **
	 *                      *
	 *    LIBRO GIORNALE    *
	 *                      * 
	 *                      *
	 * * * * * * * * * * * */
	@FXML
    private HBox hBoxLibroGiornale;
		@FXML
	    private BorderPane borderPaneLibroGiornale;
			@FXML
		    private HBox hBoxTitoloLibroGiornale;
				@FXML
			    private ImageView libroGiornaleIcon;
				@FXML
			    private VBox vBoxTitoloEPulsanteLibroGiornale;
					@FXML
					private Text libroGiornaleTitolo;
					@FXML
				    private BorderPane borderPanePulsanteLibroGiornale;
						@FXML
						private Button pulsanteVaiALibroGiornale;
							@FXML
							void apriLibroGiornale(ActionEvent event) {
								GestisciInterfacce.setFinestra("Libro Giornale");
						    }
			@FXML
			private GridPane gridPaneLibroGiornale;
				@FXML
			    private Text vociTotaliText;
					@FXML
					private Text numeroVociTotale;
				@FXML
				private Text dareTotaleText;
					@FXML
					private Text numeroDareTotale;
				@FXML
				private Text avereTotaleText;
					@FXML
					private Text numeroAvvereTotale;

	/* * * * * * * * * * * **
	 *                      *
	 * REPARTI DI PRODUZIONE *
	 *                      * 
	 *                      *
	 * * * * * * * * * * * */
					
	@FXML
	private HBox hBoxRepartiDiProduzione;
		@FXML
	    private ScrollPane scrollPane;
			@FXML
		    private BorderPane borderPaneRepartiDiProduzione;
				@FXML
			    private HBox hBoxTitoloRepartiDiProduzione;
					@FXML
				    private ImageView repartiDiProduzioneIcon;
					@FXML
				    private VBox vBoxTitoloEPulsanteRepartiDiProduzione;
						@FXML
					    private Text repartiDiProduzioneTitolo;
						@FXML
					    private BorderPane borderPanePulsanteRepartiDiProduzione;
							@FXML
						    private Button pulsanteVaiARepartiDiProduzione;
								@FXML
								void apriRepartiDiProduzione(ActionEvent event) {
									GestisciInterfacce.setFinestra("Reparti Di Produzione");
							    }
					@FXML
					private GridPane gridPaneDatiRepartiDiProduzione;
						@FXML
					    private HBox hBoxDatiContenutiRepartoDiProduzione;
							@FXML
						    private BorderPane borderPaneDatiFabbricazioneEMontaggio;
								@FXML
							    private ImageView iconaDatiFabbricazioneEMontaggio;
								@FXML
							    private Text datiFabbricazioneEMontaggioTitolo;
								@FXML
							    private Button pulsanteGeneraCommentoDatiFabbricazioneEMontaggio;
									@FXML
								    void generaCommentoFabbricazioneEMontaggio(ActionEvent event) {
		
								    }
							@FXML
							private TextArea areaDiTestoCommentoFabbricazioneEMontaggio;
							@FXML
						    private BorderPane borderPaneDatiTestDiResistenzaAmbientale;
								@FXML
							    private ImageView iconaDatiTestDiResistenzaAmbientale;
								@FXML
							    private Text titoloDatiTestDiResistenzaAmbientale;
								@FXML
							    private Button pulsanteDatiTestDiResistenzaAmbientale;
									@FXML
								    void generaCommentoTestDiResistenzaAmbientale(ActionEvent event) {
		
								    }
							@FXML
							private TextArea textAreaDatiTestDiResistenzaAmbientale;
							@FXML
							private BorderPane borderPaneDatiPulizziaEImballaggio;
								@FXML
							    private ImageView iconaDatiPulizziaEImballaggio;
								@FXML
							    private Text titoloDatiPulizziaEImballaggio;
								@FXML
							    private Button pulsanteDatiPulizziaEImballaggio;
								@FXML
							    void generaCommentoPulizziaEImballaggio(ActionEvent event) {
	
							    }	
							@FXML
							private TextArea textAreaDatiPulizziaEImballaggio;
	/* * * * * * * * * * * **
	 *                      *
	 * CATALOGO E MAGAZZINO *
	 *                      * 
	 *                      *
	 * * * * * * * * * * * */
							//TODO
							
	/* * * * * * * * * * * **
	*                      *
	*     STATISTICHE      *
	*                      * 
	*                      *
	* * * * * * * * * * * */
							//TODO
}
