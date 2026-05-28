public class ProdutoImportado extends Produto {
    private double taxaImportacao; // 5% -> 0.05
    private double taxa; // 5% -> 0.05
    private double imposto; // 10% -> 0.10

    public ProdutoImportado(String descricao, double valor) {
        super(descricao, valor);
        this.taxaImportacao = 0.10;
        this.taxa = 0.05; 
        this.imposto = 0.05;
    }

    @Override
    public double calcularValorFinal() {
        // Valor base + (5% de taxa de importação + 5% de taxa + 10% de imposto) sobre o valor base
        return super.calcularValorFinal() + (this.valor * this.taxaImportacao) + (this.valor * this.taxa) + (this.valor * this.imposto);
    }

    // Sobrescreve o método exibirDados para mostrar as informações específicas do produto importado
    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo: Importado");
        System.out.println("Taxa de Importação (5%): R$ " + (this.valor * this.taxaImportacao));
        System.out.println("Taxa Regular (5%): R$ " + (this.valor * this.taxa));
        System.out.println("Imposto (10%): R$ " + (this.valor * this.imposto));
        System.out.println("Valor Final: R$ " + this.calcularValorFinal());
    }
}
