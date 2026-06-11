import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        System.out.print("Digite o lado A do triângulo: ");
        double ladoA = sc.nextDouble();

        System.out.print("Digite o lado B do triângulo: ");
        double ladoB = sc.nextDouble();

        System.out.print("Digite o lado C do triângulo: ");
        double ladoC = sc.nextDouble();

        System.out.println("\n RESULTADO ");


        if ((ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB) && (ladoB + ladoC > ladoA)) {
            
            System.out.println("Os valores informados FORMAM um triângulo.");

          
            if (ladoA == ladoB && ladoB == ladoC) {
                // Se A é igual a B, e B é igual a C, logo todos são iguais
                System.out.println("Tipo: Triângulo Equilátero (três lados iguais).");
            } 
            else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
                // Se não são todos iguais, mas pelo menos um par coincide
                System.out.println("Tipo: Triângulo Isósceles (dois lados iguais).");
            } 
            else {
                // Se não caiu em nenhuma das opções anteriores, todos são diferentes
                System.out.println("Tipo: Triângulo Escaleno (três lados diferentes).");
            }

        } else {
            // Caso a validação matemática falhe
            System.out.println("Os valores informados NÃO PODEM formar um triângulo.");
            System.out.println("Motivo: A soma de dois lados deve ser sempre maior que o terceiro lado.");
        }

    
        sc.close();
    }
}