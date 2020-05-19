package impiegati;

public class Operaio extends Persona{
	
	private float salario;
	private String reparto;
	
	public Operaio(String nome, String cognome, String codiceFiscale, int giornoDiNascita, int meseDiNascita,
			int annoDiNascita, String residenza, int creditiDiAssunzione, float salario, String reparto) {
		super(nome, cognome, codiceFiscale, giornoDiNascita, meseDiNascita, annoDiNascita, residenza,
				creditiDiAssunzione);
		this.salario = salario;
		this.reparto = reparto;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	
}
