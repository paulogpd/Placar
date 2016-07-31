import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Arquivo {
	
	public String resultado;
	
	public void GravarArquivo(Usuario u) throws IOException {
		String pontos;
		BufferedWriter arq = new BufferedWriter(new FileWriter("pontuacao.txt", true));
		pontos = u.nome + " - "+" Estrela:"+u.estrela+" - "+"Moeda:"+u.moeda+" - "+"Comentario:"+u.comentario+" - "+"Topico:"+u.topico+" - "+"Curtida:"+u.curtida;
		arq.write(pontos);
		arq.newLine();
		arq.close();
	}
	
	public String LerArquivo(Usuario u, String tipoDePonto) throws IOException {
		InputStream i = new FileInputStream("pontuacao.txt");
		Scanner s = new Scanner(i);
		tipoDePonto.toLowerCase();
		while (s.hasNextLine()) {
			String linha = s.nextLine();
			String [] dados = linha.split(" - ");
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
