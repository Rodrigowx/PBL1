package app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

import app.model.Jogador;
import app.model.Selecao;
import app.model.SelecaoDAOImpl;
import app.model.Tecnico;

class SelecaoDAOTest {
	
	public void zerandoListasEstaticas(SelecaoDAOImpl selecaoDAOImpl) {
		
		Collection<Selecao> lista1 = selecaoDAOImpl.getLista1();
		Collection<String> lista2 = selecaoDAOImpl.getLista2();
		
		selecaoDAOImpl.getLista1().removeAll(lista1);
		selecaoDAOImpl.getLista2().removeAll(lista2);
		
		selecaoDAOImpl = null;
	}

	@Test
	void testChecarNomeVazio() {
		
		SelecaoDAOImpl selecaoDAOImpl = new SelecaoDAOImpl();

		String nomeSelecao = "Brasil";
		assertEquals(selecaoDAOImpl.getLista2().isEmpty(), !(selecaoDAOImpl.checarNome(nomeSelecao)));
	}
	
	@Test
	void testChecarNomeNaoContem() {
		
		SelecaoDAOImpl selecaoDAOImpl = new SelecaoDAOImpl();
		
		String nomeSelecao1 = "Argentina";
		String nomeSelecao2 = "Brasil";
		selecaoDAOImpl.getLista2().add(nomeSelecao1);
		
		assertFalse(selecaoDAOImpl.checarNome(nomeSelecao2));		
		zerandoListasEstaticas(selecaoDAOImpl);
	}
	
	@Test
	void testChecarNomeContem() {
		
		SelecaoDAOImpl selecaoDAOImpl = new SelecaoDAOImpl();
		
		String nomeSelecao1 = "Brasil";
		String nomeSelecao2 = "França";
		selecaoDAOImpl.getLista2().add(nomeSelecao1);
		selecaoDAOImpl.getLista2().add(nomeSelecao2);
		
		assertTrue(selecaoDAOImpl.checarNome(nomeSelecao2));
		zerandoListasEstaticas(selecaoDAOImpl);
	}

	@Test
	void testVerificaTecnicoNaoContem() {
		
		SelecaoDAOImpl selecaoDAOImpl = new SelecaoDAOImpl();
		
		String nomeSelecao = "Brasil";
		ArrayList<Jogador> listaJogs = new ArrayList<>();
		Selecao selecao = new Selecao(nomeSelecao, listaJogs, "A");
		selecaoDAOImpl.getLista1().add(selecao);
		selecaoDAOImpl.getLista2().add(nomeSelecao);
		
		assertEquals(selecao, selecaoDAOImpl.verificaTecnico(nomeSelecao));
		zerandoListasEstaticas(selecaoDAOImpl);
	}
	
	@Test
	void testVerificaTecnicoContemTecnico() {
		
		SelecaoDAOImpl selecaoDAOImpl = new SelecaoDAOImpl();
		
		String nomeSelecao = "Brasil";
		ArrayList<Jogador> listaJogs = new ArrayList<>();
		Selecao selecao = new Selecao(nomeSelecao, listaJogs, "A");
		selecaoDAOImpl.getLista1().add(selecao);
		selecaoDAOImpl.getLista2().add(nomeSelecao);
		
		String nomeTecnico = "Marcelo Rosti";
		Tecnico tecnico = new Tecnico(nomeTecnico);
		selecao.setTecnico(tecnico);
		
		assertNull(selecaoDAOImpl.verificaTecnico(nomeSelecao));
		zerandoListasEstaticas(selecaoDAOImpl);
	}
	
	@Test
	void testVerificaSelecaoNaoExixte() {
		
		SelecaoDAOImpl selecaoDAOImpl = new SelecaoDAOImpl();
		
		String nomeSelecao = "Brasil";
		assertNull(selecaoDAOImpl.verificaSelecao(nomeSelecao));
		zerandoListasEstaticas(selecaoDAOImpl);
	}

	@Test
	void testVerificaSelecaoExixte() {
		
		SelecaoDAOImpl selecaoDAOImpl = new SelecaoDAOImpl();
		
		String nomeSelecao = "Brasil";
		ArrayList<Jogador> listaJogs = new ArrayList<>();
		Selecao selecao = new Selecao(nomeSelecao, listaJogs, "A");
		selecaoDAOImpl.getLista1().add(selecao);
		selecaoDAOImpl.getLista2().add(nomeSelecao);
		
		assertEquals(selecao, selecaoDAOImpl.verificaSelecao(nomeSelecao));
		zerandoListasEstaticas(selecaoDAOImpl);
		
	}

	@Test
	void testInserir() {
		
		SelecaoDAOImpl selecaoDAOImpl = new SelecaoDAOImpl();
		
		String nomeSelecao = "Brasil";
		ArrayList<Jogador> listaJogs = new ArrayList<>();
		Selecao selecao = new Selecao(nomeSelecao, listaJogs, "A");
		selecaoDAOImpl.inserir(selecao);
		
		assertTrue(selecaoDAOImpl.getLista1().contains(selecao));
		assertTrue(selecaoDAOImpl.getLista2().contains(selecao.getNome()));
		
		zerandoListasEstaticas(selecaoDAOImpl);
	}

	@Test
	void testEditarNaoContem() {
		
		SelecaoDAOImpl selecaoDAOImpl = new SelecaoDAOImpl();
		
		String novoNome = "Inglaterra";
		
		assertFalse(selecaoDAOImpl.editar("Teodoro Matos", novoNome));
		
		selecaoDAOImpl.getLista2().remove("England");
		zerandoListasEstaticas(selecaoDAOImpl);
	}

	@Test
	void testEditar() {
		
		SelecaoDAOImpl selecaoDAOImpl = new SelecaoDAOImpl();
		
		String nomeSelecao = "England";
		ArrayList<Jogador> listaJogs = new ArrayList<>();
		Selecao selecao = new Selecao(nomeSelecao, listaJogs, "A");
		selecaoDAOImpl.inserir(selecao);
		
		String novoNome = "Inglaterra";
		
		assertTrue(selecaoDAOImpl.editar(nomeSelecao, novoNome));
		assertTrue(selecaoDAOImpl.checarNome(novoNome));
		
		selecaoDAOImpl.getLista2().remove("England");
		zerandoListasEstaticas(selecaoDAOImpl);	
	}

	@Test
	void testExcluir() {
		
		SelecaoDAOImpl selecaoDAOImpl = new SelecaoDAOImpl();
		
		String nomeSelecao1 = "Brasil";
		ArrayList<Jogador> listaJogs1 = new ArrayList<>();
		Selecao selecao1 = new Selecao(nomeSelecao1, listaJogs1, "A");
		selecaoDAOImpl.inserir(selecao1);
		
		String nomeSelecao = "Guatemala";
		ArrayList<Jogador> listaJogs = new ArrayList<>();
		Selecao selecao = new Selecao(nomeSelecao, listaJogs, "A");
		selecaoDAOImpl.inserir(selecao);
		
		assertEquals(selecao, selecaoDAOImpl.excluir(nomeSelecao));
		assertFalse(selecaoDAOImpl.getLista1().contains(selecao));
		assertFalse(selecaoDAOImpl.getLista2().contains(nomeSelecao));
		zerandoListasEstaticas(selecaoDAOImpl);
	}

}
