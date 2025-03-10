package model.object;

public abstract class Producte {
    private String nom;
    private float preu;
    private int codiDeBarres;

    public Producte(String nom, float preu, int codiDeBarres) {
        this.nom = nom;
        this.preu = preu;
        this.codiDeBarres = codiDeBarres;
    }

    public String getNom() { return nom; }
    public int getCodiDeBarres() { return codiDeBarres; }
    public double getPreuBase() { return preu; }

    public abstract double calcularPreu();

    @Override
    public String toString() {
        return "Producte{" +
                "nom='" + nom + '\'' +
                ", preu=" + preu +
                ", codiDeBarres='" + codiDeBarres + '\'' +
                '}';
    }
}