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

import repo.Pessoa;
import repo.Repo;

@Path("/")
public class Rest {
	
	Gson gson = new Gson();
	Pessoa p = new Pessoa();
	
	@POST
	@Path("escreve")
	@Consumes(MediaType.APPLICATION_JSON)
	public void escreve(String dado) throws IOException {
		Pessoa pessoa = gson.fromJson(dado, Pessoa.class);
		Repo.escreve(pessoa);		
	}

	@GET
	@Path("le")
	@Produces(MediaType.APPLICATION_JSON)
	public String le() {
		List<Pessoa> list = Repo.le();
		String json = gson.toJson(list);
		return json;
	}
	
	@POST
	@Path("loja")
	@Consumes(MediaType.APPLICATION_JSON)
	public void loja(String dado){
		Repo.seleciona(gson.fromJson(dado, Pessoa.class));
		p = gson.fromJson(dado, Pessoa.class);
		System.out.println(p);
	}
	
	@GET
	@Path("lojale")
	@Produces(MediaType.APPLICATION_JSON)
	public String lojale() {
		System.out.println(p);
		return gson.toJson(Repo.retorna());
	}
	
	
}
