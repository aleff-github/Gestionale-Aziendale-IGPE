package catalogo_e_magazzino;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Prodotto {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty nome;
	private SimpleStringProperty reparto;
	private SimpleDoubleProperty prezzo;
	
	
	
	public Prodotto() {
//		super();
		this.id = new SimpleIntegerProperty(-1);
		this.nome = new SimpleStringProperty ("NoName");
		this.reparto = new SimpleStringProperty ("NoDepartment");
		this.prezzo = new SimpleDoubleProperty(99.9);
	}
	
	public Prodotto(Integer id, String nome, String reparto, Double prezzo) {
//		super();
		this.id = new SimpleIntegerProperty(id);
		this.nome = new SimpleStringProperty (nome);
		this.reparto = new SimpleStringProperty (reparto);
		this.prezzo = new SimpleDoubleProperty(prezzo);
	}
	public Integer getId() {return id.get();}
	public void setId(Integer id) {this.id = new SimpleIntegerProperty (id);}
	public String getNome() {return nome.get();}
	public void setNome(String nome) {this.nome = new SimpleStringProperty (nome);}
	public String getReparto() {return reparto.get();}
	public void setReparto(String reparto) {this.reparto = new SimpleStringProperty (reparto);}
	public Double getPrezzo() {return prezzo.get();}
	public void setPrezzo(Double prezzo) {this.prezzo = new SimpleDoubleProperty (prezzo);}
	
	
	
	
}
