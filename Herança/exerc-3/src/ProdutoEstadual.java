public class ProdutoEstadual extends Produto {
    private double imposto; // 10% -> 0.10

    public ProdutoEstadual(String descricao, double valor) {
        super(descricao, valor);
        this.imposto = 0.10;
    }

    // Sobrescreve o método calcularValorFinal para incluir o imposto estadual
    @Override
    public double calcularValorFinal() {
        // Valor base + 10% de imposto sobre o valor base
        return super.calcularValorFinal() + (this.valor * this.imposto);
    }

    // Sobrescreve o método exibirDados para mostrar as informações específicas do produto estadual
    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo: Estadual");
        System.out.println("Imposto (10%): R$ " + (this.valor * this.imposto));
        System.out.println("Valor Final: R$ " + this.calcularValorFinal());
    }
}