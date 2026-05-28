public class Produto {
    protected String descricao;
    protected double valor;

    // Construtor
    public Produto(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    // Método que calcula o valor final (na classe base é apenas o valor inicial sem nenhum desconto ou acréscimo)
    public double calcularValorFinal() {
        return this.valor;
    }

    public void exibirDados() {
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Valor Base: R$ " + this.valor);
    }
}