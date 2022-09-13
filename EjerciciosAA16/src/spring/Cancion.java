package spring;

public class Cancion implements Recaudacion {

	private String nombre;
	
	private long visualizaciones;
		
	private long dinero;
	
	public Cancion(String nombre, long visualizaciones, long dinero) {
		this.nombre= nombre;
		this.visualizaciones=visualizaciones;
		this.dinero=calcularRecaudacion(visualizaciones);
		
	}
	
	@Override
	public String toString() {
		return    nombre + " " + visualizaciones +  "   " + dinero + "€ ";
	}


	public long getVisualizaciones() {
		return visualizaciones;
	}

	public void setVisualizaciones(long visualizaciones) {
		this.visualizaciones = visualizaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long calcularRecaudacion(long visualizaciones) {
		
		long recaudacionL=0;
		
		recaudacionL= visualizaciones*2;
		
		
		return recaudacionL;
		
	}

	public long getDinero() {
		return dinero;
	}

	public void setDinero(long dinero) {
		this.dinero = dinero;
	}
}
