public class Main {
    public static void main(String[] args) {
        // Criando uma instância de cada tipo de produto com valor base de R$ 100.00 para facilitar o teste das taxas
        ProdutoEstadual prodEstadual = new ProdutoEstadual("Picanha Maturada", 100.00);
        ProdutoNacional prodNacional = new ProdutoNacional("Smartphone", 100.00);
        ProdutoImportado prodImportado = new ProdutoImportado("Teclado Mecânico Wireless", 100.00);

        // Apresentando os valores finais na tela
        prodEstadual.exibirDados();
        System.out.println();
        
        prodNacional.exibirDados();
        System.out.println();
        
        prodImportado.exibirDados();
    }
}