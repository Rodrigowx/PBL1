package app.model;

public interface SelecaoDAO {
	
	public boolean inserir(Selecao selecao);
	public boolean editar(String nomeSelecao, String novoNome);
	public Selecao excluir(String nomeSelecao);
	public void listar();
}
