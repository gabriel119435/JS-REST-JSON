package pact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.Gson;

import repo.Pessoa;

public class ClientTest {
	public static void main(String[] args) throws IOException {

		Gson gson = new Gson();
		String string = "";

		// INSERE UM VALOR NO BANCO
			string = "{"+
					 "\"nome\": \"abc\","+
					 "\"idade\": \"10\""+
					 "}";

			try {
				URL url = new URL("http://localhost:8080/DBRest/rest/escreve");
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(string);
				out.close();
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		// LE O BANCO
		URL url = new URL("http://localhost:8080/DBRest/rest/le");
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);

		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}
		br.close();
		System.out.println("banco:");
		Pessoa[] list = gson.fromJson(sb.toString(), Pessoa[].class);
		int i = 0;
		for (Pessoa p : list) {
			i++;
			System.out.println(p);
		}
		System.out.println("banco: "+i);
	}
}
