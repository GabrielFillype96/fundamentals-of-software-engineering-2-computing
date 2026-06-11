
public abstract class Jogo {
	//atributos
	String nome;
	int numeroJogadores;
	
	//construtor
	public Jogo (String nome, int numeroJogadores) {
		this.nome = nome;
		this.numeroJogadores = numeroJogadores;
	}
	
	//métodos abstrato
	public abstract void exibirRegras();
	public abstract void iniciar();
	
	//método concreto
	public String toString() {
		return "Nome: " + nome
				+ " Número de jogadores: " + numeroJogadores;
	}
}