package spring;

public class Nacion extends Pais{
	
	private String capital;
	
	private String habitantes;
	
	private String clima;
	
	private String salario;
	

	public Nacion(String pais, String continente, String capital, String habitantes, String clima, String salario) {
		
		super(pais,continente);
		this.habitantes=habitantes;
		this.capital=capital;
		this.clima=clima;
		this.salario=salario;	
	}


	public String getSalario() {
		return salario;
	}


	public void setSalario(String salario) {
		this.salario = salario;
	}


	public String getClima() {
		return clima;
	}


	public void setClima(String clima) {
		this.clima = clima;
	}


	public String getHabitantes() {
		return habitantes;
	}


	public void setHabitantes(String habitantes) {
		this.habitantes = habitantes;
	}


	public String getCapital() {
		return capital;
	}


	public void setCapital(String capital) {
		this.capital = capital;
	}

	
}
