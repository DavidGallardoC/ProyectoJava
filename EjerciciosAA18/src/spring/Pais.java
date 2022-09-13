package spring;

public class Pais extends Continente{

	private String pais;
	
	public Pais(String pais, String continente) {
		super(continente);
		this.pais=pais;
	}
	

	@Override
	public String toString() {
		return pais + " " + super.getContinente();
	}


	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
}
