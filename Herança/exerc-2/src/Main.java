public class Main {
    public static void main(String[] args) {
        // Criando uma peça nacional (comum)
        Peca pecaNacional = new Peca("Processador i7", 1200.00f, 300.00f);
        pecaNacional.exibirDados();
        
        System.out.println(); // Quebra de linha para separar

        // Criando uma peça importada
        PecaImportada pecaImportada = new PecaImportada("Placa de Vídeo RTX 4070", 2500.00f, 500.00f, 400.00f, 150.00f);
        pecaImportada.exibirDados();
    }
}