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
import libro_giornale.ControllerLibroGiornale;
import util_package.GestisciInterfacce;

public class ControllerDatiDaStampare {
	
	/* * * * * * * * * * * **
	 *                      *
	 *    LIBRO GIORNALE    *
	 *                      * 
	 *                      *
	 * * * * * * * * * * * */
	
	@FXML
	public void initialize() {
//		LIBRO GIORNALE - SETTING
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
					private Text numeroVociTotale; //NUMERO VOCI TOTALE
				@FXML
				private Text dareTotaleText;
					@FXML
					private Text numeroDareTotale; //NUMERO DARE TOTALE
				@FXML
				private Text avereTotaleText;
					@FXML
					private Text numeroAvvereTotale; //NUMERO AVERE TOTALE

}
