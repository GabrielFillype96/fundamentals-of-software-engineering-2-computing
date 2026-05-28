public class PecaImportada extends Peca {
    // Atributos adicionais
    private float taxaImportacao;
    private float taxaFrete;

    // Construtor padrão
    public PecaImportada() {
        super();
    }

    // Construtor da classe Peça Importada
    public PecaImportada(String nome, float custo, float lucro, float taxaImportacao, float taxaFrete) {
        // Invoca o construtor da superclasse (Peca)
        super(nome, custo, lucro); 
        this.taxaImportacao = taxaImportacao;
        this.taxaFrete = taxaFrete;
    }

    // Sobrescrita do método calcularPreco
    @Override
    public float calcularPreco() {
        // Usa o preço base da superclasse e soma as taxas específicas
        return super.calcularPreco() + this.taxaImportacao + this.taxaFrete;
    }

    // Sobrescrita do método exibir dados
    @Override
    public void exibirDados() {
        System.out.println("--- Dados da Peça Importada ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("Custo Base: R$ " + this.custo);
        System.out.println("Lucro Base: R$ " + this.lucro);
        System.out.println("Taxa de Importação: R$ " + this.taxaImportacao);
        System.out.println("Taxa de Frete: R$ " + this.taxaFrete);
        System.out.println("Preço Final (com taxas): R$ " + this.calcularPreco());
    }
}