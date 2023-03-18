package Apis;

import java.io.IOException;
import okhttp3.*;

public class ApiMoneda {
		private Response response;
		private String respuesta;
		Double[] cambio=new Double[5];
		String[] monedas= {"USD","EUR","GBP","JPY","KRW"};

		public ApiMoneda() throws IOException{
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			
			Request request = new Request.Builder()
				      .url("https://api.apilayer.com/fixer/latest?base=PEN&symbols=USD,EUR,GBP,JPY,KRW")
				      .addHeader("apikey", "CxXlLhJEa4rXgenTpDd6ZASns9rvrHEk")
				      .method("GET",null)
				      .build();
				    response = client.newCall(request).execute();
					respuesta=response.body().string();
					obtenerCambio();
		}
		private void obtenerCambio() {
			for(int i=0;i<monedas.length;i++) {
				cambio[i]=Double.parseDouble(respuesta.substring(respuesta.indexOf(monedas[i])+6, respuesta.indexOf(monedas[i])+12));
			}
		}
		public Double[] getCambio() {
			return cambio;
		}
}
