
public class Videojuego implements Precio{

	private String titulo;

	private int cantidad_vendida;
	
	private int dinero_unidad;
	
	private String genero;
	
	private int anyo_salida;
	


	public Videojuego(String titulo, int cantidad_vendida, int dinero_unidad, String genero, int anyo_salida) {

		this.titulo = titulo;
		this.cantidad_vendida = cantidad_vendida;
		this.dinero_unidad = dinero_unidad;
		this.genero = genero;
		this.anyo_salida = anyo_salida;
	}

	public double calcular_total(int cantidad_vendida, int dinero_unidad) {
		
	
		double valor_total = cantidad_vendida * dinero_unidad;
		
		return valor_total;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCantidad_vendida() {
		return cantidad_vendida;
	}

	public void setCantidad_vendida(int cantidad_vendida) {
		this.cantidad_vendida = cantidad_vendida;
	}

	public double getDinero_unidad() {
		return dinero_unidad;
	}

	public void setDinero_unidad(int dinero_unidad) {
		this.dinero_unidad = dinero_unidad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAnyo_salida() {
		return anyo_salida;
	}

	public void setAnyo_salida(int anyo_salida) {
		this.anyo_salida = anyo_salida;
	}
	
	@Override
	public String toString() {
		return "Videojuego: Título=" + titulo + ", cantidad_vendida:" + cantidad_vendida + ", total recaudado="
				+ calcular_total(cantidad_vendida,dinero_unidad) + "\n";
	}
}
