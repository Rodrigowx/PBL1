package app.DadosArquivo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.model.FaseGrupos;
import app.model.Jogador;
import app.model.JogadorDAOImpl;
import app.model.PartidaJogador;
import app.model.Selecao;
import app.model.SelecaoDAOImpl;

public class DadosPréCadastro {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");

	public static void LeituraArquivos(SelecaoDAOImpl SelecaoDAO, JogadorDAOImpl JogadorDAO, FaseGrupos GruposCRUD) {
		
		try {
			FileInputStream arquivo = new FileInputStream("/Users/josen/git/PBL1/PBL1/src/app/DadosArquivo/arquivoDeDados.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader buffer = new BufferedReader(input);
			
			String linha = buffer.readLine();	
			
			while (linha != null) {
				
				//Lendo o arquivo das seleçoes
				String[] selecaoGrup = linha.split(";");
				
				List<Jogador> listaJogadores = new ArrayList<>();
				
				Selecao novaSelecao = new Selecao(selecaoGrup[0], listaJogadores, selecaoGrup[1]);
				
				SelecaoDAO.inserir(novaSelecao);
				GruposCRUD.atualizaGrupos(selecaoGrup[1], novaSelecao);
				
				linha = buffer.readLine();	
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo");
		}
		
		//Leitura Jogadores
		try {
			FileInputStream arquivoJog = new FileInputStream("/Users/josen/git/PBL1/PBL1/src/app/DadosArquivo/dadosJogadores.txt");
			InputStreamReader input = new InputStreamReader(arquivoJog);
			BufferedReader buffer = new BufferedReader(input);
			
			String linha = "-";
			
			while (linha != null) {
				linha = buffer.readLine();
				String selecao = linha;
				while (linha != "-") {
					
					linha = buffer.readLine();
					String[] jogadoresPos = linha.split(";");
					
					Selecao selecaoJog = SelecaoDAO.verificaSelecao(selecao);
					
					Date data = new Date();
					Jogador novoJog = new Jogador(sdf.format(data), jogadoresPos[0], jogadoresPos[1], selecaoJog);

					ArrayList<PartidaJogador> listaJogPart = new ArrayList<>();
					novoJog.setPartidasJogador(listaJogPart);

					// ADICIONANDO O JOGADOR NOVO NA LISTA DE SEU DAO E DA SUA SELEÇAO
					JogadorDAO.inserir(novoJog);
					selecaoJog.setJogadores(novoJog);
					
					linha = buffer.readLine();
				}
			}
			
		} catch(Exception e) {
			System.out.println("Erro ao ler arquivo de Jogadores");
		}
	}
}
