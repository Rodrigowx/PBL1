package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;
import app.model.*;
import app.*;

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
	 * 
	 * @param nome
	 * @return boolean
	 */
	public static boolean verificaNomes(String nome) {

		// percorre cada caracter do nome e verifica se há algum número nele
		for (int i = 0; i < nome.length(); i++) {
			if (Character.isDigit(nome.charAt(i)) == true) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Essa função serve para verificar se o usuário pode ir para a fase de grupos
	 * (fase 1)
	 * 
	 * @param grupos
	 * @param selecoes
	 * @return
	 */
	public static boolean verificaçãoFase1(FaseGrupos grupos, SelecaoDAOImpl selecoes) {

		if (grupos.getMapGrupos().isEmpty()) {
			System.out.println("\nAinda nao eh possivel ir para a fase de Grupos, pois nao ha Selecoes cadastradas!");
			return true;
		} else if (selecoes.getLista1().size() < 2) { // MUDAR PARA 32 DEPOIS DOS TESTESSSSSSSSSSSSS
			System.out.println(
					"\nAinda nao eh possivel ir para a fase de Grupos, pois o numero de Selecoes cadastradas eh Insuficiente!");
			return true;
		} else if (selecoes.verificaTotal() == false) {
			System.out.println(
					"\nAinda nao eh possivel ir para a fase de Grupos, pois o numero de jogadores cadastrados eh Insuficiente!");
			return true;
		}

		return false;
	}

	/**
	 * Essa função serve para verificar os dados de entrada tipo String para as
	 * Datas
	 * 
	 * @param data
	 * @return boolean
	 */
	public static boolean verificaDatas(String data) {
		String dateFormat = "dd/MM/uuuu";

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat)
				.withResolverStyle(ResolverStyle.STRICT);

		try {
			LocalDate.parse(data, dateTimeFormatter);
			return false;
		} catch (DateTimeParseException e) {
			return true;
		}
	}

	/**
	 * Essa função serve para verificar os dados de entrada tipo String para
	 * horários
	 * 
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

	public static void exibirJogadores(String time, SelecaoDAOImpl SelecaoDAO) {
		for (Selecao selAtual : SelecaoDAO.getLista1()) {
			if (selAtual.getNome() == time) {
				System.out.println("Jogadores do " + selAtual.getNome() + ": \n");
				for (Jogador jogAtual : selAtual.getJogadores()) {
					System.out.println("- " + jogAtual.getNome() + " ID: " + jogAtual.getCodJog() + "\n");
				}
			}
		}
	}

	public static void inserirPartidaJog(Partida partidaAtual, SelecaoDAOImpl SelecaoDAO) {
		for (Selecao atual : SelecaoDAO.getLista1()) {
			if (partidaAtual.getTime1().equals(atual.getNome())) {
				for (Jogador jogAtual : atual.getJogadores()) {
					PartidaJogador jogPartida = new PartidaJogador(partidaAtual.getCodPart(), jogAtual.getCodJog());
					jogAtual.getPartidasJogador().add(jogPartida);
				}
			}
		}
		for (Selecao atual : SelecaoDAO.getLista1()) {
			if (partidaAtual.getTime2().equals(atual.getNome())) {
				for (Jogador jogAtual : atual.getJogadores()) {
					PartidaJogador jogPartida = new PartidaJogador(partidaAtual.getCodPart(), jogAtual.getCodJog());
					jogAtual.getPartidasJogador().add(jogPartida);
				}
			}
		}
	}

	public static Jogador checarID(String ID, String nomeSelecao, SelecaoDAOImpl SelecaoDAO) {
		for (Selecao selAtual : SelecaoDAO.getLista1()) {
			System.out.println(selAtual.getNome());
			if (nomeSelecao.equals(selAtual.getNome())) {
				for (Jogador jogAtual : selAtual.getJogadores()) {
					System.out.println(jogAtual.getNome());
					if (jogAtual.getCodJog().equals(ID)) {
						return jogAtual;
					} else {
						continue;
					}
				}
			}
		}
		return null;
	}

	public static void cadastrarGolsPartida(int golsTime, Partida partidaEscolhida, SelecaoDAOImpl SelecaoDAO,
			String time) {
		Jogador jogadorIdOK;
		int golsContabilizados = 0;
		int golGeral = 0;
		while (true) {
			if (golsContabilizados < golsTime) {
				while (true) {

					System.out.println("Informe o ID do jogador que marcou algum gol(restam "
							+ (golsTime - golsContabilizados) + " gol(s) para cadastrar): \n");
					String idAtual = read.nextLine();
					jogadorIdOK = checarID(idAtual, time, SelecaoDAO);
					if (jogadorIdOK.equals(null)) {
						System.out.println("ID nao encontrado!\n");
					} else {
						break;
					}
				}

				System.out.println("Quantos gols o jogador " + jogadorIdOK.getCodJog() + " fez:\n");
				int totalGolsJog = leituraInt();
				if (golsContabilizados > 0) {
					while (totalGolsJog > (golsTime - golsContabilizados)) {
						System.out.println("Quantidade maior que o(s) gol(s) informado(s)!");
						System.out.println("Digite novamente!");
						totalGolsJog = leituraInt();
					}
				}
				for (PartidaJogador atualPart : jogadorIdOK.getPartidasJogador()) {
					if (atualPart.getCodPartida().equals(partidaEscolhida.getCodPart())) {
						atualPart.inserirGols(totalGolsJog);
						golGeral = jogadorIdOK.getGols() + totalGolsJog;
						jogadorIdOK.setGols(golGeral);
						golsContabilizados += totalGolsJog;

					}
				}
			} else {
				break;
			}
		}
		System.out.println("Gols inseridos com sucesso");
	}

	public static void cadastrarCartaoVermelho(int cartoesDoTime, Partida partidaEscolhida, SelecaoDAOImpl SelecaoDAO,
			String time) {
		Jogador jogadorIdOk;
		int cartoesContabilizados = 0;
		int cartaoGeral = 0;
		while (true) {
			if (cartoesContabilizados < cartoesDoTime) {
				while (true) {

					System.out.println("Informe o ID do jogador que recebeu algum cartao Vermelho(restam "
							+ (cartoesDoTime - cartoesContabilizados) + " cartao(s) para cadastrar): \n");
					String idAtual = read.nextLine();
					jogadorIdOk = checarID(idAtual, time, SelecaoDAO);
					if (jogadorIdOk.equals(null)) {
						System.out.println("ID nao encontrado!\n");
					} else {
						break;
					}
				}

				System.out.println("Quantos cartoes vermelhos o jogador " + jogadorIdOk.getCodJog() + " recebeu:\n");
				int totalCartaoJog = leituraInt();
				if (cartoesContabilizados > 0) {
					while (totalCartaoJog > (cartoesDoTime - cartoesContabilizados)) {
						System.out.println("Quantidade maior de cartao(s) informado(s)!");
						System.out.println("Digite novamente!");
						totalCartaoJog = leituraInt();
					}
				}
				for (PartidaJogador atualPart : jogadorIdOk.getPartidasJogador()) {
					if (atualPart.getCodPartida().equals(partidaEscolhida.getCodPart())) {
						atualPart.inserirCartV(totalCartaoJog);
						cartaoGeral = jogadorIdOk.getCartVermelho() + totalCartaoJog;
						jogadorIdOk.setCartVermelho(cartaoGeral);
						cartoesContabilizados += totalCartaoJog;

					}
				}
			} else {
				break;
			}
		}
		System.out.println("Cartoes inseridos com sucesso!");
	}

	public static void cadastrarCartaoAmarelo(int cartoesDoTime, Partida partidaEscolhida, SelecaoDAOImpl SelecaoDAO,
			String time) {
		Jogador jogadorIdOk;
		int cartoesContabilizados = 0;
		int cartaoGeral = 0;
		while (true) {
			if (cartoesContabilizados < cartoesDoTime) {
				while (true) {

					System.out.println("Informe o ID do jogador que recebeu algum cartao Amarelo(restam "
							+ (cartoesDoTime - cartoesContabilizados) + " cartao(s) para cadastrar): \n");
					String idAtual = read.nextLine();
					jogadorIdOk = checarID(idAtual, time, SelecaoDAO);
					if (jogadorIdOk.equals(null)) {
						System.out.println("ID nao encontrado!\n");
					} else {
						break;
					}
				}

				System.out.println("Quantos cartoes amarelos o jogador " + jogadorIdOk.getCodJog() + " recebeu:\n");
				int totalCartaoJog = leituraInt();
				if (cartoesContabilizados > 0) {
					while (totalCartaoJog > (cartoesDoTime - cartoesContabilizados)) {
						System.out.println("Quantidade maior de cartao(s) informado(s)!");
						System.out.println("Digite novamente!");
						totalCartaoJog = leituraInt();
					}
				}
				for (PartidaJogador atualPart : jogadorIdOk.getPartidasJogador()) {
					if (atualPart.getCodPartida().equals(partidaEscolhida.getCodPart())) {
						atualPart.inserirCartA(totalCartaoJog);
						cartaoGeral = jogadorIdOk.getCartAmarelo() + totalCartaoJog;
						jogadorIdOk.setCartAmarelo(cartaoGeral);
						cartoesContabilizados += totalCartaoJog;

					}
				}
			} else {
				break;
			}
		}
		System.out.println("Cartoes inseridos com sucesso!");
	}

	public static void atualizarDadosJog(JogadorDAOImpl jogadorDao) {
			jogadorDao.getMap().forEach((id, jogador) -> {
				int geralGols = 0;
				int geralCartaoA = 0;
				int geralCartaoV = 0;
				for (PartidaJogador partAtual : jogador.getPartidasJogador()) {
					if (jogador.getPartidasJogador().isEmpty()) {
						System.out.println("Nao existe partida cadastrada, nao foi possivel atualizar dados");
						jogador.setGols(0);
						jogador.setCartAmarelo(0);
						jogador.setCartVermelho(0);
					} else {
						geralGols += partAtual.getGols();
						geralCartaoA += partAtual.getCartoesA();
						geralCartaoV += partAtual.getCartoesV();
					}
					jogador.setGols(geralGols);
					jogador.setCartAmarelo(geralCartaoA);
					jogador.setCartVermelho(geralCartaoV);
				}
			});
		}

}