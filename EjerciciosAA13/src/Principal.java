import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		//Generacion del txt
		File documento = new File("top20_mejores_peliculas.txt");
		File docLeer = new File("Peliculas_11_20.txt");
		try {
			if(documento.exists()) {
				documento.delete();
			}
			documento.createNewFile();
			FileWriter fw = new FileWriter(documento, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Las 20 mejores peliculas de la historia son: \r\n");
			bw.write("Nombre:                                  Worldwide Lifetime Gross\r\n");
			bw.write("Avatar                                       $2,847,397,339\r\n"
					+ "Avengers: Endgame                            $2,797,501,328\r\n"
					+ "Titanic                                      $2,201,647,264\r\n"
					+ "Star Wars: Episode VII - The Force Awakens   $2,069,521,700\r\n"
					+ "Avengers: Infinity War                       $2,048,359,754\r\n"
					+ "Spider-Man: No Way Home                      $1,910,675,428\r\n"
					+ "Jurassic World                               $1,671,537,444\r\n"
					+ "The Lion King                                $1,663,2\r\n"
					+ "The Avengers                                 $1,518,815,515\r\n");
			
			Scanner sc = new Scanner(docLeer);
			String pelicula = sc.nextLine();
			while (sc.hasNextLine()) {
				pelicula = sc.nextLine();
				
				bw.write(pelicula + "\r\n");
				
			}
			sc.close();
			bw.close();
			System.out.println("\nArchivo de texto no existe, se genera uno nuevo.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Leer archivo txt	

		try {
			Scanner sc = new Scanner(documento);
			while (sc.hasNextLine()) {
				String pelicula = sc.nextLine();
				System.out.println(pelicula);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no existe.");
		}
		
		
		
		
		File jenkins = new File("jenkinsFile");
		try {
			jenkins.createNewFile();
			FileWriter fw = new FileWriter(jenkins);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("import java.time.LocalDate\r\n" 
					+ "pipeline {\r\n"
					+ "    agent any\r\n"
					+ "    stages{\r\n"
					+ "        \r\n"
					+ "        stage('mostrarFecha') {\r\n"
					+ "            steps {\r\n"
					+ "                script{\r\n"
					+ "                    def fecha = LocalDate.now() \r\n"
					+ "                    println(\"Hola mundo! El d?a de hoy es \" + fecha.getDayOfWeek())\r\n"
					+ "                    println (\"Este curso me hizo programar mas de lo que me hubiese gustado.\")\r\n"
					+ "                }\r\n"
					+ "            }\r\n"
					+ "        }\r\n"
					+ "            \r\n"
					+ "    }\r\n"
					+ "}");
			
			bw.close();
			System.out.println("\n Jenkins generado .\n");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
