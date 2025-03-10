package model.object;

public class Textil extends Producte {
    private String composicio;

    public Textil(String nom, float preu, int codiDeBarres, String composicio) {
        super(nom, preu, codiDeBarres);
        this.composicio = composicio;
    }

    public String getComposicio() {
        return composicio;
    }

    @Override
    public double calcularPreu() {
        return 0;
    }
}