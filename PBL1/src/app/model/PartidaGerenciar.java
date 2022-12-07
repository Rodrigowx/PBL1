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
	 * Função para verificar se uma partida já foi cadastrada pelo usuário
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean verificaPartida(Selecao time1, Selecao time2) {
		
		for(Partida partida : mapPartidas.values()) {
			if (partida.getTime1().equals(time1.getNome()) && partida.getTime2().equals(time2.getNome())) {
				return true;
			}
		}
		return false;
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
