package spring;

public class Continente {

	private String continente;
	

	@Override
	public String toString() {
		return  continente ;
	}

	public Continente(String continente) {
		this.continente = continente;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}
}
