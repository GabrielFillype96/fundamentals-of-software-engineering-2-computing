import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println(" CADASTRO DE PRODUTO ");
        System.out.print("Digite o nome do produto: ");
        String nome = sc.nextLine();

        System.out.print("Digite o preço do produto: R$ ");
        double preco = sc.nextDouble();

        System.out.print("Digite a quantidade inicial em estoque: ");
        int quantidadeEstoque = sc.nextInt();

       
        Produto produto = new Produto(nome, preco, quantidadeEstoque);

        
        System.out.println("\n DADOS INICIAIS DO PRODUTO ");
        produto.exibirDadosProduto();


        
        System.out.print("Digite a quantidade de produtos que entraram no estoque: ");
        int qtdEntrada = sc.nextInt();
        produto.realizarEntrada(qtdEntrada);

        
        System.out.println("\n DADOS ATUALIZADOS (PÓS-ENTRADA) ");
        produto.exibirDadosProduto();


        
        System.out.print("Digite a quantidade de produtos para dar saída do estoque: ");
        int qtdSaida = sc.nextInt();
        produto.realizarSaida(qtdSaida);

       
        System.out.println("\n DADOS ATUALIZADOS (PÓS-SAÍDA) ");
        produto.exibirDadosProduto();

        sc.close();
    }
}