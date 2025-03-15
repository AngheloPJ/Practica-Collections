package model.object;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alimentacio extends Producte implements Comparable<Alimentacio>{
    private final LocalDate dataCaducitat;

    public Alimentacio(String nom, float preu, int codiDeBarres, String dataCaducitat) {
        super(nom, preu, codiDeBarres);
        this.dataCaducitat = LocalDate.parse(dataCaducitat, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public double calcularPreu(LocalDate dataActual) {
        long diesFinsCaducitat = dataCaducitat.toEpochDay() - dataActual.toEpochDay();
        if (diesFinsCaducitat < 0) return 0.0; // Hem de llançar una excepció.
        return getPreuBase() - getPreuBase() * (1.0 / (diesFinsCaducitat + 1)) + (getPreuBase() * 0.1);
    }

    @Override
    public int compareTo(Alimentacio alimentacio) {
        return this.dataCaducitat.compareTo(alimentacio.dataCaducitat);
    }
}