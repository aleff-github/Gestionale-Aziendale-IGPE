package imprenditore_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import util_package.GestisciInterfacce;

public class ControllerDatiRepartiDiProduzione {
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
			private AnchorPane anchorPaneBaseDatiRepartiDiProduzione;
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
}
