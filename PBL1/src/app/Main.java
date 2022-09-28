package app;

import java.text.SimpleDateFormat;
import java.util.*;

import app.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

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
		
		//INSTANCIANDO CADA DAO DAS CLASSES
		ArbitroDAOImpl ArbitroDAO = new ArbitroDAOImpl();
		JogadorDAOImpl JogadorDAO = new JogadorDAOImpl();
		SelecaoDAOImpl SelecaoDAO = new SelecaoDAOImpl();
		TecnicoDAOImpl TecnicoDAO = new TecnicoDAOImpl();

		System.out.println("----------Bem-vindo(a) ao SysCopa!-------------\n");

		boolean loopMenu = true; // Para o loop do menu, caso o usuário escolha SAIR, o valor muda para false e o loop se encerra

		/* Aqui começa o loop a as opções dos menus */

		while (loopMenu) {

			System.out.println("\nESCOLHA UMA DAS OPCOES: ");

			System.out.println("1 - INSERIR \n2 - EDITAR \n3 - EXCLUIR \n4 - LISTAR \n5 - SAIR"); // Menu principal

			// O TRATAMENTO DE ENTRADA COM O TRY É AQUI??
			int menu = read.nextInt(); // O programa ler a opção escolhida pelo usuario

			switch (menu) {
			case 1:
				System.out.println("\nQUAL DAS ENTIDADES DESEJA INSERIR: ");
				System.out.println("1 - INSERIR SELECAO \n2 - INSERIR JOGADOR \n3 - INSERIR ARBITRO \n4 - INSERIR TECNICO");
				int insert = read.nextInt();

				// SWITCH-CASE PARA O MENU INTERNO DE INSERIR
				switch (insert) {
				case 1://---------------------------------------------------------------------------------
					System.out.println("\n -> Digite o nome da nova Selecao: ");
					String nomeS = read.next();
					
					//VERIFICAÇÃO SE O ESSA SELEÇAO JÁ FOI INSERIDA ANTES
					while (SelecaoDAO.checarNome(nomeS)) {//***caso dê erro
						System.out.println("\nSelecao já cadastrada! Digite o nome da nova Selecao: ");
						nomeS = read.next();
					}
					
					//CRIANDO O OBJETO SELEÇÃO
					List<Jogador> listaJogadores = new ArrayList<>(); //lista de jogadores para o atributo de Seleção
					Selecao novaSelecao = new Selecao(nomeS, listaJogadores); // cria o novo objeto
					

					// ADICIONANDO A SELECAO NOVA NA LISTA DE SEU DAO
					SelecaoDAO.inserir(novaSelecao);
					break;

				case 2://---------------------------------------------------------------------------------
					
					//AVISO CASO O USUÁRIO QUEIRA CADASTRAR UM JOGADOR E NAO HÁ SELEÇÕES
					if (SelecaoDAO.getLista1().isEmpty()) {
						System.out.println("\n-- Você não pode cadastrar um jogador agora pois ainda não há Seleções cadastradas! --");
						break;
					}
						
					System.out.println("\n -> Digite o nome do Jogador: ");
					String nomeJ = read.next();

					// POSIÇÕES PRÉ ESTABELEIDAS PARA O USUÁRIO ESCOLHER
					System.out.println("\n -> Escolha qual a posicao do Jogador: ");
					System.out.println("1 - Goleiro \n2 - Zagueiro \n3 - Meia \n4 - Atacante");
					int escolhaPos = read.nextInt();
					String posicao = null;

					while (posicao == null) {
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
							escolhaPos = read.nextInt();
						}
					}
					

					//***verificar com try os erros
					System.out.println("\n -> Digite quantos cartões-amarelo o jogador possui: ");
					Integer cartA = read.nextInt();
					System.out.println("\n -> Digite quantos cartões-vermelho o jogador possui: ");
					Integer cartV = read.nextInt();
					System.out.println("\n -> Digite quantos gols o jogador ja fez: ");
					Integer gols = read.nextInt();
					
					//ADICIONANDO JOGADOR EM UMA SELEÇÃO
					System.out.println("\n -> Digite qual dessas é a Selecao do Jogador: ");
					for (String selecao : SelecaoDAO.getLista2()) {
						System.out.println("-" + selecao);
					}
					String escolhaSel = read.next();
					
					Selecao selecaoJog = SelecaoDAO.verificaSelecao(escolhaSel);
					
					while (selecaoJog == null) {
						System.out.println("\nSeleção não cadastrada! Digite novamente: ");
						escolhaSel = read.next();
						selecaoJog = SelecaoDAO.verificaSelecao(escolhaSel);
					}
					
					// CRIANDO O JOGADOR
					Jogador novoJog = new Jogador(sdf.format(data), nomeJ, posicao, cartA, cartV, gols);

					// ADICIONANDO O JOGADOR NOVO NA LISTA DE SEU DAO E DA SUA SELEÇAO
					JogadorDAO.inserir(novoJog);
					selecaoJog.setJogadores(novoJog);
					break;

				case 3://---------------------------------------------------------------------------------
					System.out.println("\n -> Digite o nome do novo Arbitro: ");
					String nomeAr = read.nextLine();
					
					while (true) {  
						if (TecnicoDAO.checarNome(nomeAr)) {//verifica se já possui um Árbitro com esse nome
							System.out.println("\nÁrbitro já cadastrado! Digite o nome novamente: ");
							nomeAr = read.next();
						}else {
							break;
						}
					}

					// CRIANDO O ÁRBITRO
					Arbitro novoArbitro = new Arbitro(nomeAr);
					
					//ADICIONANDO O ARBITRO NA LISTA DO DAO
					ArbitroDAO.getLista1().add(novoArbitro);
					break;

				case 4://---------------------------------------------------------------------------------
					
					//AVISO CASO O USUÁRIO QUEIRA CADASTRAR UM TÉCNICO E NAO HÁ SELEÇÕES
					if (SelecaoDAO.getLista1().isEmpty()) {
						System.out.println("\n-- Você não pode cadastrar um técnico agora pois ainda não há Seleções cadastradas! --");
						break;
					}
					
					System.out.println("\n -> Digite o nome do novo Tecnico: ");
					String nomeTec = read.next();
					
					while (true) {  
						if (TecnicoDAO.checarNome(nomeTec)) {//verifica se já possui um tecnico com esse nome
							System.out.println("\nTécnico já cadastrado! Digite o nome novamente: ");
							nomeTec = read.next();
						}else {
							break;
						}
					}
					

					System.out.println("\n -> Digite a qual Selecao pertence o novo Tecnico: ");
					String selecaoTec = read.next();
					
					Selecao selecaoAtual = SelecaoDAOImpl.verificaTecnico(selecaoTec);//função que verifica se a seleção já tem Técnico

					while (true) {
						
						if (SelecaoDAO.verificaSelecao(selecaoTec) != null) { //verifica se o nome está na lista de Seleções
							
							if (selecaoAtual == null) { //verifica se essa seleção já tem tecnico
								System.out.println("NEssa Selecao ja possui um tecnico! Digite o nome de outra Selecao: ");
								selecaoTec = read.next();
								
							}else { //se não, sai do loop, cria o objeto Técnico e adiciona esse Técnico em sua Seleção
								break;
							}
							
						}else { //se não estiver pergunta novamente
							System.out.println("\nSeleção não cadastrada! Digite novamente: ");
							selecaoTec = read.next();
						}
					}
					
					// CRIANDO O TÉCNICO
					Tecnico novoTecnico = new Tecnico(nomeTec);
					selecaoAtual.setTecnico(novoTecnico);

					// ADICIONAR O TECNICO NA LISTA DO DAO
					TecnicoDAO.getLista1().add(novoTecnico);
					break;
					
				default:
					System.out.println("\nOpcao Invalida!"); //Tratamento de entrada para o switch-case de Inserir
				}
				break;
					
			// -----------------------------------------------------------------------------------------------------------------------
			case 2:
				System.out.println("\nQUAL DAS ENTIDADES DESEJA EDITAR: ");
				System.out.println("1 - EDITAR SELECAO \n2 - EDITAR JOGADOR \n3 - EDITAR ARBITRO \n4 - EDITAR TECNICO");
				int edit = read.nextInt();

				// SWITCH-CASE PARA O MENU INTERNO DE EDITAR
				switch (edit) {
				case 1:
					System.out.println("\n -> Digite o nome da Selecao que deseja editar: ");
					String nomeSelecao = read.nextLine();

					// CHAMAR A FUNÇÃO DO DAOIMPL DE SELECAO E VERIFICAR SE HÁ ESSE NOME NA LISTA,
					// DEPOIS CHAMAR A FUNÇÃO EDITAR DO DAO
					boolean verificar = SelecaoDAO.checarNome(nomeSelecao);

					if (verificar) {
						System.out.println("\n -> Digite o novo nome da Selecao: ");
						String novoNomeS = read.nextLine();

						// editar aqui
					}
					break;

				case 2:
					break;

				case 3:
					break;

				case 4:
					break;

				}
				break;

				// -----------------------------------------------------------------------------------------------------------------------
			case 3:
				System.out.println("\nEM QUAL DAS ENTIDADES DESEJA FAZER UMA EXCLUSÃO: ");
				System.out.println(
						"1 - EXCLUIR UMA SELECAO \n2 - EXCLUIR UM JOGADOR \n3 - EXCLUIR ARBITRO \n4 - EXCLUIR TECNICO");
				int remove = read.nextInt();
				break;

				// -----------------------------------------------------------------------------------------------------------------------
			case 4:
				System.out.println("\nQUAL DAS ENTIDADES DESEJA LISTAR: ");
				System.out.println(
						"1 - LISTAR SELECOES \n2 - LISTAR JOGADORES \n3 - LISTAR ARBITROS \n4 - LISTAR TECNICOS");
				int list = read.nextInt();
				break;

				// -----------------------------------------------------------------------------------------------------------------------
			case 5:
				System.out.println("\nEncerrando programa...");
				loopMenu = false;
				break;

			default:
				System.out.println("\nDigite um numero valido!");
			}
		}
	}
}
