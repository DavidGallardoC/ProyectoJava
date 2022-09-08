import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce tu nombre: ");
		
		String nombre = entrada.nextLine();
		
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
				System.out.print(informacionString);
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		entrada.close();

	}

}
