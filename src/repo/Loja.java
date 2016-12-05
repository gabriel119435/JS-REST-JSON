package repo;

public class Loja {
	private String nome;
	private String cnpj;
	private String template;

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getcnpj() {
		return cnpj;
	}

	public void setcnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return this.nome + "-" + this.cnpj + "-" + this.template;
	}
}
