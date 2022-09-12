import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Provincia extends Capital implements archivo{

	private String nombre;

	public Provincia(String capital, String nombre) {
		super(capital);
		this.nombre = nombre;
		
	}


	@Override
	public String toString() {
		return nombre + "               " + super.getCapital() + "\n";
		
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
public String generarArchivo(List<Provincia> listaProvincia) {
		
	
	String nombreArchivo ="Provincias.txt";
	String fecha_actual = LocalDate.now() + "";
	String listaProvincias = "Provincia                   Capital \n" + listaProvincia;
	Usuario p1 = new Usuario(1,"David Gallardo");
	
	
	try {
		File archivo = new File(nombreArchivo);
		if(!archivo.exists()) 
		{
			System.out.println("El archivo no existe, se crea uno nuevo");
			Path file = Paths.get(nombreArchivo);
			List<String> lineas = Arrays.asList(fecha_actual + "\n" + p1.toString() + "\n" + listaProvincias);
			Files.write(file, lineas, StandardCharsets.UTF_8 );
			
			
		}
		else {
			System.out.println("El archivo ya existe");
		}
	}
	catch (IOException e){
		System.out.println("El archivo ya existe");
		e.printStackTrace();
	}
	
	
	
	
	//Aqui creo tambien el jenkins con otra lista
	List<String> jenk = new ArrayList<>();
	jenk.add("import java.time.LocalDate");
	jenk.add("pipeline{");//{
	jenk.add("	agent any");
	jenk.add("	stages{");//{
	jenk.add("		stage(\"holaMundo\"){");//{
	jenk.add("			steps{");//{
	jenk.add("				script{");//{
	jenk.add("					println" + listaProvincia);
	jenk.add("				}");
	jenk.add("			}");
	jenk.add("		}");
	jenk.add("	}");
	jenk.add("}");
	Path file = Paths.get("Jenkinsfile");
	try {
		Files.write(file, jenk, StandardCharsets.UTF_8);
		System.out.println("Jenkins generado correctamente");
	} catch (IOException e) {
		System.out.println("Excepción en el write().");
		e.printStackTrace();
	}
	
	
		
		return "Archivo generado";
	}
}
