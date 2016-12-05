package pact;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;

import repo.Loja;
import repo.Repo;

@Path("/")
public class Rest {
	
	Gson gson = new Gson();
	
	@POST
	@Path("escreve")
	@Consumes(MediaType.APPLICATION_JSON)
	public void pessoa(String dado) throws IOException {
		Loja pessoa = gson.fromJson(dado, Loja.class);
		Repo.escreve(pessoa);		
	}

	@GET
	@Path("le")
	@Produces(MediaType.APPLICATION_JSON)
	public String lePessoa() {
		List<Loja> list = Repo.le();
		String json = gson.toJson(list);
		return json;
	}
	
	@POST
	@Path("loja")
	@Consumes(MediaType.APPLICATION_JSON)
	public void loja(String dado){
		Repo.seleciona(gson.fromJson(dado, Loja.class));
	}
	
	@GET
	@Path("lojale")
	@Produces(MediaType.APPLICATION_JSON)
	public String leLoja() {
		return gson.toJson(Repo.retorna());
	}
}
