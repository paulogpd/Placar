import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Placar {

	Armazenamento placar = new Armazenamento();
	Usuario u = new Usuario();
	ArrayList<Integer> ranking = new ArrayList<>();
	
	public ArrayList<String> retornaPontosUsuario(Usuario u) {
		return placar.retornaPontosUsuario(u);
	}	
	
	public ArrayList<Integer> rankingCurtida(Usuario u) throws IOException {
		InputStream i = new FileInputStream("pontuacao.txt");
		Scanner s = new Scanner(i);
		while (s.hasNext()) {
			String linha = s.nextLine();
			String [] dados = linha.split("-");
			int index = Integer.parseInt(dados[5]);
			if (index != 0) ranking.add(index);
		}
		s.close();
		i.close();
		Collections.sort(ranking, Collections.reverseOrder());
		return ranking;
	}

	public ArrayList<Integer> rankingTopico(Usuario u) throws IOException {
		InputStream i = new FileInputStream("pontuacao.txt");
		Scanner s = new Scanner(i);
		while (s.hasNext()) {
			String linha = s.nextLine();
			String [] dados = linha.split("-");
			int index = Integer.parseInt(dados[4]);
			if (index != 0) ranking.add(index);
		}
		s.close();
		i.close();
		Collections.sort(ranking, Collections.reverseOrder());
		return ranking;
	}

	public ArrayList<Integer> rankingComentario(Usuario u) throws IOException {
		InputStream i = new FileInputStream("pontuacao.txt");
		Scanner s = new Scanner(i);
		while (s.hasNext()) {
			String linha = s.nextLine();
			String [] dados = linha.split("-");
			int index = Integer.parseInt(dados[3]);
			if (index != 0) ranking.add(index);
		}
		s.close();
		i.close();
		Collections.sort(ranking, Collections.reverseOrder());
		return ranking;
	}

	public ArrayList<Integer> rankingMoeda(Usuario u) throws IOException {
		InputStream i = new FileInputStream("pontuacao.txt");
		Scanner s = new Scanner(i);
		while (s.hasNext()) {
			String linha = s.nextLine();
			String [] dados = linha.split("-");
			int index = Integer.parseInt(dados[2]);
			if (index != 0) ranking.add(index);
		}
		s.close();
		i.close();
		Collections.sort(ranking, Collections.reverseOrder());
		return ranking;
	}

	public ArrayList<Integer> rankingEstrela(Usuario u) throws IOException {
		InputStream i = new FileInputStream("pontuacao.txt");
		Scanner s = new Scanner(i);
		while (s.hasNext()) {
			String linha = s.nextLine();
			String [] dados = linha.split("-");
			int index = Integer.parseInt(dados[1]);
			if (index != 0) ranking.add(index);
		}
		s.close();
		i.close();
		Collections.sort(ranking, Collections.reverseOrder());
		return ranking;
	}

	public void registraPontosUsuario(Usuario u) throws IOException {
		placar.GravaPontuacao(u);
	}
	
	public void armazenaEstrela(Usuario u, int pontuacao) {
		u.estrela += pontuacao;;
	}
	
	public void armazenaMoeda(Usuario u,int pontuacao) {
		u.moeda += pontuacao;
	}
	
	public void armazenaComentario(Usuario u,int pontuacao) {
		u.comentario += pontuacao;
	}
	
	public void armazenaTopico(Usuario u,int pontuacao) {
		u.topico += pontuacao;
	}
	
	public void armazenaCurtida(Usuario u,int pontuacao) {
		u.curtida += pontuacao;
	}
}
