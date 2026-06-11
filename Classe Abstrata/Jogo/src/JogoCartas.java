// Imports externos

import java.util.Scanner;

public class JogoCartas extends Jogo {
	//atributo
	private String tipoBaralho;
    Scanner sc = new Scanner(System.in);
    private int qntCartas = 50;
    private int qntCartasRecebidas;
    private int qntCartasRestantes;
    private int qntCartasDescartadas;


	

	//construtor da classe
	public JogoCartas(String nome, int numeroJogadores, String tipoBaralho) {
		super(nome, numeroJogadores);
		this.tipoBaralho = tipoBaralho;
	}
	
	//consumir os métodos concretos e abstratos
	@Override
	public void iniciar() {
		//comportamento específico
		System.out.println("Jogo de Cartas: " + super.nome);

        System.out.print("Digite a quantidade de jogadores para o Poker: ");
        this.numeroJogadores = sc.nextInt();
		
        if (this.numeroJogadores >= 2 && this.numeroJogadores <= 4) {
            System.out.println("\nQuantidade de jogadores definida: " + this.numeroJogadores);
            

            for (int i = 1; i <= this.numeroJogadores; i++) {
                System.out.println("\nDefina quantidade de cartas que o jogador " + i + " irá receber: ");
                qntCartasRecebidas = sc.nextInt();
                

                qntCartas -= qntCartasRecebidas; 
                qntCartasRestantes = qntCartas;
                qntCartasDescartadas += qntCartasRecebidas; 
                
                System.out.println("\nO jogador " + i + " recebe " + qntCartasRecebidas + " cartas.");
                System.out.println("\nRestam " + qntCartasRestantes + " cartas no baralho.");
            }


            if (this.numeroJogadores == 2) System.out.println("\nParabéns jogador 1, você venceu essa rodada!");
            else if (this.numeroJogadores == 3) System.out.println("\nParabéns jogador 3, você venceu essa rodada!");
            else if (this.numeroJogadores == 4) System.out.println("\nParabéns jogador 2, você venceu essa rodada!");

            System.out.println("\nForam descartadas: " + qntCartasDescartadas + " cartas." + "Restam " + qntCartasRestantes + " cartas no baralho");

        } else {
            System.out.println("\nNúmero de jogadores inválido. Defina uma quantidade entre 2 e 4!");
        }
	}

	
	@Override
	public void exibirRegras() {
        System.out.println("\nO jogo permite a participação de 2 a 4 jogadores!");
        System.out.println("\nO baralho possui 50 cartas");
		System.out.println("\nCada jogador deve jogar"
				+ " uma carta por vez");
	}
	
	@Override
	public String toString() {
		return super.toString()+
				" Tipo baralho: " + tipoBaralho;
	}
}