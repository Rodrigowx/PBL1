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
	
	public static void editar() {
		
	}
	
	public static void excluir(Partida partida) {
		
		//retirando os dados do objeto excluído
		partida.setData(null);
		partida.setGolsTime1(null);
		partida.setGolsTime2(null);
		partida.setHorario(null);
		partida.setLocal(null);
		
		mapPartidas.remove(partida);
		
		//retornando a partida para a lista de partidas geradas para ser cadastrada novamente
		FaseGruposPage.getPartidasGeradas().get(partida.getGrupo()).add(partida);
		
		//chamando a função que retira os dados da partida dos jogadores
		
		
		return;
	}

	/**
	 * Função responsável por pesquisar pelo nome da seleção.
	 * 
	 * @param nomeSelecao
	 */
	public void pesquisarSelecao(String nomeSelecao) {
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
	public void pesquisarPartidaData(String data) {
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
	public void listar() {

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

}
