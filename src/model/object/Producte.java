package model.object;

public abstract class Producte {
    private final String nom;
    private final float preu;
    private final int codiDeBarres;

    public Producte(String nom, float preu, int codiDeBarres) {
        this.nom = nom;
        this.preu = preu;
        this.codiDeBarres = codiDeBarres;
    }

    public String getNom() { return nom; }
    public double getPreuBase() { return preu; }
    public int getCodiDeBarres() { return codiDeBarres; }



    @Override
    public String toString() {
        return "Producte{" +
                "nom='" + nom + '\'' +
                ", preu=" + preu +
                ", codiDeBarres='" + codiDeBarres + '\'' +
                '}';
    }
}