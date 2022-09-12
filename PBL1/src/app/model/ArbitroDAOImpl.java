package app.model;
import app.model.*;
import java.util.*;


public class ArbitroDAOImpl implements ArbitroDAO {
	
	ArrayList<Arbitro> listaArbitro = new ArrayList<>();	
	@Override
	public boolean inserir(Arbitro arbitro) {
			listaArbitro.add(arbitro);
		return true;
	}

	@Override
	public boolean editar(Arbitro arbitro) {
		// TODO Auto-generated method stub
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
			System.out.println(listaArbitro.get(i).getNome());
					
		}
		
	}

}
