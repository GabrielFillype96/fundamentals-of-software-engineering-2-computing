import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
		//não conseguimos instanciar o objeto Jogo (classe abstrata)
		//Jogo jogoCartas = new Jogo("Uno", 4);
		
        Scanner sc = new Scanner(System.in);

		Jogo jogoTabuleiro = new JogoTabuleiro("Ludo", 0, "Quadrado");
		jogoTabuleiro.exibirRegras();
		jogoTabuleiro.iniciar();
		
    
		// Jogo jogoCarta = new JogoCartas("Poker", 0, "Padrão");
		// jogoCarta.exibirRegras();
		// jogoCarta.iniciar();

        sc.close();
    }
}
