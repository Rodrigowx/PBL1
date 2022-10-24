package app.model;

public class PartidaJogador {
	
	private String codPartida;
	private String codJogador;
	private int gols;
	private int cartoesA;
	private int cartoesV;
	
	public PartidaJogador(String codPartida, String codJogador, int gols, int cartoesA, int cartoesV) {
		super();
		this.codPartida = codPartida;
		this.codJogador = codJogador;
		this.gols = gols;
		this.cartoesA = cartoesA;
		this.cartoesV = cartoesV;
	}
	
	public String getCodPartida() {
		return codPartida;
	}
	public void setCodPartida(String codPartida) {
		this.codPartida = codPartida;
	}
	public String getCodJogador() {
		return codJogador;
	}
	public void setCodJogador(String codJogador) {
		this.codJogador = codJogador;
	}
	public int getGols() {
		return gols;
	}
	public void setGols(int gols) {
		this.gols = gols;
	}

	public int getCartoesA() {
		return cartoesA;
	}

	public void setCartoesA(int cartoesA) {
		this.cartoesA = cartoesA;
	}

	public int getCartoesV() {
		return cartoesV;
	}

	public void setCartoesV(int cartoesV) {
		this.cartoesV = cartoesV;
	}
	
}
