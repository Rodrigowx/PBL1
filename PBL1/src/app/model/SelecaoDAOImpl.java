package app.model;

import java.util.*;

public class SelecaoDAOImpl implements SelecaoDAO {

	private static ArrayList<Selecao> listaSelecoes = new ArrayList<>();
	private static List<String> nomesSelecao = new ArrayList<String>();

	// ------------------------------------------------------------------------
	public boolean checarNome(String nome) {
		if (nomesSelecao.isEmpty()) {
			return false;
		} else {
			if (nomesSelecao.contains(nome)) {
				return true;
			} else {
				return false;
			}
		}
	}

	// ------------------------------------------------------------------------
	public Selecao verificaTecnico(String nomeSelecao) {

		/* comentar aqui */

		for (Selecao atual : listaSelecoes) {
			if (atual.getNome().equals(nomeSelecao)) {
				if (atual.getTecnico() == null) {
					return atual;
				}
			}
		}
		return null;
	}
	// ------------------------------------------------------------------------

	public Selecao verificaSelecao(String nomeSelecao) {

		/*
		 * escrever aqui pra que serve isso: verificar se a seleção informada pelo
		 * usuário existe na lista e retorná-la pra adicionar o jogador e o tecnico no
		 * objeto seleçao deles
		 */

		if (nomesSelecao.contains(nomeSelecao)) {

			for (Selecao selecao : listaSelecoes) {

				if (selecao.getNome().equals(nomeSelecao)) {// buscando a seleção na lista
					return selecao;
				}
			}

		} else {
			return null;
		}
		return null;
	}

	// ------------------------------------------------------------------------
	public ArrayList<Selecao> getLista1() {
		return listaSelecoes;
	}

	public List<String> getLista2() {
		return nomesSelecao;
	}
	// ------------------------------------------------------------------------

	@Override
	public boolean inserir(Selecao selecao) {

		listaSelecoes.add(selecao); // **
		nomesSelecao.add(selecao.getNome());
		System.out.println("Inserido com sucesso!");
		return true;
	}

	@Override
	public boolean editar(String nomeSelecao, String novoNome) {

		for (int i = 0; i < listaSelecoes.size(); i++) {

			if (listaSelecoes.get(i).getNome().equals(nomeSelecao)) {
				
				listaSelecoes.get(i).setNome(novoNome);//mudando o nome no objeto 
				
				//tirando o nome antigo da segunda lista e adicionando o novo
				int index = nomesSelecao.indexOf(nomeSelecao);
				nomesSelecao.remove(index);
				nomesSelecao.add(novoNome);
				
				System.out.println("Editado com sucesso!");
				return true;
			}
		}
		return false;
	}

	@Override
	public Selecao excluir(String nomeSelecao) {

		/* explicar aqui o que faz */
		int indx2 = nomesSelecao.indexOf(nomeSelecao);
		nomesSelecao.remove(indx2);

		for (Selecao atual : listaSelecoes) {
			if (atual.getNome().equals(nomeSelecao) == true) {
				Selecao a = atual;
				listaSelecoes.remove(atual);
				return a;
			} else {
				return null;
			}

		}
		return null;
	}

	@Override
	public void listar() {
		System.out.println("- Selecoes:");
		for (int i = 0; i < listaSelecoes.size(); i++) {
			System.out.println("- " + listaSelecoes.get(i).getNome());
		}
	}

	public void attTecnico(Tecnico tec) {

		for (Selecao x : listaSelecoes) {
			if (x.getNome().equals(tec.getSelecao().getNome()) == true) {
				int indx = listaSelecoes.indexOf(x);
				listaSelecoes.get(indx).setTecnico(null);
			}
		}
	}
}