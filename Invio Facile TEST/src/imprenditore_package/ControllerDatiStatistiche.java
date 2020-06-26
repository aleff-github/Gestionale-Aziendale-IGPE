package imprenditore_package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import util_package.Util;

public class ControllerDatiStatistiche {
	
	@FXML
    private ScrollPane scrollPaneStatistiche;
		@FXML
	    private AnchorPane anchorPaneStatistiche;
			@FXML
		    private BorderPane borderPaneTitolo;
				@FXML
			    private HBox hBoxTitolo;
					@FXML
				    private ImageView statisticheIcona;
				@FXML
			    private BorderPane borderPanePulsante;
					@FXML private Text statisticheTitolo;
					@FXML private Button pulsanteVaiStatistiche;
				@FXML
				private GridPane statisticheGridPane;
					@FXML private Label testoPaginaStatisticheLable; @FXML private TextArea commentoPaginaStatistiche;
					@FXML private Label vociPerMeseLabel; @FXML private TextArea vociPerMeseTextArea;
					@FXML private Label mesiCalcolatiLabel; @FXML private Label mesiCalcolati;
	@FXML
	private void initialize () {
		mesiCalcolati.setText(String.valueOf(Util.MESI_DA_CONTROLLARE));
		vociPerMeseTextArea.appendText(Util.vociTotaliPerMese());
	}
	
    @FXML
    void apriStatistiche(ActionEvent event) {

    }

}
