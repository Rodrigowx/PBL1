package app.model;

import java.util.*;

public class PartidaDAOImpl implements PartidaDAO{
	
	private static Map<String, Partida> mapPartidas = new HashMap<String, Partida>(); //É MELHOR USAR MAP OU LIST PARA PARTIDAS??
	
	
	//função para retornar o map de Partidas
	public static Map<String, Partida> getMapPartidas() {
		return mapPartidas;
	}
	
	//função para gerar as partidas. SERIA AQUI OU NA MAIN???
	public static void gerarPartidas() {
		
	}

	@Override
	public boolean inserir(Partida partida) {
		// TODO Auto-generated method stub
		mapPartidas.put(partida.getCodPart(), partida);//**
		return false;
	}

	@Override
	public boolean editar(String idPartida, int opcaoMenu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Partida excluir(String idPartida) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
		System.out.println("\nLISTAGEM DAS PARTIDAS: ");
		
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
