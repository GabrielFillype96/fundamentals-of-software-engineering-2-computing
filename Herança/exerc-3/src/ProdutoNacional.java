public class ProdutoNacional extends Produto {
    private double taxa; // 5% -> 0.05
    private double imposto; // 10% -> 0.10 

    public ProdutoNacional(String descricao, double valor) {
        super(descricao, valor);
        this.taxa = 0.05;
        this.imposto = 0.10;
    }

    // Sobrescreve o método calcularValorFinal para incluir o imposto estadual e a taxa nacional
    @Override
    public double calcularValorFinal() {
        // Valor com imposto estadual + 5% de taxa nacional sobre o valor base
        return super.calcularValorFinal() + (this.valor * this.taxa) + (this.valor * this.imposto);
    }

    // Sobrescreve o método exibirDados para mostrar as informações específicas do produto nacional
    @Override
    public void exibirDados() {
        // Chamamos os dados bases e o imposto herdado da classe Estadual
        super.exibirDados(); 
        System.out.println("Tipo: Nacional");
        System.out.println("Imposto (10%): R$ " + (this.valor * this.imposto));
        System.out.println("Taxa Nacional (5%): R$ " + (this.valor * this.taxa));
        System.out.println("Valor Final: R$ " + this.calcularValorFinal());
    }
}