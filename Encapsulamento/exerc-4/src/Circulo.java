public class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    public double getRaio() {
        return raio;
    }

    public double calcularArea(double raio) {
        return Math.PI * Math.pow(raio, 2);
    }

    public double calcularPerimetro(double raio) {
        return 2 * Math.PI * raio;
    }

    public void exibirInformacoes(double raio) {
        System.out.println("Raio: " + raio + " metros");
        System.out.println("Área: " + calcularArea(raio) + " metros quadrados");
        System.out.println("Perímetro: " + calcularPerimetro(raio) + " metros");
    }
}
