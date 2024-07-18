public class ContaCorrente extends Conta {
    private double limiteCredito;

    public ContaCorrente(int numeroConta, double limiteCredito) {
        super(numeroConta);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= (getSaldo() + limiteCredito)) {
            super.sacar(valor);
        } else {
            System.out.println("Saldo e limite de crédito insuficientes.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Corrente:");
        System.out.println("Número da Conta: " + getNumeroConta());
        System.out.println("Saldo: R$ " + getSaldo());
        System.out.println("Limite de Crédito: R$ " + limiteCredito);
    }
}
