package util_package;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GestisciInterfacce{
	private static HashMap<String, Pane> finestre = new HashMap<String, Pane>();
	private static Scene main;
	
	/* Login
		 * Imprenditore
			 * Reparti Di Produzione
			 * Libro Giornale
			 * Catalogo E Magazzino
			 * Statistiche
	 */
	
	public static void inizio (Scene m) {
		main = m;
	}
	
	public static void add (String nome, Pane pannello) {
		finestre.put(nome, pannello);
	}
	
	public static void setFinestra (String nome) {
		main.setRoot(finestre.get(nome));
	}
	
}
