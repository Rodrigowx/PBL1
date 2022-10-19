package app.model;

/**
 * Interface do DAO da Partida. Com as funções responsáveis pelo CRUD.
 */

public interface PartidaDAO {
	
	public boolean inserir(Partida partida);
	
	public boolean editar(String idPartida, int opcaoMenu);
	
	public Partida excluir(String idPartida);
	
	public void listar();
}
