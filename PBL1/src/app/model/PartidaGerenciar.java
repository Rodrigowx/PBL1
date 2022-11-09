package app.model;

import java.util.*;

public class PartidaGerenciar{
	
	private static Map<String, Partida> mapPartidas = new HashMap<String, Partida>(); //É MELHOR USAR MAP OU LIST PARA PARTIDAS??
	
	
	//função para retornar o map de Partidas
	public static Map<String, Partida> getMapPartidas() {
		return mapPartidas;
	}

	public static boolean inserir(Partida partida) {
		mapPartidas.put(partida.getCodPart(), partida);//**
		return false;
	}

	public static boolean editar(String idPartida, int opcaoMenu) {
		
		//edição desse foi feito na main, precisa passar pra cá????? Mas ver como fica as verificações 
		
		return false;
	}

	public static void excluir(String idPartida) {
		
		mapPartidas.remove(idPartida);
		return;
	}

	public void listar() {
		
		System.out.println("\nLISTAGEM DAS PARTIDAS: n");
		
		mapPartidas.forEach((id, partida) -> {
			System.out.println("ID: " + id);
			System.out.println(partida.getTime1() + "\t" + partida.getGolsTime1() + " X " + partida.getGolsTime2() + "\t" + partida.getTime2());
			//PRECISA FORMATAR A DATA E HORÁRIO!!
			System.out.println("DATA: " + partida.getData());
			System.out.println("HORARIO: " + partida.getHorario());
			System.out.println("LOCAL: " + partida.getLocal());
			System.out.println();
		});
		
	}

}
