package app.model;

import java.util.*;

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
