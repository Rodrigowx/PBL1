package app.model;
import java.util.*;

public class JogadorDAOImpl implements JogadorDAO{
	
	private static Scanner scan = new Scanner(System.in); 
	private static Map<String, Jogador> mapJogadores = new HashMap<String, Jogador>(); //Lista para armazenar os objetos Jogador
	private static List<String> nomesJogadores = new ArrayList<String>();
	
	//------------------------------------------------------------------------
	public static boolean checarNome(String nome) {
		if (nomesJogadores.isEmpty()) {
			return false;
		}else {
			if(nomesJogadores.contains(nome)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	//------------------------------------------------------------------------
	public Map<String, Jogador> getMap(){
		return mapJogadores;
	}
		
	public List<String> getLista(){
		return nomesJogadores;
	}
	//------------------------------------------------------------------------
	
	@Override
	public boolean inserir(Jogador jogador) {
		
		mapJogadores.put(jogador.getCodJog(), jogador);
		//fazer verificação caso haja erro aqui
		nomesJogadores.add(jogador.getNome());
		
		return true;
	}

	@Override
	public boolean editar(String idJogador, int opcaoMenu) {
		
		/*...primeiro verifica se o ID recebido está na lista
		 * */
		
		
		if (mapJogadores.containsKey(idJogador)) { 
			
			
			
			//Condicional para a opção que o usuário colocou no menu na main
			
			if (opcaoMenu == 1) { //EDITA NOME
				
				System.out.println("Informe o novo nome: ");
				String novoNome = scan.nextLine();
				mapJogadores.get(idJogador).setNome(novoNome);//FAZER VERIFICAÇÃO DE ERRO DE TODOS
				System.out.println("Nome editado com sucesso!");
				
			}else if (opcaoMenu == 2) { //EDITA POSIÇÃO
				
				System.out.println("\n -> Escolha qual a posicao do Jogador: ");
				System.out.println("1 - Goleiro \n2 - Zagueiro \n3 - Meia \n4 - Atacante");
				int novaPosic = scan.nextInt();
				String posicao = null;
				while (posicao == null) {
					switch (novaPosic) {
					case 1:
						posicao = "Goleiro";
						break;
					case 2:
						posicao = "Zagueiro";
						break;
					case 3:
						posicao = "Meia";
						break;
					case 4:
						posicao = "Atacante";
						break;
					default:
						System.out.println("Escolha uma posicao valida!");
						novaPosic = scan.nextInt();
					}
				}
				mapJogadores.get(idJogador).setPosicao(posicao);
				System.out.println("Posicao alterada com sucesso!");
				
			}else if (opcaoMenu == 3) { //EDITA CARTÕES AMARELO
				
				System.out.println("Informe a nova quantidade de cartoes amarelos: ");
				Integer novoCartA = scan.nextInt();
				mapJogadores.get(idJogador).setCartAmarelo(novoCartA);
				System.out.println("Cartao alterado com sucesso!");
				
			}else if (opcaoMenu == 4) { //EDITA CARTÕES VERMELHO
				
				System.out.println("Informe a nova quantidade de cartoes vermelhos: ");
				Integer novoCartV = scan.nextInt();
				mapJogadores.get(idJogador).setCartVermelho(novoCartV);
				System.out.println("Cartao alterado com sucesso!");
				
			}else if (opcaoMenu == 5) { //EDITA QUANTIDADE DE GOLS
				
				System.out.println("Informe a nova quantidade de gols: ");
				Integer novoGols = scan.nextInt();
				mapJogadores.get(idJogador).setGols(novoGols);
				System.out.println("Gols alterado com sucesso!");
				
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
