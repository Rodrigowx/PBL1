package app.model;

import java.util.*;

/**
 * Classe responsável pelo DAO do Seleção. Aqui foi implementado todas as
 * funções do CRUD.
 */

public class SelecaoDAOImpl implements SelecaoDAO {

	private static ArrayList<Selecao> listaSelecoes = new ArrayList<>();
	private static List<String> nomesSelecao = new ArrayList<String>();
	
	private static Map<String, List<Selecao>> mapGrupos = new HashMap<String, List<Selecao>>();//map para armazenar em que grupos as seleções estão

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
	
	/**
	 * Função para verificar se o Grupo informado pelo usuário na hora de cadastrar a
	 * Seleção já está completo. Se estiver não poderá mais cadastrar Seleções nesse Grupo
	 * e retornará true.
	 * 
	 * @param Letra do Grupo
	 * @return true ou false
	 */
	public boolean verificaGrupos(String opcaoMenu) {
		
		List<Selecao> grupo = mapGrupos.get(opcaoMenu);
		
		if (grupo == null) {
			return false;
			
		}else if (grupo.isEmpty()) {
			return false;
			
		}else if (grupo.size() == 4) {
			return true; //retorna true (que a lista está cheia)
		}
		
		return false;
	}
	
	/**
	 * Função que adiciona as seleções em seus grupos e atualiza o map Grupos
	 * para sempre fazer a verificação 
	 * @param grupo
	 */
	public void atualizaGrupos(String grupo, Selecao selecao) {
		
		if (mapGrupos.containsKey(grupo)) { //se o map já contem esse grupo, adiciona a seleção a lista
			mapGrupos.get(grupo).add(selecao);
			
		}else {	//se não, então cria o grupo no map e adiciona a seleção depois
			List<Selecao> listaSel = new ArrayList<Selecao>();
			mapGrupos.put(grupo, listaSel);
			mapGrupos.get(grupo).add(selecao);
		}
		
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
	
	/**
	 * Get para map dos Grupos das Seleções cadastradas.
	 * @return Map dos Grupos
	 */
	public Map<String, List<Selecao>> getMapGrupos(){
		return mapGrupos;
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