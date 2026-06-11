public class Triangulo {
    // Atributos para os três lados
    private double ladoA;
    private double ladoB;
    private double ladoC;

    // Construtor para inicializar os lados
    public Triangulo(double ladoA, double ladoB, double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    // Método que aplica a Fórmula de Heron
    public double calcularArea() {
        // p = semiperímetro
        double p = (ladoA + ladoB + ladoC) / 2.0;
        
        // Área = Raiz Quadrada de (p * (p - a) * (p - b) * (p - c))
        double area = Math.sqrt(p * (p - ladoA) * (p - ladoB) * (p - ladoC));
        
        return area;
    }
}