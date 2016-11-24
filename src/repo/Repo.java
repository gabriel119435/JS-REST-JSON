package repo;

import java.util.List;
import java.util.ArrayList;

public class Repo {
	static private List<Pessoa> repo = new ArrayList<Pessoa>();

	public static void escreve(Pessoa p) {
		repo.add(p);
	}

	public static List<Pessoa> le() {
		return repo;
	}	
}
