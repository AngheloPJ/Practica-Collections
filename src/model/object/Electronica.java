package model.object;

public class Electronica extends Producte {
    private int diesGarantia;

    public Electronica(String nom, float preu, int codiDeBarres, int diesGarantia) {
        super(nom, preu, codiDeBarres);
        this.diesGarantia = diesGarantia;
    }


    @Override
    public double calcularPreu() {
        return 0;
    }
}