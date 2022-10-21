package app.model;

import java.util.*;

public class FaseGrupos {
	
	private static Map<String, List<Selecao>> mapGrupos = new HashMap<String, List<Selecao>>();//map para armazenar em que grupos as seleções estão
	
	
	//-----------------------------------------------------------------------------------------
	
	/**
	 * Get para map dos Grupos das Seleções cadastradas.
	 * @return Map dos Grupos
	 */
	public Map<String, List<Selecao>> getMapGrupos(){
		return mapGrupos;
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

}
