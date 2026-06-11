import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Digite o primeiro número: ");
        double num1 = sc.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = sc.nextDouble();

       
        System.out.print("Escolha uma operação matemática (+, -, *, /): ");
        char operacao = sc.next().charAt(0); 
        

        double resultado = 0;
        boolean operacaoValida = true;

        
        switch (operacao) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':

                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("\nErro: Não é possível dividir um número por zero!");
                    operacaoValida = false;
                }
                break;
            default:
                System.out.println("\nErro: Operação inválida! Escolha apenas +, -, * ou /.");
                operacaoValida = false;
                break;
        }

        
        if (operacaoValida) {
            System.out.println("\nRESULTADO");
            System.out.printf("Cálculo: %.2f %c %.2f\n", num1, operacao, num2);
            System.out.printf("Resultado final: %.2f\n", resultado);
        }

        sc.close();
    }
}