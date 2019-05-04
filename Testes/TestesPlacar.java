import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class TestesPlacar {

	Usuario u = new Usuario();
	Mock m = new Mock();
	Placar p = new Placar();
		
	@Test
	public void testaUsuario() {
		u.nome = "Paulo";
		assertEquals("Paulo", u.nome);
	}
	
	@Test
	public void testaPontucao(){
		m.GravaPontuacao(u);
		assertEquals(1, u.comentario);
		assertEquals(2, u.curtida);
		assertEquals(3, u.estrela);
		assertEquals(4, u.moeda);
		assertEquals(5, u.topico);
	}
	
	@Test
	public void testaPontosPorTipo() {
		assertEquals("Comentario, Estrela", m.getPontosPorTipo(u, "Comentario"));
	}
	
	@Test
	public void testaRetornaPontos() {
		m.GravaPontuacao(u);
		u.nome = "Paulo";
		ArrayList<Integer> testaPontos = new ArrayList<>();
		testaPontos.add(1);
		testaPontos.add(2);
		testaPontos.add(3);
		testaPontos.add(4);
		testaPontos.add(5);
		assertEquals(testaPontos, m.retornaPontosUsuario(u));
	}
	
	@Test
	public void testaRetornaPontosUsuario() {
		ArrayList<String> testaPontos = new ArrayList<>();
		testaPontos = p.retornaPontosUsuario(u);
		assertEquals(testaPontos, p.retornaPontosUsuario(u));
	}
	
	@Test
	public void testaRankingCurtida() throws IOException {
		ArrayList<Integer> testaPontos = new ArrayList<>();
		testaPontos = p.rankingCurtida(u);
		assertEquals(testaPontos, p.rankingCurtida(u));
	}
	
	@Test
	public void testaRankingComentario() throws IOException {
		ArrayList<Integer> testaPontos = new ArrayList<>();
		testaPontos = p.rankingComentario(u);
		assertEquals(testaPontos, p.rankingComentario(u));
	}
	
	@Test
	public void testaRankingEstrela() throws IOException {
		ArrayList<Integer> testaPontos = new ArrayList<>();
		testaPontos = p.rankingEstrela(u);
		assertEquals(testaPontos, p.rankingEstrela(u));
	}
	
	@Test
	public void testaRankingMoeda() throws IOException {
		ArrayList<Integer> testaPontos = new ArrayList<>();
		testaPontos = p.rankingMoeda(u);
		assertEquals(testaPontos, p.rankingMoeda(u));
	}
	
	@Test
	public void testaRankingTopico() throws IOException {
		ArrayList<Integer> testaPontos = new ArrayList<>();
		testaPontos = p.rankingTopico(u);
		assertEquals(testaPontos, p.rankingTopico(u));
	}
}
