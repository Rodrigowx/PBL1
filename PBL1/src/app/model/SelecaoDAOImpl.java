package app.model;

import java.util.*;

public class SelecaoDAOImpl implements SelecaoDAO {

	ArrayList<Selecao> listaSelecoes = new ArrayList<>(); 
	
	@Override
	public boolean inserir(Selecao selecao) {
		
		listaSelecoes.add(selecao); //**
		
		return true;
	}

	@Override
	public boolean editar(String nomeSelecao, String novoNome) {
		
		for (int i = 0; i < listaSelecoes.size(); i++) {
			
			if (listaSelecoes.get(i).getNome() == nomeSelecao) {
				
				listaSelecoes.get(i).setNome(novoNome);
				return true;
			}
		}
		return false;
	}

	@Override
	public Selecao excluir(String nomeSelecao) {
		
		/*explicar aqui o que faz*/
		
		for (int i = 0; i < listaSelecoes.size(); i++) {
			
			if (listaSelecoes.get(i).getNome() == nomeSelecao) {
				
				Selecao removed = listaSelecoes.get(i);
				listaSelecoes.remove(i);
				return removed;
			}
		}
		return null;
	}

	@Override
	public void listar() {
		for (int i = 0; i < listaSelecoes.size(); i++) {
			System.out.println(listaSelecoes.get(i).getNome());
		}
	}

}
