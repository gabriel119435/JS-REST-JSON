package repo;

import java.util.List;
import java.util.ArrayList;

public class Repo {
	static private List<Pessoa> repo = new ArrayList<Pessoa>();
	static private Pessoa escolhida = new Pessoa();

	public static void escreve(Pessoa p) {
		repo.add(p);
	}

	public static List<Pessoa> le() {
		return repo;
	}	
	
	public static void seleciona(Pessoa p){
		escolhida = p;
	}
	
	public static Pessoa retorna(){
		return escolhida;
	}
	
	
}
