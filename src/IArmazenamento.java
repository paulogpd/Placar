import java.util.ArrayList;

public interface IArmazenamento {

	public void GravaPontuacao(Usuario u);
	public String getPontosPorTipo(Usuario u, String tipo);
	public ArrayList<Integer> retornaPontosUsuario(Usuario u);
	public String LerArquivo(Usuario u, String tipoDePonto);
	
}
