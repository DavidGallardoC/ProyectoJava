package spring;

import org.springframework.stereotype.Service;

@Service
public class Servicio {

	public void generartxt() 
	{
		
		Usuario u1= new Usuario();
		u1.setNombre("David");
		System.out.println("El usuario que implementó los archivos es: " + u1.getNombre());
		
		System.out.println("Generando txt");
	}
	
}
