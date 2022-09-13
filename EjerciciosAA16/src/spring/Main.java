package spring;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * EJERCICIO AA16
--------------- 	IMPLEMENTANDO AOP, INTERFACES, CLASES, HERENCIA, GITHUB ---------------
PROBLEMATICA: Nos contrataron de Spotify para desarrollar un programa que nos brinde
información general del uso de la aplicación
A día de hoy tienen 4 archivos planos donde tienen los registros de los ultimos
 años y les gustaría unificarlos en uno solo. Los archivos son los siguientes:
TOP 10 CANCIONES DE 2021
TOP 10 CANCIONES DE 2020
TOP 10 ARTISTAS DE 2021
TOP 10 ARTISTAS DE 2020
Luego de haber informado esto, nos piden que informemos, segun el valor de
 cada canción su recaudación global. teniendo en cuenta que por cada vez que se escucha una canción se le da 2 euros a cada artista
El formato del archivo de salida esperado es el siguiente: 
TOP 10 CANCIONES DE 2020 + Recaudación de cada una
TOP 10 CANCIONES DE 2021 + Recaudación de cada una
TOP 10 ARTISTAS DE 2020
TOP 10 ARTISTAS DE 2021

AOP: 
- Implementar AOP ANTES de ejecutar el metodo generaArchivo() informando que se 
esta por generar un archivo nuevo. 
- Implementar AOP ANTES de cargar los TXTS en el programa validando que sean
 formato .txt 
- Implementar AOP DESPUES de generar la salida informando que se genero la salida
 del programa.

INTERFACES: 
- Implementar un metodo que calcule la recaudación

CLASES:
Declarar la clase Persona, Artista y Usuario informando atributos de cada una de 
las mismas. 

ENTREGABLE:
- Codigo del proyecto
- Archivo final de salida
- Subir el proyecto al repo de Github. 

 * 
 * 
 * 
 */
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main 
{
	public static void main (String [] args)
	{	
		
		try {
			String linea;
			FileReader fr = new FileReader("Canciones_2020.txt");
			BufferedReader br = new BufferedReader(fr);
			List<Cancion> listaCancion = new ArrayList<>();
			while ((linea = br.readLine()) != null) 
			{
				String[] partes = linea.split(";");// divido en partes usando el ;
				partes[0] = partes[0].trim();
				partes[1] = partes[1].trim(); 
				partes[1] = partes[1].replace(".", ""); //remplazo los puntos de las visualizaciones por nada
				listaCancion.add(new Cancion("\n" + partes[0], Long.parseLong(partes[1]), Long.parseLong(partes[1]))); 
				//nombre, visualizaciones leidas y como tercer argumento paso otra vez visualizaciones, llegará al constructor
				//como dinero, llamará al método de la interfaz y lo multiplicará *2 y añadirá € con toString
			}
			fr.close();
			br.close();
			

			FileReader fr1 = new FileReader("Canciones_2021.txt");
			BufferedReader br1 = new BufferedReader(fr1);
			List<Cancion> listaCancion1 = new ArrayList<>();
			while ((linea = br1.readLine()) != null) 
			{
				String[] partes1 = linea.split(";"); //divido archivo TXT para mejor manejo con ; dividiendo artista y visualizaciones
				partes1[0] = partes1[0].trim();
				partes1[1] = partes1[1].trim(); 	
				partes1[1] = partes1[1].replace(".", ""); 
			   listaCancion1.add(new Cancion("\n" + partes1[0], Long.parseLong(partes1[1]), Long.parseLong(partes1[1]))); 
			}
			fr1.close();
			br1.close();
			
			FileReader fr2 = new FileReader("Artistas_2021.txt");
			BufferedReader br2 = new BufferedReader(fr2);
			List<Artista> listaArtista1 = new ArrayList<>();
			while ((linea = br2.readLine()) != null) {					
				listaArtista1.add(new Artista(linea)); 
			}
			fr2.close();
			br2.close();
			
			
			FileReader fr3 = new FileReader("Artistas_2020.txt");
			BufferedReader br3 = new BufferedReader(fr3);
			List<Artista> listaArtista2 = new ArrayList<>();
			while ((linea = br3.readLine()) != null)
			{
		           listaArtista2.add(new Artista(linea)); 
			}
			fr3.close();
			br3.close();

			Usuario yo = new Usuario("1","David","correo@gmail.com")	;
			String nombreArchivo ="TOPSPOTIFY.txt";
			String listaCanciones = yo.toString() + "\n" +
									"TOP 10 CANCIONES 2020" + listaCancion + "\n" + "\n" +
									"TOP 10 CANCIONES 2021" + listaCancion1 + "\n"  + "\n" +
									"TOP 10 ARTISTAS 2020"  + "\n" + listaArtista1 + "\n" + "\n" +
									"TOP 10 ARTISTAS 2021"  + "\n" + listaArtista2 + "\n" ; 
			try {

					try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class)) {
						Servicio servicio = ctx.getBean(Servicio.class);
						servicio.generaArchivo(); //pasaria argumento con listaCanciones para generar Archivo allí
						servicio.comprobartxt();
						
					} catch (BeansException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println("El archivo no existe, se crea uno nuevo");
					Path file = Paths.get(nombreArchivo);
					List<String> lineas = Arrays.asList(listaCanciones);
					Files.write(file, lineas, StandardCharsets.UTF_8 );
			}
			catch (IOException e){
				System.out.println("El archivo ya existe");
				e.printStackTrace();
			}
			
			
			
			
		} catch(FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (NumberFormatException e1) {
			// TODO Bloque catch generado automáticamente
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Bloque catch generado automáticamente
			e1.printStackTrace();
		}

		
		

	}
	
}
