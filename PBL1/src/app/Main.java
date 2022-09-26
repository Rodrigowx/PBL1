package app;

import java.text.SimpleDateFormat;
import java.util.*;

import app.model.*;
import app.model.Jogador;
import app.model.Selecao;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

import java.text.SimpleDateFormat;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("app.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// launch(args);

		// PARA A LEITURA DAS VARIÁVEIS
		Scanner read = new Scanner(System.in);

		// PARA GERAR O CÓDIGO DO JOGADOR
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");

		System.out.println("----------Bem-vindo(a) ao SysCopa!-------------\n");

		boolean loopMenu = true; // Para o loop do menu, caso o usuário escolha SAIR, o valor muda para false e o
									// loop se encerra

		/* Aqui começa o loop a as opções dos menus */

		while (loopMenu) {

			System.out.println("ESCOLHA UMA DAS OPCOES: ");

			System.out.println("1 - INSERIR \n2 - EDITAR \n3 - EXCLUIR \n4 - LISTAR \n5 - SAIR"); // Menu principal

			// O TRATAMENTO DE ENTRADA COM O TRY É AQUI??
			int menu = read.nextInt(); // O programa ler a opção escolhida pelo usuario

			switch (menu) {
			case 1:
				System.out.println("QUAL DAS ENTIDADES DESEJA INSERIR: ");
				System.out.println(
						"1 - INSERIR SELECAO \n2 - INSERIR JOGADOR \n3 - INSERIR ARBITRO \n4 - INSERIR TECNICO");
				int insert = read.nextInt();

				// SWITCH-CASE PARA O MENU INTERNO DE INSERIR
				switch (insert) {
				case 1:
					System.out.println("\n -> Digite o nome da nova Selecao: ");
					String nomeS = read.nextLine();

					Selecao novaSelecao = new Selecao(nomeS); // cria o novo objeto

					// ADICIONANDO A SELECAO NOVA NA LISTA DE SEU DAO

				case 2:
					System.out.println("\n -> Digite o nome do Jogador: ");
					String nomeJ = read.nextLine();

					// POSIÇÕES PRÉ ESTABELEIDAS PARA O USUÁRIO ESCOLHER
					System.out.println("\n -> Escolha qual a posicao do Jogador: ");
					System.out.println("1 - Goleiro \n2 - Zagueiro \n3 - Meia \n4 - Atacante");
					int escolhaPos = read.nextInt();
					String posicao = null;

					switch (escolhaPos) {
					case 1:
						posicao = "Goleiro";
						break;
					case 2:
						posicao = "Zagueiro";
						break;
					case 3:
						posicao = "Meia";
						break;
					case 4:
						posicao = "Atacante";
						break;
					default:
						System.out.println("Escolha uma posicao valida!");
					}

					System.out.println("\n -> Digite quantos cartões-amarelo o jogador possui: ");
					Integer cartA = read.nextInt();
					System.out.println("\n -> Digite quantos cartões-vermelho o jogador possui: ");
					Integer cartV = read.nextInt();
					System.out.println("\n -> Digite quantos gols o jogador ja fez: ");
					Integer gols = read.nextInt();

					// CRIANDO O JOGADOR
					Jogador novoJog = new Jogador(sdf.format(data), nomeJ, posicao, cartA, cartV, gols);

					// ADICIONANDO O JOGADOR NOVO NA LISTA DE SEU DAO

				case 3:
					System.out.println("\n -> Digite o nome do novo Arbitro: ");
					String nomeAr = read.nextLine();

					Arbitro novoArbitro = new Arbitro(nomeAr);

				case 4:
					System.out.println("\n -> Digite o nome do novo Tecnico: ");
					String nomeTec = read.nextLine();

					System.out.println("\n -> Digite a qual Selecao pertence o novo Tecnico: ");
					String selecaoTec = read.nextLine();

					Tecnico novoTecnico = new Tecnico(nomeTec);

					if (SelecaoDAOImpl.checarNome(selecaoTec)) {
						// verificar se tem na lista e colocar no objeto
					}

					// ADICIONAR O TECNICO NA LISTA DO DAO E NA SELEÇAO QUE ELE PERTENCE

				}
				// -----------------------------------------------------------------------------------------------------------------------
			case 2:
				System.out.println("QUAL DAS ENTIDADES DESEJA EDITAR: ");
				System.out.println("1 - EDITAR SELECAO \n2 - EDITAR JOGADOR \n3 - EDITAR ARBITRO \n4 - EDITAR TECNICO");
				int edit = read.nextInt();

				// SWITCH-CASE PARA O MENU INTERNO DE EDITAR
				switch (edit) {
				case 1:
					System.out.println("\n -> Digite o nome da Selecao que deseja editar: ");
					String nomeSelecao = read.nextLine();

					// CHAMAR A FUNÇÃO DO DAOIMPL DE SELECAO E VERIFICAR SE HÁ ESSE NOME NA LISTA,
					// DEPOIS CHAMAR A FUNÇÃO EDITAR DO DAO
					boolean verificar = SelecaoDAOImpl.checarNome(nomeSelecao);

					if (verificar) {
						System.out.println("\n -> Digite o novo nome da Selecao: ");
						String novoNomeS = read.nextLine();

						// editar aqui
					}

				case 2:

				case 3:

				case 4:

				}

				// -----------------------------------------------------------------------------------------------------------------------
			case 3:
				System.out.println("EM QUAL DAS ENTIDADES DESEJA FAZER UMA EXCLUSÃO: ");
				System.out.println(
						"1 - EXCLUIR UMA SELECAO \n2 - EXCLUIR UM JOGADOR \n3 - EXCLUIR ARBITRO \n4 - EXCLUIR TECNICO");
				int remove = read.nextInt();

				// -----------------------------------------------------------------------------------------------------------------------
			case 4:
				System.out.println("QUAL DAS ENTIDADES DESEJA LISTAR: ");
				System.out.println(
						"1 - LISTAR SELECOES \n2 - LISTAR JOGADORES \n3 - LISTAR ARBITROS \n4 - LISTAR TECNICOS");
				int list = read.nextInt();

				// -----------------------------------------------------------------------------------------------------------------------
			case 5:
				System.out.println("Encerrando programa...");
				loopMenu = false;
				break;

			default:
				System.out.println("Digite um numero valido!");
			}
		}
	}
}
