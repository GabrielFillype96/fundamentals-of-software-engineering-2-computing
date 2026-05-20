public class Retangulo {
    private double largura;
    private double comprimento;

    public Retangulo(){}

    public Retangulo(double largura, double comprimento) {
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public void validacao(double largura, double comprimento) {
        if (largura >= 0 && comprimento >= 0) {
            this.largura = largura;
            this.comprimento = comprimento;
        } else {
            System.out.println("Valor inválido. A largura e o comprimento devem ser maiores ou iguais a zero.");
        }
    }
    
    public void setLargura(double largura) {
        this.largura = largura;
    }
    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
    public double getLargura() {
        return largura;
    }
    public double getComprimento() {
        return comprimento;
    }

    public void exibirDados() {
        System.out.println("Largura: " + largura + " metros");
        System.out.println("Comprimento: " + comprimento + " metros");
    }

}
