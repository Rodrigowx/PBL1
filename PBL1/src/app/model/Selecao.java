package app.model;

import java.util.*;

public class Selecao {
	
	//ATRIBUTOS
	private String nome;
	private List<Jogador> jogadores;
	private Tecnico tecnico;
	
	
	//CONSTRUTOR
	public Selecao(String nome, List<Jogador> jogadores, Tecnico tecnico) {
		super();
		this.nome = nome;
		this.jogadores = jogadores;
		this.tecnico = tecnico;
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

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
}
