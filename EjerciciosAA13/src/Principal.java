import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		

		File documento = new File("Peliculas_11_20.txt");
		
		try {
			String peliculas="";
			Scanner sc = new Scanner(documento);
			
			while(sc.hasNextLine()) {
				
			peliculas +=sc.nextLine() + "\n";
			
			}
			System.out.println(peliculas);
			sc.close();
		} catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		

		File documentos = new File("Peliculas_1_10.txt");
		
		try {
			String peliculas="";
			Scanner sc = new Scanner(documento);
			
			while(sc.hasNextLine()) {
				
			peliculas +=sc.nextLine() + "\n";
			
			}
			System.out.println(peliculas);
			sc.close();
		} catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		

	}

}
