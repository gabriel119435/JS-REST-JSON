package repo;

import java.util.List;
import java.util.ArrayList;

public class ShopRepo {
	static private List<Shop> shopList = new ArrayList<Shop>();
	static private Shop shop = new Shop();

	public void add(Shop s) {
		shopList.add(s);
	}
	
	public void remove(String cnpj){
		for(Shop s: shopList){
			if(s.getCnpj().equals(cnpj)){
				shopList.remove(s);
				break;
			}
		}
	}

	public List<Shop> read() {
		return shopList;
	}	
	
	public void loadShop(Shop s){
		shop = s;
	}
	
	public Shop readShop(){
		return shop;
	}
	
}
