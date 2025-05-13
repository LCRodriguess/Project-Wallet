public class Dolar extends Moeda {
    private final double TAXA_DOLAR = 5.81;

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor * TAXA_DOLAR;
    }

    @Override
    public String toString() {
        return String.format("$ %.2f", valor);
    }
}