package app.model.oitavas;

import java.util.*;
import app.model.*;
import app.*;

public class Oitavas {
	
	private Map<String, ArrayList<Selecao>> selecoesOitavas = new HashMap<>();
	
	String grupo;
	Selecao selecao1, selecao2;
	ArrayList <Selecao> selecoesClassificadas = new ArrayList<>();
	int pontos1 = 0, pontos2 = 0, pontos3 = 0, pontos4 = 0;
	
	public void gerarOitavas(SelecaoDAOImpl SelecaoDAO) {
		for (Selecao selAtual : SelecaoDAO.getLista1()) {
			grupo = selAtual.getGrupo();
			switch(grupo){
				
			case "A":
				pontos1 = selAtual.getPontuacaoFaseG();
				break;
			case "B":
				break;
			case "C":
				break;
			case "D":
				break;
			case "E":
				break;
			case "F":
				break;
			case "G":
				break;
			case "H":
				break;
			}
			
		}
	
	
}
}
			