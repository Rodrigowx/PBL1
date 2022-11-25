package app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.model.Partida;
import app.model.PartidaGerenciar;

class PartidaGerenciarTests {

	@Test
	void testInserir() {
		
		Partida partida = new Partida("Brasil", "Argentina");
		PartidaGerenciar.inserir(partida);
		
		assertTrue(PartidaGerenciar.getMapPartidas().containsValue(partida));
	}

}
