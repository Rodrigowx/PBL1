package app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import app.model.ArbitroDAOImpl;
import app.model.Arbitro;

import org.junit.jupiter.api.Test;

class ArbitroDAOTest {
	
public void zerandoListasEstaticas(ArbitroDAOImpl arbitroDAOImpl) {
		
		Collection<Arbitro> lista1 = arbitroDAOImpl.getLista1();
		Collection<String> lista2 = arbitroDAOImpl.getLista2();
		
		arbitroDAOImpl.getLista1().removeAll(lista1);
		arbitroDAOImpl.getLista2().removeAll(lista2);
		
		arbitroDAOImpl = null;
	}

	@Test
	void testChecarNomeVazio() {
		
		ArbitroDAOImpl arbitroDAOImpl = new ArbitroDAOImpl();
		
		String nomeArbitro = "Fernando Reis";
		
		assertEquals(arbitroDAOImpl.getLista2().isEmpty(), !(arbitroDAOImpl.checarNome(nomeArbitro)));
		
		zerandoListasEstaticas(arbitroDAOImpl);

	}
	
	@Test
	void testChecarNomeNaoContem() {
		
		ArbitroDAOImpl arbitroDAOImpl = new ArbitroDAOImpl();
		
		String nomeArbitro1 = "Jeferson Almeida";
		String nomeArbitro2 = "Fabio Dantas";
		arbitroDAOImpl.getLista2().add(nomeArbitro1);
		
		assertFalse(arbitroDAOImpl.checarNome(nomeArbitro2));
		
		zerandoListasEstaticas(arbitroDAOImpl);
		
	}
	
	@Test
	void testChecarNomeContem() {
		
		ArbitroDAOImpl arbitroDAOImpl = new ArbitroDAOImpl();
		
		String nomeArbitro1 = "Jeferson Almeida";//
		String nomeArbitro2 = "Rene Magalhaes";
		arbitroDAOImpl.getLista2().add(nomeArbitro1);
		arbitroDAOImpl.getLista2().add(nomeArbitro2);
		
		assertTrue(arbitroDAOImpl.checarNome(nomeArbitro2));
		
		zerandoListasEstaticas(arbitroDAOImpl);
	}

	@Test
	void testInserir() {
		
		ArbitroDAOImpl arbitroDAOImpl = new ArbitroDAOImpl();
		
		String nomeArbitro = "Gabriel Leni";
		Arbitro arbitro = new Arbitro(nomeArbitro);
		arbitroDAOImpl.inserir(arbitro);
		
		assertTrue(arbitroDAOImpl.getLista1().contains(arbitro));
		assertTrue(arbitroDAOImpl.getLista2().contains(arbitro.getNome()));
		
		zerandoListasEstaticas(arbitroDAOImpl);
		
	}
	
	@Test
	void testEditarNaoContem() {
		
		ArbitroDAOImpl arbitroDAOImpl = new ArbitroDAOImpl();
		
		String novoNome = "Matheus Machado";
		
		assertFalse(arbitroDAOImpl.editar("Teodoro Matos", novoNome));
		
		arbitroDAOImpl.getLista2().remove("Thiago Henrique");
		zerandoListasEstaticas(arbitroDAOImpl);
	}

	@Test
	void testEditar() {
		
		ArbitroDAOImpl arbitroDAOImpl = new ArbitroDAOImpl();
		
		String nomeArbitro = "Thiago Henrique";
		Arbitro arbitro = new Arbitro(nomeArbitro);
		arbitroDAOImpl.inserir(arbitro);
		
		String novoNome = "Matheus Machado";
		
		assertTrue(arbitroDAOImpl.editar(nomeArbitro, novoNome));
		assertTrue(arbitroDAOImpl.checarNome(novoNome));
		
		arbitroDAOImpl.getLista2().remove("Thiago Henrique");
		zerandoListasEstaticas(arbitroDAOImpl);
	}
	
	@Test
	void testExcluirNaoContem() {
		
		ArbitroDAOImpl arbitroDAOImpl = new ArbitroDAOImpl();
		
		String nomeArbitro = "David Leonardo";
		Arbitro arbitro = new Arbitro(nomeArbitro);
		
		assertEquals(null, arbitroDAOImpl.excluir(arbitro.getNome()));
		zerandoListasEstaticas(arbitroDAOImpl);
		
	}

	@Test
	void testExcluirContem() {
		
		ArbitroDAOImpl arbitroDAOImpl = new ArbitroDAOImpl();
		
		String nomeArbitro = "Yago Gomes";
		Arbitro arbitro = new Arbitro(nomeArbitro);
		arbitroDAOImpl.inserir(arbitro);
		
		assertEquals(arbitro, arbitroDAOImpl.excluir(nomeArbitro));
		assertFalse(arbitroDAOImpl.getLista1().contains(arbitro));
		assertFalse(arbitroDAOImpl.getLista2().contains(nomeArbitro));
		zerandoListasEstaticas(arbitroDAOImpl);
		
	}

}
