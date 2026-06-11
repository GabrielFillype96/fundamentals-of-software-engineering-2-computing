import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o salário atual do funcionário: R$ ");
        double salarioAntigo = sc.nextDouble();

        System.out.print("Digite o tempo de serviço (em anos): ");
        double tempoServico = sc.nextDouble();


        double percentualBonus;

        
        if (tempoServico > 5) {
            percentualBonus = 5.0; // 5% de bônus
        } else {
            percentualBonus = 1.3; // 1.3% de bônus
        }

       
        double valorBonus = salarioAntigo * (percentualBonus / 100);
        double novoSalario = salarioAntigo + valorBonus;

       
        System.out.printf("Tempo de serviço: %.1f anos\n", tempoServico);
        System.out.printf("Antigo salário: R$ %.2f\n", salarioAntigo);
        System.out.printf("Percentual aplicado: %.1f%%\n", percentualBonus);
        System.out.printf("Valor líquido do bônus: R$ %.2f\n", valorBonus);
        System.out.printf("Novo salário: R$ %.2f\n", novoSalario);
        

        sc.close();
    }
}
