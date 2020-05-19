package login_package;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import util_package.GestisciInterfacce;
import util_package.Util;

public class LoginController implements Initializable{
	 
	@FXML
    private AnchorPane loginAnchorPane;
		@FXML
	    private AnchorPane quadratoDelLogin;
			@FXML
		    private VBox boxContenitoreDiBorderPane;
			
				@FXML /*   LOGIN   */
			    private BorderPane borderPaneUsername;
					@FXML
				    private ImageView iconaUsername;
					@FXML
				    private TextField usernameField;
				@FXML
			    private BorderPane borderPanePassword;
					@FXML
				    private ImageView iconaPassword;
					@FXML
				    private PasswordField passwordField;
					
				@FXML /*   PULSANTI   */
			    private HBox hBoxPulsanti;
					@FXML
				    private BorderPane borderPaneEntra;
						@FXML
					    private Button entraButton;
					@FXML
				    private BorderPane borderPaneAssistenza;
						@FXML
					    private Button assistenzaButton;
    
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		SFONDO LOGIN
			// nuova immagine (url)
			Image immagineSfondoLogin = new Image("/backgrounds/sfondo_login.png");
			// BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
			BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
			// new BackgroundImage(image, repeatX, repeatY, position, size)
			BackgroundImage backgroundPaginaLogin= new BackgroundImage(immagineSfondoLogin,	
					BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
					backgroundSize );
			loginAnchorPane.setBackground(new Background(backgroundPaginaLogin));
	
	}
	
	private static HashMap<String, String> utenti = new HashMap<String, String>();
	
	public static void init (String username, String password) {
//		admin - admin
		utenti.put(username, password);
		
	}
	
	public static void add (String username, String Password) {
		if(!utenti.containsKey(username))
			utenti.put(username, Password);
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore di login");
			alert.setHeaderText(null);
			alert.setContentText("Questo username non può essere utilizzato.");
		
			alert.showAndWait();
	
		}
	}
	
	@FXML
    void pulsanteEntraPremutoInvio(KeyEvent  event) { //OK
		switch (event.getCode()) {
	        case ENTER:
	        	login();
	        default:
	            break;
        }
    
    }
	
    @FXML
    void pulsanteEntraPremuto(ActionEvent event) { //OK
    	login();
    }
    
    @FXML
    void pulsanteContattaLAssistenzaPremuto(ActionEvent event) {
    	Util.inviaEmail();
    }
	
	void login() {
		String username = usernameField.getText();
    	if(utenti.containsKey(username)) {
    		String password = passwordField.getText();
    		if(utenti.get(username).equals(password)) {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Login effettuato");
    			alert.setHeaderText(null);
    			alert.setContentText("Il login è avvenuto con successo!");
    		
    			alert.showAndWait();
    			
    			
    			GestisciInterfacce.setFinestra("Imprenditore");
    			
    		}
//    		Non aggiungo la notifica dell'errore d'inserimento della password per non notificare che l'utente esiste
    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore di login");
			alert.setHeaderText(null);
			alert.setContentText("I dati inseriti non sono corretti, t'invitiamo a riprovare.");
		
			alert.showAndWait();
    	}
    	passwordField.clear();
    }    
    
}
