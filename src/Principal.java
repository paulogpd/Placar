import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		Armazenamento a = new Armazenamento();
		Usuario u = new Usuario();
		u.nome = "Paulo";
		u.comentario = 10;
		u.curtida = 1;
		u.estrela = 5;
		u.topico = 23;
		u.moeda = 100;
		
		Usuario u2 = new Usuario();
		u2.nome = "Pedro";
		u2.comentario = 11;
		u2.curtida = 14;
		u2.estrela = 555;
		u2.topico = 21;
		
		a.getPontosPorTipo(u, "moeda");
		a.getPontosPorTipo(u2, "estrela");
		a.getPontosPorTipo(u2, "comentario");
		a.retornaPontosUsuario(u);
		a.retornaPontosUsuario(u2);
		a.retornaUsuarioComPontos();
	}

}
