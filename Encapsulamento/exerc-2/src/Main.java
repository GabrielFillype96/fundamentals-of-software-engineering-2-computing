import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Retangulo retangulo = new Retangulo();
        System.out.print("Digite a largura do retângulo em metros: ");
        double largura = sc.nextDouble();
        System.out.print("Digite o comprimento do retângulo em metros: ");
        double comprimento = sc.nextDouble();

        retangulo.setLargura(largura);
        retangulo.setComprimento(comprimento);
        retangulo.exibirDados();

        sc.close();
    }
}
