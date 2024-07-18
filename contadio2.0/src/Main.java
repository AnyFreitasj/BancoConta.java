import java.util.Scanner;

public class Main {
    private static Banco banco = new Banco();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Adicionar algumas contas iniciais para teste
        ContaCorrente contaCorrente = new ContaCorrente(1, 500.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca(2, 2.0);
        banco.adicionarConta(contaCorrente);
        banco.adicionarConta(contaPoupanca);

        while (true) {
            mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    realizarDeposito();
                    break;
                case 3:
                    realizarSaque();
                    break;
                case 4:
                    consultarExtrato();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Criar Conta");
        System.out.println("2. Realizar Depósito");
        System.out.println("3. Realizar Saque");
        System.out.println("4. Consultar Extrato");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarConta() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Escolha o tipo de conta (1 para Conta Corrente, 2 para Conta Poupança): ");
        int tipoConta = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (tipoConta == 1) {
            System.out.print("Digite o limite de crédito: ");
            double limiteCredito = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha
            ContaCorrente conta = new ContaCorrente(numeroConta, limiteCredito);
            banco.adicionarConta(conta);
            System.out.println("Conta Corrente criada com sucesso!");
        } else if (tipoConta == 2) {
            System.out.print("Digite a taxa de juros: ");
            double taxaJuros = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha
            ContaPoupanca conta = new ContaPoupanca(numeroConta, taxaJuros);
            banco.adicionarConta(conta);
            System.out.println("Conta Poupança criada com sucesso!");
        } else {
            System.out.println("Tipo de conta inválido.");
        }
    }

    private static void realizarDeposito() {
        System.out.print("Digite o número da conta para depósito: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Conta conta = banco.buscarConta(numeroConta);
        if (conta != null) {
            System.out.print("Digite o valor do depósito: ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha
            conta.depositar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void realizarSaque() {
        System.out.print("Digite o número da conta para saque: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Conta conta = banco.buscarConta(numeroConta);
        if (conta != null) {
            System.out.print("Digite o valor do saque: ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha
            conta.sacar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void consultarExtrato() {
        System.out.print("Digite o número da conta para consultar o extrato: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Conta conta = banco.buscarConta(numeroConta);
        if (conta != null) {
            conta.imprimirExtrato();
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}
