package model.object;

public class Electronica extends Producte {
    private final int diesGarantia;

    public Electronica(String nom, float preu, int codiDeBarres, int diesGarantia) {
        super(nom, preu, codiDeBarres);
        this.diesGarantia = diesGarantia;
    }

    public double calcularPreu() {
        return getPreuBase() + getPreuBase() * ((double) diesGarantia / 365) * 0.1;
    }

    public int getDiesGarantia() {
        return diesGarantia;
    }
}