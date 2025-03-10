package model.object;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alimentacio extends Producte {
    private String dataCaducitat;

    public Alimentacio(String nom, float preu, int codiDeBarres, String dataCaducitat) {
        super(nom, preu, codiDeBarres);
        this.dataCaducitat = new SimpleDateFormat("dd/MM/yyyy").format(new Date(dataCaducitat));
    }

    @Override
    public double calcularPreu() {
        return 0;
    }


}