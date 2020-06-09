package libro_giornale;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class VoceLibroGiornale {

	private SimpleStringProperty data;
	private SimpleIntegerProperty documentoNumero;
	private SimpleStringProperty descrizione;
	private SimpleStringProperty reparto;
	private SimpleIntegerProperty iva;
	private SimpleDoubleProperty dare;
	private SimpleDoubleProperty avere;

	
	public VoceLibroGiornale() {
		super();
		this.data = new SimpleStringProperty ("2020-01-01");
		this.documentoNumero = new SimpleIntegerProperty (123);
		this.descrizione = new SimpleStringProperty ("Merci c/Acquisti");
		this.reparto = new SimpleStringProperty("Fabbricazione e Montaggio");
		this.iva = new SimpleIntegerProperty (22);
		this.dare = new SimpleDoubleProperty (150.0);
		this.avere = new SimpleDoubleProperty (0.0);
	}
	
	public VoceLibroGiornale(String data, Integer documentoNumero, String descrizione, String reparto, Integer iva, Double dare, Double avere) {
		super();
		this.data = new SimpleStringProperty (data);
		this.documentoNumero = new SimpleIntegerProperty (documentoNumero);
		this.descrizione = new SimpleStringProperty (descrizione);
		this.reparto = new SimpleStringProperty(reparto);
		this.iva = new SimpleIntegerProperty (iva);
		this.dare = new SimpleDoubleProperty (dare);
		this.avere = new SimpleDoubleProperty (avere);
	}

	public String getData() { return data.get(); }
	public void setData(String data) { this.data = new SimpleStringProperty (data); }
	public Integer getDocumentoNumero() { return documentoNumero.get(); }
	public void setDocumentoNumero(Integer documentoNumero) { this.documentoNumero = new SimpleIntegerProperty (documentoNumero); }
	public String getDescrizione() { return descrizione.get(); }
	public void setDescrizione(String descrizione) { this.descrizione = new SimpleStringProperty (descrizione); }
	public String getReparto() { return reparto.get(); }
	public void setReparto(String reparto) { this.reparto = new SimpleStringProperty (reparto); }
	public Integer getIva() { return iva.get(); }
	public void setIva(Integer iva) { this.iva = new SimpleIntegerProperty (iva); }
	public Double getDare() { return dare.get(); }
	public void setDare(Double dare) { this.dare = new SimpleDoubleProperty (dare); }
	public Double getAvere() { return avere.get(); }
	public void setAvere(Double avere) { this.avere = new SimpleDoubleProperty (avere); }
}
