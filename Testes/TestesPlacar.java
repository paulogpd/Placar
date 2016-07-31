import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

public class TestesPlacar {

	Usuario u = new Usuario();
	Armazenamento a = new Armazenamento();
	Mock m = new Mock();
		
	@Test
	public void testaUsuario() {
		u.nome = "Paulo";
		assertEquals("Paulo", u.nome);
	}
	
	@Test
	public void testaAtribuicaoPontuacao() {
		m.armazenaComentario(u,10);
		m.armazenaCurtida(u,100);
		m.armazenaEstrela(u,2);
		m.armazenaMoeda(u,9);
		m.armazenaTopico(u,123);
	}
	
	@Test
	public void testaRegistraPontos() {
		m.armazenaComentario(u,10);
		m.armazenaCurtida(u,100);
		m.armazenaEstrela(u,2);
		m.armazenaMoeda(u,9);
		m.armazenaTopico(u,123);
		try {
			m.registraPontosUsuario(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testaRankings() {
		m.armazenaComentario(u,10);
		m.armazenaCurtida(u,100);
		m.armazenaEstrela(u,2);
		m.armazenaMoeda(u,9);
		m.armazenaTopico(u,123);
		try {
			m.rankingComentario(u);
			m.rankingCurtida(u);
			m.rankingEstrela(u);
			m.rankingMoeda(u);
			m.rankingTopico(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
