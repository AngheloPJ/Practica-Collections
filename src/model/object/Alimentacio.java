package model.object;

import model.exceptions.DataCaducitatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Alimentacio extends Producte implements Comparable<Alimentacio>{
    private final LocalDate dataCaducitat;

    public Alimentacio(String nom, float preu, int codiDeBarres, String dataCaducitat) throws DataCaducitatException {
        super(nom, preu, codiDeBarres);

        try {
            this.dataCaducitat = LocalDate.parse(dataCaducitat, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            throw new DataCaducitatException("El format de la data de caducitat es incorrecte: " + dataCaducitat);
        }
    }

    public double calcularPreu(LocalDate dataActual) {
        long diesFinsCaducitat = dataCaducitat.toEpochDay() - dataActual.toEpochDay();
        if (diesFinsCaducitat < 0) return 0.0; // Hem de llançar una excepció.
        return getPreuBase() - getPreuBase() * (1.0 / (diesFinsCaducitat + 1)) + (getPreuBase() * 0.1);
    }

    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    @Override
    public int compareTo(Alimentacio alimentacio) {
        return this.dataCaducitat.compareTo(alimentacio.dataCaducitat);
    }
}