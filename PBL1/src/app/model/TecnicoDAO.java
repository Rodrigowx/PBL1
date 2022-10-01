package app.model;

public interface TecnicoDAO {

	public boolean inserir(Tecnico tecnico);

	public boolean editar(String nomeTecnico, String novoNome);

	public Tecnico excluir(String nomeTecnico);

	public void listar();
}
