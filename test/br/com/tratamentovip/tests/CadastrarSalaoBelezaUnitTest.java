package br.com.tratamentovip.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class CadastrarSalaoBelezaUnitTest {

	@Test
	public void test() {
		try{
			URL url = new URL("http://www.nakatu.com.br/tratamento-vip/ws-rest/salao/cadastrar");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json");
			
			DateFormat df = new SimpleDateFormat("HH:mm");
			
			JSONObject object = new JSONObject();
			object.put("facebook", "http://www.facebook.com/salao");
			object.put("cpfCnpj", "000000000000100");
			object.put("horarioAbertura", new Time(df.parse("09:00").getTime()));
			object.put("horarioFechamento", new Time(df.parse("18:00").getTime()));
			object.put("nomeFantasia", "Nome Fantasia");
			object.put("razaoSocial", "Razão Social");
			object.put("loginEmail", "tvip@tratamento-vip.com.br");
			object.put("senha", "tvip");
			
			JSONObject objectEndereco = new JSONObject();
			objectEndereco.put("latitude", new Double("-23.552653"));
			objectEndereco.put("longitude", new Double("-46.5434"));
			objectEndereco.put("logradouro", "Rua Lutecia");
			objectEndereco.put("numero", "950");
			objectEndereco.put("bairro", "Vila Carrão");
			objectEndereco.put("cidade", "São Paulo");
			objectEndereco.put("cep", "03423000");
			objectEndereco.put("regiao", "Leste");
			
			JSONObject objectUF = new JSONObject();
			objectUF.put("idUF", "26");
			objectEndereco.put("uf", objectUF);
			
			object.put("endereco", objectEndereco);
			
			OutputStream os = conn.getOutputStream();
			os.write(object.toString().getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}

			conn.disconnect();


			
		}catch(JSONException ex){
			ex.printStackTrace();
		}catch(MalformedURLException ex){
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}catch(ParseException ex){
			ex.printStackTrace();
		}
	}
}
