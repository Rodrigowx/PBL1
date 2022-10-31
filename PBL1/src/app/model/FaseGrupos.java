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
	
	/**
	 * Essa função é responsável por gerar as todas as Partidas, pois
	 * elas são pré-estabelecidas. Essa função é chamada somente uma vez na Main
	 * antes de iniciar o Menu da fase de Grupos (fase1), pois é lá que ela ficará armazenada
	 * 
	 * @return map de todas as partidas geradas
	 */
	
	public Map<String, List<Partida>> gerarPartidas() {
		
		Map<String, List<Partida>> mapPartidasGeradas = new HashMap<String, List<Partida>>(); //cria um Map para armazenar as partidas geradas
		
		mapGrupos.forEach((grupo, selecoes) -> { //percorre cada Grupo presente no dicionário
			
			List<Partida> PartidasGrupo = new ArrayList<Partida>(); //A cada grupo percorrido, ele cria uma lista com as Partidas desse Grupo que serão geradas
			
			//cria uma lista temporária e copia todos os elementos da lista de seleções do grupo, para não comprometer a lista original dos grupos
			List<Selecao> ListaSelTemp = new ArrayList<>();
			ListaSelTemp.addAll(selecoes); //a função .addAll copia todos os elementos de uma outra lista
			
			for (Selecao atual1 : selecoes) {
				
				//int index = ListaSelTemp.indexOf(atual1); //Identifica qual o index da seleção atual do for...
				//ListaSelTemp.remove(index);// ...e remove ele da lista para não gerar partidas repetidas
				ListaSelTemp.remove(atual1);
				
				for (Selecao atual2 : ListaSelTemp) {
					String time1, time2; //Cria as variáveis que irão guardar os times da partida				
					time1 = atual1.getNome();
					time2 = atual2.getNome();
					
					System.out.println(time1);
					System.out.println(time2);
					
					Partida partidaNova = new Partida(time1, time2); //cria o objeto com os times/Seleções que irão competir
					PartidasGrupo.add(partidaNova); //adiciona a Partida criada na lista de Partidas desse Grupo
				}
			}
			
			mapPartidasGeradas.put(grupo, PartidasGrupo); //adiciona a Lista de Partidas do Grupo que acabou de ser percorrido no Map de TODAS as Partidas
		});
		return mapPartidasGeradas;
	}

}
