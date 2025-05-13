package src;
public class Real extends Moeda {
    public Real(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor;
    }

    @Override
    public String toString() {
        return String.format("R$ %.2f", valor);
    }
}
