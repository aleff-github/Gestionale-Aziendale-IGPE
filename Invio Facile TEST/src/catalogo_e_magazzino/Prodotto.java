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
	
	
	
	public Prodotto() {
//		super();
		this.nome = new SimpleStringProperty ("NoName");
		this.reparto = new SimpleStringProperty ("NoDepartment");
		this.prezzo = new SimpleDoubleProperty(99.9);
		this.iva = new SimpleIntegerProperty (22);
		this.descrizione = new SimpleStringProperty ("No description.id");
	}
	
	public Prodotto(Integer id, String nome, String reparto, Double prezzo, Integer iva, String descrizione) {
//		super();
		this.id = new SimpleIntegerProperty(id);
		this.nome = new SimpleStringProperty (nome);
		this.reparto = new SimpleStringProperty (reparto);
		this.prezzo = new SimpleDoubleProperty(prezzo);
		this.iva = new SimpleIntegerProperty(iva);
		this.descrizione = new SimpleStringProperty(descrizione);
	}
	public Integer getId() {return id.get();}
	public void setId(Integer id) {this.id = new SimpleIntegerProperty (id);}
	public String getNome() {return nome.get();}
	public void setNome(String nome) {this.nome = new SimpleStringProperty (nome);}
	public String getReparto() {return reparto.get();}
	public void setReparto(String reparto) {this.reparto = new SimpleStringProperty (reparto);}
	public Double getPrezzo() {return prezzo.get();}
	public void setPrezzo(Double prezzo) {this.prezzo = new SimpleDoubleProperty (prezzo);}
	public Integer getIva() {return iva.get();}
	public void setIva(Integer iva) {this.iva = new SimpleIntegerProperty (iva);}
	public String getDescrizione() {return descrizione.get();}
	public void setDescrizione(String descrizione) {this.descrizione = new SimpleStringProperty (descrizione);}
	
	
}
