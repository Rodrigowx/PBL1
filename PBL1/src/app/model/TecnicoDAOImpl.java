package app.model;

import java.util.*;

public class TecnicoDAOImpl implements TecnicoDAO {
	
	ArrayList<Tecnico> listaTecnicos = new ArrayList<>();
	public static List<String> nomesTecnico = new ArrayList<String>();
	
	public static boolean checarNome(String nome) {
		if (nomesTecnico.isEmpty()) {
			return false;
		}else {
			if(nomesTecnico.contains(nome)) {
				return true;
			}else {
				return false;
			}
		}
	}

	@Override
	public boolean inserir(Tecnico tecnico) {
		this.listaTecnicos.add(tecnico);
		nomesTecnico.add(tecnico.getNome());
		return true;
	}
	
	@Override
	public boolean editar(String nomeTecnico, String novoNome) {
		
		/*O 'for' percorre a lista de tecnicos procurando o objeto que possui o nome
		 * dado pelo usuário, quando encontrado, troca o nome antigo pelo novo.
		 * Caso não encontre um objeto com o nome dado, o método retorna false*/
		
		for (int i = 0; i < listaTecnicos.size(); i++) {
			if (listaTecnicos.get(i).getNome() == nomeTecnico) {
				
				listaTecnicos.get(i).setNome(novoNome);
				return true;
			}
		}
		return false;
	}

	@Override
	public Tecnico excluir(String nomeTecnico) {
		
		/* O método excluir funciona de uma maneira parecida com o método editar,
		 * mas ele exclui o objeto da lista Tecnico ao encontrá-lo.
		 * E retorna o nome do Técnico que foi excluído. 
		 * Caso não encontre, retorna NULL. */
		
		for (int i = 0; i < listaTecnicos.size(); i++) {
			
			if (listaTecnicos.get(i).getNome() == nomeTecnico) {
				
				Tecnico objTecnico = listaTecnicos.get(i); //puxa da lista o objeto que será excluído para o retorno 
				listaTecnicos.remove(i);
				
				return objTecnico;
			}
		}
		return null;
	}

	@Override
	public void listar() {
		for(int i = 0; i < listaTecnicos.size(); i++) {
			System.out.println(listaTecnicos.get(i).getNome()); //for para percorrer e listar o nome cada Técnico da lista
		}
	}

}
