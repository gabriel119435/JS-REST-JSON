package pact;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import repo.Shop;
import repo.ShopRepo;

@Path("/shop/")
public class ShopRest {
	
	Gson gson = new Gson();
	ShopRepo repo = new ShopRepo();
	
	@POST
	@Path("add")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addShop(String data) throws IOException {
		Shop shop = gson.fromJson(data, Shop.class);
		for(Shop s: repo.read()){
			if(shop.getCnpj().equals(s.getCnpj())){
				return "repetido";
			}
		}		
		repo.add(shop);	
		return "novo";
	}

	@GET
	@Path("readAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String readAllShops() {
		List<Shop> list = repo.read();
		String json = gson.toJson(list);
		return json;
	}
	
	@DELETE
	@Path("remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeShop(String data){
		repo.remove(data);
	}
	
	//loads store into memory
	@POST
	@Path("load")
	@Consumes(MediaType.APPLICATION_JSON)
	public void loadShop(String data){
		repo.loadShop(gson.fromJson(data, Shop.class));
	}
	
	//retrieve memory store
	@GET
	@Path("read")
	@Produces(MediaType.APPLICATION_JSON)
	public String readShop() {
		return gson.toJson(repo.readShop());
	}
}
