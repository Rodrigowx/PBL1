package app.model;
import app.model.*;
import java.util.*;


public class ArbitroDAOImpl implements ArbitroDAO {
	
	ArrayList<Arbitro> listaArbitro = new ArrayList<>(); //Lista para o armazenamento dos Arbitros cadastrados PRECISA DO PUBLIC AQUI?
	public static List<String> nomesArbitros = new ArrayList<String>();
	
	
	public static boolean checarNome(String nome) {
		if (nomesArbitros.isEmpty()) {
			return false;
		}else {
			if(nomesArbitros.contains(nome)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	@Override
	public boolean inserir(Arbitro arbitro) {
		listaArbitro.add(arbitro);
		nomesArbitros.add(arbitro.getNome());
		return true;
	}

	@Override
	public boolean editar(String nome1, String nome2 ) {
		for(Arbitro atual : listaArbitro) {
			if(atual.getNome() == nome1) {
				atual.setNome(nome2);
				return true;
			}
		}
		return false;
	}

	@Override
	public Arbitro excluir(String nomeArbitro) {
		
		/* O método excluir funciona de uma maneira parecida com o método editar,
		 * mas ele exclui o objeto da lista Árbitro ao encontrá-lo.
		 * E retorna o nome do Árbitro que foi excluído. 
		 * Caso não encontre, retorna NULL. */
		
		for (int i = 0; i < listaArbitro.size(); i++) {
			
			if (listaArbitro.get(i).getNome() == nomeArbitro) {
				
				Arbitro objArbitro = listaArbitro.get(i); //puxa da lista o objeto que será excluído para o retorno 
				listaArbitro.remove(i);
				
				return objArbitro;
			}
		}
		
		return null;
	}

	@Override
	public void listar() {
		for(int i = 0; i < listaArbitro.size(); i++) {
			System.out.println(listaArbitro.get(i).getNome()); //for para percorrer e listar o nome cada Arbitro da lista 
					
		}
		
	}

}
