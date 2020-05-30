	package imprenditore_package;

	import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import util_package.GestisciInterfacce;

	public class ControllerDatiCatalogoEMagazzino {
		
		/* * * * * * * * * * * **
		 *                      *
		 * CATALOGO E MAGAZZINO *
		 *                      * 
		 *                      *
		 * * * * * * * * * * * */
		
		@FXML
	    private ScrollPane scrollPaneBase;
			@FXML
		    private AnchorPane anchorPaneBase;
				@FXML
			    private BorderPane borderPaneTitolo;
					@FXML
				    private HBox hBoxTitolo;
						@FXML
					    private ImageView catalocoEMagazzinoIcona;
						@FXML
					    private VBox vBoxTitolo;
							@FXML
						    private Text catalocoEMagazzinoTitolo;
							@FXML
						    private BorderPane borderPanePulsante;
								@FXML
							    private Button pulsanteVaicatalocoEMagazzino;
					@FXML
				    private GridPane catalocoEMagazzinoGridPane;
					@FXML private Label vociTotaliLabel; @FXML private Label vociTotali;
					@FXML private Label prodottiLabel; @FXML private Label prodotti;
					@FXML private Label scorteInMagazzinoLabel; @FXML private Label scorteInMagazzino;

		@FXML
	    void apriCatalocoEMagazzino(ActionEvent event) {
			GestisciInterfacce.setFinestra("Catalogo E Magazzino");
	    }

	}
