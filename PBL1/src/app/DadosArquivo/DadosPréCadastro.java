package app.DadosArquivo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import app.model.FaseGrupos;
import app.model.Jogador;
import app.model.Selecao;
import app.model.SelecaoDAOImpl;

public class DadosPréCadastro {

	public static void LeituraArquivos(SelecaoDAOImpl SelecaoDAO, FaseGrupos GruposCRUD) {
		
		try {
			FileInputStream arquivo = new FileInputStream("/Users/josen/git/PBL1/PBL1/src/app/DadosArquivo/arquivoDeDados.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader buffer = new BufferedReader(input);
			
			String linha = buffer.readLine();	
			
			while (linha != null) {
						
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
	}
}
