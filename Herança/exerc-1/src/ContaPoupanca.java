public class ContaPoupanca extends ContaBancaria {
    private int diaRendimento;

    // Construtor
    public ContaPoupanca(String cliente, String numeroConta, double saldoInicial, int diaRendimento) {
        super(cliente, numeroConta, saldoInicial);
        this.diaRendimento = diaRendimento;
    }

    // Método calcularNovoSaldo recebe a taxa (ex: 0.005 para 0.5%) e atualiza o saldo
    public void calcularNovoSaldo(double taxaRendimento) {
        double rendimento = this.saldo * taxaRendimento;
        this.saldo += rendimento;
        System.out.println("Rendimento de R$ " + rendimento + " aplicado à poupança.");
    }

    // Sobrescrita do método mostrarDados para incluir o dia de rendimento
    @Override
    public void mostrarDados() {
        System.out.println("--- CONTA POUPANÇA ---");
        super.mostrarDados();
        System.out.println("Dia de Rendimento: " + this.diaRendimento);
    }
}