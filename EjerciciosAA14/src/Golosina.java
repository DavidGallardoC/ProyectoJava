
public class Golosina {

	private String tipo_golosina;
	
	private double peso;
	
	private int cantidad;

	
	public String toString() {
		return "Golosina [tipo_golosina=" + tipo_golosina + ", peso=" + peso + ", cantidad=" + cantidad + "]";
	}

	public Golosina(String tipo_golosina, double peso, int cantidad) {
		this.tipo_golosina = tipo_golosina;
		this.peso = peso;
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getTipo_golosina() {
		return tipo_golosina;
	}

	public void setTipo_golosina(String tipo_golosina) {
		this.tipo_golosina = tipo_golosina;
	}
}
