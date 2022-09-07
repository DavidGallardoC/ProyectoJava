import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Videojuego v1 = new Videojuego("Dark Souls 3",70000,50,"RPG de acción ",2016);
		Videojuego v2 = new Videojuego("Fifa 2022",100000,55,"Deportes ",2022);
		Videojuego v3 = new Videojuego("Mario Bros",120000,15,"Rayman Adventures ",1985);
		Videojuego v4 = new Videojuego("Horizon",50000,40,"rol",2015);
		
		
		String salida1 = v1.toString();
		String salida2 = v2.toString();
		String salida3 = v3.toString();
		String salida4 = v4.toString();
		
		String salida_final = salida1 + salida2 + salida3 + salida4;
		
		
		
		
			String nombreArchivo ="videojuegos.txt";
		
		try {
			File archivo = new File(nombreArchivo);
			if(!archivo.exists()) 
			{
				System.out.println("El archivo no existe, se crea uno nuevo");
				Path file = Paths.get(nombreArchivo);
				
				
				List<String> lineas = Arrays.asList(salida_final);
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
		
	}

}
