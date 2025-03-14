package model.object;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alimentacio extends Producte {
    private final LocalDate dataCaducitat;

    public Alimentacio(String nom, float preu, int codiDeBarres, String dataCaducitat) {
        super(nom, preu, codiDeBarres);
        this.dataCaducitat = LocalDate.parse(dataCaducitat, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public double calcularPreu(LocalDate dataActual) {
        long diesFinsCaducitat = dataCaducitat.toEpochDay() - dataActual.toEpochDay();
        return getPreuBase() - getPreuBase() * (1.0f / (diesFinsCaducitat + 1)) + (getPreuBase() * 0.1f);
    }

    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }
}