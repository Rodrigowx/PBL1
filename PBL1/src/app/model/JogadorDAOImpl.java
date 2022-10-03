package app.model;

import java.util.*;

import app.funcoes;

public class JogadorDAOImpl implements JogadorDAO {

	private static Scanner scan = new Scanner(System.in);
	private static Map<String, Jogador> mapJogadores = new HashMap<String, Jogador>(); // Lista para armazenar os
																						// objetos Jogador
	private static List<String> nomesJogadores = new ArrayList<String>();

	// ------------------------------------------------------------------------
	public boolean checarNome(String nome) {
		if (nomesJogadores.isEmpty()) {
			return false;
		} else {
			if (nomesJogadores.contains(nome)) {
				return true;
			} else {
				return false;
			}
		}
	}

	// ------------------------------------------------------------------------
	public boolean checarID(String id) {
		if (mapJogadores.isEmpty()) {
			return false;
		} else {
			if (mapJogadores.containsKey(id)) {
				return true;
			} else {
				return false;
			}
		}
	}

	// ------------------------------------------------------------------------
	public Map<String, Jogador> getMap() {
		return mapJogadores;
	}

	public List<String> getLista() {
		return nomesJogadores;
	}
	// ------------------------------------------------------------------------

	@Override
	public boolean inserir(Jogador jogador) {

		mapJogadores.put(jogador.getCodJog(), jogador);
		// fazer verificação caso haja erro aqui
		nomesJogadores.add(jogador.getNome());
		return true;
	}

	@Override
	public boolean editar(String idJogador, int opcaoMenu) {

		/*
		 * ...primeiro verifica se o ID recebido está na lista
		 */

		if (mapJogadores.containsKey(idJogador)) {

			// Condicional para a opção que o usuário colocou no menu na main

			if (opcaoMenu == 1) { // EDITA NOME

				System.out.println("Informe o novo nome: ");
				String novoNome = scan.nextLine();
				mapJogadores.get(idJogador).setNome(novoNome);// FAZER VERIFICAÇÃO DE ERRO DE TODOS
				System.out.println("Nome editado com sucesso!");

			} else if (opcaoMenu == 2) { // EDITA POSIÇÃO

				System.out.println("\n -> Escolha qual a posicao do Jogador: ");
				System.out.println("1 - Goleiro \n2 - Zagueiro \n3 - Meia \n4 - Atacante");
				//int novaPosic = scan.nextInt();
				Integer novaPosic = funcoes.leituraInt();
				String posicao = null;
				while (posicao == null) {
					switch (novaPosic) {
					case 1:
						posicao = "Goleiro";
						break;
					case 2:
						posicao = "Zagueiro";
						break;
					case 3:
						posicao = "Meia";
						break;
					case 4:
						posicao = "Atacante";
						break;
					default:
						System.out.println("Escolha uma posicao valida!");
						//novaPosic = scan.nextInt();
						novaPosic = funcoes.leituraInt();
					}
				}
				mapJogadores.get(idJogador).setPosicao(posicao);
				System.out.println("Posicao alterada com sucesso!");

			} else if (opcaoMenu == 3) { // EDITA CARTÕES AMARELO

				System.out.println("Informe a nova quantidade de cartoes amarelos: ");
				//Integer novoCartA = scan.nextInt();
				Integer novoCartA = funcoes.leituraInt();
				mapJogadores.get(idJogador).setCartAmarelo(novoCartA);
				System.out.println("Cartao alterado com sucesso!");

			} else if (opcaoMenu == 4) { // EDITA CARTÕES VERMELHO

				System.out.println("Informe a nova quantidade de cartoes vermelhos: ");
				//Integer novoCartV = scan.nextInt();
				Integer novoCartV = funcoes.leituraInt();
				mapJogadores.get(idJogador).setCartVermelho(novoCartV);
				System.out.println("Cartao alterado com sucesso!");

			} else if (opcaoMenu == 5) { // EDITA QUANTIDADE DE GOLS

				System.out.println("Informe a nova quantidade de gols: ");
				//Integer novoGols = scan.nextInt();
				Integer novoGols = funcoes.leituraInt();
				mapJogadores.get(idJogador).setGols(novoGols);
				System.out.println("Gols alterado com sucesso!");

			}
			return true;
		}
		return false;
	}

	@Override
	public Jogador excluir(String idJogador) {

		/*
		 * esse método retorna o objeto excluído, ou NULL caso esse id não exista no Map
		 */

		Jogador obj = mapJogadores.remove(idJogador);
		System.out.println("Excluido com sucesso!");
		
		for (String atual : nomesJogadores) {
			if (atual.equals(obj.getNome())) {
				nomesJogadores.remove(nomesJogadores.indexOf(atual));
				return obj;
			}

		}
		return null;

	}

	@Override
	public void listar() {

		System.out.println("LISTAGEM DOS JOGADORES: \n");

		mapJogadores.forEach((id, jogador) -> {
			System.out.print("ID: " + id + "\nNOME: " + jogador.getNome() + "\t");
			System.out.print("SELECAO: " + jogador.getSelecao().getNome() + "\t");
			System.out.print("POSICAO: " + jogador.getPosicao() + "\t");
			System.out.print("CARTOES AMARELOS: " + jogador.getCartAmarelo() + "\t");
			System.out.print("CARTOES VERMELHOS: " + jogador.getCartVermelho() + "\t");
			System.out.println("QUANTIDADE DE GOLS: " + jogador.getGols());
			System.out.println();
		});
	}

	public void attListaJogadores(Selecao obj) {

		for (Jogador atual : obj.getJogadores()) {
			mapJogadores.remove(atual.getCodJog());
			int indx = nomesJogadores.indexOf(atual.getNome());
			nomesJogadores.remove(indx);
		}

	}

}
