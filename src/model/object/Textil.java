package model.object;

public class Textil extends Producte implements Comparable<Textil> {
    private final String composicio;

    public Textil(String nom, float preu, int codiDeBarres, String composicio) {
        super(nom, preu, codiDeBarres);
        this.composicio = composicio;
    }

    public String getComposicio() {
        return composicio;
    }

    @Override
    public int compareTo(Textil textil) {
        return this.composicio.compareTo(textil.composicio);
    }

    @Override
    public boolean equals(Object t) {
        if (this == t) return true;
        if (!(t instanceof Textil)) return false;

        Textil textil = (Textil) t;
        return getCodiDeBarres() == textil.getCodiDeBarres();
    }
}