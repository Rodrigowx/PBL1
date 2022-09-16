package app.model;
import app.model.*;
import java.util.*;


public class ArbitroDAOImpl implements ArbitroDAO {
	
	ArrayList<Arbitro> listaArbitro = new ArrayList<>(); //Lista para o armazenamento dos Arbitros cadastrados PRECISA DO PUBLIC AQUI?
	
	
	@Override
	public boolean inserir(Arbitro arbitro) {
			listaArbitro.add(arbitro);
		return true;
	}

	@Override
	public boolean editar(Arbitro arbitro) {
		
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
