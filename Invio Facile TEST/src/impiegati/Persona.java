package impiegati;

public class Persona {
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private int giornoDiNascita;
	private int meseDiNascita;
	private int annoDiNascita;
	private String residenza;
	private int creditiDiAssunzione;
	
	public Persona(String nome, String cognome, String codiceFiscale, int giornoDiNascita, int meseDiNascita,
			int annoDiNascita, String residenza, int creditiDiAssunzione) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.giornoDiNascita = giornoDiNascita;
		this.meseDiNascita = meseDiNascita;
		this.annoDiNascita = annoDiNascita;
		this.residenza = residenza;
		this.creditiDiAssunzione = creditiDiAssunzione;
	}
	
	

	public String getNome() { return nome; }
	
	public String getCognome() { return cognome; }

	public String getCodiceFiscale() { return codiceFiscale; }

	public int getGiornoDiNascita() { return giornoDiNascita; }

	public int getMeseDiNascita() { return meseDiNascita; }

	public int getAnnoDiNascita() { return annoDiNascita; }

	public String getResidenza() { return residenza; }

	public void setResidenza(String residenza) { this.residenza = residenza; }

	public int getCreditiDiAssunzione() { return creditiDiAssunzione; }

	public void setCreditiDiAssunzione(int creditiDiAssunzione) { this.creditiDiAssunzione = creditiDiAssunzione; }
	
}
