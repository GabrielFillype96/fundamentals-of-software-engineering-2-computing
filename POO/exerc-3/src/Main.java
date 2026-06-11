import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Digite as medidas dos lados do triângulo X:");
        System.out.print("Lado A: ");
        double xa = sc.nextDouble();
        System.out.print("Lado B: ");
        double xb = sc.nextDouble();
        System.out.print("Lado C: ");
        double xc = sc.nextDouble();
        
        Triangulo trianguloX = new Triangulo(xa, xb, xc);

        
        System.out.println("\nDigite as medidas dos lados do triângulo Y:");
        System.out.print("Lado A: ");
        double ya = sc.nextDouble();
        System.out.print("Lado B: ");
        double yb = sc.nextDouble();
        System.out.print("Lado C: ");
        double yc = sc.nextDouble();
        
        Triangulo trianguloY = new Triangulo(ya, yb, yc);

        
        double areaX = trianguloX.calcularArea();
        double areaY = trianguloY.calcularArea();

        
        System.out.println("\n RESULTADO ");
        System.out.printf("Área do triângulo X: %.4f\n", areaX);
        System.out.printf("Área do triângulo Y: %.4f\n", areaY);
        

        
        if (areaX > areaY) {
            System.out.println("O triângulo X possui a MAIOR área.");
        } else if (areaY > areaX) {
            System.out.println("O triângulo Y possui a MAIOR área.");
        } else {
            System.out.println("Ambos os triângulos possuem ÁREAS IGUAIS.");
        }

        sc.close();
    }
}