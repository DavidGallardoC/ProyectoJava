package spring;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class Servicio {

	public void generaArchivo() 
	{
		System.out.println("Generando txt nuevo");
	}
	
	public void comprobartxt()
	{
		File art2020 = new File("Artistas_2020.txt");
		File art2021 = new File("Artistas_2021.txt");
		File can2020 = new File("Canciones_2020.txt");
		File can2021 = new File("Canciones_2021.txt");
		String artist2020 = art2020.getName();
		String artist2021 = art2021.getName();
		String cancio2020 = can2020.getName();
		String cancio2021 =can2021.getName();
		
		if(artist2020.contains(".txt")) {
			System.out.println("El archivo es un txt.");
		}else {
			System.out.println("El archivo no es un txt.");
		}
		if(artist2021.contains(".txt")) {
			System.out.println("El archivo es un txt.");
		}else {
			System.out.println("El archivo no es un txt.");
		}
		if(cancio2020.contains(".txt")) {
			System.out.println("El archivo es un txt.");
		}else {
			System.out.println("El archivo no es un txt.");
		}
		if(cancio2021.contains(".txt")) {
			System.out.println("El archivo es un txt.");
		}else {
			System.out.println("El archivo no es un txt.");
		}
		
	}
	
}
