import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		
		try
		{
			URL url = new URL ("https://public.opendatasoft.com/api/records/1.0/search/?dataset=provincias-espanolas&q=&rows=0&sort=-provincia&facet=ccaa&facet=provincia");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			int tiempoRespuesta = conn.getResponseCode();
			
			if(tiempoRespuesta!= 200) {
				throw new RuntimeException("HttpResponse" + tiempoRespuesta);
			}
			else
			{
				Scanner sc = new Scanner(url.openStream());
	            String json = "";
	            while(sc.hasNextLine()) {
	                json = json + sc.nextLine();
	            }
	            sc.close();
	            JSONObject objetoJSON = new JSONObject(json);
	            JSONArray arrayJSON = (JSONArray) objetoJSON.get("facet_groups");
	            objetoJSON = (JSONObject) arrayJSON.get(1);
	            arrayJSON = (JSONArray) objetoJSON.get("facets");
	            //System.out.println(arrayJSON);
	            List<Provincia> listaProvincia = new ArrayList<>();
	            for(Object iter:arrayJSON) {
	                listaProvincia.add(new Provincia(((JSONObject) iter).getString("name"), ((JSONObject) iter).getString("path")));
	            }
	            
	            Provincia p1 = new Provincia ("","");
	            
	            System.out.println(p1.generarArchivo(listaProvincia));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
