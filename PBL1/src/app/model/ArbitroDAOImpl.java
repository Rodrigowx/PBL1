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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listar() {
		for(int i = 0; i < listaArbitro.size(); i++) {
			System.out.println(listaArbitro.get(i).getNome()); //for para percorrer e listar o nome cada Arbitro da lista 
					
		}
		
	}

}
