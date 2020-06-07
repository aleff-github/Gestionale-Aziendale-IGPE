package catalogo_e_magazzino;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Prodotto {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty nome;
	private SimpleStringProperty reparto;
	private SimpleDoubleProperty prezzo;
	private SimpleIntegerProperty iva;
	private SimpleStringProperty descrizione;
	private SimpleDoubleProperty prezzoFinale;
	
	public Prodotto(Integer id, String nome, String reparto, Double prezzo, Integer iva, String descrizione) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.nome = new SimpleStringProperty (nome);
		this.reparto = new SimpleStringProperty (reparto);
		this.prezzo = new SimpleDoubleProperty(prezzo);
		this.iva = new SimpleIntegerProperty(iva);
		this.descrizione = new SimpleStringProperty(descrizione);
		this.prezzoFinale = new SimpleDoubleProperty(calcolaPrezzoFinale(prezzo, iva)); // €50,00 * (1 + 0,22) ---> 50 * 1,22 ---> 61 Prezzo con iva
	}
	
	/*
	 * 
	 * SETTER ADN GETTER
	 * 
	 * */
	public Integer getId() {return id.get();}
	public void setId(Integer id) {this.id = new SimpleIntegerProperty (id);}
	public String getNome() {return nome.get();}
	public void setNome(String nome) {this.nome = new SimpleStringProperty (nome);}
	public String getReparto() {return reparto.get();}
	public void setReparto(String reparto) {this.reparto = new SimpleStringProperty (reparto);}
	public Double getPrezzo() {return prezzo.get();}
	public void setPrezzo(Double prezzo) {
		this.prezzo = new SimpleDoubleProperty (prezzo);
		setPrezzoFinale( calcolaPrezzoFinale( prezzo, getIva() ) );
	}
	public Integer getIva() {return iva.get();}
	public void setIva(Integer iva) {
		this.iva = new SimpleIntegerProperty (iva);
		setPrezzoFinale( calcolaPrezzoFinale( getPrezzo(), iva ) );
	}
	public String getDescrizione() {return descrizione.get();}
	public void setDescrizione(String descrizione) {this.descrizione = new SimpleStringProperty (descrizione);}
	public Double getPrezzoFinale() {return prezzoFinale.get();}
	public void setPrezzoFinale(Double prezzoFinale) {
		this.prezzoFinale = new SimpleDoubleProperty(prezzoFinale);
	}
	
	/*
	 * 
	 * METODI EXTRA
	 * 
	 * */
	private Double calcolaPrezzoFinale(Double prezzo, Integer iva) {
		return (prezzo * ((iva/100) + 1));
	}
	
}
