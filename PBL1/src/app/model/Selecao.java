package app.model;

import java.util.*;

public class Selecao {
	
	//ATRIBUTOS
	private String nome;
	private List<Jogador> jogadores;
	private Tecnico tecnico = null;
	
	
	//CONSTRUTOR
	public Selecao(String nome, List<Jogador> jogadores) {
		super();
		this.nome = nome;
		this.jogadores = jogadores;
	}

	//METODOS
	
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
		return jogadores;//AQUI PRECISARIA LISTAR CADA UM DA LISTA
	}

	public void setJogadores(Jogador jogador) {
		this.jogadores.add(jogador); //adiciona o objeto passado como parâmetro na lista
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
}
