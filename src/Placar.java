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
	
	private void retornaPontosUsuario() {
		placar.retornaPontosUsuario(u);
	}	
	
	private ArrayList<Integer> rankingCurtida(Usuario u) throws IOException {
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
		Collections.sort(ranking);
		return ranking;
	}

	private ArrayList<Integer> rankingTopico(Usuario u) throws IOException {
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
		Collections.sort(ranking);
		return ranking;
	}

	private ArrayList<Integer> rankingComentario(Usuario u) throws IOException {
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
		Collections.sort(ranking);
		return ranking;
	}

	private ArrayList<Integer> rankingMoeda(Usuario u) throws IOException {
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
		Collections.sort(ranking);
		return ranking;
	}

	private ArrayList<Integer> rankingEstrela(Usuario u) throws IOException {
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
		Collections.sort(ranking);
		return ranking;
	}

	private void registraPontosUsuario() throws IOException {
		placar.GravaPontuacao(u);
	}
	
	private void armazenaEstrela(int pontuacao) {
		u.estrela += pontuacao;;
	}
	
	private void armazenaMoeda(int pontuacao) {
		u.moeda += pontuacao;
	}
	
	private void armazenaComentario(int pontuacao) {
		u.comentario += pontuacao;
	}
	
	private void armazenaTopico(int pontuacao) {
		u.topico += pontuacao;
	}
	
	private void armazenaCurtida(int pontuacao) {
		u.curtida += pontuacao;
	}
}
