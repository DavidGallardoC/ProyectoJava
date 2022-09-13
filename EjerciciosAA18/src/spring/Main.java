package spring;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main 
{
	public static void main (String [] args)
	{
	
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class)) {
			Servicio servicio = ctx.getBean(Servicio.class);
			
			try {
				String nombreArchivo = "INFO_PAISES.txt";
				servicio.generartxt();
			
				FileReader fr = new FileReader(nombreArchivo);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				String paises = "";
				
				while ((linea = br.readLine()) != null) {
					String[] partes = linea.split(":");// divido en partes usando el ;
					partes[0] = partes[0].trim();
					partes[1] = partes[1].trim(); 
					partes[1] = partes[1].replace(".", "");//elimina puntos para luego operar
					partes[1] = partes[1].replace(",", "");//elimina comas para luego operar
					paises += linea + "\n";
				}
				fr.close();
				br.close();
				//System.out.println(paises);
				String pais1 ="";
				String pais2 ="";
				String pais3 ="";
				String pais4 ="";
				
				String habitantes1="";
				String salario1="";
				String habitantes2="";
				String salario2="";
				String habitantes3="";
				String salario3="";
				String habitantes4="";
				String salario4="";
				
				String[] parts1 = paises.split("\n"); 
				for(int i=0; i<=5;i++) {
					new Nacion(parts1[0],parts1[1],parts1[2],parts1[3],parts1[4],parts1[5]);
					pais1+= parts1[i] + "\n";
					habitantes1= parts1[3];
					salario1=parts1[5];
				}
				
				String[] parts2 = paises.split("\n"); 
				for(int i=6; i<=11;i++) {
					new Nacion(parts2[6],parts2[7],parts2[8],parts2[9],parts2[10],parts2[11]);
					pais2+= parts2[i] + "\n";
					habitantes2= parts2[9];
					salario2=parts2[11];
				}
				String[] parts3 = paises.split("\n"); 
				for(int i=12; i<=17;i++) {
					new Nacion(parts3[12],parts3[13],parts3[14],parts3[15],parts3[16],parts3[17]);
					pais3+= parts3[i] + "\n";
					habitantes3= parts3[15];
					salario3=parts3[17];
				}
				String[] parts4 = paises.split("\n"); 
				for(int i=18; i<=23;i++) {
					new Nacion(parts4[18],parts4[19],parts4[20],parts4[21],parts4[22],parts4[23]);
					pais4+= parts4[i] + "\n";
					habitantes4= parts4[21];
					salario4=parts4[23];
				}
				
			
				String views1 ="";
				String habitantes10="";
				for(int i=0;i<habitantes1.length();i++) {
					views1 = habitantes1.substring(habitantes1.indexOf(" "), habitantes1.length() - 1);
				}
				habitantes10= views1.replaceAll(" ","");
				float habitantes_def1= Float.parseFloat(habitantes10);
				float salarioe = 0;
				for(int i=0;i<salario1.length();i++) {
					salarioe = Float.parseFloat(salario1.substring(salario1.indexOf(": ") + 1, salario1.length()));
				}
				
				
				String views2 ="";
				String habitantes20="";
				for(int i=0;i<habitantes2.length();i++) {
					views2 = habitantes2.substring(habitantes2.indexOf(" "), habitantes2.length() - 1);
				}
				habitantes20= views2.replaceAll(" ","");
				float habitantes_def2= Float.parseFloat(habitantes20);
				float salarioe1 = 0;
				for(int i=0;i<salario2.length();i++) {
					salarioe1 = Float.parseFloat(salario2.substring(salario2.indexOf(": ") + 1, salario2.length()));
				}
				
				String views3 ="";
				String habitantes30="";
				for(int i=0;i<habitantes3.length();i++) {
					views3 = habitantes3.substring(habitantes3.indexOf(" "), habitantes3.length() - 1);
				}
				habitantes30= views3.replaceAll(" ","");
				float habitantes_def3= Float.parseFloat(habitantes30);
				float salarioe2 = 0;
				for(int i=0;i<salario3.length();i++) {
					salarioe2 = Float.parseFloat(salario3.substring(salario3.indexOf(": ") + 1, salario3.length()));
				}
				
				
				String views4 ="";
				String habitantes40="";
				for(int i=0;i<habitantes4.length();i++) {
					views4 = habitantes4.substring(habitantes4.indexOf(" "), habitantes4.length() - 1);
				}
				habitantes40= views4.replaceAll(" ","");
				float habitantes_def4= Float.parseFloat(habitantes40);
				float salarioe3 = 0;
				for(int i=0;i<salario4.length();i++) {
					salarioe3 = Float.parseFloat(salario4.substring(salario4.indexOf(": ") + 1, salario4.length()));
				}
				
				
				
			      Adivinar adivinar_numero = (float t1, float t2) -> t1 * t2;
				  float PCI1= comprobar(habitantes_def1, salarioe, adivinar_numero);
				  float PCI2= comprobar(habitantes_def2, salarioe1, adivinar_numero);
				  float PCI3= comprobar(habitantes_def3, salarioe2, adivinar_numero);
				  float PCI4= comprobar(habitantes_def4, salarioe3, adivinar_numero);
				  System.out.println(PCI1);
				  System.out.println(PCI2);
				  System.out.println(PCI3);
				  System.out.println(PCI4);
				
				//System.out.println(PCI);
				String nombreArchivo1 ="Argentina.txt";
				Path file1 = Paths.get(nombreArchivo1);
				List<String> lineas1 = Arrays.asList(pais1 +  "PCI:" + PCI1);
				Files.write(file1, lineas1, StandardCharsets.UTF_8 );
				
				String nombreArchivos2 ="España.txt";
				Path file2 = Paths.get(nombreArchivos2);
				List<String> lineas2 = Arrays.asList(pais2 + " PCI:" + PCI2);
				Files.write(file2, lineas2, StandardCharsets.UTF_8 );
				
				String nombreArchivos3 ="Alemania.txt";
				Path file3 = Paths.get(nombreArchivos3);
				List<String> lineas3 = Arrays.asList(pais3 + " PCI:" + PCI3);
				Files.write(file3, lineas3, StandardCharsets.UTF_8 );
				
				String nombreArchivos4 ="Brasil.txt";
				Path file4 = Paths.get(nombreArchivos4);
				List<String> lineas4 = Arrays.asList(pais4 +  " PCI:" + PCI4);
				Files.write(file4, lineas4, StandardCharsets.UTF_8 );

			} catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado.");
			}
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	


public static float comprobar(float n1, float n2, Adivinar formato) {
	float resultado = formato.ejecutar(n1, n2);

	return resultado;

}
}

interface Adivinar {
	float ejecutar(float n1, float n2);
}	

