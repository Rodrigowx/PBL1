package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;
import app.model.*;

/**
 * Classe responsável pelas demais funções.
 */

public class Funcoes {

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
	
	/**
	 * Função que verifica se os nomes informados pelo usuário possuem números
	 * @param nome
	 * @return boolean
	 */
	public static boolean verificaNomes(String nome) {
		
		//percorre cada caracter do nome e verifica se há algum número nele
		for (int i = 0; i < nome.length(); i++) {
	          if (Character.isDigit(nome.charAt(i))==true){
	              return false;
	          }
	    }
		return true;
	}
	
	/**
	 * Essa função serve para verificar se o usuário pode ir para a fase de grupos (fase 1)
	 * @param grupos
	 * @param selecoes
	 * @return
	 */
	public static boolean verificaçãoFase1(FaseGrupos grupos, SelecaoDAOImpl selecoes) {
		
		if (grupos.getMapGrupos().isEmpty()) {
			System.out.println("\nAinda nao eh possivel ir para a fase de Grupos, pois nao ha Selecoes cadastradas!");
			return true;
		}else if (selecoes.getLista1().size() < 2) { //MUDAR PARA 32 DEPOIS DOS TESTESSSSSSSSSSSSS
			System.out.println("\nAinda nao eh possivel ir para a fase de Grupos, pois o numero de Selecoes cadastradas eh Insuficiente!");
			return true;
		}else if (selecoes.verificaTotal() == false) {
			System.out.println("\nAinda nao eh possivel ir para a fase de Grupos, pois o numero de jogadores cadastrados eh Insuficiente!");
			return true;
		}
		
		return false;
	}
	
	/**
	 * Essa função serve para verificar os dados de entrada tipo String para as Datas
	 * @param data
	 * @return boolean
	 */	
	public static boolean verificaDatas(String data) {
	    String dateFormat = "dd/MM/uuuu";

	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat).withResolverStyle(ResolverStyle.STRICT);
	    
	    try {
	        LocalDate.parse(data, dateTimeFormatter);
	        return false;
	    } catch (DateTimeParseException e) {
	       return true;
	    } 
	}
	
	/**
	 * Essa função serve para verificar os dados de entrada tipo String para horários
	 * @param hora
	 * @return boolean
	 */	
	public static boolean verificaHorario(String hora) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
		dateFormat.setLenient(false);
	    
	    try {
	        dateFormat.parse(hora);
	        return false;
	    } catch (ParseException e) {
	       return true;
	    } 
	}
}
