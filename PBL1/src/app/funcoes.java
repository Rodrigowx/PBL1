package app;

import java.util.*;
import app.model.*;

/**
 * Classe responsável pelas demais funções.
 */

public class funcoes {

	static Scanner read = new Scanner(System.in);

	/**
	 * Essa função tem o objetivo de realizar todas as leituras de dados informados
	 * pelo usuário que são números inteiros. Ele ler o dado informado em String e
	 * depois converte para inteiro, caso o usuário digite algo sem ser um número, o
	 * try-catch trata esse erro
	 */

	public static Integer leituraInt() {

		String dadoLeitura;
		Integer dadoLeituraInt = null;
		boolean finish = true;

		while (finish) {
			try {
				dadoLeitura = read.nextLine();
				dadoLeituraInt = Integer.parseInt(dadoLeitura);

				// Caso não dê erro, agora verifica se a entrada é um numero positivo
				if (dadoLeituraInt < 0) {
					System.err.println("Apenas numeros positivos!");
				} else {
					finish = false;
				}

			} catch (NumberFormatException erro) {
				System.err.println("Digite apenas numeros!");
			}
		}

		return dadoLeituraInt;

	}
	
	//essa função serve para verificar se o usuário pode realizar a fase de 
	public static boolean verificaçãoFase1(FaseGrupos grupos, ArrayList<Selecao> listaSel) {
		
		if (grupos.getMapGrupos().isEmpty()) {
			System.out.println("\nAinda nao eh possivel ir para a fase de Grupos, pois nao ha Selecoes cadastradas!");
			return true;
		}else if (listaSel.size() < 32) {
			System.out.println("\nAinda nao eh possivel ir para a fase de Grupos, pois o numero de Selecoes cadastradas eh Insuficiente!");
			return true;
		}//PRECISA VERIFICAR SE A SELEÇÃO TEM 16 JOGADORES ANTES??
		
		return false;
	}
	
}
