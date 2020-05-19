package impiegati;

public class Dipendente extends Persona{
	
	private float stipendio;
	private String studio;
	
	public Dipendente(String nome, String cognome, String codiceFiscale, int giornoDiNascita, int meseDiNascita,
			int annoDiNascita, String residenza, int creditiDiAssunzione, float stipendio, String studio) {
		super(nome, cognome, codiceFiscale, giornoDiNascita, meseDiNascita, annoDiNascita, residenza,
				creditiDiAssunzione);
		this.stipendio = stipendio;
		this.studio = studio;
	}

	public float getStipendio() { return stipendio; }

	public void setStipendio(float stipendio) { this.stipendio = stipendio; }

	public String getStudio() { return studio; }

	public void setStudio(String studio) { this.studio = studio; }
	
}
