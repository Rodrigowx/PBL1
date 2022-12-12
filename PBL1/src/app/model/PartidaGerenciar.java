package app.model;

import java.util.*;

import app.controller.FaseGruposPage;

public class PartidaGerenciar {

	private static Map<String, Partida> mapPartidas = new HashMap<String, Partida>();

	/**
	 * Função para retornar o map de Partidas
	 * 
	 * @return mapPartidas
	 */
	public static Map<String, Partida> getMapPartidas() {
		return mapPartidas;
	}
	
	public static Partida retornaPartida(Selecao time1, Selecao time2) {
		for(Partida partida : mapPartidas.values()) {
			if (partida.getTime1().equals(time1.getNome()) && partida.getTime2().equals(time2.getNome())) {
				return partida;
			}
		}
		return null;
	}

	/**
	 * Inserir partida na lista
	 * 
	 * @param partida
	 * @return boolean
	 */
	public static boolean inserir(Partida partida) {
		mapPartidas.put(partida.getCodPart(), partida);// **
		return false;
	}


	public static void excluir(Partida partida) {
		//chamando a função que retira os dados da partida dos jogadores
		
		
		//retirando os dados do objeto excluído
		partida.setData(null);
		partida.setGolsTime1(null);
		partida.setGolsTime2(null);
		partida.setHorario(null);
		partida.setLocal(null);
		
		mapPartidas.remove(partida.getCodPart());
		System.out.println(mapPartidas);
		
		//retornando a partida para a lista de partidas geradas para ser cadastrada novamente
		FaseGruposPage.getPartidasGeradas().get(partida.getGrupo()).add(partida);
	
		return;
	}

	/**
	 * Função responsável por pesquisar pelo nome da seleção.
	 * 
	 * @param nomeSelecao
	 */
	public static void pesquisarSelecao(String nomeSelecao) {
		mapPartidas.forEach((id, partida) -> {
			if (partida.getTime1().equals(nomeSelecao) || partida.getTime2().equals(nomeSelecao)) {
				System.out.println("ID: " + id);
				System.out.println(partida.getTime1() + "\t" + partida.getGolsTime1() + " X " + partida.getGolsTime2()
						+ "\t" + partida.getTime2());
				System.out.println("DATA: " + partida.getData());
				System.out.println("HORARIO: " + partida.getHorario());
				System.out.println("LOCAL: " + partida.getLocal());
				System.out.println();

			}
		});
	}

	/**
	 * Função responsável por pesquisar partida pela data.
	 * 
	 * @param data
	 */
	public static void pesquisarPartidaData(String data) {
		mapPartidas.forEach((id, partida) -> {
			if (partida.getData().equals(data)) {
				System.out.println("ID: " + id);
				System.out.println(partida.getTime1() + "\t" + partida.getGolsTime1() + " X " + partida.getGolsTime2()
						+ "\t" + partida.getTime2());
				System.out.println("DATA: " + partida.getData());
				System.out.println("HORARIO: " + partida.getHorario());
				System.out.println("LOCAL: " + partida.getLocal());
				System.out.println();

			}
		});
	}

	/**
	 * Função responsável por listar.
	 */
	public static void listar() {

		System.out.println("\nLISTAGEM DAS PARTIDAS: \n");

		mapPartidas.forEach((id, partida) -> {
			System.out.println("ID: " + id);
			System.out.println(partida.getTime1() + "\t" + partida.getGolsTime1() + " X " + partida.getGolsTime2()
					+ "\t" + partida.getTime2());
			System.out.println("DATA: " + partida.getData());
			System.out.println("HORARIO: " + partida.getHorario());
			System.out.println("LOCAL: " + partida.getLocal());
			System.out.println();
		});

	}

	public static boolean todasPartidasCadastradas() {

		for (Map.Entry<String, Partida> partidaAtual : mapPartidas.entrySet()) {
			if (partidaAtual.getValue().isCadastro() == true) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

}
