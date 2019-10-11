package br.com.tratamentovip.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import br.com.tratamentovip.core.persistence.model.Especialidade;

public class ConsultarSalaoBelezaUnitTest {

	@Test
	public void test() {
		try{
			URL url = new URL("http://www.nakatu.com.br/tratamento-vip/ws-rest/salao/getSalaoPorRegiaoBairroEspecialidade");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			
			JSONObject object = new JSONObject();
			
			List<Especialidade> especialidades = new ArrayList<Especialidade>();
			Especialidade especialidade = new Especialidade();
			especialidade.setId(1);
			especialidades.add(especialidade);
			
			object.put("especialidadeSalao", especialidades);
			
			JSONObject objectEndereco = new JSONObject();
			objectEndereco.put("bairro", "Vila Carrão");
			objectEndereco.put("regiao", "Leste");
			
			object.put("endereco", objectEndereco);
			
			OutputStreamWriter os = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			os.write(object.toString());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}
			
			conn.disconnect();

		}catch(MalformedURLException ex){
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
