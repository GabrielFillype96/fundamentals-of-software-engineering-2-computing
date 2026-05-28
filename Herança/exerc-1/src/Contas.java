public class Contas {
    public static void main(String[] args) {
        
        // 1. Incluir dados relativos a(s) conta(s) de um cliente
        System.out.println("--- 1. CRIANDO AS CONTAS ---");
        ContaPoupanca poupanca = new ContaPoupanca("Gabriel Lima", "1001-P", 1000.00, 5);
        ContaEspecial especial = new ContaEspecial("Gabriel Lima", "2002-E", 500.00, 1000.00);
        
        poupanca.mostrarDados();
        System.out.println();
        especial.mostrarDados();
        System.out.println("\n");

        // 2. Sacar um determinado valor da(s) sua(s) conta(s)
        System.out.println("--- 2. OPERAÇÕES DE SAQUE ---");
        System.out.println("[Conta Poupança]");
        poupanca.sacar(1200.00); // Deve falhar porque conta comum não pode ficar negativa
        
        System.out.println("\n[Conta Especial]");
        especial.sacar(1200.00); // Deve funcionar utilizando o limite (Saldo: -700.00)
        System.out.println("\n");

        // 3. Depositar um determinado valor na(s) sua(s) conta(s)
        System.out.println("--- 3. OPERAÇÕES DE DEPÓSITO ---");
        poupanca.depositar(500.00); // Novo saldo: 1500.00
        especial.depositar(200.00); // Novo saldo: -500.00
        System.out.println("\n");

        // 4. Mostrar o novo saldo do cliente a partir da taxa de rendimento (Apenas para poupança)
        System.out.println("--- 4. APLICANDO RENDIMENTO NA POUPANÇA ---");
        // Aplicando taxa de 1% (0.01) sobre o saldo de 1500.00
        poupanca.calcularNovoSaldo(0.01); 
        System.out.println("\n");

        // 5. Mostrar os dados da(s) conta(s) de um cliente
        System.out.println("--- 5. EXIBINDO DADOS ATUALIZADOS DAS CONTAS ---");
        poupanca.mostrarDados();
        System.out.println();
        especial.mostrarDados();
    }
}