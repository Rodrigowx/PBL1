package app.model;

public interface JogadorDAO {
	public boolean inserir(Jogador jogador);
	public boolean editar(Jogador jogador);
	public Arbitro excluir(String idJogador);
	public void listar();
}
