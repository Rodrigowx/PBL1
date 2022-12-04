package app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.model.Tecnico;
import app.model.TecnicoDAOImpl;

class TecnicoDAOTest {

	@Test
	void testChecarNomeVazio() {
		
		TecnicoDAOImpl tecnicoDAOImpl = new TecnicoDAOImpl();
		
		String nomeTecnico = "Fernando Reis";
		
		assertEquals(tecnicoDAOImpl.getLista2().isEmpty(), !(tecnicoDAOImpl.checarNome(nomeTecnico)));
		
		tecnicoDAOImpl = null;

	}
	
	@Test
	void testChecarNomeNaoContem() {
		
		TecnicoDAOImpl tecnicoDAOImpl = new TecnicoDAOImpl();
		
		String nomeTecnico1 = "Jeferson Almeida";
		String nomeTecnico2 = "Fabio Dantas";
		tecnicoDAOImpl.getLista2().add(nomeTecnico1);
		
		assertFalse(tecnicoDAOImpl.checarNome(nomeTecnico2));
		
		tecnicoDAOImpl = null;
		
	}
	
	@Test
	void testChecarNomeContem() {
		
		TecnicoDAOImpl tecnicoDAOImpl = new TecnicoDAOImpl();
		
		String nomeTecnico1 = "Jeferson Almeida";//
		String nomeTecnico2 = "Rene Magalhaes";
		tecnicoDAOImpl.getLista2().add(nomeTecnico1);
		tecnicoDAOImpl.getLista2().add(nomeTecnico2);
		
		assertTrue(tecnicoDAOImpl.checarNome(nomeTecnico2));
		
		tecnicoDAOImpl = null;
	}

	@Test
	void testInserir() {
		
		TecnicoDAOImpl tecnicoDAOImpl = new TecnicoDAOImpl();
		
		String nomeTecnico = "Gabriel Leni";
		Tecnico tecnico = new Tecnico(nomeTecnico);
		tecnicoDAOImpl.inserir(tecnico);
		
		assertTrue(tecnicoDAOImpl.getLista1().contains(tecnico));
		assertTrue(tecnicoDAOImpl.getLista2().contains(tecnico.getNome()));
		
		tecnicoDAOImpl = null;
		
	}
	
	@Test
	void testEditarNaoContem() {
		
		TecnicoDAOImpl tecnicoDAOImpl = new TecnicoDAOImpl();
		
		String novoNome = "Matheus Machado";
		
		//assertFalse(tecnicoDAOImpl.editar("Teodoro Matos", novoNome));
		
		tecnicoDAOImpl.getLista2().remove("Thiago Henrique");
		tecnicoDAOImpl = null;	
	}

	@Test
	void testEditar() {
		
		TecnicoDAOImpl tecnicoDAOImpl = new TecnicoDAOImpl();
		
		String nomeTecnico = "Thiago Henrique";
		Tecnico tecnico = new Tecnico(nomeTecnico);
		tecnicoDAOImpl.inserir(tecnico);
		
		String novoNome = "Matheus Machado";
		
		//assertTrue(tecnicoDAOImpl.editar(nomeTecnico, novoNome));
		assertTrue(tecnicoDAOImpl.checarNome(novoNome));
		
		tecnicoDAOImpl.getLista2().remove("Thiago Henrique");
		tecnicoDAOImpl = null;	
	}
	
	@Test
	void testExcluirNaoContem() {
		
		TecnicoDAOImpl tecnicoDAOImpl = new TecnicoDAOImpl();
		
		String nomeTecnico = "David Leonardo";
		Tecnico tecnico = new Tecnico(nomeTecnico);
		
		assertEquals(null, tecnicoDAOImpl.excluir(tecnico.getNome()));
		tecnicoDAOImpl = null;
		
	}

	@Test
	void testExcluirContem() {
		
		TecnicoDAOImpl tecnicoDAOImpl = new TecnicoDAOImpl();
		
		String nomeTecnico = "Yago Gomes";
		Tecnico tecnico = new Tecnico(nomeTecnico);
		tecnicoDAOImpl.inserir(tecnico);
		
		assertEquals(tecnico, tecnicoDAOImpl.excluir(nomeTecnico));
		assertFalse(tecnicoDAOImpl.getLista1().contains(tecnico));
		assertFalse(tecnicoDAOImpl.getLista2().contains(nomeTecnico));
		tecnicoDAOImpl = null;
		
	}

}
