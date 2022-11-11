package app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import app.model.Jogador;
import app.model.JogadorDAOImpl;
import app.model.Selecao;

class JogadorDAOTest {

	@Test
	void testChecarNome() {
		
		JogadorDAOImpl jogadorDAOImpl = new JogadorDAOImpl();		
		jogadorDAOImpl.getLista().add("Rodrigo");
		
		assertTrue(jogadorDAOImpl.checarNome("Rodrigo"));

	}
	
	@Test
	void testChecarNomeNaoContem() {
		
        JogadorDAOImpl jogadorDAOImpl = new JogadorDAOImpl();
		jogadorDAOImpl.getLista().add("Rodrigo");
		
		assertFalse(jogadorDAOImpl.checarNome("Matheus"));		
	}

	@Test
	void testChecarID() {
		
		JogadorDAOImpl jogadorDAOImpl = new JogadorDAOImpl();
		
		ArrayList<Jogador> listaJogs = new ArrayList<>();
		Selecao selecao = new Selecao("Brasil", listaJogs, "A");
		Jogador jogador = new Jogador("54321", "Rodrigo", "Atacante", selecao);
		
		jogadorDAOImpl.getMap().put("54321", jogador);
		
		assertTrue(jogadorDAOImpl.checarID("54321"));
	}
	
	@Test
	void testChecarIDNaoContem() {
		
		JogadorDAOImpl jogadorDAOImpl = new JogadorDAOImpl();
		
		ArrayList<Jogador> listaJogs = new ArrayList<>();
		Selecao selecao = new Selecao("Brasil", listaJogs, "A");
		Jogador jogador = new Jogador("54321", "Rodrigo", "Atacante", selecao);
		
		jogadorDAOImpl.getMap().put("54321", jogador);
		
		assertFalse(jogadorDAOImpl.checarID("97665"));
	}

	@Test
	void testInserir() {
		
        JogadorDAOImpl jogadorDAOImpl = new JogadorDAOImpl();
		
		ArrayList<Jogador> listaJogs = new ArrayList<>();
		Selecao selecao = new Selecao("Brasil", listaJogs, "A");
		Jogador jogador = new Jogador("54321", "Rodrigo", "Atacante", selecao);
		
		jogadorDAOImpl.inserir(jogador);
		
		assertTrue(jogadorDAOImpl.getMap().containsValue(jogador));
		assertTrue(jogadorDAOImpl.getLista().contains(jogador.getNome()));
	}

	@Test
	void testExcluir() {
		 JogadorDAOImpl jogadorDAOImpl = new JogadorDAOImpl();
			
		ArrayList<Jogador> listaJogs = new ArrayList<>();
		Selecao selecao = new Selecao("Brasil", listaJogs, "A");
		Jogador jogador = new Jogador("54321", "Rodrigo", "Atacante", selecao);
			
		jogadorDAOImpl.inserir(jogador);
		jogadorDAOImpl.excluir("54321");
			
		assertFalse(jogadorDAOImpl.getMap().containsValue(jogador));
		assertFalse(jogadorDAOImpl.getLista().contains(jogador.getNome()));
	}

}
