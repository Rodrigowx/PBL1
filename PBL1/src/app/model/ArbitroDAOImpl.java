package app.model;

import java.util.*;

public class ArbitroDAOImpl implements ArbitroDAO {

	private static ArrayList<Arbitro> listaArbitro = new ArrayList<>(); // Lista para o armazenamento dos Arbitros
																		// cadastrados PRECISA DO PUBLIC AQUI?
	private static List<String> nomesArbitros = new ArrayList<String>();

	public boolean checarNome(String nome) {
		if (nomesArbitros.isEmpty()) {
			return false;
		} else {
			if (nomesArbitros.contains(nome)) {
				return true;
			} else {
				return false;
			}
		}
	}

	// ------------------------------------------------------------------------
	public ArrayList<Arbitro> getLista1() {
		return listaArbitro;
	}

	public List<String> getLista2() {
		return nomesArbitros;
	}
	// ------------------------------------------------------------------------

	@Override
	public boolean inserir(Arbitro arbitro) {
		listaArbitro.add(arbitro);
		nomesArbitros.add(arbitro.getNome());
		System.out.println("Inserido com sucesso!");
		return true;
	}

	@Override
	public boolean editar(String nome1, String nome2) {
		for (Arbitro atual : listaArbitro) {
			if (atual.getNome().equals(nome1) == true) {
				atual.setNome(nome2);
				
				//tirando o nome antigo da segunda lista e adicionando o novo
				int index = nomesArbitros.indexOf(nome1);
				nomesArbitros.remove(index);
				nomesArbitros.add(nome2);
				
				System.out.println("Editado com sucesso!");
				return true;
			}
		}
		return false;
	}

	@Override
	public Arbitro excluir(String nomeArbitro) {

		/*
		 * O método excluir funciona de uma maneira parecida com o método editar, mas
		 * ele exclui o objeto da lista Árbitro ao encontrá-lo. E retorna o nome do
		 * Árbitro que foi excluído. Caso não encontre, retorna NULL.
		 */

		for (int i = 0; i < listaArbitro.size(); i++) {

			if (listaArbitro.get(i).getNome().equals(nomeArbitro) == true) {

				Arbitro objArbitro = listaArbitro.get(i); // puxa da lista o objeto que será excluído para o retorno
				listaArbitro.remove(i);
				
				/*removendo da lista de nomes (segunda lista)*/
				int index = nomesArbitros.indexOf(nomeArbitro);
				nomesArbitros.remove(index);
				
				System.out.println("Excluido com sucesso!");
				return objArbitro;
			}
		}

		return null;
	}

	@Override
	public void listar() {
		System.out.println("- Arbitros:");
		for (int i = 0; i < listaArbitro.size(); i++) {
			System.out.println("- " + listaArbitro.get(i).getNome()); // for para percorrer e listar o nome cada Arbitro
																		// da lista

		}

	}

}
