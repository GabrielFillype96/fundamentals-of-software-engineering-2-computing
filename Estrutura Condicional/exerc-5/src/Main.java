import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.println(" MENU DO RESTAURANTE ");
        System.out.println("1 - Pizza");
        System.out.println("2 - Hambúrguer");
        System.out.println("3 - Salada");
        System.out.println("4 - Bebida");
        
        
        System.out.print("Escolha uma opção (1 a 4) para ver detalhes: ");
        int opcao = sc.nextInt();

       

       
        switch (opcao) {
            case 1:
                System.out.println("Prato: Pizza Grande de Muçarela");
                System.out.println("Descrição: Molho de tomate artesanal, muçarela derretida, rodelas de tomate e orégano.");
                System.out.println("Preço: R$ 45,90");
                break;
                
            case 2:
                System.out.println("Prato: Hambúrguer Artesanal Blend");
                System.out.println("Descrição: Pão brioche selado na manteiga, blend bovino de 150g, queijo cheddar e maionese da casa.");
                System.out.println("Preço: R$ 28,50");
                break;
                
            case 3:
                System.out.println("Prato: Salada Caesar Completa");
                System.out.println("Descrição: Alface romana fresca, pedaços de frango grelhado, croutons crocantes e molho Caesar especial.");
                System.out.println("Preço: R$ 22,00");
                break;
                
            case 4:
                System.out.println("Prato: Suco Natural ou Refrigerante Lata");
                System.out.println("Descrição: Suco de laranja natural feito na hora (300ml) ou refrigerante lata à sua escolha.");
                System.out.println("Preço: R$ 7,00");
                break;
                
            default:
                // Tratamento caso o usuário digite um número fora do intervalo 1-4
                System.out.println("Opção inválida! Por favor, selecione um número de 1 a 4.");
                break;
        }

        sc.close();
    }
}