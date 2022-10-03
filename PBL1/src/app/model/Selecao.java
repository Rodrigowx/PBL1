package app.model;

import java.util.*;

/**
 * Classe que representa o Seleção no sistema. Seleção possiu nome, lista de
 * jogadores e tecnico como parametro. Get e o set do dos atributos.
 */

public class Selecao {

	// ATRIBUTOS
	private String nome;
	private List<Jogador> jogadores;
	private Tecnico tecnico = null;

	// CONSTRUTOR
	public Selecao(String nome, List<Jogador> jogadores) {
		super();
		this.nome = nome;
		this.jogadores = jogadores;
	}

	// METODOS

	public String toString() {
		return this.nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Jogador> getJogadores() {
		return jogadores;// AQUI PRECISARIA LISTAR CADA UM DA LISTA
	}

	public void setJogadores(Jogador jogador) {
		this.jogadores.add(jogador); // adiciona o objeto passado como parâmetro na lista
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	/**
	 * Método responsável por atualizar a lista de jogadores ao excluir o mesmo.
	 * 
	 * @param jogador
	 */
	public void attListaJogs(Jogador jog) {
		for (Jogador atual : jogadores) {
			if (jog.getNome() == atual.getNome())
				jogadores.remove(atual);
		}
	}
}
