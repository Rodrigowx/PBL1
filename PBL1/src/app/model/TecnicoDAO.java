package app.model;

public interface TecnicoDAO {
	public boolean inserir(Tecnico tecnico);
	public boolean editar(String nomeTecnico, String novoNome); //AQUI NÃO SERIA MELHOR O NOME DO TECNICO QUE QUER EDITAR AO INVES DO OBJETO e o novo nome (e o mesmo nos outros) ?
	public Tecnico excluir(String nomeTecnico);
	public void listar();
}
