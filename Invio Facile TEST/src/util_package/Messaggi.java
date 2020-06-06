package util_package;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Messaggi {
	public static void erroreApriLibroGiornale() {
		Alert alert = new Alert (AlertType.INFORMATION);
			alert.setTitle("Apri libro giornale");
			alert.setHeaderText("Stai cercando di accedere il libro giornale.");
			alert.setContentText("Sei già all'interno del Libro Giornale, se desideri uscire puoi andare alla Home oppure, cliccando il tasto esci, tornerai alla schermata di Login.");
			
			alert.showAndWait();
	}
	
	public static void erroreSalvataggio() {
		Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Errore nel salvataggio");
    	alert.setHeaderText(null);
    	alert.setContentText("Scegli una cartella correttamente, se credi di averne scelta una correttamente contatta l'assistenza.");

    	alert.showAndWait();
	}
	
	public static void crediti() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Invio Facile!");
		alert.setHeaderText(null);
		alert.setContentText("Questo software è stato creato al fine del superamento dell'esame di IGPE da Alessandro Greco.\nUniversità Della Calabria - UNICAL");
	
		alert.showAndWait();
	}

	public static void contattaAssistenza() {
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Contatta l'assistenza");
    	alert.setHeaderText(null);
    	alert.setContentText("Stai contattando l'assistenza, se desideri un consulto immediato contatta il numero:\n+39 327 83 21 517");
    	ButtonType inviaUnaEmail = new ButtonType ("Invia una email");
    	alert.getButtonTypes().setAll(inviaUnaEmail);
    	
    	Optional<ButtonType> opzioneScelta = alert.showAndWait();
    	if(opzioneScelta.get() == inviaUnaEmail) {
    		//TODO
    		Util.inviaEmail();
    	}
	}
	
	public static void erroreDocumentoNegativo () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore d'inserimento in Documento N.");
		alert.setHeaderText(null);
		alert.setContentText("Non puoi inserire un numero negativo come numero del documento.");

		alert.showAndWait();
	}
	
	public static void erroreDocumentoSuperiore () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore d'inserimento in Documento N.");
		alert.setHeaderText(null);
		alert.setContentText("Non puoi inserire un numero del documento superiore a 10000.");

		alert.showAndWait();
	}
	
	public static void erroreDocumentoGenerico () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore d'inserimento in Documento N.");
		alert.setHeaderText(null);
		alert.setContentText("Puoi inserire solo un numero nel campo \"Documento N.\", non sono ammessi altri caratteri.");

		alert.showAndWait();
	}
	
	public static void erroreRepartoGenerico () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore in scegli reparto");
		alert.setHeaderText(null);
		alert.setContentText("Per continuare devi necessariamente scegliare un reparto.");

		alert.showAndWait();
	}
	public static void erroreIvaGenerico () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore in scegli iva");
		alert.setHeaderText(null);
		alert.setContentText("Per continuare devi necessariamente scegliare un iva.");

		alert.showAndWait();
	}
	
	public static void erroreDareEAvere () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore d'inserimento in Dare o Avere");
		alert.setHeaderText(null);
		alert.setContentText("Non puoi inserire sia Dare che Avere");

		alert.showAndWait();
	}
	
	public static void erroreAlmenoUnValoreDareEAvere () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore d'inserimento in Dare o Avere");
		alert.setHeaderText(null);
		alert.setContentText("Devi inserire almeno un valore in Dare o in Avere");

		alert.showAndWait();
	}
	
	public static void erroreGenericoDareEAvere () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore d'inserimento in Dare o Avere");
		alert.setHeaderText(null);
		alert.setContentText("Puoi inserire solo un numero sia nel campo \"Dare\" che nel campo \"Avere\", non sono ammessi altri caratteri e ricorda di usare il punto e non la virgola. \nSe inserisci un valore in Dare ricorda di mettere 0 in Avere (e viceversa)");

		alert.showAndWait();
	}
	
	public static void annullaVoce () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Annullamento");
		alert.setHeaderText(null);
		alert.setContentText("Hai annullato l'inserimento della nuova voce, non sono stati applicati ulteriori cambiamenti.");

		alert.showAndWait();
	}
	
	public static void erroreNomeProdotto () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore in nome prodotto");
		alert.setHeaderText(null);
		alert.setContentText("Per continuare devi necessariamente inserire il nome del prodotto.");

		alert.showAndWait();
	}
	
	public static void erroreSceltaRepartoProdotto () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore in scegli reparto");
		alert.setHeaderText(null);
		alert.setContentText("Per continuare devi necessariamente scegliare un reparto.");

		alert.showAndWait();
	}
	
	public static void errorePrezzoNegativoProdotto () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore in prezzo");
		alert.setHeaderText(null);
		alert.setContentText("Devi necessariamente inserire un valore superiore a zero quando inserisci il prezzo, e ricorda di inserirlo SENZA iva");

		alert.showAndWait();
	}
	
	public static void erroreGenericoPrezzoProdotto () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore in prezzo");
		alert.setHeaderText(null);
		alert.setContentText("Devi necessariamente inserire un valore in prezzo per continuare. Assicurati di non aver inserito altri caratteri.");

		alert.showAndWait();
	}
	
	public static void erroreIvaSceltaProdotto () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore in scegli iva");
		alert.setHeaderText(null);
		alert.setContentText("Per continuare devi necessariamente scegliare un iva.");

		alert.showAndWait();
	}
	
	public static void erroreDescrizioneProdotto() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore in descrizione");
		alert.setHeaderText(null);
		alert.setContentText("Devi necessariamente inserire una descrizione per continuare.");

		alert.showAndWait();
	}
	
	public static void annullaModifiche () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Annullamento");
		alert.setHeaderText(null);
		alert.setContentText("Hai annullato l'inserimento del nuovo prodotto, non sono stati applicati ulteriori cambiamenti.");

		alert.showAndWait();
	}
	
}
