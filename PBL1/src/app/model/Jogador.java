package app.model;

/**
 * Classe que representa o Jogador no sistema. Jogador possiu ID do jogador,
 * nome, posição, cartão amarelo e vermelho, gols e selecao que ele faz parte
 * como parametro. Get e o set do de todos atributos.
 */

public class Jogador {

	// ATRIBUTOS
	private String codJog;
	private String nome;
	private String posicao;
	private Integer cartAmarelo;
	private Integer cartVermelho;
	private Integer gols;
	private Selecao selecao;

	// CONSTRUTOR
	public Jogador(String codJog, String nome, String posicao, Integer cartAmarelo, Integer cartVermelho, Integer gols,
			Selecao selecao) {
		super();
		this.codJog = codJog;
		this.nome = nome;
		this.posicao = posicao;
		this.cartAmarelo = cartAmarelo;
		this.cartVermelho = cartVermelho;
		this.gols = gols;
		this.selecao = selecao;
	}

	// MÉTODOS

	public String toString() {
		return codJog;
	}

	public String getCodJog() {
		return codJog;
	}

	public void setCodJog(String codJog) {
		this.codJog = codJog;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Integer getCartAmarelo() {
		return cartAmarelo;
	}

	public void setCartAmarelo(Integer cartAmarelo) {
		this.cartAmarelo = cartAmarelo;
	}

	public Integer getCartVermelho() {
		return cartVermelho;
	}

	public void setCartVermelho(Integer cartVermelho) {
		this.cartVermelho = cartVermelho;
	}

	public Integer getGols() {
		return gols;
	}

	public void setGols(Integer gols) {
		this.gols = gols;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

}
