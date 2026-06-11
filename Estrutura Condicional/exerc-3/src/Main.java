import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    
        System.out.print("Digite o seu peso (em kg, ex: 70,5): ");
        double peso = sc.nextDouble();

        System.out.print("Digite a sua altura (em metros, ex: 1,75): ");
        double altura = sc.nextDouble();

    
        double imc = peso / (altura * altura);

        
        System.out.println("\nRESULTADO");
        System.out.printf("Seu IMC é: %.2f\n", imc);

       
        if (imc < 16) {
            System.out.println("Classificação: Magreza grave");
        } 
        else if (imc >= 16 && imc < 17) {
            System.out.println("Classificação: Magreza moderada");
        } 
        else if (imc >= 17 && imc < 18.5) {
            System.out.println("Classificação: Magreza leve");
        } 
        else if (imc >= 18.5 && imc < 25) {
            System.out.println("Classificação: Saudável");
        } 
        else if (imc >= 25 && imc < 30) {
            System.out.println("Classificação: Sobrepeso");
        } 
        else if (imc >= 30 && imc < 35) {
            System.out.println("Classificação: Obesidade Grau I");
        } 
        else if (imc >= 35 && imc < 40) {
            System.out.println("Classificação: Obesidade Grau II (severa)");
        } 
        else { 
            System.out.println("Classificação: Obesidade Grau III (mórbida)");
        }

        sc.close();
    }
}