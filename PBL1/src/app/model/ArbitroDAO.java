package app.model;

public interface ArbitroDAO {
	
	public boolean inserir(Arbitro arbitro);
	public boolean editar(String nome1, String nome2);
	public Arbitro excluir(String nomeArbitro);
	public void listar();
	
}
