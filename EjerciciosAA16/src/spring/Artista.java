package spring;

public class Artista extends Persona {

	public Artista(String nombre) {
		super(nombre);
		
	}

	@Override
	public String toString() {
		return super.getNombre() + "\n";
	}
	
	
}
