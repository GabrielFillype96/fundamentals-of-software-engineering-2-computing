public class Peca {
    // Atributos
    protected String nome;
    protected float custo;
    protected float lucro;

    // Construtor padrão
    public Peca() {
    }

    // Construtor da classe Peça
    public Peca(String nome, float custo, float lucro) {
        this.nome = nome;
        this.custo = custo;
        this.lucro = lucro;
    }

    // Método para calcular o preço base
    public float calcularPreco() {
        return this.custo + this.lucro;
    }

    // Método para exibir os dados
    public void exibirDados() {
        System.out.println("--- Dados da Peça ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("Custo: R$ " + this.custo);
        System.out.println("Lucro: R$ " + this.lucro);
        System.out.println("Preço Final: R$ " + this.calcularPreco());
    }
}