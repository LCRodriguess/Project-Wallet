import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho();
        Scanner scanner = new Scanner(System.in);
        boolean menuInicial = true;

        System.out.println("Bem-vindo ao seu Cofrinho de Moedas!");

        while (menuInicial) {
            // Menu principal
            System.out.println("\n================================= Menu Principal =================================");
            System.out.println("1 - Depositos");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver informativos");
            System.out.println("4 - Sair");
            System.out.println("===================================================================================");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Submenu de depósitos
                    boolean realizarDepositos = true;
                    while (realizarDepositos) {
                        System.out.println("\n=============================== Menu de Depositos ===============================");
                        System.out.println("1 - Adicionar saldo (REAL)");
                        System.out.println("2 - Adicionar saldo (DOLAR)");
                        System.out.println("3 - Adicionar saldo (EURO)");
                        System.out.println("4 - Retornar ao menu");
                        System.out.println("===================================================================================");
                        System.out.print("Escolha uma opção: ");

                        int opcaoDeposito = scanner.nextInt();

                        switch (opcaoDeposito) {
                            case 1:
                                System.out.print("Digite o valor em Real: ");
                                double valorReal = scanner.nextDouble();
                                cofrinho.adicionarMoeda(new Real(valorReal));
                                System.out.println("\n================================= Ação Executada =================================");
                                System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valorReal);
                                System.out.println("===================================================================================");
                                break;
                            case 2:
                                System.out.print("Digite o valor em Dólar: ");
                                double valorDolar = scanner.nextDouble();
                                cofrinho.adicionarMoeda(new Dolar(valorDolar));
                                System.out.println("\n================================= Ação Executada =================================");
                                System.out.printf("Depósito de $ %.2f realizado com sucesso.%n", valorDolar);
                                System.out.println("===================================================================================");
                                break;
                            case 3:
                                System.out.print("Digite o valor em Euro: ");
                                double valorEuro = scanner.nextDouble();
                                cofrinho.adicionarMoeda(new Euro(valorEuro));
                                System.out.println("\n================================= Ação Executada =================================");
                                System.out.printf("Depósito de EUR %.2f realizado com sucesso.%n", valorEuro);
                                System.out.println("===================================================================================");
                                break;
                            case 4:
                                realizarDepositos = false;
                                break;
                            default:
                                System.out.println("\n================================= Ação Executada =================================");
                                System.out.println("Opção inválida! Tente novamente.");
                                System.out.println("===================================================================================");
                        }
                    }
                    break;

                case 2:
                    // Submenu de saques
                    boolean sacarSaldo = true;
                    while (sacarSaldo) {
                        System.out.println("\n================================ Menu de Saque =================================");
                        System.out.println("1 - Sacar em Reais");
                        System.out.println("2 - Sacar em Dólares");
                        System.out.println("3 - Sacar em Euros");
                        System.out.println("4 - Retornar ao menu");
                        System.out.println("===================================================================================");
                        System.out.print("Escolha uma opção: ");

                        int opcaoSaque = scanner.nextInt();

                        switch (opcaoSaque) {
                            case 1:
                                System.out.print("Digite o valor do saque em Reais: ");
                                double valorSaqueReal = scanner.nextDouble();
                                cofrinho.removerReal(valorSaqueReal);  // Usando o novo método removerReal
                                break;
                            case 2:
                                System.out.print("Digite o valor do saque em Dólares: ");
                                double valorSaqueDolar = scanner.nextDouble();
                                cofrinho.removerDolar(valorSaqueDolar);  // Usando o novo método removerDolar
                                break;
                            case 3:
                                System.out.print("Digite o valor do saque em Euros: ");
                                double valorSaqueEuro = scanner.nextDouble();
                                cofrinho.removerEuro(valorSaqueEuro);  // Usando o novo método removerEuro
                                break;
                            case 4:
                                sacarSaldo = false;
                                break;
                            default:
                                System.out.println("\n================================= Ação Executada =================================");
                                System.out.println("Opção inválida! Tente novamente.");
                                System.out.println("===================================================================================");
                        }
                    }
                    break;

                case 3:
                    // Submenu de informativos
                    boolean verSaldos = true;
                    while (verSaldos) {
                        System.out.println("\n============================== Menu de Informativos ==============================");
                        System.out.println("1 - Ver saldos disponiveis");
                        System.out.println("2 - Ver Histórico de Depositos");
                        System.out.println("3 - Ver Histórico de Saques");
                        System.out.println("4 - Retornar ao menu");
                        System.out.println("===================================================================================");
                        System.out.print("Escolha uma opção: ");

                        int opcaoSaldo = scanner.nextInt();
                        switch (opcaoSaldo) {
                            case 1:
                                System.out.println("\n================================= Ação Executada =================================");
                                cofrinho.exibirSaldoGuardado();
                                break;
                            case 2:
                                System.out.println("\n================================= Ação Executada =================================");
                                cofrinho.exibirHistoricoDepositos();
                                break;
                            case 3:
                                System.out.println("\n================================= Ação Executada =================================");
                                cofrinho.exibirHistoricoSaques();
                                break;
                            case 4:
                                verSaldos = false;
                                break;
                            default:
                                System.out.println("\n================================= Ação Executada =================================");
                                System.out.println("Opção inválida! Tente novamente.");
                                System.out.println("===================================================================================");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n================================= Ação Executada =================================");
                    System.out.println("Saindo...");
                    System.out.println("===================================================================================");
                    menuInicial = false;
                    break;

                default:
                    System.out.println("\n================================= Ação Executada =================================");
                    System.out.println("Opção inválida! Tente novamente.");
                    System.out.println("===================================================================================");
            }
        }

        scanner.close();
    }
}