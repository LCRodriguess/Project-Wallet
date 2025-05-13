package src;
import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
    // Lista de moedas no cofrinho
    private List<Moeda> moedas = new ArrayList<>();

    // Históricos de depósitos e saques
    private List<String> historicoDepositos = new ArrayList<>();
    private List<String> historicoSaques = new ArrayList<>();

    // Método para adicionar uma moeda ao cofrinho
    public void adicionarMoeda(Moeda moeda) {
        // Verifica se já existe uma moeda do mesmo tipo no cofrinho
        for (int i = 0; i < moedas.size(); i++) {
            Moeda m = moedas.get(i);
            if (m.getClass().equals(moeda.getClass())) {
                // Se existir, soma o valor da nova moeda à moeda existente
                Moeda novaMoeda;
                if (m instanceof Real) {
                    novaMoeda = new Real(m.getValor() + moeda.getValor());
                } else if (m instanceof Dolar) {
                    novaMoeda = new Dolar(m.getValor() + moeda.getValor());
                } else if (m instanceof Euro) {
                    novaMoeda = new Euro(m.getValor() + moeda.getValor());
                } else {
                    // Caso não seja nenhum dos tipos conhecidos, adiciona a nova moeda
                    moedas.add(moeda);
                    historicoDepositos.add(String.format("+ %s", moeda));
                    return;
                }
                // Atualiza a moeda na lista
                moedas.set(i, novaMoeda);
                historicoDepositos.add(String.format("+ %s", moeda));
                return;
            }
        }
        // Se não existir uma moeda do mesmo tipo, adiciona a nova moeda
        moedas.add(moeda);
        historicoDepositos.add(String.format("+ %s", moeda));
    }

    // Método para remover Real
    public void removerReal(double valor) {
        for (int i = 0; i < moedas.size(); i++) {
            Moeda moeda = moedas.get(i);
            if (moeda instanceof Real) {
                if (moeda.getValor() >= valor) {
                    // Subtrai o valor do saque da moeda existente
                    Moeda novaMoeda = new Real(moeda.getValor() - valor);
                    moedas.set(i, novaMoeda);  // Atualiza a moeda na lista
                    historicoSaques.add(String.format("- R$ %.2f", valor));
                    System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
                    return;
                } else {
                    System.out.println("Saldo insuficiente em reais.");
                    return;
                }
            }
        }
        System.out.println("Nenhum Real encontrado no cofrinho.");
    }

    // Método para remover Dólar
    public void removerDolar(double valor) {
        for (int i = 0; i < moedas.size(); i++) {
            Moeda moeda = moedas.get(i);
            if (moeda instanceof Dolar) {
                if (moeda.getValor() >= valor) {
                    // Subtrai o valor do saque da moeda existente
                    Moeda novaMoeda = new Dolar(moeda.getValor() - valor);
                    moedas.set(i, novaMoeda);  // Atualiza a moeda na lista
                    historicoSaques.add(String.format("- $ %.2f", valor));
                    System.out.printf("Saque de $ %.2f realizado com sucesso.%n", valor);
                    return;
                } else {
                    System.out.println("Saldo insuficiente em dólares.");
                    return;
                }
            }
        }
        System.out.println("Nenhum Dólar encontrado no cofrinho.");
    }

    // Método para remover Euro
    public void removerEuro(double valor) {
        for (int i = 0; i < moedas.size(); i++) {
            Moeda moeda = moedas.get(i);
            if (moeda instanceof Euro) {
                if (moeda.getValor() >= valor) {
                    // Subtrai o valor do saque da moeda existente
                    Moeda novaMoeda = new Euro(moeda.getValor() - valor);
                    moedas.set(i, novaMoeda);  // Atualiza a moeda na lista
                    historicoSaques.add(String.format("- EUR %.2f", valor));
                    System.out.printf("Saque de EUR %.2f realizado com sucesso.%n", valor);
                    return;
                } else {
                    System.out.println("Saldo insuficiente em euros.");
                    return;
                }
            }
        }
        System.out.println("Nenhum Euro encontrado no cofrinho.");
    }

    // Método para listar todas as moedas no cofrinho
    public void listarMoedas() {
        if (moedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
        } else {
            System.out.println("\nMoedas no cofrinho:");
            for (Moeda moeda : moedas) {
                System.out.println(moeda);
            }
        }
    }

    // Método para calcular o saldo total em reais
    public double calcularSaldoTotalEmReais() {
        double total = 0;
        for (Moeda moeda : moedas) {
            total += moeda.converterParaReal();
        }
        return total;
    }

    // Método para exibir o saldo guardado
    public void exibirSaldoGuardado() {
        double totalConvertido = calcularSaldoTotalEmReais();

        System.out.println("\n================================= Saldo Guardado ==================================");
        System.out.printf("Saldo total disponível em reais (incluindo conversões): R$ %.2f%n", totalConvertido);
        System.out.println("Detalhamento:");
        for (Moeda moeda : moedas) {
            System.out.printf("   > %s (= R$ %.2f)%n", moeda, moeda.converterParaReal());
        }
        System.out.println("===================================================================================\n");
    }

    // Método para exibir histórico de depósitos
    public void exibirHistoricoDepositos() {
        if (historicoDepositos.isEmpty()) {
            System.out.println("Nenhum depósito realizado ainda.");
        } else {
            System.out.println("\nHistórico de Depósitos:");
            for (String deposito : historicoDepositos) {
                System.out.println(deposito);
            }
        }
    }

    // Método para exibir histórico de saques
    public void exibirHistoricoSaques() {
        if (historicoSaques.isEmpty()) {
            System.out.println("Nenhum saque realizado ainda.");
        } else {
            System.out.println("\nHistórico de Saques:");
            for (String saque : historicoSaques) {
                System.out.println(saque);
            }
        }
    }
}