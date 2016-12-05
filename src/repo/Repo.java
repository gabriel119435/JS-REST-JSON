package repo;

import java.util.List;
import java.util.ArrayList;

public class Repo {
	static private List<Loja> repo = new ArrayList<Loja>();
	static private Loja escolhida = new Loja();

	public static void escreve(Loja p) {
		repo.add(p);
	}

	public static List<Loja> le() {
		return repo;
	}	
	
	public static void seleciona(Loja p){
		escolhida = p;
	}
	
	public static Loja retorna(){
		return escolhida;
	}
	
}
