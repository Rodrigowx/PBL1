package app.model;

public interface JogadorDAO {

	public boolean inserir(Jogador jogador);

	public boolean editar(String idJogador, int opcaoMenu);

	public Jogador excluir(String idJogador);

	public void listar();
}
