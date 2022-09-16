package app.model;
import java.util.*;

public class JogadorDAOImpl implements JogadorDAO{
	
	Map<String, Jogador> mapJogadores = new HashMap<String, Jogador>(); //Lista para armazenar os objetos Jogador

	@Override
	public boolean inserir(Jogador jogador) {
		
		mapJogadores.put(jogador.getCodJog(), jogador);
		//fazer verificação caso haja erro aqui
		
		return true;
	}

	@Override
	public boolean editar(String idJogador, int opcaoMenu) {
		
		/*...primeiro verifica se o ID recebido está na lista
		 * */
		
		
		if (mapJogadores.containsKey(idJogador)) { 
			
			//Condicional para a opção que o usuário colocou no menu na main
			
			if (opcaoMenu == 1) { //EDITA NOME
				
				Scanner scan = new Scanner(System.in);
				String novoNome = scan.nextLine();
				mapJogadores.get(idJogador).setNome(novoNome);//FAZER VERIFICAÇÃO DE ERRO DE TODOS
				
				
			}else if (opcaoMenu == 2) { //EDITA POSIÇÃO
				
				Scanner scan = new Scanner(System.in);
				String novaPosic = scan.nextLine();
				mapJogadores.get(idJogador).setPosicao(novaPosic);
				
			}else if (opcaoMenu == 3) { //EDITA CARTÕES AMARELO
				
				Scanner scan = new Scanner(System.in);
				Integer novoCartA = scan.nextInt();
				mapJogadores.get(idJogador).setCartAmarelo(novoCartA);
				
			}else if (opcaoMenu == 4) { //EDITA CARTÕES VERMELHO
				
				Scanner scan = new Scanner(System.in);
				Integer novoCartV = scan.nextInt();
				mapJogadores.get(idJogador).setCartVermelho(novoCartV);
				
			}else if (opcaoMenu == 5) { //EDITA QUANTIDADE DE GOLS
				
				Scanner scan = new Scanner(System.in);
				Integer novoGols = scan.nextInt();
				mapJogadores.get(idJogador).setGols(novoGols);
				
			}
			return true;
		}
		return false;
	}

	@Override
	public Jogador excluir(String idJogador) {
		
		/*esse método retorna o objeto excluído, ou NULL caso 
		 * esse id não exista no Map*/
		
		//AQUI PRECISA EXCLUIR DAS DUAS LISTAS??
			
		return mapJogadores.remove(idJogador);
		
	}

	@Override
	public void listar() {
	    
		System.out.println("LISTAGEM DOS JOGADORES: \n");
		
	    mapJogadores.forEach((id, jogador) -> {
	    	   System.out.println("ID: " + id + "\nNOME: " + jogador.getNome());
	    	   System.out.println("POSICAO: " + jogador.getPosicao());
	    	   System.out.println("CARTOES AMARELOS: " + jogador.getCartAmarelo());
	    	   System.out.println("CARTOES VERMELHOS: " + jogador.getCartVermelho());
	    	   System.out.println("QUANTIDADE DE GOLS: " + jogador.getGols());
	    	});
	}

}
