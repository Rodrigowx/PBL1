/**
Autores: Rodrigo de Matos Ferreira e Nathille Cerqueira Alves
Componente Curricular: MI Algoritmos II
Concluido em: 03/10/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
**/

package app;

import java.text.SimpleDateFormat;
import java.util.*;
import app.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * Classe MAIN, responsável por toda logística de execução do sistema. E também,
 * Instanciamento dos objetos.
 * 
 */

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

		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");

		// INSTANCIANDO CADA DAO DAS CLASSES
		ArbitroDAOImpl ArbitroDAO = new ArbitroDAOImpl();
		JogadorDAOImpl JogadorDAO = new JogadorDAOImpl();
		SelecaoDAOImpl SelecaoDAO = new SelecaoDAOImpl();
		TecnicoDAOImpl TecnicoDAO = new TecnicoDAOImpl();
		
		FaseGrupos GruposCRUD = new FaseGrupos();
		PartidaGerenciar PartGerenciar = new PartidaGerenciar();
		

		System.out.println("----------Bem-vindo(a) ao SysCopa!-------------\n");

		boolean loopMenu = true; // Para o loop do menu, caso o usuário escolha SAIR, o valor muda para false e o
									// loop se encerra

		/* Aqui começa o loop a as opções dos menus */

		while (loopMenu) {

			System.out.println("\nESCOLHA UMA DAS OPCOES: ");

			System.out.println("1 - INSERIR \n2 - EDITAR \n3 - EXCLUIR \n4 - LISTAR \n5 - IR PARA FASE DE GRUPOS \n6 - SAIR"); // Menu principal

			// O programa ler a opção escolhida pelo usuario
			Integer menu = Funcoes.leituraInt();

			switch (menu) {

			// INSERIR
			case 1:
				System.out.println("\nQUAL DAS ENTIDADES DESEJA INSERIR: ");
				System.out.println(
						"1 - INSERIR SELECAO \n2 - INSERIR JOGADOR \n3 - INSERIR ARBITRO \n4 - INSERIR TECNICO\n5 - RETORNAR AO MENU PRINCIPAL");

				Integer insert = Funcoes.leituraInt();

				// SWITCH-CASE PARA O MENU INTERNO DE INSERIR
				switch (insert) {
				// INSERIR SELECAO
				case 1:// ---------------------------------------------------------------------------------
					System.out.println("\n -> Digite o nome da nova Selecao: ");
					String nomeS = read.nextLine();

					// VERIFICAÇÃO SE O ESSA SELEÇAO JÁ FOI INSERIDA ANTES
					while (SelecaoDAO.checarNome(nomeS)) {// ***caso dê erro
						System.err.println("\nSelecao ja cadastrada! Digite o nome da nova Selecao: ");
						nomeS = read.nextLine();
						;
					}

					// CRIANDO O OBJETO SELEÇÃO
					List<Jogador> listaJogadores = new ArrayList<>(); // lista de jogadores para o atributo de Seleção
					
					//perguntando ao usuário a qual Grupo a Seleção pertence
					System.out.println("\n -> Escolha qual desses Grupos a Selecao pertence: ");	
					System.out.println("1 - Grupo A \n2 - Grupo B \n3 - Grupo C \n4 - Grupo D \n5 - Grupo E \n6 - Grupo F \n7 - Grupo G \n8 - Grupo H");

					Integer escolhaGrup = Funcoes.leituraInt();
					String grupo = null;

					while (grupo == null) {
						switch (escolhaGrup) {
						case 1:
							grupo = "A";
							break;
						case 2:
							grupo = "B";
							break;
						case 3:
							grupo = "C";
							break;
						case 4:
							grupo = "D";
							break;
						case 5:
							grupo = "E";
							break;
						case 6:
							grupo = "F";
							break;
						case 7:
							grupo = "G";
							break;
						case 8:
							grupo = "H";
							break;
						default:
							System.err.println("Escolha um Grupo valido!");
							escolhaGrup = Funcoes.leituraInt();
						}
					}
					
					//chama a função que verifica se esse grupo já está cheio, ou seja, com 4 Seleções
					if (GruposCRUD.verificaGrupos(grupo)) {
						System.err.println("Esse Grupo ja esta completo! Nao foi possivel cadastrar a Selecao.");
						break;
					}
					
					Selecao novaSelecao = new Selecao(nomeS, listaJogadores, grupo); // cria o novo objeto

					// ADICIONANDO A SELECAO NOVA NA LISTA DE SEU DAO E NO MAP DOS GRUPOS
					SelecaoDAO.inserir(novaSelecao);
					GruposCRUD.atualizaGrupos(grupo, novaSelecao);
					break;

				// INSERIR JOGADOR
				case 2:// ---------------------------------------------------------------------------------
						// AVISO CASO O USUÁRIO QUEIRA CADASTRAR UM JOGADOR E NAO HÁ SELEÇÕES
					if (SelecaoDAO.getLista1().isEmpty()) {
						System.out.println(
								"\n-- Voce nao pode cadastrar um jogador agora pois ainda nao ha Selecoes cadastradas! --");
						break;
					}

					System.out.println("\n -> Digite o nome do Jogador: ");
					String nomeJ = read.nextLine();

					// POSIÇÕES PRÉ ESTABELEIDAS PARA O USUÁRIO ESCOLHER
					System.out.println("\n -> Escolha qual a posicao do Jogador: ");
					System.out.println("1 - Goleiro \n2 - Zagueiro \n3 - Meia \n4 - Atacante");

					Integer escolhaPos = Funcoes.leituraInt();
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
							System.err.println("Escolha uma posicao valida!");

							escolhaPos = Funcoes.leituraInt();
						}
					}

					System.out.println("\n -> Digite quantos cartoes-amarelo o jogador possui: ");
					Integer cartA = Funcoes.leituraInt();
					System.out.println("\n -> Digite quantos cartoes-vermelho o jogador possui: ");
					Integer cartV = Funcoes.leituraInt();
					System.out.println("\n -> Digite quantos gols o jogador ja fez: ");
					Integer gols = Funcoes.leituraInt();

					// ADICIONANDO JOGADOR EM UMA SELEÇÃO
					System.out.println("\n -> Digite qual dessas eh a Selecao do Jogador: ");
					for (String selecao : SelecaoDAO.getLista2()) {
						System.out.println("-" + selecao);
					}
					String escolhaSel = read.nextLine();

					Selecao selecaoJog = SelecaoDAO.verificaSelecao(escolhaSel);

					while (selecaoJog == null) {
						System.err.println("\nSelecao nao cadastrada! Digite novamente: ");
						escolhaSel = read.nextLine();
						selecaoJog = SelecaoDAO.verificaSelecao(escolhaSel);
					}
					
					//Verifica se essa seleção já possui o número máximo de jogadores (11)***MUDAR AQUI
					if (selecaoJog.getJogadores().size() == 2) {
						System.err.println("Essa Selecao ja alcancou seu limite de jogadores! Nao foi possivel cadastrar o Jogador.");
						break;
					}

					// CRIANDO O JOGADOR
					Date data = new Date();
					Jogador novoJog = new Jogador(sdf.format(data), nomeJ, posicao, cartA, cartV, gols, selecaoJog);

					// ADICIONANDO O JOGADOR NOVO NA LISTA DE SEU DAO E DA SUA SELEÇAO
					JogadorDAO.inserir(novoJog);
					selecaoJog.setJogadores(novoJog);
					System.out.println("Jogador cadastrado!\nNUMERO DO ID: " + novoJog.getCodJog());
					break;

				// INSERIR ARBITRO
				case 3:// ---------------------------------------------------------------------------------
					System.out.println("\n -> Digite o nome do novo Arbitro: ");
					String nomeAr = read.nextLine();

					while (true) {
						if (TecnicoDAO.checarNome(nomeAr)) {// verifica se já possui um Árbitro com esse nome
							System.err.println("\nArbitro ja cadastrado! Digite o nome novamente: ");
							nomeAr = read.nextLine();
						} else {
							break;
						}
					}

					// CRIANDO O ÁRBITRO
					Arbitro novoArbitro = new Arbitro(nomeAr);

					// ADICIONANDO O ARBITRO NA LISTA DO DAO
					ArbitroDAO.inserir(novoArbitro);
					break;

				// INSERIR TECNICO
				case 4:// ---------------------------------------------------------------------------------

					// AVISO CASO O USUÁRIO QUEIRA CADASTRAR UM TÉCNICO E NAO HÁ SELEÇÕES
					if (SelecaoDAO.getLista1().isEmpty()) {
						System.out.println(
								"\n-- Voce nao pode cadastrar um tecnico agora pois ainda nao ha Selecoes cadastradas! --");
						break;
					}

					System.out.println("\n -> Digite o nome do novo Tecnico: ");
					String nomeTec = read.nextLine();

					while (true) {
						if (TecnicoDAO.checarNome(nomeTec)) {// verifica se já possui um tecnico com esse nome
							System.err.println("\nTecnico já cadastrado! Digite o nome novamente: ");
							nomeTec = read.nextLine();
						} else {
							break;
						}
					}

					System.out.println("\n -> Digite a qual Selecao pertence o novo Tecnico: ");
					for (String selecao : SelecaoDAO.getLista2()) {
						System.out.println("-" + selecao);
					}
					String selecaoTec = read.nextLine();
					Selecao selecaoAtual;

					while (true) {

						selecaoAtual = SelecaoDAO.verificaTecnico(selecaoTec);// função que verifica se a seleção já tem
																				// Técnico

						if (selecaoAtual != null) { // verifica se o nome está na lista de
													// Seleções

							if (selecaoAtual.getTecnico() != null) { // verifica se essa seleção já tem tecnico
								System.err.println(
										"Nessa Selecao ja possui um tecnico! Digite o nome de outra Selecao: ");
								selecaoTec = read.nextLine();

							} else { // se não, sai do loop, cria o objeto Técnico e adiciona esse Técnico em sua
										// Seleção
								break;
							}

						} else { // se não estiver pergunta novamente
							System.err.println("\nSeleçao nao cadastrada! Digite novamente: ");
							selecaoTec = read.nextLine();
						}
					}

					// CRIANDO O TÉCNICO
					Tecnico novoTecnico = new Tecnico(nomeTec);
					selecaoAtual.setTecnico(novoTecnico);
					novoTecnico.setSelecao(selecaoAtual);

					// ADICIONAR O TECNICO NA LISTA DO DAO
					TecnicoDAO.inserir(novoTecnico);
					break;

				case 5:
					break;

				default:
					System.err.println("\nOpcao Invalida!"); // Tratamento de entrada para o switch-case de Inserir
				}
				break;

			// -----------------------------------------------------------------------------------------------------------------------

			// EDITAR
			case 2:
				System.out.println("\nQUAL DAS ENTIDADES DESEJA EDITAR: ");
				System.out.println(
						"1 - EDITAR SELECAO \n2 - EDITAR JOGADOR \n3 - EDITAR ARBITRO \n4 - EDITAR TECNICO\n5 - RETORNAR AO MENU PRINCIPAL");

				Integer edit = Funcoes.leituraInt();

				// SWITCH-CASE PARA O MENU INTERNO DE EDITAR
				switch (edit) {

				// EDITAR SELECAO
				case 1:
					if (SelecaoDAO.getLista1().isEmpty()) {
						System.err.println("Nao existe selecoes cadastradas no sistema!");
						break;
					}
					System.out.println("\n -> Digite o nome da Selecao que deseja editar: ");
					String novoNomeSelecao = read.nextLine();

					// CHAMAR A FUNÇÃO DO DAOIMPL DE SELECAO E VERIFICAR SE HÁ ESSE NOME NA LISTA,
					// DEPOIS CHAMAR A FUNÇÃO EDITAR DO DAO
					boolean verificar = SelecaoDAO.checarNome(novoNomeSelecao);

					if (verificar) {
						System.out.println("\n -> Digite o novo nome da Selecao: ");
						String novoNomeS = read.nextLine();
						SelecaoDAO.editar(novoNomeSelecao, novoNomeS);

					} else {
						System.err.println("Selecao nao cadastrada!");
					}
					break;

				// EDITAR JOGADOR
				case 2:

					if (JogadorDAO.getMap().isEmpty()) {
						System.out.println(
								"\n-- Voce nao pode editar um jogador agora, pois ainda nao ha Jogadores cadastrados! --");
						break;
					}

					System.out.println("*-ID DISPONIVEL EM LISTAR JOGADORES-*\nInforme o ID do jogador: ");
					String idPesquisa = read.nextLine();

					if (JogadorDAO.getMap().containsKey(idPesquisa)) {
						String nomeAtualJogador = JogadorDAO.getMap().get(idPesquisa).getNome();

						boolean loopCase = true;

						while (loopCase) {

							System.out.println("\nINFORME O DADO QUE DESEJA EDITAR DE " + nomeAtualJogador);
							System.out.println(
									"1 - NOME\n2 - POSICAO\n3 - CARTAO AMARELO\n4 - CARTAO VERMELHO\n5 - GOLS");
							Integer dado = Funcoes.leituraInt();

							switch (dado) {

							case 1:

								if (JogadorDAO.editar(idPesquisa, dado)) {
									loopCase = false;
									continue;

								} else {
									System.err.println("Falha na edicao!");
								}
								break;

							case 2:

								if (JogadorDAO.editar(idPesquisa, dado)) {
									loopCase = false;
									continue;

								} else {
									System.err.println("Falha na edicao!");
								}
								break;

							case 3:

								if (JogadorDAO.editar(idPesquisa, dado)) {
									loopCase = false;
									continue;

								} else {
									System.err.println("Falha na edicao!");
								}
								break;

							case 4:

								if (JogadorDAO.editar(idPesquisa, dado)) {
									loopCase = false;
									continue;

								} else {
									System.err.println("Falha na edicao!");
								}
								break;

							case 5:

								if (JogadorDAO.editar(idPesquisa, dado)) {
									loopCase = false;
									continue;

								} else {
									System.err.println("Falha na edicao!");
								}
								break;

							default:
								System.err.println("\nOpcao Invalida!");
							}
						}
					} else {
						System.out.println("ID nao encontrado");
						break;
					}
					break;

				// EDITAR ARBITRO
				case 3:
					if (ArbitroDAO.getLista1().isEmpty()) {
						System.out.println(
								"\n-- Voce nao pode editar um Arbitro agora, pois ainda nao ha Arbitros cadastrados! --");
						break;
					}

					System.out.println("Informe o nome do Arbitro que deseja editar: ");
					String antigoArbitro = read.nextLine();

					System.out.println("Agora informe o NOVO nome do Arbitro: ");
					String novoArbitro = read.nextLine();
					if (ArbitroDAO.editar(antigoArbitro, novoArbitro))
						break;
					else
						System.err.println("Falha na edicao! Arbitro nao encontrado!");
					break;

				// EDITAR TECNICO
				case 4:

					if (TecnicoDAO.getLista1().isEmpty()) {
						System.out.println(
								"\n-- Voce nao pode editar um Tecnico agora, pois ainda nao ha Tecnicos cadastrados! --");
						break;
					}
					System.out.println("Informe o nome do Tecnico que deseja editar: ");
					String antigoTecnico = read.nextLine();
					System.out.println("Agora informe o NOVO nome do Tecnico: ");
					String novoTecnico = read.nextLine();
					if (TecnicoDAO.editar(antigoTecnico, novoTecnico))
						break;
					else
						System.err.println("Falha na edicao!");

					break;

				case 5:
					break;

				default:
					System.err.println("Opcao invalida!");
					break;

				}
				break;

			// -----------------------------------------------------------------------------------------------------------------------
			// EXCLUIR
			case 3:

				System.out.println("\nEM QUAL DAS ENTIDADES DESEJA FAZER UMA EXCLUSAO: ");
				System.out.println(
						"1 - EXCLUIR UMA SELECAO \n2 - EXCLUIR UM JOGADOR \n3 - EXCLUIR ARBITRO \n4 - EXCLUIR TECNICO\n5 - RETORNAR AO MENU PRINCIPAL");

				Integer remove = Funcoes.leituraInt();

				switch (remove) {

				case 1:
					System.out.println("Informe o nome da Selecao: ");
					String NomeSelecao = read.nextLine();

					boolean verificar = SelecaoDAO.checarNome(NomeSelecao);
					if (verificar) {
						Selecao obj = SelecaoDAO.excluir(NomeSelecao);
						if (obj == null) {
							System.err.println("Falha ao excluir!");
						} else {
							JogadorDAO.attListaJogadores(obj);
							if (obj.getTecnico() == null) {
								break;
							} else {
								TecnicoDAO.excluir(obj.getTecnico().getNome());
							}

						}
					} else {
						System.err.println("Selecao nao encontrada!");
					}
					break;

				case 2:
					System.out.println("Informe o ID do Jogador: ");
					String IdJog = read.nextLine();
					boolean verificarId = JogadorDAO.checarID(IdJog);
					if (verificarId) {
						Jogador atual = JogadorDAO.excluir(IdJog);
						if (atual == null) {
							System.err.println("Falha na exclusão");
							break;
						} else {
							atual.getSelecao().getJogadores().remove(atual);
						}
					} else {
						System.out.println("ID do jogador nao encontrado!");
					}
					break;

				case 3:
					System.out.println("Informe o nome completo do Arbitro: ");
					String nomeArbitro = read.nextLine();
					boolean verificarNomeAr = ArbitroDAO.checarNome(nomeArbitro);
					if (verificarNomeAr) {
						Arbitro b = ArbitroDAO.excluir(nomeArbitro);
						if (b == null) {
							System.err.println("Falha na exclusao");
							break;

						}
					}
					break;

				case 4:
					System.out.println("Informe o nome completo do Tecnico: ");
					String nomeTecc = read.nextLine();
					boolean verificarNomeTec = TecnicoDAO.checarNome(nomeTecc);
					if (verificarNomeTec) {
						Tecnico c = TecnicoDAO.excluir(nomeTecc);
						SelecaoDAO.attTecnico(c);
					} else {
						System.out.println("Tecnico nao encontrado!");
					}
					break;

				case 5:
					break;

				default:
					System.err.println("\nOpcao Invalida!");

				}
				break;

			// -----------------------------------------------------------------------------------------------------------------------
			// LISTAR
			case 4:
				System.out.println("\nQUAL DAS ENTIDADES DESEJA LISTAR: ");
				System.out.println(
						"1 - LISTAR SELECOES \n2 - LISTAR JOGADORES \n3 - LISTAR ARBITROS \n4 - LISTAR TECNICOS\n5 - RETORNAR AO MENU PRINCIPAL");

				Integer list = Funcoes.leituraInt();

				switch (list) {

				case 1:
					boolean verificar = SelecaoDAO.getLista1().isEmpty();
					if (verificar) {
						System.out.println("Nao ha Selecao(oes) cadastrada(s)!");
					} else {
						SelecaoDAO.listar();
					}
					break;
				case 2:
					boolean verificarID = JogadorDAO.getMap().isEmpty();
					if (verificarID) {
						System.out.println("Nao ha Jogador(es) cadastrado(s)!");
					} else {
						JogadorDAO.listar();
					}
					break;
				case 3:
					boolean verificarAr = ArbitroDAO.getLista1().isEmpty();
					if (verificarAr) {
						System.out.println("Nao ha Arbitro(s) cadastrado(s)!");
					} else {
						ArbitroDAO.listar();
					}
					break;
				case 4:
					boolean verificarTec = TecnicoDAO.getLista1().isEmpty();
					if (verificarTec) {
						System.out.println("Nao ha Tecnico(s) cadastrado(s)!");
					} else {
						TecnicoDAO.listar();
					}
					break;
				case 5:
					break;
				default:
					System.err.println("\nOpcao Invalida!");

				}
				break;

			// -----------------------------------------------------------------------------------------------------------------------
			//FASE DE GRUPOS (CADASTRO DAS PARTIDAS)
			case 5:
				
				/*Verificação se o usuário já está apto para ir para a fase 1 (fase de grupos)
				if (Funcoes.verificaçãoFase1(GruposCRUD, SelecaoDAO)) {
					break;
				}
				DEIXAR COMENTADO POR ENQUANTO PARA TESTES*/
				
				//confirma se o usuário realmente quer ir para a fase de grupos, pois ele não poderá mais voltar para o menu de cadastro
				System.out.println("Tem certeza que deseja ir para a Fase de Grupo? Voce nao podera mais cadastrar/editar/excluir Selecoes!: ");
				System.out.println("DIGITE 1 PARA SIM \nDIGITE 2 PARA VOLTAR");
				Integer confirm = Funcoes.leituraInt();
				
				while (true) {
					if (confirm == 1) {
						loopMenu = false;
						break;
					}else if (confirm == 2) {
						break;
					}else {
						System.err.println("\nOpcao Invalida!");
						System.out.println("DIGITE 1 PARA SIM \nDIGITE 2 PARA VOLTAR");
						confirm = Funcoes.leituraInt();
					}
				}
				
				//dependendo da resposta do usuário, encerra esse loop e começa o loop do cadastro de partidas (fase 1) ou volta
				break;
				
			// -----------------------------------------------------------------------------------------------------------------------
			// ENCERRAR
			case 6:
				System.out.println("\nEncerrando programa...");
				System.exit(0);

			default:
				System.out.println("\nDigite uma opcao valida!");
			}

		}
		//=======================================================================================================================================================
		/**
		 * Essa parte da Main é a Fase de grupos, onde o usuário não poderá mais inserir, editar ou excluir seleções,
		 * apenas jogadores, técnicos e árbitros. Esse segundo Menu Principal terá as seguintes oçções:
		 * 1 GERENCIAR PARTIDAS
		 * 2 GERENCIAR JOGADORES
		 * 3 GERENCIAR ARBITROS**
		 * 4 GERENCIAR TECNICOS**se não colocar precisaria verificar de cada seleção?
		 * 5 PESQUISAR
		 */
		
		//CHAMANDO A FUNÇÃO QUE GERA TODAS AS PARTIDAS A PARTIR DAS SELEÇÕES JÁ CADASTRADAS ANTES DE INICIAR O MENU
		Map<String, List<Partida>> PartidasGeradas = GruposCRUD.gerarPartidas();
		
		boolean loopMenuFase1 = true;
		
		while (loopMenuFase1) {
			
			System.out.println("\n==== MENU DA FASE 1 ====");
			System.out.println("ESCOLHA UMA DAS OPCOES: ");
			
			//MENU PARA A FASE 1
			System.out.println("1 - GERENCIAR PARTIDAS \n2 - GERENCIAR JOGADORES \n3 - GERENCIAR ARBITROS \n4 - GERENCIAR TECNICOS \n5 - PESQUISAR \n6 - SAIR");
			
			// O programa ler a opção escolhida pelo usuario
			Integer menu2 = Funcoes.leituraInt();

			switch (menu2) {

			//GERENCIAR PARTIDAS
			case 1:
				
				//NA PARTE DE INSERIR DE PARTIDAS PRECISA LISTAR AS PARTIDAS GEREDAS PARA O USUÁRIO ESCOLHER QUAL ELE VAI INSERIR**
				//fazer função de listar partidas por grupo
				//perguntar antes ao usuário de que grupo será a partida para não listar todas (pq são 48 no total)
				
				break;
			//-----------------------------------------------------------------------------------------------------------------------
			//GERENCIAR JOGADORES
			case 2:
				
				//MENU JOGADOR
				boolean loopJog = true;
				while (loopJog) {
					System.out.println("\n==GERENCIAR JOGADORES==");//Indicador de qual menu o usuário está
					System.out.println("ESCOLHA UMA DAS OPCOES: ");
					System.out.println("1 - INSERIR JOGADOR \n2 - EDITAR JOGADOR \n3 - EXCLUIR JOGADOR\n4 - LISTAR JOGADORES \n5 - VOLTAR");
					Integer menuJogador = Funcoes.leituraInt();
					
					switch(menuJogador){
					case 1: //inserir
						
						break;
					case 2: //editar
						
						break;
					case 3: //excluir
						
						break;
					case 4: //listar
						
						break;
					case 5: //voltar para o Menu Anterior
						loopJog = false;
						break;
					default:
						System.out.println("\nDigite uma opcao valida!");
					}
				}
				break;
			//-----------------------------------------------------------------------------------------------------------------------
			//GERENCIAR ARBITROS
			case 3:
				break;
			//-----------------------------------------------------------------------------------------------------------------------
			//GERENCIAR TECNICOS
			case 4:
				break;
			//-----------------------------------------------------------------------------------------------------------------------
			//PESQUISAR
			case 5:
				break;	
			//-----------------------------------------------------------------------------------------------------------------------
			// ENCERRAR
			case 6:
				System.out.println("\nEncerrando programa...");
				System.exit(0);

			default:
				System.out.println("\nDigite uma opcao valida!");
			}
		}
	}
}
