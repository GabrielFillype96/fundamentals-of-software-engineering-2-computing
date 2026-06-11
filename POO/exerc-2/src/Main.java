import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Digite o nome do funcionário: ");
        String nome = sc.nextLine();

        System.out.print("Digite o salário atual do funcionário: R$ ");
        double salarioAntigo = sc.nextDouble();

        double percentualAumento = 0;

       
        if (salarioAntigo >= 1 && salarioAntigo <= 1000) {
            percentualAumento = 15.0; // 15% de aumento
        } 
        else if (salarioAntigo >= 1001 && salarioAntigo <= 1500) {
            percentualAumento = 10.0; // 10% de aumento
        } 
        else if (salarioAntigo >= 1501 && salarioAntigo <= 2000) {
            percentualAumento = 5.0;  // 5% de aumento
        } 
        else {
            System.out.println("\nAviso: O salário digitado está fora das faixas de aumento (1 a 2000). Nenhum aumento será aplicado.");
        }

        double valorAumento = salarioAntigo * (percentualAumento / 100);
        double salarioAtual = salarioAntigo + valorAumento;

       
        System.out.println("Funcionário: " + nome);
        System.out.printf("Salário Antigo: R$ %.2f\n", salarioAntigo);
        System.out.printf("Aumento Aplicado: %.1f%%\n", percentualAumento);
        System.out.printf("Valor do aumento: R$ %.2f\n", valorAumento);
        System.out.printf("Salário Atual: R$ %.2f\n", salarioAtual);

        sc.close();
    }
}