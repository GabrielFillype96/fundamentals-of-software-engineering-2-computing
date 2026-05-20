import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o ID do funcionário 1: ");
        String id1 = sc.nextLine();
        System.out.println("Digite o nome do funcionário 1: ");
        String nome1 = sc.nextLine();
        System.out.println("Digite o salário do funcionário 1: ");
        double salario1 = sc.nextDouble();
        sc.nextLine(); // Limpar o buffer do scanner
        
        Funcionario funcionario1 = new Funcionario(id1, nome1, salario1);
        
        
        System.out.println("Digite o ID do funcionário 2: ");
        String id2 = sc.nextLine();
        System.out.println("Digite o nome do funcionário 2: ");
        String nome2 = sc.nextLine();
        System.out.println("Digite o salário do funcionário 2: ");
        double salario2 = sc.nextDouble();
        sc.nextLine(); // Limpar o buffer do scanner
        
        Funcionario funcionario2 = new Funcionario(id2, nome2, salario2);
        

        funcionario1.exibirDadosFuncionario();
        funcionario2.exibirDadosFuncionario();

        sc.close();

    }
}
