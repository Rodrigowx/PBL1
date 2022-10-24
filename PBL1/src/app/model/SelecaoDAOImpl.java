package app.model;

import java.util.*;

/**
 * Classe responsável pelo DAO do Seleção. Aqui foi implementado todas as
 * funções do CRUD.
 */

public class SelecaoDAOImpl implements SelecaoDAO {

	private static ArrayList<Selecao> listaSelecoes = new ArrayList<>();
	private static List<String> nomesSelecao = new ArrayList<String>();

	// ------------------------------------------------------------------------
	public boolean checarNome(String nome) {
		if (nomesSelecao.isEmpty()) {
			return false;
		} else {
			if (nomesSelecao.contains(nome)) {
				return true;
			} else {
				return false;
			}
		}
	}

	// ------------------------------------------------------------------------

	/**
	 * Função responsável para saber seleção ja tem técnico.
	 * 
	 * @param nomeSelecao
	 * @return seleção
	 */
	public Selecao verificaTecnico(String nomeSelecao) {

		for (Selecao atual : listaSelecoes) {
			if (atual.getNome().equals(nomeSelecao)) {
				if (atual.getTecnico() == null) {
					return atual;
				}
			}
		}
		return null;
	}
	// ------------------------------------------------------------------------

	/**
	 * Função para verificar se a seleção informada pelo usuário existe na lista e
	 * retorná-la pra adicionar o jogador e o tecnico no objeto seleçao deles.
	 * 
	 * @param nome da seleção.
	 * @return objeto da Seleção
	 */

	public Selecao verificaSelecao(String nomeSelecao) {

		if (nomesSelecao.contains(nomeSelecao)) {

			for (Selecao selecao : listaSelecoes) {

				if (selecao.getNome().equals(nomeSelecao)) {// buscando a seleção na lista
					return selecao;
				}
			}

		} else {
			return null;
		}
		return null;
	}
	
	public boolean verificaTotal() {
		
		/**Essa função verifica se cada seleção cadastrada possui pelo menos 7 jogadores cadastrados, pois
		 * as partidas só podem ser iniciadas com pelo menos essa quantidade em cada time (min 7 e max 11)
		 */
		
		for(Selecao selecao : listaSelecoes) {
			if (selecao.getJogadores().size() >= 7) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}

	// ------------------------------------------------------------------------
	/**
	 * Get para lista de objetos seleções cadastrados.
	 * 
	 * @return Lista Selecao.
	 */

	public ArrayList<Selecao> getLista1() {
		return listaSelecoes;
	}

	/**
	 * Get para lista de nomes das seleções ja cadastrados.
	 * 
	 * @return Lista de nomes da Selecao.
	 */
	public List<String> getLista2() {
		return nomesSelecao;
	}
	
	// ------------------------------------------------------------------------

	/**
	 * Função inserir, responsável por adicionar o novo objeto Seleção na lista. E
	 * também, adicionar o novo nome na lista de nomes cadastrados.
	 * 
	 * @param seleção
	 * @return verificação de sucesso ou falha do processo(boolean)
	 */

	@Override
	public boolean inserir(Selecao selecao) {

		listaSelecoes.add(selecao); // **
		nomesSelecao.add(selecao.getNome());
		System.out.println("Inserido com sucesso!");
		return true;
	}

	/**
	 * Função editar, responsável por modificar os atributos do objeto Seleção salvo
	 * na lista. E também,caso seja novo nome, adicionar na lista de nomes
	 * cadastrados. E excluir o antigo nome.
	 * 
	 * @param nomeSelecao(antigo) e novoNome (novo).
	 * @return verificação de sucesso ou falha do processo(boolean).
	 */

	@Override
	public boolean editar(String nomeSelecao, String novoNome) {

		for (int i = 0; i < listaSelecoes.size(); i++) {

			if (listaSelecoes.get(i).getNome().equals(nomeSelecao)) {

				listaSelecoes.get(i).setNome(novoNome);// mudando o nome no objeto

				// tirando o nome antigo da segunda lista e adicionando o novo
				int index = nomesSelecao.indexOf(nomeSelecao);
				nomesSelecao.remove(index);
				nomesSelecao.add(novoNome);

				System.out.println("Editado com sucesso!");
				return true;
			}
		}
		return false;
	}

	/**
	 * Função excluir, responsável por excluir o objeto Seleção da lista. E também,
	 * excluir o nome da seleção da lista de nomes cadastrados.
	 * 
	 * @param nome do árbitro.
	 * @return Objeto Árbitro recém excluido .
	 */

	@Override
	public Selecao excluir(String nomeSelecao) {

		/* removendo da lista de nomes (segunda lista) */
		int indx2 = nomesSelecao.indexOf(nomeSelecao);
		nomesSelecao.remove(indx2);

		for (Selecao atual : listaSelecoes) {
			if (atual.getNome().equals(nomeSelecao) == true) {
				Selecao a = atual;
				listaSelecoes.remove(atual);
				System.out.println("Excluido com sucesso!");
				return a;
			} else {
				return null;
			}

		}
		return null;
	}

	/**
	 * Função listar, responsável por imprimir o nome de todos os objetos Seleções
	 * cadastrados.
	 */

	@Override
	public void listar() {
		System.out.println("\nLISTAGEM DAS SELECOES:");
		for (int i = 0; i < listaSelecoes.size(); i++) {
			System.out.println("- " + listaSelecoes.get(i).getNome() + "\tGrupo: " + listaSelecoes.get(i).getGrupo());
		}
	}

	/**
	 * Função responsável por atualizar a lista de tecnicos da seleção após ele ser
	 * excluido do sistema
	 * 
	 * @param tec
	 */

	public void attTecnico(Tecnico tec) {

		for (Selecao x : listaSelecoes) {
			if (x.getNome().equals(tec.getSelecao().getNome())) {
				int indx = listaSelecoes.indexOf(x);
				listaSelecoes.get(indx).setTecnico(null);
			}
		}
	}
}