package app.model;

public interface TecnicoDAO {
	public boolean inserir(Tecnico tecnico);
	public boolean editar(Tecnico tecnico); //AQUI NÃO SERIA MELHOR O NOME DO TECNICO QUE QUER EDITAR AO INVES DO OBJETO (e o mesmo nos outros) ?
	public Arbitro excluir(String nomeTecnico);
	public void listar();
}
