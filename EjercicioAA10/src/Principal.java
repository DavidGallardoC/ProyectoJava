import java.net.HttpURLConnection;
import org.json.*;
import java.net.URL;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		String nombre;
		
		System.out.println("Introduce tu nombre: ");
		
		 nombre = entrada.nextLine();
		
		while(nombre.isEmpty()) {
			
			System.out.println("Inserte su nombre");
			 nombre = entrada.nextLine();
			
		}
		
		System.out.println("Bienvenido " + nombre + " te muestro el clima actual en España por provincias");
		
		try
		{
			URL url = new URL ("https://www.el-tiempo.net/api/json/v2/provincias/28");
		
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			
			int tiempoRespuesta = conn.getResponseCode();
			
			if(tiempoRespuesta!= 200) {
				
				throw new RuntimeException("HttpResponse" + tiempoRespuesta);
			}
			
			else
			{
				StringBuilder informacionString = new StringBuilder();
				Scanner sc = new Scanner(url.openStream());
				
				while(sc.hasNext())
				{
					informacionString.append(sc.nextLine());
					
				}
				sc.close();
				entrada.close();
				
				JSONObject job = null;
				try {
					job = new JSONObject(informacionString.toString());
					System.out.println(job.toString(2));
				} catch (JSONException e) {
					System.err.println("Error JSONException: " + e);
				}
			}		 	
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	
		
		

	}

}
