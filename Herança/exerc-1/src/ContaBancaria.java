public class ContaBancaria {
    // Atributos privados 
    private String cliente;
    private String numeroConta;
    protected double saldo; // 'protected' permite acesso direto nas subclasses

    // Construtor
    public ContaBancaria(String cliente, String numeroConta, double saldoInicial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    // Método depositar
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    // Método sacar (o saldo não pode ficar negativo na conta comum)
    public boolean sacar(double valor) {
        // Se o valor for positivo e houver saldo suficiente, realiza o saque
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente para o saque de R$ " + valor + ".");
            return false;
        }
    }

    // Método para mostrar dados
    public void mostrarDados() {
        System.out.println("Cliente: " + this.cliente);
        System.out.println("Número da Conta: " + this.numeroConta);
        System.out.println("Saldo Atual: R$ " + this.saldo);
    }

    // Getters e Setters
    public String getCliente() { return cliente; }
    public String getNumeroConta() { return numeroConta; }
    public double getSaldo() { return saldo; }
}