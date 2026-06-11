public class Produto {
    // Atributos
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    // Construtor para inicializar o produto
    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Método para calcular o valor total das mercadorias em estoque
    public double calcularValorTotalEstoque() {
        return this.preco * this.quantidadeEstoque;
    }

    // Método para realizar a entrada de mercadorias
    public void realizarEntrada(int quantidade) {
        this.quantidadeEstoque += quantidade;
        System.out.println("\n Entrada de " + quantidade + " unidades realizada com sucesso!");
    }

    // Método para realizar a saída de mercadorias com validação
    public void realizarSaida(int quantidade) {
        if (quantidade > this.quantidadeEstoque) {
            System.out.println("\n[ERRO] Não é possível realizar a saída! A quantidade informada (" 
                               + quantidade + ") excede a quantidade disponível em estoque (" 
                               + this.quantidadeEstoque + ").");
        } else {
            this.quantidadeEstoque -= quantidade;
            System.out.println("\n Saída de " + quantidade + " unidades realizada com sucesso!");
        }
    }

    // Método para exibir todos os dados formatados do produto
    public void exibirDadosProduto() {
        System.out.println("Produto: " + this.nome);
        System.out.printf("Preço unitário: R$ %.2f\n", this.preco);
        System.out.println("Quantidade em estoque: " + this.quantidadeEstoque + " unidades");
        System.out.printf("Valor total no estoque: R$ %.2f\n", calcularValorTotalEstoque());
        
    }
}