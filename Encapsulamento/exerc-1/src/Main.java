import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome da pessoa:");
        String nome = sc.nextLine();
        System.out.println("Digite o país da pessoa:");
        String pais = sc.nextLine();
        System.out.println("Digite a idade da pessoa:");
        int idade = sc.nextInt();

        Pessoa identidade1 = new Pessoa();
        identidade1.setNome(nome);
        identidade1.setPais(pais);
        identidade1.setIdade(idade);

        identidade1.exibirDados();
        sc.close();


    }
}
