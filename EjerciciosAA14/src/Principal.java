import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;


public class Principal {

	public static void main(String[] args) {
		//Se intenta crear un chocolate
		Chocolate chocolate_prueba = new Chocolate("Chocolate",200,1000,"Chocolate Blanco");
		
		//se ve si al intentar crearlo, se puede por la temperatura
		boolean temperatura_correcta = chocolate_prueba.produccion_activa();
		
		//en caso de que se pueda, se añade ESE y los demás chocolates
		if (temperatura_correcta)
	
		{
			Chocolate c1 = new Chocolate("Chocolate",200,1500,"Chocolate Negro");
			Chocolate c2 = new Chocolate("Chocolate",200,1200,"Chocolate con almendras");
			Chocolate c3 = new Chocolate("Chocolate",200,1300,"Chocolate con castañas de caju");
			Chocolate c4 = new Chocolate("Chocolate",200,100,"Chocolate en rama");
			Chocolate c5 = new Chocolate("Chocolate",200,1500,"Chocolate con 70% de cacao");
		    try{
				System.out.println("Generación de los chocolates en txt");
				//Abro stream, crea el fichero si no existe
				File documento = new File("salida" + LocalDate.now() + ".txt");
				if(documento.exists()) {
					documento.delete();
				}
		        FileWriter fw=new FileWriter(documento,true);
		        BufferedWriter bw = new BufferedWriter(fw);
		        bw.write("NOMBRE:                                    CANTIDAD PRODUCIDA \n");
		        bw.write(chocolate_prueba.toString());
		        bw.write(c1.toString());
		        bw.write(c2.toString());
		        bw.write(c3.toString());
		        bw.write(c4.toString());
		        bw.write(c5.toString());
		            
		        bw.close();
		        fw.close();
		        
		        System.out.println(chocolate_prueba.toString());
		        System.out.print(c1.toString());
		        System.out.print(c2.toString());
		        System.out.print(c3.toString());
		        System.out.print(c4.toString());
		        System.out.print(c5.toString());
		           
		        }catch(IOException e){
		            System.out.println("Error E/S: "+e);//Aunque salga error, el archivo te lo crea
		        }
		    
		    File jenkins = new File("jenkinsFile");
			try {
				jenkins.createNewFile();
				
				//manipulo jenkins en git con pipeline
				FileWriter fw = new FileWriter(jenkins);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(chocolate_prueba.toString());
				bw.write(c1.toString());
				bw.write(c1.toString());
				bw.write(c2.toString());
				bw.write(c3.toString());
				bw.write(c4.toString());
				bw.write(c5.toString());
				
				
				
				bw.close();
				System.out.println("\n Jenkins generado .\n");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}    
			
		}
		else {
			System.out.println("No se puede hacer chocolates porque hace mucha calor");
		}

	}

}
