public class Euro extends Moeda {
    private final double TAXA_EURO = 6.34;

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor * TAXA_EURO;
    }

    @Override
    public String toString() {
        return String.format("EUR %.2f", valor);
    }
}