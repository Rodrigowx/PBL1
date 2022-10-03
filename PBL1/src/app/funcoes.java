package app;

import java.util.*;

public class funcoes {

	static Scanner read = new Scanner(System.in);

	public static Integer leituraInt() {
		
		/*Essa função tem o objetivo de realizar todas as leituras 
		 * de dados informados pelo usuário que são números inteiros.
		 * Ele ler o dado informado em String e depois converte para inteiro,
		 * caso o usuário digite algo sem ser um número, o try-catch trata esse erro*/
		
		String dadoLeitura;
		Integer dadoLeituraInt = null;
		boolean finish = true;

		while (finish) {
			try {
				dadoLeitura = read.nextLine();
				dadoLeituraInt = Integer.parseInt(dadoLeitura);
				
				//Caso não dê erro, agora verifica se a entrada é um numero positivo
				if (dadoLeituraInt < 0) {
					System.err.println("Apenas numeros positivos!");
				}else {
					finish = false;
				}
				
			} catch (NumberFormatException erro) {
				System.err.println("Digite apenas numeros!");
			}
		}
		
		return dadoLeituraInt;

	}
}
