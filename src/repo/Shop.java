package repo;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private String name;
	private String cnpj;
	private String template;
	private List<Fridge> fridges = new ArrayList<Fridge>();

	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public void addFridge(Fridge f){
		fridges.add(f);
	}

	public void delFridge(String model){
		for(Fridge f: fridges){
			if(f.getModel().equals(model)){
				fridges.remove(f);
				break;
			}
		}
	}
	
	public void updateFridge(String model, int quantity){
		for(Fridge f: fridges){
			if(f.getModel().equals(model)){
				f.setQuantity(quantity);
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		String allfridges="";
		for(Fridge f : fridges)
			allfridges += f.getBrand() + "-" + f.getModel() + "-" + f.getQuantity() + "\n";
		return this.name + "-" + this.cnpj + "-" + this.template + "\n" + allfridges + "\n\n";
	}
}
