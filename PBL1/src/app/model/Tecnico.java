package app.model;

public class Tecnico {

	// ATRIBUTO
	private String nome;
	private Selecao selecao = null;

	public Tecnico(String nome) {
		this.nome = nome;
	}

	// METODOS
	public String toString() {
		return this.nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
}
