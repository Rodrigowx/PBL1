package app.model;

import java.util.*;

import app.Funcoes;

/**
 * Classe responsável pelo DAO do Jogador. Aqui foi implementado todas as
 * funções do CRUD.
 */

public class JogadorDAOImpl implements JogadorDAO {

	private static Scanner scan = new Scanner(System.in);
	private static Map<String, Jogador> mapJogadores = new HashMap<String, Jogador>(); // Lista para armazenar os
																						// objetos Jogador
	private static List<String> nomesJogadores = new ArrayList<String>();

	// ------------------------------------------------------------------------

	/**
	 * Função responsável por checar se a lista de nomes está vazia e se contém o
	 * nome passado pelo parametro.
	 * 
	 * @param nome
	 * @return vericação de execução.
	 */
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

	/**
	 * Função para verificar se o ID informado pelo usuário está na Map de Joadpres
	 * 
	 * @param ID do jogador
	 * @return resultado da verificação
	 */

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

	/**
	 * Função para retornar o Map de jogadores, pois é um atributo privado do DAO
	 * 
	 * @return Map dos jogadores
	 */

	public Map<String, Jogador> getMap() {
		return mapJogadores;
	}

	/**
	 * Função para retornar a lista de nomes dos jogadores, pois é um atributo
	 * privado do DAO
	 * 
	 * @return lista do nome dos jogadores
	 */

	public List<String> getLista() {
		return nomesJogadores;
	}
	// ------------------------------------------------------------------------

	/**
	 * Função para inserir um jogador novo (CRUD)
	 * 
	 * @param objeto jogador
	 */
	@Override
	public boolean inserir(Jogador jogador) {
		mapJogadores.put(jogador.getCodJog(), jogador);
		nomesJogadores.add(jogador.getNome());
		return true;
	}

	/**
	 * Função para editar algum dado de um jogador já cadastrado (CRUD). Para
	 * editar, primeiro verifica se o ID recebido está na lista e depois ele edita
	 * conforme a escolha do usuário.
	 * 
	 * @param ID do jogador e opção do que o usuário quer editar
	 * @return verificação de falha ou sucesso da função (boolean)
	 */

	@Override
	public boolean editar(String idJogador, int opcaoMenu) {

		if (mapJogadores.containsKey(idJogador)) {

			// Condicional para a opção que o usuário colocou no menu na main

			if (opcaoMenu == 1) { // EDITA NOME

				System.out.println("Informe o novo nome: ");
				String novoNome = scan.nextLine();

				// tirando o nome antigo da segunda lista de jogadores
				int index = nomesJogadores.indexOf(mapJogadores.get(idJogador).getNome());
				nomesJogadores.remove(index);

				mapJogadores.get(idJogador).setNome(novoNome);// mudando o nome do objeto
				nomesJogadores.add(novoNome); // adicionando o novo nome na segunda lista

				System.out.println("Nome editado com sucesso!");

			} else if (opcaoMenu == 2) { // EDITA POSIÇÃO

				System.out.println("\n -> Escolha qual a posicao do Jogador: ");
				System.out.println("1 - Goleiro \n2 - Zagueiro \n3 - Meia \n4 - Atacante");

				Integer novaPosic = Funcoes.leituraInt();
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

						novaPosic = Funcoes.leituraInt();
					}
				}
				mapJogadores.get(idJogador).setPosicao(posicao);
				System.out.println("Posicao alterada com sucesso!");

			} else if (opcaoMenu == 3) { // EDITA CARTÕES AMARELO

				System.out.println("Informe a nova quantidade de cartoes amarelos: ");
				// Integer novoCartA = scan.nextInt();
				Integer novoCartA = Funcoes.leituraInt();
				mapJogadores.get(idJogador).setCartAmarelo(novoCartA);
				System.out.println("Cartao alterado com sucesso!");

			} else if (opcaoMenu == 4) { // EDITA CARTÕES VERMELHO

				System.out.println("Informe a nova quantidade de cartoes vermelhos: ");
				// Integer novoCartV = scan.nextInt();
				Integer novoCartV = Funcoes.leituraInt();
				mapJogadores.get(idJogador).setCartVermelho(novoCartV);
				System.out.println("Cartao alterado com sucesso!");

			} else if (opcaoMenu == 5) { // EDITA QUANTIDADE DE GOLS

				System.out.println("Informe a nova quantidade de gols: ");
				// Integer novoGols = scan.nextInt();
				Integer novoGols = Funcoes.leituraInt();
				mapJogadores.get(idJogador).setGols(novoGols);
				System.out.println("Gols alterado com sucesso!");

			}
			return true;
		}
		return false;
	}

	/**
	 * Função para excluir um jogador cadastrado (CRUD). Esse método retorna o
	 * objeto excluído, ou NULL caso esse ID não exista no Map
	 * 
	 * @param ID do jogador
	 * @return objeto Jogador que foi excluído
	 */
	@Override
	public Jogador excluir(String idJogador) {

		Jogador obj = mapJogadores.remove(idJogador);
		System.out.println("Excluido com sucesso!");

		for (String atual : nomesJogadores) {
			if (atual.equals(obj.getNome()) == true) {
				nomesJogadores.remove(nomesJogadores.indexOf(atual));
				return obj;
			}

		}
		return null;

	}

	/**
	 * Função para listar todos os jogadores e seus atributos (CRUD)
	 */

	@Override
	public void listar() {

		System.out.println("\nLISTAGEM DOS JOGADORES: \n");

		mapJogadores.forEach((id, jogador) -> {
			System.out.print("ID: " + id + "\nNOME: " + jogador.getNome() + "\t");
			System.out.print("SELECAO: " + jogador.getSelecao().getNome() + "\t");
			System.out.print("\tPOSICAO: " + jogador.getPosicao() + "\t");
			System.out.print("CARTOES AMARELOS: " + jogador.getCartAmarelo() + "\t");
			System.out.print("CARTOES VERMELHOS: " + jogador.getCartVermelho() + "\t");
			System.out.println("QUANTIDADE DE GOLS: " + jogador.getGols());
			System.out.println();
		});
	}

	/**
	 * Funçao para atualizar a lista de jogadores da seleção de um jogador que foi
	 * excluido
	 * 
	 * @param Objeto Seleçao
	 */

	public void attListaJogadores(Selecao obj) {

		for (Jogador atual : obj.getJogadores()) {
			mapJogadores.remove(atual.getCodJog());
			int indx = nomesJogadores.indexOf(atual.getNome());
			nomesJogadores.remove(indx);
		}

	}

}
