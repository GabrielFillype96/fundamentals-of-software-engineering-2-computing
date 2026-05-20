import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o raio do circulo em metros: ");
        double raio = sc.nextDouble();
        Circulo circulo = new Circulo(raio);
        circulo.exibirInformacoes(raio);
    }
}
