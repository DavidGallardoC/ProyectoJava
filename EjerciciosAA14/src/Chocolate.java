
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;


public class Chocolate extends Golosina implements Produccion {

	private String tipo_chocolate;
	
	@Override
	public String toString() {
		return tipo_chocolate + "            "  + super.getCantidad() + "\n";
	}

	public Chocolate(String tipo_golosina, double peso, int cantidad, String tipo_chocolate) {
		super(tipo_golosina,peso,cantidad);
		this.tipo_chocolate=tipo_chocolate;
		
	}


	public String getTipo_chocolate() {
		return tipo_chocolate;
	}

	public void setTipo_chocolate(String tipo_chocolate) {
		this.tipo_chocolate = tipo_chocolate;
	}
	
	public boolean produccion_activa() {
		

		try
		{
			URL urls = new URL ("https://www.el-tiempo.net/api/json/v2/provincias/41");
		
			HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
			conn.connect();
			
			int tiempoRespuesta = conn.getResponseCode();
			
			if(tiempoRespuesta!= 200) {
				
				throw new RuntimeException("HttpResponse" + tiempoRespuesta);
			}
			
			
			else
			{
				StringBuilder informacionString = new StringBuilder();
				Scanner sc = new Scanner(urls.openStream());
				
				while(sc.hasNext())
				{
					informacionString.append(sc.nextLine());
				}
				sc.close();
				//System.out.print(informacionString);
				JSONObject respuesta = new JSONObject(informacionString.toString()) ;
				JSONObject temperaturas = respuesta.getJSONArray("ciudades").getJSONObject(0).getJSONObject("temperatures");
				int temperaturaMax = temperaturas.getInt("max");

				if(temperaturaMax>40)
				{
					System.out.println("Lo siento, no se fabrican chocolates");
					
					return false;
				}
				else 
				{
					System.out.println("Temperatura maxima correcta, ahora mismo en Grana hace " + temperaturaMax);
					return true;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
		
	}
	
}
