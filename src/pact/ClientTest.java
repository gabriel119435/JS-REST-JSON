package pact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

import repo.Shop;

public class ClientTest {
	public static void main(String[] args) throws IOException {

		Gson gson = new Gson();
		String string = "{\"name\": \"abc\" , \"cnpj\": \"10\" , \"template\": \"1\"}";

		try {
			URL url = new URL("http://localhost:8080/DBRest/rest/shop/add");
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
		URL url = new URL("http://localhost:8080/DBRest/rest/shop/readAll");
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);

		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			sb.append(line);
		}
		br.close();
		System.out.println("dataBase:");
		Shop[] list = gson.fromJson(sb.toString(), Shop[].class);
		int i = 0;
		for (Shop p : list) {
			i++;
			System.out.println(p);
		}
		System.out.println("dataBase stores: " + i);
	}
}
