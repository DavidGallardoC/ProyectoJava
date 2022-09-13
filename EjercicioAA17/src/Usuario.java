
public class Usuario {

	
	private String nombre;
	
	private int edad;
	
	

	@Override
	public String toString() {
		return "Bienvenido " + nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
