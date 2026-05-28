public class ContaEspecial extends ContaBancaria {
    private double limite;

    // Construtor
    public ContaEspecial(String cliente, String numeroConta, double saldoInicial, double limite) {
        super(cliente, numeroConta, saldoInicial);
        this.limite = limite;
    }

    // Redefinição do método sacar (Sobrescrita), permitindo saldo negativo até o valor do limite
    @Override
    public boolean sacar(double valor) {
        // Se o valor for positivo e houver saldo suficiente ou limite disponível, realiza o saque
        if (valor > 0 && (this.saldo + this.limite) >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso (Uso do Limite Especial).");
            return true;
        } else {
            System.out.println("Saque de R$ " + valor + " recusado. Valor excede o limite disponível.");
            return false;
        }
    }
    
    // Sobrescrita do método mostrarDados para incluir o limite e o saldo total disponível
    @Override
    public void mostrarDados() {
        System.out.println("--- CONTA ESPECIAL ---");
        super.mostrarDados();
        System.out.println("Limite Disponível: R$ " + this.limite);
        System.out.println("Saldo Total Disponível (Saldo + Limite): R$ " + (this.saldo + this.limite));
    }
}