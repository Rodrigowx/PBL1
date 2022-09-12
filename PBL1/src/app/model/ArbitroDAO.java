package app.model;

public interface ArbitroDAO {
	public boolean inserir(Arbitro arbitro);
	public boolean editar(Arbitro arbitro);
	public Arbitro excluir(String nomeArbitro);
	public void listar();
	
}
