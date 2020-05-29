package catalogo_e_magazzino;

import java.io.File;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Prodotto {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty nome;
	private SimpleStringProperty reparto;
	private SimpleDoubleProperty prezzo;
	private Integer iva;
	private ImageView fotoDelProdotto;
	private String descrizione;
	
	
	
	public Prodotto() {
//		super();
		this.id = new SimpleIntegerProperty(-1);
		this.nome = new SimpleStringProperty ("NoName");
		this.reparto = new SimpleStringProperty ("NoDepartment");
		this.prezzo = new SimpleDoubleProperty(99.9);
		this.iva = 22;
		File file = new File("/icons/logo_iPear.jpg");
		this.fotoDelProdotto.setImage(new Image(file.toURI().toString()));
		this.descrizione = "No description.id";
	}
	
	public Prodotto(Integer id, String nome, String reparto, Double prezzo, Integer iva, ImageView fotoDelProdotto, String descrizione) {
//		super();
		this.id = new SimpleIntegerProperty(id);
		this.nome = new SimpleStringProperty (nome);
		this.reparto = new SimpleStringProperty (reparto);
		this.prezzo = new SimpleDoubleProperty(prezzo);
		this.iva = iva;
		this.fotoDelProdotto = fotoDelProdotto;
		this.descrizione = descrizione;
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
