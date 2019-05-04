import java.util.ArrayList;

public class Mock implements IArmazenamento {

	@Override
	public void GravaPontuacao(Usuario u) {
		u.comentario = 1;
		u.curtida = 2;
		u.estrela = 3;
		u.moeda = 4;
		u.topico = 5;
	}

	@Override
	public String getPontosPorTipo(Usuario u, String tipo) {
		return "Comentario, Estrela";
	}

	@Override
	public ArrayList<Integer> retornaPontosUsuario(Usuario u) {
		ArrayList<Integer> pontos = new ArrayList<>();
		u.nome = "Paulo";
		GravaPontuacao(u);
		pontos.add(u.comentario);
		pontos.add(u.curtida);
		pontos.add(u.estrela);
		pontos.add(u.moeda);
		pontos.add(u.topico);
		return pontos;
	}

	@Override
	public String LerArquivo(Usuario u, String tipoDePonto) {
		return null;
	}
}