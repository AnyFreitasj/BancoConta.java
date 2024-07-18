public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(int numeroConta, double taxaJuros) {
        super(numeroConta);
        this.taxaJuros = taxaJuros;
    }

    public void aplicarJuros() {
        double juros = getSaldo() * taxaJuros / 100;
        depositar(juros);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Poupança:");
        System.out.println("Número da Conta: " + getNumeroConta());
        System.out.println("Saldo: R$ " + getSaldo());
        System.out.println("Taxa de Juros: " + taxaJuros + "%");
    }
}
