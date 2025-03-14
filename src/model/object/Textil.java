package model.object;

public class Textil extends Producte {
    private final String composicio;

    public Textil(String nom, float preu, int codiDeBarres, String composicio) {
        super(nom, preu, codiDeBarres);
        this.composicio = composicio;
    }

    public String getComposicio() {
        return composicio;
    }

}