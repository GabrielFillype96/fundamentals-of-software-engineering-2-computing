import java.util.Scanner;
import java.util.Random; // Import necessário para simular o dado

public class JogoTabuleiro extends Jogo {
	// Atributos
	private String tipoTabuleiro;
    Scanner sc = new Scanner(System.in);
    Random random = new Random(); // Gerador de números aleatórios para o dado
    
    // Variáveis para a simulação do Ludo
    private int[] posicaoJogadores;  // Guarda a casa atual de cada jogador (ex: jogador 1 está na casa 12)
    private boolean[] saiuDaBase;    // Guarda se o jogador já conseguiu sair da base (true/false)
    private int rodadaAtual = 0;     // Contador de rodadas

	// Construtor
	public JogoTabuleiro(String nome, int numeroJogadores, String tipoTabuleiro) {
		super(nome, numeroJogadores);
		this.tipoTabuleiro = tipoTabuleiro;
	}
	
	@Override
	public void iniciar() {
		System.out.println("\nJogo de tabuleiro: " + super.nome);

        System.out.print("\nDigite a quantidade de jogadores para o Ludo (2 a 4): ");
        this.numeroJogadores = sc.nextInt();
        
        if (this.numeroJogadores >= 2 && this.numeroJogadores <= 4) {
            System.out.println("\nQuantidade de jogadores definida: " + this.numeroJogadores);

            // Inicializa os arrays de acordo com a quantidade de jogadores digitada
            posicaoJogadores = new int[this.numeroJogadores]; // Todos começam na casa 0
            saiuDaBase = new boolean[this.numeroJogadores];   // Todos começam na base (false)
            
            boolean existeVencedor = false;
            int jogadorVencedor = 0;

            // Roda enquanto o jogador não chega ao centro
            do {
                rodadaAtual++;
                System.out.println("\nEssa é a rodada de número: " + rodadaAtual + " ---");

                // Loop para cada jogador fazer sua jogada na rodada atual
                for (int i = 0; i < this.numeroJogadores; i++) {
                    int numeroJogador = i + 1; // Para exibir "Jogador 1", "Jogador 2", etc.
                    
                    // Para fazer a lógica de se tirar 6 e jogar novamente
                    boolean jogaNovamente;
                    do {
                        jogaNovamente = false;
                        
                        // Random para gerar um dado de 1 a 6
                        int dado = random.nextInt(6) + 1;
                        System.out.println("Jogador " + numeroJogador + " tirou " + dado + " no dado.");

                        // Regra da Base: Se está na base, precisa de 1 ou 6 para sair
                        if (!saiuDaBase[i]) {
                            if (dado == 1 || dado == 6) {
                                saiuDaBase[i] = true;
                                System.out.println(" Jogador " + numeroJogador + " SAIU DA BASE!");
                            } else {
                                System.out.println(" Jogador " + numeroJogador + " continua na base.");
                            }
                        } 
                        // Se já saiu da base, ele anda
                        else {
                            // Posição do jogador vai ser dada conforme vai tirando os números no dado
                            posicaoJogadores[i] += dado;
                            System.out.println(" Jogador " + numeroJogador + " andou " + dado + " casas.");

                            // Verificação de Vitória. Se a posição do jogador é maior ou igual a 55 (correspondente ao centro do tabuleiro), existe um vencedor
                            if (posicaoJogadores[i] >= 55) {
                                posicaoJogadores[i] = 55; // Limita o teto em 55
                                existeVencedor = true;
                                jogadorVencedor = numeroJogador;
                                break; // Para o turno atual do jogador
                            }
                        }

                        // Regra do dado ser valor 6 que permite jogar novamente
                        // Se o valor do dado for 6 E não existe vencedor ("existeVencedor" ser falso), joga novamente
                        if (dado == 6 && !existeVencedor) {
                            System.out.println("Jogador " + numeroJogador + " tirou 6 e joga novamente!");
                            jogaNovamente = true;
                        }

                    } while (jogaNovamente); // Repete o turno enquanto o jogaNovamente for true, que para mudar precisa ter tirado 6 no dado

                    // Se alguém ganhou no meio da rodada repetida, interrompe o loop dos outros jogadores
                    if (existeVencedor) {
                        break;
                    }
                }

                // Ao final de cada rodada, mostra o relatório de posições 
                System.out.println("\n PLACAR DA RODADA " + rodadaAtual);
                // Para cada numero de jogadores executa o relatório
                for (int i = 0; i < this.numeroJogadores; i++) {
                    // Se o saiuDaBase for verdadeiro então ele está na pista e a variável statusBase vai ser "Na Pista" se não vai ser na "Na Base"
                    String statusBase = saiuDaBase[i] ? "Na pista" : "Na Base";
                    System.out.println("Jogador " + (i + 1) + " -> Casa atual: " + posicaoJogadores[i] + " (" + statusBase + ")");
                }
                
                // Faz uma pausa no console para o jogador ler a leitura
                System.out.println("Pressione Enter para ir para a próxima rodada...");
                sc.nextLine(); // Consome o enter pendente
                sc.nextLine(); // Aguarda o próximo enter

            } while (!existeVencedor); // Enquanto não existe vencedor continua as rodadas

            // Fim do jogo: exibe o vencedor e o total de rodadas
            System.out.println("\n=================================");
            System.out.println("FIM DE JOGO! TEMOS UM VENCEDOR!");
            System.out.println("Parabéns JOGADOR " + jogadorVencedor + ", você completou as 55 casas e venceu!");
            System.out.println("Total de rodadas realizadas: " + rodadaAtual);
            System.out.println("=================================");

        } else {
            System.out.println("\nNúmero de jogadores inválido. Defina uma quantidade entre 2 e 4!");
        }
	}
	
	@Override
	public void exibirRegras() {
        System.out.println("\nO jogo permite a participação de 2 a 4 jogadores!");
		System.out.println("\nCada jogador rola o dado e deve mover suas peças no tabuleiro.");
        System.out.println("\nPara que o jogador saia da base vá para o tabuleiro precisa tirar 1 OU 6 nos dados!");
        System.out.println("\nSe o jogador tirar 6 permite que jogue novamente!");
        System.out.println("\nO jogo finaliza quando um jogador chega ao centro do tabuleiro, completando as 55 casas!");
	}
	
	@Override
	public String toString() {
		return super.toString() + " Tipo tabuleiro: " + tipoTabuleiro;
	}
}