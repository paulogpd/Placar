import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Armazenamento {

	Usuario u = new Usuario();
	public String resultado;
	
	public void GravaPontuacao(Usuario u) throws IOException {
		String pontos;
		BufferedWriter arq = new BufferedWriter(new FileWriter("pontuacao.txt", true));
		pontos = u.nome+"-"+u.estrela+"-"+u.moeda+"-"+u.comentario+"-"+u.topico+"-"+u.curtida;
		arq.write(pontos);
		arq.newLine();
		arq.close();
	}
	
	public void getPontosPorTipo(String tipo) throws IOException {
		LerArquivo(u, tipo);
	}
	
	public void retornaUsuarioComPontos() throws IOException {
		InputStream i = new FileInputStream("pontuacao.txt");
		Scanner s = new Scanner(i);
		while (s.hasNext()) {
			String linha = s.nextLine();
			String [] nomeUsuario = linha.split("-");
			System.out.println("Usuarios com pontos registrados no sistema: "+nomeUsuario[0]);
		}
		i.close();
		s.close();
	}
	
	public ArrayList<String> retornaPontosUsuario(Usuario u) {
		ArrayList<String> pontosUsuario = new ArrayList<>();
		if (u.comentario != 0) pontosUsuario.add("Tipo Comentario");
		if (u.curtida != 0) pontosUsuario.add("Tipo Curtida");
		if (u.estrela != 0) pontosUsuario.add("Tipo Estrela");
		if (u.moeda != 0) pontosUsuario.add("Tipo Moeda");
		if (u.topico != 0) pontosUsuario.add("Tipo Topico");
		return pontosUsuario;
	}
	
	public String LerArquivo(Usuario u, String tipoDePonto) throws IOException {
		InputStream i = new FileInputStream("pontuacao.txt");
		Scanner s = new Scanner(i);
		tipoDePonto.toLowerCase();
		while (s.hasNextLine()) {
			String linha = s.nextLine();
			String [] dados = linha.split("-");
			if (dados[0].equals(u.nome)) {
				if (tipoDePonto.equals("estrela")) resultado = "O usuário "+u.nome+" tem "+u.estrela+" pontos de Estrela";
				if (tipoDePonto.equals("moeda")) resultado = "O usuário "+u.nome+" tem "+u.moeda+" pontos de Moeda";
				if (tipoDePonto.equals("comentario")) resultado = "O usuário "+u.nome+" tem "+u.comentario+" pontos de Comentário";
				if (tipoDePonto.equals("topico")) resultado = "O usuário "+u.nome+" tem "+u.topico+" pontos de Tópico";
				if (tipoDePonto.equals("curtida")) resultado = "O usuário "+u.nome+" tem "+u.estrela+" pontos de Curtida";
			}
		}
		i.close();
		s.close();
		return resultado;
	}
	
}
