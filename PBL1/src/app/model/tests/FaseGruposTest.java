package app.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import app.model.FaseGrupos;
import app.model.Jogador;
import app.model.Partida;
import app.model.Selecao;

class FaseGruposTest {

	@Test
	void testVerificaGrupos() {
		
		FaseGrupos gruposC = new FaseGrupos();
		
		ArrayList<Jogador> listaJogs = new ArrayList<>();
		Selecao selecao1 = new Selecao("Brasil", listaJogs, "A");
		gruposC.atualizaGrupos("A", selecao1);
		Selecao selecao2 = new Selecao("Argentina", listaJogs, "A");
		gruposC.atualizaGrupos("A", selecao2);
		Selecao selecao3 = new Selecao("Franca", listaJogs, "A");
		gruposC.atualizaGrupos("A", selecao3);
		Selecao selecao4 = new Selecao("Espanha", listaJogs, "A");
		gruposC.atualizaGrupos("A", selecao4);
		
		System.out.println(gruposC.getMapGrupos());
		
		assertTrue(gruposC.verificaGrupos("A"));
		gruposC.getMapGrupos().clear();
		gruposC = null;
	}

	@Test
	void testGerarPartidas() {
		
		FaseGrupos gruposC = new FaseGrupos();
		Map<String, List<Partida>> mapTest = new HashMap<String, List<Partida>>();
		ArrayList<Partida> partidasTest = new ArrayList<>();
		
		ArrayList<Jogador> listaJogs = new ArrayList<>();
		
		Selecao selecao1 = new Selecao("Brasil", listaJogs, "A");
		gruposC.atualizaGrupos("A", selecao1);
		Selecao selecao2 = new Selecao("Argentina", listaJogs, "A");
		gruposC.atualizaGrupos("A", selecao2);
		Selecao selecao3 = new Selecao("Franca", listaJogs, "A");
		gruposC.atualizaGrupos("A", selecao3);
		Selecao selecao4 = new Selecao("Espanha", listaJogs, "A");
		gruposC.atualizaGrupos("A", selecao4);
		
		Partida partida = new Partida("Brasil", "Argentina");
		partidasTest.add(partida);
		Partida partida1 = new Partida("Brasil", "Franca");
		partidasTest.add(partida1);
		Partida partida2 = new Partida("Brasil", "Espanha");
		partidasTest.add(partida2);
		Partida partida3 = new Partida("Argentina", "Franca");
		partidasTest.add(partida3);
		Partida partida4 = new Partida("Argentina", "Espanha");
		partidasTest.add(partida4);
		Partida partida5 = new Partida("Franca", "Espanha");
		partidasTest.add(partida5);
		
		mapTest.put("A", partidasTest);
		
		assertEquals(mapTest, gruposC.gerarPartidas());
		gruposC = null;
	}

}
